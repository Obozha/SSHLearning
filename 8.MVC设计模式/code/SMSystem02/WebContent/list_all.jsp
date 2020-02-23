<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
			function onDelete(sid) {
				var result = confirm("你是否要删除这一条数据");
				if (result) {
					window.location.href = 'DeleteStuServlet?sid=' + sid;
				}
			}
		</script>
</head>
<body>
	<table border="1">
		<tr>
			<td colspan="7">
				<form action="DisplayFuzzyQueryServlet" method="post"
					style="margin-bottom: 0px;">
					姓名:<input type="text" name="sname" /> &nbsp;&nbsp; 性别:<select
						name="gender">
						<option value="男">男</option>
						<option value="女">女</option>
						<option value=""></option>
					</select> <input type="submit" value="模糊查询" />&nbsp;&nbsp;&nbsp;<a
						href="add.jsp">增加</a>
				</form>
			</td>
		</tr>
		<tr>
			<td>姓名</td>
			<td>性别</td>
			<td>电话</td>
			<td>生日</td>
			<td>爱好</td>
			<td>简介</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${ list }" var="stu">
			<tr>
				<td>${stu.sname }</td>
				<td>${stu.gender }</td>
				<td>${stu.phone }</td>
				<td>${stu.birthday }</td>
				<td>${stu.hobby }</td>
				<td>${stu.info }</td>
				<td><a href="DisplayOneStuServlet?sid= ${stu.sid}">更新</a> <a
					href="#" onclick="onDelete( ${stu.sid} )">删除</a></td>
			</tr>
		</c:forEach>
	</table>
	<p>
		更新状态：
		<c:if test="${ status }">更新成功</c:if>
		<c:if test="${ !status }">更新失败</c:if>
	</p>
</body>
</html>
