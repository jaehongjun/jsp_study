<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="javax.script.ScriptEngine"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Statement"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		
		Connection con;
		String url = "jdbc:mysql://localhost:3306/jsp_study";
		String dbConId = "root";
		String dbConPwd = "1234";
		PreparedStatement ps;
		String id = request.getParameter("id1");
		String pwd = request.getParameter("pwd1");
		String result = id+"는 없는 아이디입니다.";
		session.setAttribute("login", "false");
		
		try {
			Class.forName("org.mariadb.jdbc.Driver"); // 리플렉션? 드라이버,인터페이스를 사용하기위해 사용
			con = DriverManager.getConnection(url, dbConId, dbConPwd); //DB커넥트
			String sql = "select * from user where id=?";
			ps = con.prepareStatement(sql); //쿼리실행전
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				if (pwd.equals(rs.getString("password"))) {
					result = "로그인했습니다.";
					session.setAttribute("login", "true");
					session.setAttribute("id",id);
				} else {
					result = "비밀번호 오류";
				}

			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			// TODO: handle exception
		} catch (SQLException e) {
			// TODO: handle exception
		}

		boolean login = false;
		
		
	%>
	<%-- 	<script>
	//=붙이면 프린트
	alert("<%=result%>");
	if("<%=login%>
		" == "false") {
			location.href = "index.html";
		}
	</script> --%>
	<%= session.getId()%>
	
	<script>
		alert("<%=result%>");
		location.href="/login.jsp";
	</script>
</body>
</html>