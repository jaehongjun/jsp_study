package servlet;

//import static javax.servlet.http.HttpServlet.lStrings;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {
	// http://raw.githubusercontent.com/cafree/eclipse/master/decompiler/update/
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("두포스트 호출"+req.getParameterMap());
		PrintWriter out = resp.getWriter();
		doProcess(resp,"두겟 호출"+req.getParameterMap());
		/*
		 * String protocol = req.getProtocol(); String msg =
		 * lStrings.getString("http.method_post_not_supported"); if
		 * (protocol.endsWith("1.1")) {
		 * resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, msg); } else {
		 * resp.sendError(HttpServletResponse.SC_BAD_REQUEST, msg); }
		 */
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Map<String,String[]> m = req.getParameterMap();
		Iterator<String> it = m.keySet().iterator();
		String result = "두겟 호출"; 
		while(it.hasNext()) {
			String key = it.next();
			result += key +" : " + req.getParameter(key);
		}

		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=utf-8");
		doProcess(resp,result);
		/*
		 * String protocol = req.getProtocol(); String msg =
		 * lStrings.getString("http.method_get_not_supported"); if
		 * (protocol.endsWith("1.1")) {
		 * resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, msg); } else {
		 * resp.sendError(HttpServletResponse.SC_BAD_REQUEST, msg); }
		 */
	}
	public void doProcess(HttpServletResponse resp,String writeStr) throws IOException{
		System.out.println(writeStr);
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.print(writeStr);
	}

}
