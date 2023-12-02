package pc05132.layout.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter({"/"})
public class LocaleFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse respone, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest =(HttpServletRequest) request;
		HttpServletResponse httpServletResponse= (HttpServletResponse) respone; 
		String lang = httpServletRequest.getParameter("lang");
		
		if(lang!=null) {
			httpServletRequest.getSession().setAttribute("lang",lang);
		}
		chain.doFilter(httpServletRequest, httpServletResponse);
	}

}
