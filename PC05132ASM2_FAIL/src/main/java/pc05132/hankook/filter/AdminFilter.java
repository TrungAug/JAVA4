//package pc05132.hankook.filter;
//
//import java.io.IOException;
//
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebFilter;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import pc05132.hankook.entity.User;
//
//@WebFilter("/admin/*")
//public class AdminFilter implements HttpFilter {
//
//	@Override
//	public void Filter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain)
//			throws IOException, ServletException {
//		User  user = (User) req.getSession().getAttribute("userLogin");
//		if(user==null || !user.isAdmin()) {
//			resp.sendRedirect(req.getContextPath()+"/user-controller/sign-in");
//		}else {
//			chain.doFilter(req, resp);
//		}
//		
//	}
//
//}
