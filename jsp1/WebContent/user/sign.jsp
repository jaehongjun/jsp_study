<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="sign.user" method="post">
		<table border=7>
			<tr>
				<td colspan=2>회원가입</td>
			</tr>
			<tr>
				<th>아이디</th>
				<td><input type="text" name='id' id='id' /></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name='pwd' id='pwd' /></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name='name' id='name' /></td>
			</tr>
			<tr>
				<th>취미</th>
				<td>수면<input type="checkbox" name='hobby' value="수면" />
					음악<input type="checkbox" name='hobby' value="음악" />
					영화<input type="checkbox" name='hobby' value="영화" />
					게임<input type="checkbox" name='hobby' value="게임" />
					요리<input type="checkbox" name='hobby' value="요리" />
					여행<input type="checkbox" name='hobby' value="여행" /></td>
			</tr>
			<tr>
				<td colspan=2><input  type="submit" value="로그인" /></td>
			</tr>
		</table>
	</form>
	<input type="hidden"  value="commend" value="sign"/>
</body>
</html>