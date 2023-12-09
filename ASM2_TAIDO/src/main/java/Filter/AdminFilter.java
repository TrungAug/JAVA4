package Filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pc03980.entity.Account; 

@WebFilter({"/admin/*"  })
public class AdminFilter implements Filter{

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain fil)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) req;
		HttpServletResponse httpServletResponse = (HttpServletResponse) resp;
		pc03980.entity.Account account =  (Account) httpServletRequest.getSession().getAttribute("account");
		if (account == null || !account.isAdmin()) {
			httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/log_in");
		} else {
			fil.doFilter(httpServletRequest, httpServletResponse);
		}

	
		
	}

}
