package pc05132.lab3.bai3;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

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

@MultipartConfig
@WebServlet({ "/staffform" })
public class StaffController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/staff/staff_form.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		File dir = new File(req.getServletContext().getRealPath("/files"));
		
		if(!dir.exists()) {
			dir.mkdirs();
		}
		
		
		Part photo = req.getPart("photo_file");
		File photoFile = new File(dir,photo.getSubmittedFileName());
		photo.write(photoFile.getAbsolutePath());
	
		
		try {
			DateTimeConverter dtc = new DateConverter(new Date());
			dtc.setPattern("MM/dd/yyyy");
			ConvertUtils.register(dtc, Date.class);

			Staff staff = new Staff();
			staff.setPhoto(photoFile.getName());
			BeanUtils.populate(staff, req.getParameterMap());
						
			req.setAttribute("newbean", staff);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		req.getRequestDispatcher("/WEB-INF/views/staff/staff_result.jsp").forward(req, resp);
	}

}
