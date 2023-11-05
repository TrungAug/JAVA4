package pc05132.demo.uploadfile.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@MultipartConfig
@WebServlet({"/","/file"})
public class FileController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/upload.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Lấy file đã upload
		Part part = req.getPart("upload");
		System.out.println(part.getSubmittedFileName());
		
		//Tạo đường dẫn lưu file
		String saveFile = "/upload "+part.getSubmittedFileName();
		saveFile=getServletContext().getRealPath(saveFile);
		
		//Tạo thư mục cha chứa đường dẫn lưu file
		File file = new File(saveFile);
		File parentDir = file.getParentFile();
		if(parentDir!=null && !parentDir.exists()) {
			parentDir.mkdirs();
		}
		
		//Lưu file vào đường dẫn
//		InputStream inputstream = part.getInputStream();
//		Files.copy(inputstream,file.toPath(),StandardCopyOption.REPLACE_EXISTING);			
		part.write(saveFile);
		
		System.out.println(saveFile);
		
		req.getRequestDispatcher("/WEB-INF/upload.jsp").forward(req, resp);
	}
}
