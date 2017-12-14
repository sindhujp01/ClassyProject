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
  <title>modern</title>
  <link rel="stylesheet" href="${css}/bootstrap.min.css">
  <link rel="stylesheet" href="${css}/font-awesome.min.css">
  <script src="${js}/jquery.min.js"></script>
  <script src="${js}/bootstrap.min.js"></script>
  <style>
  .carousel-inner > .item > p,
  .carousel-inner > .item > a > p {
      width: 100%;
      margin: auto;
  }
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

<center><h1>modern dress</h1></center>
<br>
<div class="container">
<div class="row">
<div class="col-sm-4">
  <img src="${img}/m1.jpg" class="img-rounded" alt="happy life" width="250" height="350">
  </div>
  <div class="col-sm-4">
  <img src="${img}/m2.jpg" class="img-rounded" alt="happy life" width="250" height="350">
  </div>
  <div class="col-sm-4">
  <img src="${img}/m3.jpg" class="img-rounded" alt="happy life" width="304" height="350">
  </div>
  </div>
  <br>
  <div class="row">
  <div class="col-sm-4">
  <img src="${img}/m4.jpg" class="img-rounded" alt="happy life" width="304" height="350">
  </div>
  <div class="col-sm-4">
  <img src= "${img}/m5.jpg" class="img-rounded" alt="happy life" width="304" height="350">
  </div>
  <div class="col-sm-4">
  <img src="${img}/m10.jpg" class="img-rounded" alt="happy life" width="304" height="350">
  </div>
  </div>
  <br>
  <div class="row">
  <div class="col-sm-3">
  <img src="${img}/m6.jpg" class="img-rounded" alt="happy life" width="304" height="350">
  </div>
  <div class="col-sm-3">
  <img src="${img}/m7.jpg" class="img-rounded" alt="happy life" width="304" height="350">
  </div>
  <div class="col-sm-3">
  <img src="${img}/m8.jpg" class="img-rounded" alt="happy life" width="304" height="350">
  </div>
  <div class="col-sm-3">
  <img src="${img}/m9.jpg" class="img-rounded" alt="happy life" width="280" height="350">
  </div>
  </div>
  </br>
<br>  </div>
</body>
</html>