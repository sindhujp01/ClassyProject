<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c1" %> 
<%@ taglib uri="http://www.springframework.org/tags" prefix="c" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

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
  h2{
  color:green;
  }
  tr{
  text-align:center;}
  tr:hover {background-color: #f5f5f5}
  td{
  background-color: pink;
  color:solid black;
  }
  table {
     border-collapse: collapse;
     border: 1px solid black;
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


<center><h2>PRODUCT</h2></center>
<c:url value="/addpro" var="add"/>
<form:form action="${add}" commandName="prod" method="post" enctype="multipart/form-data">
<div class="row">
<div class="col-sm-4">
</div>
<div class="col-sm-4">
<div class="form-group">
<label for="text">PRODUCT_ID</label>
<form:input type="text" path="p_id" class="form-control" placeholder="enter your id"/>
</div>
</div>
</div>
  
 <div class="row">
 <div class="col-sm-4">
 </div>
 <div class="col-sm-4">
 <label for="text">PRODUCT NAME:</label>
<form:input type="text" name="product name" path="p_name" class="form-control" placeholder="enter product name"/>
</div>
</div>
<div class="row">
<div class="col-sm-4">
</div>
 <div class="col-sm-4">
<div class="form-group">
<label for="pwd">QUANTITY</label>
<form:input type="text" name="quantity" path="p_quantity" class="form-control" placeholder="quantity"/>
</div>
</div>
</div>
<div class="row">
 <div class="col-sm-4">
 </div>
 <div class="col-sm-4">
 
<div class="form-group">
<label for="email">PRICE</label>
<form:input type="text" name="price" path="p_price" class="form-control" placeholder="price"/>
</div>
</div>
</div>
<div class="row">
<div class="col-sm-4">
</div>
 <div class="col-sm-4">
<div class="form-group">
<label for="email">DESCRIPTION</label>
<form:input type="text" name="description" path="p_description" class="form-control" placeholder="description"/>
</div>
</div>
</div><div class="row">
<div class="col-sm-4">
</div>
 <div class="col-sm-4">
<div class="form-group">
<label for="image">IMAGE</label>
<form:input path="pimg" type="file" name="image" value="upload file"/>
</div>
</div>
</div>

<center><button id="button" class="btn btn-primary" type="submit">submit</button></center>
</form:form>
<br>
<br>
<center>
<table style="border:1px solid black">
<tr style="background-color:#eee">

<th style="border:1px solid black">ProductID</th>
<th style="border:1px solid black">Product NAME</th>
<th style="border:1px solid black">Quantity</th>
<th style="border:1px solid black">Price</th>
<th style="border:1px solid black">Description</th>
<th style="border:1px solid black">Image</th>
<th colspan="2" style="border:1px solid black">Edit/Delete</th>

<center><tbody>
<c1:forEach items="${products}" var="prod">
<tr sytle="border:1px solid black">
<td sytle="border:1px solid black">${prod.getP_id()}</td>
<td sytle="border:1px solid black">${prod.getP_name()}</td>
<td sytle="border:1px solid black">${prod.getP_quantity()}</td>
<td sytle="border:1px solid black">${prod.getP_price()}</td>
<td sytle="border:1px solid black">${prod.getP_description()}</td>
<td sytle="border:1px solid black"><img src="<c:url value="resources/images/${prod.getP_id()}.jpg"/>"></td>
<td sytle="border:1px solid black"><a href="<c:url value="/editproduct/${prod.getP_id()}"/>" class="btn btn-info">EDIT</a></td>
<td sytle="border:1px solid black"><a href="<c:url value="/deleteprod/${prod.getP_id()}"/>" class="btn btn-danger">DELEETE</a></td>

</tr>
</c1:forEach>
</tbody>
</center>
</tr>
</table>
</center>
<br>
</body>
</html>


















  