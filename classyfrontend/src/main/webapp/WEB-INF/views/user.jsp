<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c1" %> 
<%@ taglib uri="http://www.springframework.org/tags" prefix="c" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>



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
  label{
  color:red;
  }
  h2{
  color:green;
  }
/*   p{ */
/*   color:green;} */
  </style>
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

<center><h2>USER</h2></center>
<c:url value="/adduser" var="add"/>
<form:form action="${add}" method="post" commandName="user" >
<div class="row">
<div class="col-sm-4">
</div>
<div class="col-sm-4">
<div class="form-group">
<label for="text">USER_ID</label>
<form:input type="text" path="uid" class="form-control" placeholder="enter your id"/>
</div>
</div>
</div>
  
 <div class="row">
 <div class="col-sm-4">
 </div>
 <div class="col-sm-4">
 <label for="text">NAME:</label>
<form:input type="text" name="username" path="uname" class="form-control" placeholder="enter your name"/>
</div>
</div>
<div class="row">
<div class="col-sm-4">
</div>
 <div class="col-sm-4">
<div class="form-group">
<label for="pwd">PASSWORD</label>
<form:input type="password" name="password" path="" class="form-control" placeholder="enter your password" />
</div>
</div>
</div>
<div class="row">
 <div class="col-sm-4">
 </div>
 <div class="col-sm-4">
 
<div class="form-group">
<label for="email">ADDRESS</label>
<form:input type="text" name="address" path="address" class="form-control" placeholder="enter your address" />
</div>
</div>
</div>
<div class="row">
<div class="col-sm-4">
</div>
 <div class="col-sm-4">
<div class="form-group">
<label for="email">EMAIL_ID</label>
<form:input type="email" name="usermail"  path="email" class="form-control" placeholder="enter your mail id" />
</div>
</div>
</div>

<div class="row">
<div class="col-sm-4">
</div>
 <div class="col-sm-4">
<div class="form-group">
<label for="email">PHONE_NO</label>
<form:input type="text" name="phone" path="phone" class="form-control" placeholder="enter your phone no" />
</div>
</div>
</div>
<!-- <div class="row"> -->
<!-- <div class="col-sm-4"> -->
<!-- </div> -->
<center><h3 style="color:yellow"><strong>ENTER BILLING DETAILS</strong></h3></center>>
<!-- </div> -->
<!-- </div> -->
<div class="row">
<div class="col-sm-4">
</div>
 <div class="col-sm-4">
<div class="form-group">
<label for="b_id">BILLING_ID</label>
<input type="text"  path="bill.b_id" class="form-control"/>
</div>
</div>
</div>
<div class="row">
<div class="col-sm-4">
</div>
 <div class="col-sm-4">
<div class="form-group">
<label for="b_dno">DOOR NO</label>
<input type="text" name="doorno" path="user1.b_dno" class="form-control" placeholder="enter your door no">
</div>
</div>
</div>
<div class="row">
<div class="col-sm-4">
</div>
 <div class="col-sm-4">
<div class="form-group">
<label for="street">STREET</label>
<input type="text" name="street" path="user1.b_street" class="form-control" placeholder="enter current street dress">
</div>
</div>
</div>
<div class="row">
<div class="col-sm-4">
</div>
 <div class="col-sm-4">
<div class="form-group">
<label for="email">LOCALITY</label>
<input type="text" name="locality" path="b_locality" class="form-control" placeholder="enter your current locality">
</div>
</div>
</div>
<div class="row">
<div class="col-sm-4">
</div>
 <div class="col-sm-4">
<div class="form-group">
<label for="email">CITY</label>
<input type="text" name="city" path="b_city" class="form-control" placeholder="enter your city" >
</div>
</div>
</div>
<div class="row">
<div class="col-sm-4">
</div>
 <div class="col-sm-4">
<div class="form-group">
<label for="email">STATE</label>
<input type="text" name="state" path="b_state" class="form-control" placeholder="enter your state">
</div>
</div>
</div>
<div class="row">
<div class="col-sm-4">
</div>
 <div class="col-sm-4">
<div class="form-group">
<label for="email">PINCODE</label>
<input type="text" name="pincode" path="b_pincode" class="form-control" placeholder="pincode" >
</div>
</div>
</div>
<center><button id="button" class="btn btn-primary" type="submit">submit</button></center>

</form:form>
<br>
<br>
</body>
</html>


















  