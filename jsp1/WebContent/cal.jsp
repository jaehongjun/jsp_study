<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.Import"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List" %>
<%@page import="javax.script.ScriptEngine" %>
<%@page import="java.sql.Connection" %>
<%@page import="java.sql.DriverManager" %>
<%@page import="java.sql.ResultSet" %>
<%@page import="java.sql.SQLException" %>
<%@page import="java.sql.Statement" %>

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	List<String> list = new ArrayList<String>();
	int num1 = Integer.parseInt(request.getParameter("num1"));
	String op = request.getParameter("op");
	int num2 = Integer.parseInt(request.getParameter("num2"));
	int result =0;
	if(op.equals("+")){
		result = num1+num2;
	}else if(op.equals("-")){
		result = num1-num2;
	}else if(op.equals("*")){
		result = num1*num2;
	}else if(op.equals("/")){
		result = num1/num2;
	}
	out.println(" 결과: " +result);
	
	switch(op){
		case "+": result = num1+num2;break;
		case "-": result = num1-num2;break;
		case "*": result = num1*num2;break;
		case "/": result = num1/num2;break;
	}
	
	out.println(" 결과: " +result);
	
	
	for(int num=10; num<=100; num+=10){
		list.add(""+num);
	}
	
	for(String str:list){
		out.println("<BR>"+str);
	}
	
	
	

%>
</body>
<script>
 
</script>
</html>