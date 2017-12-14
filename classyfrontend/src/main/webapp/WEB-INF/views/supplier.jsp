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
 //form{
border-style:groove;
background-color:;
margin-top:50px;
margin-bottom:100px;
margin-right:600;
margin-left:80;
padding-left:0cm;
}
label{
color:green;
}
h2{
color:darkblue;
}
/* body{ */
/* background-repeat:no-repeat; */
/* background-size:1400px 800px; */
/* } */
tr{
  text-align:center;}
  tr:hover {background-color: #f5f5f5}
  td{
  background-color: white;
  color:solid black;
  }
  table {
    border-collapse: collapse;
     border: 2px solid black;
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

<br>
<center><h2>SUPPLIER</h2></center>
<c:url value="/addsup" var="add"/>
<form:form action="${add}" method="post" commandName="supplier">
<div class="row">
<div class="col-sm-4">
</div>
<div class="col-sm-4">
<div class="form-group">
<label for="text">SUPPLIER_ID</label>
<form:input type="text" path="supid" class="form-control" />
</div>
</div>
</div>
  <div class="row">
 <div class="col-sm-4">
</div>
 <div class="col-sm-4">
 <label for="text">NAME</label>
<form:input type="text" path="supname" class="form-control" placeholder="enter your name"/>
</div>
</div>
<div class="row">
<div class="col-sm-4">
</div>
 <div class="col-sm-4">
<div class="form-group">
<label for="text">ADDRESS</label>
<form:input type="text" path="address" class="form-control" placeholder="enter your address"/>
</div>
</div>
</div>
<center><button id="button" class="btn btn-success" type="submit">submit</button></center>
</form:form>
<br>
<br
>
<center>
<table style="border:1px solid black">
<tr style="background-color:#eee">

<th style="border:1px solid black">Supplier ID</th>
<th style="border:1px solid black">Supplier NAME</th>
<th style="border:1px solid black">Supplier ADDRESS</th>
<th colspan="2" style="border:1px solid black">Edit/Delete</th>

<center><tbody>
<c1:forEach items="${suppliers}" var="sup">
<tr sytle="border:1px solid black">
<td sytle="border:1px solid black">${sup.getSupid()}</td>
<td sytle="border:1px solid black">${sup.getSupname()}</td>
<td sytle="border:1px solid black">${sup.getAddress()}</td>
<td sytle="border:1px solid black"><a href="<c:url value="/editsupplier/${sup.getSupid()}"/>" class="btn btn-info">EDIT</a></td>
<td sytle="border:1px solid black"><a href="<c:url value="/deletesup/${sup.getSupid()}"/>" class="btn btn-danger">DELEETE</a></td>

</tr>
</c1:forEach>
</tbody>
</center>
</tr>
</table>
</center>
<br>
<br>
</body>
</html>