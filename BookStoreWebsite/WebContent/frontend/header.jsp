<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div align="center">

	<div>
		<img src="images/logo22473.png" />
	</div>
	<div>
		<input type="text" name="keyword" size="50" /> 
		<input type="button" value="search" /> 
		<a href="Login">Sing in</a> 
		<a href="register">Register</a>
		<a href="view_cart">Cart</a>

	</div>
	<div>&nbsp;</div>

	<div>
		<c:forEach var="category" items="${listCategory}">
			<a href="view_category?id=${category.categoryId}"> 
				<font size="+1"><b><c:out value="${category.name}" /></b></font>
			</a>
			<c:if test="${not status.last}">
				&nbsp; |&nbsp; 
			</c:if>
			
		</c:forEach>
	</div>
</div>