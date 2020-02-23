<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="cc.sms.bean.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
		<c:forEach items="${ page.stuDataList }" var="stu">
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

		<tr>
			<td colspan="7">第 ${ page.currentPage } / ${ page.totalPage }
				&nbsp;&nbsp;&nbsp; 每页显示 ${ page.pageSize } 条 &nbsp;&nbsp;&nbsp;总记录数
				${ page.stuCount } &nbsp;&nbsp; <c:if
					test="${ page.currentPage!=1 }">
					<a href="DisplayCurrentPageServlet?currentPage=1">首页</a>|<a
						href="DisplayCurrentPageServlet?currentPage=${ page.currentPage-1 }">上一页</a>
				</c:if> <c:forEach begin="1" end="${ page.totalPage }" var="i">
					<c:if test="${ page.currentPage==i }">
						${ i }
					</c:if>
					<c:if test="${ page.currentPage!=i }">
						<a href="DisplayCurrentPageServlet?currentPage=${i}">${i}</a>
					</c:if>

				</c:forEach> <c:if test="${ page.currentPage!=page.totalPage }">
					<a
						href="DisplayCurrentPageServlet?currentPage=${ page.currentPage+1 }">下一页</a>
					<a href="DisplayCurrentPageServlet?currentPage=${page.totalPage}">尾页</a>
				</c:if>
			</td>
		</tr>
		<tr>
			<td colspan="7">
				<form action="ChangePageSizeServlet" method="post">
					设置每页显示大小： <input type="text" name="pageSize"
						onkeyup="this.value=this.value.replace(/[^0-9]+/,'')" ; /> <input
						type="submit" value="提交">
				</form>
			</td>
		</tr>
	</table>
</body>
</html>