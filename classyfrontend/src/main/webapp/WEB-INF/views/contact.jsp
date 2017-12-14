<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c1" %> 
<%@ taglib uri="http://www.springframework.org/tags" prefix="c" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!doctype html>
<html >
<head>
<c:url value="/resources/images" var="img"/>
<c:url value="/resources/css" var="css"/>
<c:url value="/resources/js" var="js"/>

  <title>dresses</title>
  <link rel="stylesheet" href="${css}/bootstrap.min.css">
  <link rel="stylesheet" href="${css}/font-awesome.min.css">
  <script src="${js}/jquery.min.js"></script>
  <script src="${js}/bootstrap.min.js"></script>
<style>
h2{
color:orange;}
p{
color:blue;}

 body{ 
 background-repeat:no-repeat; 
background-size:1400px 800px; 
}
</style>
</head>
<body background="${img}/4.jpg">
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
     <li><a href="<c:url value="/home"/>"><span class="glyphicon glyphicon-user"></span> Sign out</a></li>
     
     </c1:if>
     </ul>

</nav>
</div>

<div class="container">
<center><h2>contact us</h2></center>
<div class="row">
<div class="col-sm-4">
</div>

<div class="col-sm-4">
<center>
<br>
<p><b>Email :</b> sindhujp01@gmail.com</p>
<p><b>Phone no :</b> 9066574663</p>
<p><b>Facebook :</b> sindhu gowda jp</p></center>
</div>
</div>
<div class="row">
<div class="col-sm-4">
</div>
<div class="col-sm-4">
<br><center>
<img src="${img}/b6.png" width="80" height="50">
 <img src="${img}/b3.jpg" width="80" height="50">
 <img src="${img}/b8.png" width="80" height="50"></center>
 </div>
 </div>
 </div>
</body>