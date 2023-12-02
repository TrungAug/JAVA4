package pc05132.lab7.bai2.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pc05132.lab7.bai2.model.AccountMod;

@WebFilter("/account/result")
public class ResultFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest httpServletRequest =(HttpServletRequest) request;
		HttpServletResponse httpServletResponse=(HttpServletResponse) response;
		
		AccountMod account = (AccountMod) httpServletRequest.getSession().getAttribute("userLogin");
		
		if(account==null) {
			httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/account/sign-in");
		}else {
			chain.doFilter(httpServletRequest, httpServletResponse);
		}
	}
	
}
