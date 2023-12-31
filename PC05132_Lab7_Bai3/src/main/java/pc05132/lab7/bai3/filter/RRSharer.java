package pc05132.lab7.bai3.filter;

import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RRSharer {
	private static Map<Long, HttpServletRequest> reqs= new HashMap<Long, HttpServletRequest>();
	private static Map<Long, HttpServletResponse> resps = new HashMap<Long, HttpServletResponse>();
	
	public static void add(HttpServletRequest req, HttpServletResponse resp) {
		reqs.put(Thread.currentThread().getId(), req);
		resps.put(Thread.currentThread().getId(), resp);
	}
	
	public static void remove() {
		reqs.remove(Thread.currentThread().getId());
		resps.remove(Thread.currentThread().getId());
	}
	
	public static HttpServletRequest request() {
		return reqs.get(Thread.currentThread().getId());
	}
	
	public static HttpServletResponse respone() {
		return resps.get(Thread.currentThread().getId());
	}
}
