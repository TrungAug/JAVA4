package pc05132.useraccess.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pc05132.useraccess.entity.Account;

@WebFilter("/user")
public class UserFilter implements Filter {

	@Override
	public void doFilter(ServletRequest resquest, ServletResponse respone, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest =(HttpServletRequest) resquest;
		HttpServletResponse httpServletResponse=(HttpServletResponse) respone;
		Account account = (Account) httpServletRequest.getSession().getAttribute("accountSS");
		
		if(account==null) {
			httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/login");
		}else {
			chain.doFilter(httpServletRequest, httpServletResponse);
		}
	}

}
