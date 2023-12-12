package pc05132.finaltest.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pc05132.finaltest.entity.Account; 

@WebFilter({"/admin/*"  })
public class AdminFilter implements Filter{

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain fil)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) req;
		HttpServletResponse httpServletResponse = (HttpServletResponse) resp;
		Account account =  (Account) httpServletRequest.getSession().getAttribute("account");
		if (account == null || !account.isAdmin()) {
			httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/user/login");
		} else {
			fil.doFilter(httpServletRequest, httpServletResponse);
		}

	
		
	}

}
