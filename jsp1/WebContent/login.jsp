<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%	
	String login = "false";
if(session.getAttribute("login")!=null){
	login = (String)session.getAttribute("login");
}
	if(login.equals("false")){
		
%>
<%= request.getParameter("id") %>
	<form action="login_OK.jsp">
		아이디: <input type="text" id="id" name="id1" /> <br /> 
		비밀번호: <input type="password" id="pwd" name="pwd1" value="red" /> <br />
		<input type="submit" value="로그인" /> <br />
	</form>
	<%
	}else if(login.equals("true")){
		out.print(session.getAttribute("id")+"님 환영합니다.");
	}
	%>
	
	
</body>
</html>