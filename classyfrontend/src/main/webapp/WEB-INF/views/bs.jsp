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
  <link rel="stylesheet" href="${css}/font-awesome.min.css">
  <script src="${js}/jquery.min.js"></script>
  <script src="${js}/bootstrap.min.js"></script>
  <style>
  label{
  color:green;
  }
  h2{
  color:green;
  }
   .border1{  
/*  border-style:groove;    */
/*  background-color:lightpink;   */
  margin-top:30px;  
/*   margin-bottom:100px;   */
   margin-right:200px;
  margin-left:-650px;  
  padding-left:20cm;
  
  }  
 
 fieldset
 {
 border:2px solid white;
 }
  
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

<div class="container">
<center><h2>ADDRESS ORDER</h2></center>
  <form>
<fieldset>
<!-- <div class="row"> -->
<div class="border1">
<div class="col-sm-7">
<label for="text">bid</label>
  <input type="text" path="b_id" class="form-control" name="billing id" placeholder="Enter billing id">
<label for="text">bname:</label>
  <input type="text" path="b_no" class="form-control" name="billing name" placeholder="enter billing name">
<label for="text">baddress:</label>
  <input type="text" path="b_street" class="form-control" name="billing address" placeholder="enter billing address">
<label for="text">blocality:</label>
  <input type="text" path="b_locality" class="form-control" name="billing locality" placeholder="enter billing locality">
<label for="text">bcity:</label>
  <input type="text" path="b_city" class="form-control" name="billing city" placeholder="enter billing address">
<label for="text">bstate:</label>
  <input type="text" path="b_state" class="form-control" name="billing state" placeholder="enter billing address">
<label for="text">bpincode:</label>
  <input type="text" path="b_pincode" class="form-control" name="billing pincode" placeholder="enter billing address">
  <br>
	<center><button id="button" class="btn btn-primary" type="submit">submit</button></center>
	</br>
</div>
</div>

<div class="col-sm-5"> 
<label for="text">sid:</label>
<input type="text" path="s_id" class="form-control" name="shipping id" placeholder="Enter shipping id">
<label for="text">sname:</label>
  <input type="text" path="s_no" class="form-control" name="shipping name" placeholder="enter shipping name">
<label for="text">saddress:</label>
  <input type="text" path="s_street" class="form-control" name="shipping address" placeholder="enter shipping address">
<label for="text">slocality:</label>
  <input type="text" path="s_locality" class="form-control" name="shipping locality" placeholder="enter shipping locality">
<label for="text">scity:</label>
  <input type="text" path="s_city" class="form-control" name="shipping city" placeholder="enter shipping address">
<label for="text">sstate:</label>
  <input type="text" path="s_state" class="form-control" name="shipping state" placeholder="enter shipping address">
<label for="text">spincode:</label>
  <input type="text" path="s_pincode" class="form-control" name="shipping pincode" placeholder="enter shipping address">
  <br>
	<center><button id="button" class="btn btn-primary" type="submit">submit</button></center>
	</br>
</div>
</div></fieldset>
</form>
</body>
</html>