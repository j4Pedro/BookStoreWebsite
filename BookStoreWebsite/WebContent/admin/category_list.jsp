<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../css/style.css" />
<meta charset="UTF-8">
<title>Manage Categories - Bookstore Administration</title>
</head>
<body>
	<jsp:directive.include file="header.jsp" />

	<div align="center">
		<h2 class="pageheading">Category Management</h2>
		<h3>
			<a href="category_form.jsp">Create New Category 新增類別</a>
		</h3>
	</div>
	<c:if test="${message != null}">
		<div align="center">
			<h4 class="message">
				${message}
			</h4>
		</div>
	</c:if>


	<div align="center">
		<table border="1" cellpadding="5">
			<tr>
				<th>Index</th>
				<th>ID</th>
				<th>Name</th>
				<th>Actions</th>
			</tr>
			<c:forEach var="cat" items="${listCategory}" varStatus="status">
				<tr>
					<td>${status.index + 1}</td>
					<td>${cat.categoryId}</td>
					<td>${cat.name}</td>
					<td>
						<a href="edit_category?id=${cat.categoryId}">Edit</a>|| 
						<a href="javascript:confirmDelete(${cat.categoryId})">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<jsp:directive.include file="footer.jsp" />
	<script>
		function confirmDelete(categoryId) {
			if (confirm("確定要刪除 ID:" + categoryId + " ??")) {
				window.location = "delete_category?id=" + categoryId;
			}
		}
	</script>
</body>

</html>