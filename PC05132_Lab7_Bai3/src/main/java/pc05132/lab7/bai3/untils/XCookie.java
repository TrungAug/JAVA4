package pc05132.lab7.bai3.untils;

import jakarta.servlet.http.Cookie;
import pc05132.lab7.bai3.filter.RRSharer;

public class XCookie {
	public static void add(String name, String value, int hours) {
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(hours * 60 * 60);
		cookie.setPath("/");
		RRSharer.respone().addCookie(cookie);
	}

	public static String get(String name, String defaultValue) {
		Cookie[] cookies = RRSharer.request().getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equalsIgnoreCase("name")) {
					return cookie.getValue();
				}
			}
		}
		return defaultValue;
	}
}
