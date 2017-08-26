package servlet;

//import static javax.servlet.http.HttpServlet.lStrings;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.DbConnector;
import service.UserService;
import service.impliment.UserServiceImpl;

public class UserServlet extends HttpServlet {
	private UserService us = new UserServiceImpl();
	// http://raw.githubusercontent.com/cafree/eclipse/master/decompiler/update/
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String name = req.getParameter("name");
		String[] hobbies = req.getParameterValues("hobby");
		
		String hobby = "";
		for(String h:hobbies) {
			hobby += h + ",";
		}
		hobby = hobby.substring(0, hobby.length()-1);
		Map<String,String> hm = new HashMap<String, String>();
		hm.put("id", id);
		hm.put("pwd", pwd);
		hm.put("name", name);
		hm.put("hobby", hobby);
		String result = us.insertUser(hm);
		doProcess(resp, result);
//		String result = "입력하신  ID : " + id + "<br>";
//		result += "입력하신 취미 : " + hobby + "<br>";
		
//		result = name+"님 회원가입 실패!";
//		Connection con;
//		try {
//			con = DbConnector.getCon();
//			String 	sql = "insert into user(id,password,name,hobby)";
//					sql += "values(?,?,?,?)";
//			PreparedStatement ps = con.prepareStatement(sql);
//			ps.setString(1, id);
//			ps.setString(2, pwd);
//			ps.setString(3, name);
//			ps.setString(4, hobby);
//			int row = ps.executeUpdate();
//			if(row==1) {
//				result = "회원가입 성공!";
//			}
//			//con.close();
//		}catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
		
		doProcess(resp, result);
		
/*		System.out.println("두포스트 호출"+req.getParameterMap());
		PrintWriter out = resp.getWriter();
		doProcess(resp,"두겟 호출"+req.getParameterMap());*/
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
