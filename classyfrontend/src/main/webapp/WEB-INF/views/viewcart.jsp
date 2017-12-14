
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c1" %> 
<%@ taglib uri="http://www.springframework.org/tags" prefix="c" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>


<!doctype html>
<html>
<head>
<c:url value="/resources/images" var="img"/>
<c:url value="/resources/css" var="css"/>
<c:url value="/resources/js" var="js"/>
  <title>dresses</title>
   <link rel="stylesheet" href="${css}/bootstrap.min.css">
  <script src="${js}/jquery.min.js"></script>
  <script src="${js}/bootstrap.min.js"></script>
</head>

<body background="${img}/2.jpg">
<div class="container-fluid">
  <nav class="navbar navbar-inverse">
 <div class="navbar-header">
      <a class="navbar-brand" href="">CLASSY</a>
	 </div>
	 <ul class="nav navbar-nav">
	 <c1:if test="${pageContext.request.userPrincipal.name!=null}">
	 <security:authorize access="hasRole('ROLE_ADMIN')">
	 <li> <a href="<c:url value="/supplier"/>">supplier</a></li>
	 <li><a href="<c:url value="/product"/>">product</a></li>
	 <li><a href="<c:url value="/category"/>">category</a></li>
	 </security:authorize>
	 </c1:if>
	 </ul>
    <ul class="nav navbar-nav pull-right">
      <li ><a href="<c:url value="/home"/>"><span class="glyphicon glyphicon-home"></span>home</a></li>
      <li><a href="<c:url value="/contact"/>"><span class="glyphicon glyphicon-user"></span>contact</a></li>
      <li><a href="<c:url value="/about"/>">about us</a></li>
         <li><a href="<c:url value="/bs"/>">addOrder</a></li>
     <c1:if test="${pageContext.request.userPrincipal.name==null}">
     
     <li><a href="<c:url value="/login"/>"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
       <li><a href="<c:url value="/user"/>"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
     </c1:if>
     <c1:if test="${pageContext.request.userPrincipal.name!=null}">
     welcome ${pageContext.request.userPrincipal.name}
     </c1:if>
     </ul>

</nav>
</div>
<div class="table-responsive">
<table>
 <thead>
   <tr>
   		<th></th>
		<th>cart item id</th>
		<th>Product name</th>
		<th>description</th>
		<th>price</th>
		<th>quantity</th>
		<th colspan="2">BUY/REMOVE</th>
	</tr>
 </thead>
<tbody>
	<c1:forEach items="${viewcart}" var="cit">
<tr>	
	<td><img src="<c:url value="resources/images/${cit.getP().getP_id()}.jpg"/>"></td>
	<td></td>
	<td>${getP().getP_name()}</td>
	<td>${getP().getP_description()}</td>
	<td>${getP().getP_price()}</td>
	<td>${getP().getP_quantity()}</td>
	<td>${getP().getP_quantity()}</td>
	<td><a href="<c:url value="/addtocart/${getP().getP_id()}"/>" class="btn btn-info">BUY</a></td>
	<td><a href="<c:url value="/Remove/${getP().getP_id()}"/>" class="btn btn-info">REMOVE</a></td>
</tr>	
	</c1:forEach>

</tbody>
</table>
</div>
</body>
</html>