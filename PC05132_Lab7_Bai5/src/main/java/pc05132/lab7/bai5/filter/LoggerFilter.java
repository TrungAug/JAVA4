package pc05132.lab7.bai5.filter;

import java.io.IOException;
import java.util.Date;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pc05132.lab7.bai5.model.AccountMod;

@WebFilter(filterName = "LoggerFilter",urlPatterns = "/admin/*")
public class LoggerFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req =(HttpServletRequest) request;
		HttpServletResponse resp=(HttpServletResponse) response;
		
		AccountMod account = (AccountMod) req.getSession().getAttribute("userLogin");
		String uri = req.getRequestURI();
		Date time = new Date();
		
		//ghi nhận vào cơ sở dữ liệu Log
		
		// in thông tin 
		System.out.println(account.toString());
		System.out.println(uri);
		System.out.println(time);
		
		chain.doFilter(req, resp);
	}
	
}
