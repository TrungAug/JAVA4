package pc05132.hankook.controller;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;

import jakarta.persistence.TypedQuery;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import pc05132.hankook.dao.ImageDAO;
import pc05132.hankook.dao.LikeDAO;
import pc05132.hankook.dao.ProductDAO;
import pc05132.hankook.dao.RelProductTyreDAO;
import pc05132.hankook.dao.ShareDAO;
import pc05132.hankook.dao.SizeDAO;
import pc05132.hankook.dao.TyreDAO;
import pc05132.hankook.entity.Image;
import pc05132.hankook.entity.Like;
import pc05132.hankook.entity.Product;
import pc05132.hankook.entity.RelProductTyre;
import pc05132.hankook.entity.Share;
import pc05132.hankook.entity.Size;
import pc05132.hankook.entity.Tyre;
import pc05132.hankook.untils.HankookUntils;

@MultipartConfig
@WebServlet({ "/admin/editor-product", "/admin/create-product", "/admin/update-product", "/admin/change-product",
		"/admin/delete-product", "/admin/add-size-product", "/admin/delete-size-product" })
public class EditorProductController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Tyre> listT = HankookUntils.excuteNamedQueryNoParam("Tyre.FindAll", Tyre.class);
		String jpql = "SELECT o FROM Product o ORDER BY o.prodName ASC";
		List<Product> listPShow = HankookUntils.excuteQuey(jpql, Product.class);
		String indexParam = req.getParameter("index");// click chọn change product

		String uri = req.getRequestURI();
		if (uri.contains("create-product")) {
			this.doAddProduct(req, resp);
			return;
		} else if (uri.contains("update-product")) {
			this.doUpdateProduct(req, resp);
			return;
		} else if (uri.contains("delete-product")) {
			this.doDeleteProduct(req, resp);
			return;
		} else if (uri.contains("add-size-product")) {
			this.doAddSizeProduct(req, resp);
			return;
		} else if (uri.contains("delete-size-product")) {
			this.doDeleteSizeProduct(req, resp);
			return;
		}

		if (indexParam != null) {
			try {
				int index = Integer.parseInt(indexParam);
				req.setAttribute("showP", listPShow.get(index));
				req.setAttribute("formEditProd", listPShow.get(index));
			} catch (Exception e) {
				req.setAttribute("showP", listPShow.get(0));

				e.printStackTrace();
			}
		} else {
			req.setAttribute("showP", listPShow.get(0));
			req.setAttribute("formEditProd", listPShow.get(0));
		}

		req.getSession().setAttribute("indexParam", indexParam);
		req.setAttribute("showAllProduct", listPShow);
		req.setAttribute("Tyres", listT);
		req.getRequestDispatcher("/WEB-INF/views/templates/edit-product.jsp").forward(req, resp);
	}

	protected void doDeleteSizeProduct(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String id = req.getParameter("id");
		Size size = SizeDAO.getInstance().findSizeById(id);

		if (size != null) {

			try {

				SizeDAO.getInstance().remove(id);

				req.getSession().setAttribute("message", "Delete Successfuly");
				resp.sendRedirect(req.getContextPath() + "/admin/editor-product");
			} catch (Exception e) {
				req.setAttribute("message", "Delete Failed");
				e.printStackTrace();
			}

		} else {
			req.getSession().setAttribute("message", "Size id does not exists");
			resp.sendRedirect(req.getContextPath() + "/admin/editor-product");
		}

	}

	protected void doAddSizeProduct(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String idProd = req.getParameter("idPro");
		Size size = new Size();
		Product checkProduct = ProductDAO.getInstance().findProdById(idProd);

		if (checkProduct != null) {

			try {
				size.setProduct(checkProduct);
				BeanUtils.populate(size, req.getParameterMap());
				SizeDAO.getInstance().create(size);
				req.getSession().setAttribute("message", "Add size Successfuly");
				resp.sendRedirect(req.getContextPath() + "/admin/editor-product");
			} catch (Exception e) {
				req.setAttribute("message", "Delete Failed");
				e.printStackTrace();
			}

		} else {
			req.getSession().setAttribute("message", "Product id does not exists");

			resp.sendRedirect(req.getContextPath() + "/admin/editor-product");
		}

	}

	protected void doDeleteProduct(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String idProd = req.getParameter("id");

		Product checkProduct = ProductDAO.getInstance().findProdById(idProd);

		if (checkProduct != null) {

			try {
				ProductDAO.getInstance().remove(idProd);
				req.getSession().setAttribute("message", "Delete Successfuly");
				resp.sendRedirect(req.getContextPath() + "/admin/editor-product");
			} catch (Exception e) {
				req.setAttribute("message", "Delete Failed");
				e.printStackTrace();
			}

		} else {
			req.getSession().setAttribute("message", "Product id does not exists");
			resp.sendRedirect(req.getContextPath() + "/admin/editor-product");
		}

	}

	protected void doUpdateProduct(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Product product = new Product();
		String idProd = req.getParameter("idPro");

		Product checkProduct = ProductDAO.getInstance().findProdById(idProd);

		if (checkProduct != null) {

			try {

				BeanUtils.populate(product, req.getParameterMap());
				ProductDAO.getInstance().update(product);

				List<RelProductTyre> listR = HankookUntils.excuteNamedQuery("paramId", idProd,
						"RelProductTyre.findByIdProd", RelProductTyre.class);
				for (RelProductTyre relProductTyre : listR) {
					RelProductTyreDAO.getInstance().remove(relProductTyre.getId() + "");
				}

				List<Image> listIm = HankookUntils.excuteNamedQuery("paramId", idProd, "Image.findByIdProd",
						Image.class);

				for (Image image : listIm) {
					ImageDAO.getInstance().remove(image.getIdImg() + "");
				}

				String[] tyres = req.getParameterValues("tyre");

				if (tyres != null) {
					for (String val : tyres) {
						Tyre tyre = TyreDAO.getInstance().findProdById(val);
						if (tyre != null) {
							RelProductTyre relProductTyre = new RelProductTyre();
							relProductTyre.setProduct(product);
							relProductTyre.setTyre(tyre);
							relProductTyre.setDateLog(new Date());
							try {
								RelProductTyreDAO.getInstance().update(relProductTyre);

							} catch (Exception e) {
								e.printStackTrace();
								req.setAttribute("message", "Error while updating details of Product - Tyre");
							}
						}
					}
				}

				File dir = new File(req.getServletContext().getRealPath("/files"));

				if (!dir.exists()) {
					dir.mkdirs();
				}
				for (int i = 1; i <= 3; i++) {
					Part photo = req.getPart("photo_file" + i);
					if (photo != null && photo.getSize() > 0) {
						File photoFile = new File(dir, photo.getSubmittedFileName());
						photo.write(photoFile.getAbsolutePath());
						try {
							DateTimeConverter dtc = new DateConverter(new Date());
							dtc.setPattern("MM/dd/yyyy");
							ConvertUtils.register(dtc, Date.class);
							Image image = new Image();
							image.setImgSrc("/files/" + photoFile.getName());
							image.setProduct(product);
							BeanUtils.populate(image, req.getParameterMap());
							ImageDAO.getInstance().update(image);
						} catch (IllegalAccessException e) {
							e.printStackTrace();
							req.setAttribute("message", "Error while updating image");
						} catch (InvocationTargetException e) {
							e.printStackTrace();
							req.setAttribute("message", "Error while updating image");
						}
					}

				}
				req.getSession().setAttribute("message", "Update Successfuly");
				resp.sendRedirect(req.getContextPath() + "/admin/editor-product");
			} catch (Exception e) {
				req.setAttribute("message", "Insert Failed");
				e.printStackTrace();
			}

		} else {
			req.getSession().setAttribute("message", "Product id does not exists");
			resp.sendRedirect(req.getContextPath() + "/admin/editor-product");

		}

	}

	protected void doAddProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Product product = new Product();
		String idProd = req.getParameter("idPro");
		Product checkProduct = ProductDAO.getInstance().findProdById(idProd);
		if (checkProduct == null) {

			try {

				// product ok
				BeanUtils.populate(product, req.getParameterMap());
				ProductDAO.getInstance().create(product);

				String[] tyres = req.getParameterValues("tyre");

				if (tyres != null) {
					for (String val : tyres) {
						Tyre tyre = TyreDAO.getInstance().findProdById(val);
						if (tyre != null) {
							RelProductTyre relProductTyre = new RelProductTyre();
							relProductTyre.setProduct(product);
							relProductTyre.setTyre(tyre);
							relProductTyre.setDateLog(new Date());
							try {
								// BeanUtils.populate(relProductTyre, req.getParameterMap());
								// Không dùng bean vì các giá trị đã được set, không có có giá trị nào lấy từ
								// req
								RelProductTyreDAO.getInstance().create(relProductTyre);

							} catch (Exception e) {
								e.printStackTrace();
								req.setAttribute("message", "Error while adding details of Product - Tyre");
							}
						}
					}
				}

				// Hình ok
				File dir = new File(req.getServletContext().getRealPath("/files"));

				if (!dir.exists()) {
					dir.mkdirs();
				}
				for (int i = 1; i <= 3; i++) {
					Part photo = req.getPart("photo_file" + i);
					if (photo != null && photo.getSize() > 0) {
						File photoFile = new File(dir, photo.getSubmittedFileName());
						photo.write(photoFile.getAbsolutePath());
						try {
							DateTimeConverter dtc = new DateConverter(new Date());
							dtc.setPattern("MM/dd/yyyy");
							ConvertUtils.register(dtc, Date.class);
							Image image = new Image();
							image.setImgSrc("/files/" + photoFile.getName());
							image.setProduct(product);
							BeanUtils.populate(image, req.getParameterMap());
							ImageDAO.getInstance().create(image);
						} catch (IllegalAccessException e) {
							e.printStackTrace();
							req.setAttribute("message", "Error while adding image");
						} catch (InvocationTargetException e) {
							e.printStackTrace();
							req.setAttribute("message", "Error while adding image");
						}
					}

				}

				req.getSession().setAttribute("message", "Insert Successfuly");
				resp.sendRedirect(req.getContextPath() + "/admin/editor-product");
			} catch (Exception e) {
				req.setAttribute("message", "Insert Failed");
				e.printStackTrace();
			}

		} else {
			req.getSession().setAttribute("message", "Product id already exists");
			resp.sendRedirect(req.getContextPath() + "/admin/editor-product");

		}

	}

}
