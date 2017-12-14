
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c1" %> 
<%@ taglib uri="http://www.springframework.org/tags" prefix="c" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%-- <%@ include file="navbar.jsp"%> --%>
<!doctype html>
<html >
<head>
<c:url value="/resources/images" var="img"/>
<c:url value="/resources/css" var="css"/>
<c:url value="/resources/js" var="js"/>
  <title>dresses</title>
   <link rel="stylesheet" href="${css}/bootstrap.min.css">
  <script src="${js}/jquery.min.js"></script>
  <script src="${js}/bootstrap.min.js"></script>

 <style>
 label{
 color:red;
 }
 </style></head>
 
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

 <div class="container">
 <center>
 <c:url value='/j_spring_security_check' var="Ln"/>
<form:form action="${Ln}" method="post" commandName="user">

<div class="row">
<div class="col-sm-4">
</div>
<div class="col-sm-4">
<img src="${img}/u1.png" class="img-circle" width="150" height="150">
</div>
</div>
<div class="row">
<div class="col-sm-4">
</div>
 <div class="col-sm-4">
<div class="form-group">
<label for="email">email_id:</label>
<input type="email" name="j_username" path="email" class="form-control" placeholder="enter your mail id">
</div>
</div>
</div>
  
 <div class="row">
 <div class="col-sm-4">
</div>
 <div class="col-sm-4">
<div class="form-group">
<label for="email">password:</label>
<input type="password" name="j_password" path="email" class="form-control" placeholder="enter your password">
</div>
</div>
</div>
<center><input id="button" class="btn btn-primary" type="submit" value="login"></input></center>
</div> 
</form:form> 
</center>
 </div> 
 </body>
 </html>
