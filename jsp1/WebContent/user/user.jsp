<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List" %>
<%@page import="javax.script.ScriptEngine" %>
<%@page import="java.sql.Connection" %>
<%@page import="java.sql.DriverManager" %>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.SQLException" %>
<%@page import="java.sql.Statement" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
Connection con;
String url = "jdbc:mysql://localhost:3306/jsp_study";
String id = "root";
String pwd = "1234";
Statement st;
try {
	Class.forName("org.mariadb.jdbc.Driver"); // 리플렉션? 드라이버,인터페이스를 사용하기위해 사용
	con = DriverManager.getConnection(url, id, pwd); //DB커넥트
	out.println("연결 성공"+"<br>");
	st = con.createStatement(); //쿼리실행전
	ResultSet rs = st.executeQuery("select * from user where user_no=1");
	out.println("<table border='1'>");
	while(rs.next()) {
		out.println("<tr>");
		out.println("<td>");
		out.print(rs.getString("user_no")+"<br>");
		out.println("</td>");
		out.println("<td>");
		out.print(rs.getString("id")+"<br>");
		out.println("</td>");
		out.println("<td>");
		out.print(rs.getString("password")+"<br>");
		out.println("</td>");
		out.println("<td>");
		out.println(rs.getString("name")+"<br>");
		out.println("</td>");
		out.println("</tr>");
	}
} catch (ClassNotFoundException e) {
	e.printStackTrace();
	// TODO: handle exception
} catch (SQLException e) {
	// TODO: handle exception
}
%>
</body>
</html>