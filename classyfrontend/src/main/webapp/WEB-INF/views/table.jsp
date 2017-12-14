<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c1" %> 
<%@ taglib uri="http://www.springframework.org/tags" prefix="c" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
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
</head>

<body background="${img}/.jpg">

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

<div class="row">
<div class="col-sm-4">

<center>
<table class="table" style="border: 1px solid black; border-collapse: collapse;">
<tr style="background-color:#eee">

<tr style="border:1px solid black; border-collapse: collapse;">
<td style="border:1px solid black; border-collapse: collapse;"><p>BILLING ID:</p></td>
<td style="border:1px solid black; border-collapse: collapse;"><p>${billing.getb_id}</p></td></tr>
<tr style="border:1px solid black; border-collapse: collapse;">
<td style="border:1px solid black; border-collapse: collapse;"><p>BILLING NAME:</p></td>
<td style="border:1px solid black; border-collapse: collapse;"><p>${billing.getb_name()}</p></td></tr>
<tr style="border:1px solid black; border-collapse: collapse;">
<th style="border:1px solid black; border-collapse: collapse;"><p>BILLING ADDRESS:</p></th>
<td style="border:1px solid black; border-collapse: collapse;"><p>${billing.getb_address()}</p></td></tr>
<tr style="border:1px solid black; border-collapse: collapse;">
<th style="border:1px solid black; border-collapse: collapse;"><p>BILLING LOCALITY:</p></th>
<td style="border:1px solid black; border-collapse: collapse;"><p>${billing.getb_locality()}</p></td></tr>
<tr style="border:1px solid black; border-collapse: collapse;">
<th style="border:1px solid black; border-collapse: collapse;"><p>BILLING CITY:</p></th>
<td style="border:1px solid black; border-collapse: collapse;"><p>${billing.getb_city()}</p></td></tr>


<tr style="border:1px solid black; border-collapse: collapse;">
<th style="border:1px solid black; border-collapse: collapse;"><p>BILLING LOCALITY:</p></th>
<td style="border:1px solid black; border-collapse: collapse;"><p>${billing.getb_state()}</p></td></tr>
<tr style="border:1px solid black; border-collapse: collapse;">
<th style="border:1px solid black; border-collapse: collapse;"><p>PINCODE:</p></th>
<td style="border:1px solid black; border-collapse: collapse;"><p>${billing.getb_pincode()}</p></td></tr>

</tr>
</table></center>
</div></div>
</body>
</html>