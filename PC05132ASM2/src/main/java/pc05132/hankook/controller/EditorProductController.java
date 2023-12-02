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

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import pc05132.hankook.dao.ImageDAO;
import pc05132.hankook.dao.ProductDAO;
import pc05132.hankook.dao.RelProductTyreDAO;
import pc05132.hankook.dao.TyreDAO;
import pc05132.hankook.entity.Image;
import pc05132.hankook.entity.Product;
import pc05132.hankook.entity.RelProductTyre;
import pc05132.hankook.entity.Tyre;
import pc05132.hankook.untils.HankookUntils;


@MultipartConfig
@WebServlet({ "/admin/editor-product", "/admin/create-product" })
public class EditorProductController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Tyre> listT = HankookUntils.excuteNamedQueryNoParam("Tyre.FindAll", Tyre.class);
		Product product = new Product();
		RelProductTyre relProductTyre = new RelProductTyre();
		Image image = new Image();
		String uri = req.getRequestURI();
		if (uri.contains("create-product")) {

			String idProd = req.getParameter("idPro");
			Product checkProduct = ProductDAO.getInstance().findProdById(idProd);
			if (checkProduct == null) {
				
				try {

					BeanUtils.populate(product, req.getParameterMap());
					ProductDAO.getInstance().create(product);

					
					
					
					String[] tyres = req.getParameterValues("tyre");

					if (tyres != null) {
						for (String val : tyres) {
							Tyre tyre = TyreDAO.getInstance().findProdById(val);
							//System.out.println(tyre.getNameTyre());
							DateTimeConverter dtc = new DateConverter(new Date());
							dtc.setPattern("MM/dd/yyyy");
							ConvertUtils.register(dtc, Date.class);
							
							relProductTyre.setProduct(product);
							relProductTyre.setTyre(tyre);
							try {
								BeanUtils.populate(relProductTyre, req.getParameterMap());
								RelProductTyreDAO.getInstance().create(relProductTyre);
							} catch (Exception e) {
								e.printStackTrace();
								req.setAttribute("message", "Lỗi thêm chi tiết");
							}
						}
					}
					
					//Hình
					File dir = new File(req.getServletContext().getRealPath("/files"));

					if (!dir.exists()) {
						dir.mkdirs();
					}
					for(int i=1;i<=3;i++) {
						Part photo = req.getPart("photo_file"+i);
						File photoFile = new File(dir, photo.getSubmittedFileName());
						photo.write(photoFile.getAbsolutePath());
						//System.out.println("Photo thu "+i+" "+photoFile.getName());
						try {
							DateTimeConverter dtc = new DateConverter(new Date());
							dtc.setPattern("MM/dd/yyyy");
							ConvertUtils.register(dtc, Date.class);

							image.setImgSrc("/files/"+photoFile.getName());
							image.setProduct(product);
							BeanUtils.populate(image, req.getParameterMap());
							ImageDAO.getInstance().create(image);
						} catch (IllegalAccessException e) {
							e.printStackTrace();
							req.setAttribute("message", "Lỗi thêm hình");
						} catch (InvocationTargetException e) {
							e.printStackTrace();
							req.setAttribute("message", "Lỗi thêm hình");
						}
					}
					
					
					
					
				} catch (Exception e) {
					req.setAttribute("message", "Insert Failed");
				}

			} else {
				req.setAttribute("message", "Product id already exists");
			}

	

		}

		req.setAttribute("Tyres", listT);
		req.getRequestDispatcher("/WEB-INF/views/templates/edit-product.jsp").forward(req, resp);
	}
}
