package pc05132.lab8.filter;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter("/")
public class I18NFilter implements HttpFilter {

	@Override
	public void Filter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		String lang = req.getParameter("lang");
		if(lang!=null) {
			req.getSession().setAttribute("lang", lang);
		}
		chain.doFilter(req, resp);
	}

}
