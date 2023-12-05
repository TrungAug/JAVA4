package pc05132.lab8.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface HttpFilter extends Filter{
	@Override
	default void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
			HttpServletRequest request =(HttpServletRequest) req;
			HttpServletResponse respone=(HttpServletResponse) resp;
			this.doFilter(request, respone, chain);
	}
	
	void Filter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws IOException, ServletException;

	@Override
	default void init(FilterConfig filterConfig) throws ServletException {
		
	}
	
	@Override
	default void destroy() {
		
	}

}
