package pc05132.lab3;

import java.io.File;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@MultipartConfig
@WebServlet({"/upload"})
public class UploadController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/upload/upload_form.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		File createNewFile = new File(req.getServletContext().getRealPath("/files"));
		
		if(!createNewFile.exists()) {
			createNewFile.mkdirs();
		}
		
		Part photo = req.getPart("photo_file");		
		File photoFile = new File(createNewFile, photo.getSubmittedFileName());
		photo.write(photoFile.getAbsolutePath());
		
		Part document = req.getPart("doc_file");
		File docFile = new File(createNewFile, document.getSubmittedFileName());
		document.write(docFile.getAbsolutePath());
		
		
		req.setAttribute("img", photoFile);
		req.setAttribute("doc", docFile);
		
		req.getRequestDispatcher("/WEB-INF/views/upload/result_upload.jsp").forward(req, resp);
	}
	
}
