<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Bookstore Administration</title>
	<link rel="stylesheet" href="css/style.css" />
</head>
<body>

<jsp:directive.include file="header.jsp"/>

	<div align="center">
		<h3 class="pageheading">Administrative Dashboard</h3>
	</div>
<hr width="80%"/>
	<div align="center">
		<h3 class="pageheading">Qucik Action</h3>
		<a href="create_book">New book</a><br />
		<a href="create_user">New User</a><br />
		<a href="create_category">New Category</a>
		<a href="create_customer">New Customer</a>
	</div>
<hr width="60%"/>
	<div align="center">
		<h3 class="pageheading">Recent Sales:</h3>
	</div>
<hr width="60%"/>
	<div align="center">
		<h3 class="pageheading">Recent Reviews:</h3>
	</div>
<hr width="60%"/>
	<div align="center">
		<h3 class="pageheading">Statstics:</h3>
	</div>
<hr width="60%"/>



<jsp:directive.include file="footer.jsp"/>
</body>

</html>