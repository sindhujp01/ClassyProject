<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c1" %> 
<%@ taglib uri="http://www.springframework.org/tags" prefix="c" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>




<!DOCTYPE html>
<html >
<head>
<c:url value="/resources/images" var="img"/>
<c:url value="/resources/css" var="css"/>
<c:url value="/resources/js" var="js"/>
  <title>Indian</title>
  <link rel="stylesheet" href="${css}/bootstrap.min.css">
  <link rel="stylesheet" href="${css}/font-awesome.min.css">
  <script src="${js}/jquery.min.js"></script>
  <script src="${js}/bootstrap.min.js"></script>

  <style>
/*   .carousel-inner > .item > p, */
/*   .carousel-inner > .item > a > p { */
/*       width: 100%; */
/*       margin: auto; */
/*   } */
  </style>
</head>
<body>
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

<div class="container">
<!-- <ul class="nav nav-tabs"> -->
<!--     <li class="active"><a data-toggle="tab" href="/p3.jsp">Home</a></li> -->
<!-- 	 <li><a data-toggle="tab" href="/indian.jsp">Indian</a></li> -->
<!--     <li><a data-toggle="tab" href="/summer.jsp">summer</a></li> -->
<!--     <li><a data-toggle="tab" href="/modern.jsp">Modern</a></li> -->
<!--   </ul> -->
<!-- <br> -->
<!-- <br> -->

<center><h1>Indian dress</h1></center>
<br>
<div class="container">
<div class="row">
<div class="col-sm-4">
  <img src="${img}/i10.jpg" class="img-rounded" alt="lord ganesha" width="250" height="350">
  </div>
  <div class="col-sm-4">
  <img src="${img}/i1.jpg" class="img-rounded" alt="lord ganesha" width="304" height="350">
  </div>
  <div class="col-sm-4">
  <img src="${img}/i2.jpg" class="img-rounded" alt="lord ganesha" width="304" height="350">
  </div>
  </div>
  <br>
  <div class="row">
  <div class="col-sm-4">
  <img src="${img}/i3.jpg" class="img-rounded" alt="lord ganesha" width="304" height="350">
  </div>
  <div class="col-sm-4">
  <img src="${img}/i4.jpg" class="img-rounded" alt="lord ganesha" width="304" height="350">
  </div>
  <div class="col-sm-4">
  <img src="${img}/i5.jpg" class="img-rounded" alt="lord ganesha" width="304" height="350">
  </div>
  </div>
  <br>
  <div class="row">
  <div class="col-sm-4">
  <img src="${img}/i6.jpg" class="img-rounded" alt="lord ganesha" width="304" height="350">
  </div>
  <div class="col-sm-4">
  <img src="${img}/i7.jpg" class="img-rounded" alt="lord ganesha" width="304" height="350">
  </div>
  <div class="col-sm-4">
  <img src="${img}/i8.jpg" class="img-rounded" alt="lord ganesha" width="304" height="350">
  </div>
  </div>
  </div>
</body>
</html>