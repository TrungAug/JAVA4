package pc05132.lab7.bai5.filter;

import java.io.IOException;
import java.net.URLEncoder;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pc05132.lab7.bai5.model.AccountMod;

@WebFilter(filterName = "AuthFiler",urlPatterns = {"/admin/*","/account/sign-in"})
public class AuthFiler implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
	
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp=(HttpServletResponse) response;
		String uri = req.getRequestURI();
		AccountMod account = (AccountMod) req.getSession().getAttribute("userLogin");
		String err ="";
		
		if (account == null) {
            err = "Vui lòng đăng nhập";
        } else if (!account.isAdmin() && uri.contains("admin")) {
            err = "Vui lòng đăng nhập với vai trò admin";
        }

        if (!err.isEmpty()) {
            req.getSession().setAttribute("securi", uri);
          //  resp.sendRedirect(req.getContextPath() + "/account/sign-in");
           resp.sendRedirect(req.getContextPath()+"/account/sign-in?err=" + URLEncoder.encode(err, "UTF-8"));
//            System.out.println(resp);
//            System.out.println(req.getContextPath());
        } else {
            chain.doFilter(req, resp);
        }
		
	}

}
