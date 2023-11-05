package pc05132.lab2.bai4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet({ "/","/hit-counter" })
public class HitCounterServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	int count;
	Path path = Paths.get("c:/temp/count.txt");

	@Override
	public void init() throws ServletException {
		try {
			count = Integer.parseInt(Files.readAllLines(path).get(0));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		count++;
		req.setAttribute("count", count);
		req.getRequestDispatcher("/views/hit-counter.jsp").forward(req, resp);
	}

	@Override
	public void destroy() {
		try {
			Files.write(path, String.valueOf(count).getBytes(), StandardOpenOption.WRITE);
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
}
