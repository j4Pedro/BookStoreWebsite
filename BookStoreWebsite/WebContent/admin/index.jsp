<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>Bookstore Administration</title>
</head>
<body>

<jsp:directive.include file="header.jsp"/>

	<div align="center">
		<h3>DashBoard</h3>
	</div>
<hr width="80%"/>
	<div align="center">
		<h3>Qucik Action</h3>
		<a href="create_book">New book</a><br />
		<a href="create_user">New User</a><br />
		<a href="create_category">New Category</a>
		<a href="create_customer">New Customer</a>
	</div>
<hr width="60%"/>
	<div align="center">
		<h3>Recent Sales</h3>
	</div>
<hr width="60%"/>
	<div align="center">
		<h3>Recent Reviews</h3>
	</div>
<hr width="60%"/>
	<div align="center">
		<h3>Statstics</h3>
	</div>
<hr width="60%"/>



<jsp:directive.include file="footer.jsp"/>
</body>

</html>