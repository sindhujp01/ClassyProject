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
h1{
color:darkblue;
}
p{
color:red;
}
h3{
color:green;
}
</style>

</style>
</head>
  <body background="4.jpg">
 
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

<center><h1>ABOUT US</h1></center>
<center><p>The Amazon.in marketplace is operated by Amazon Seller Services Private Ltd, an affiliate of Amazon.com, Inc.</p></center>
 <center><p>Amazon.in seeks to build the most customer-centric online destination for customers to find and </p></center>
 <center><p>discover virtually anything they want to buy online by giving them more of what they want – vast selection,low prices,</p></center>
<center><p> fast and reliable delivery,and a trusted and convenient experience; 
 and provide sellers with a world-class e-commerce platform.</p></center>
 <p></p>
 <center><h3>You can select your collections through</h3></center>
 <br>
 <div class="container">
 <div class="row">
 <div clss="col-sm-4">
 </div>
 <div class="col-sm-4">
 </div>
 <div class="col-sm-4">
 <img src="${img}/C1.png" width="100" height="50">
 <img src="${img}/C2.png" width="100" height="50">
 <img src="${img}/C3.jpg" width="100" height="50">
 </div>
 </div></div>
</body>
</html>