<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="AddStuServlet" method="post">
		<table border="1">
			<tr>
				<td>姓名</td>
				<td><input type="text" name="sname"></td>
			</tr>
			<tr>
				<td>性别</td>
				<td><input type="radio" value="男" name="gender" />男 <input
					type="radio" value="女" name="gender" />女</td>
			</tr>
			<tr>
				<td>电话</td>
				<td><input type="text" name="phone"></td>
			</tr>
			<tr>
				<td>生日</td>
				<td><input type="date" name="birthday" /></td>
			</tr>
			<tr>
				<td>爱好</td>
				<td><input type="checkbox" name="hobby" id="" value="篮球" />篮球
					<input type="checkbox" name="hobby" id="" value="计算机" />计算机 <input
					type="checkbox" name="hobby" id="" value="唱歌" />唱歌</td>
			</tr>
			<tr>
				<td>简介</td>
				<td><textarea rows="5" name="info" cols="20"></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="更新" /></td>
			</tr>
		</table>
	</form>
</body>
</html>
