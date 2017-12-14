<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
  
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
body {
    background-color: lightblue;
}
<!-- navbar active -->
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #333;
}

li {
    float: left;
}

li a {
    display: block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

li a:hover:not(.active) {
    background-color: #111;
}

.active {
    background-color: #4CAF50;
}
</style>
</head>
<body background="">
<!-- header -->
<!-- <div class="w3-container"> -->
<%--  <h1><center>LAPTOP</center></h1> --%>

<!-- navbar -->
 <div class="container-fluid">
  <nav class="navbar navbar-inverse">
 <div class="navbar-header">
      <a class="navbar-brand" href="">CLASSY</a>
	 </div>
	 <ul class="nav navbar-nav">
	 <li> <a href="<c:url value="/supplier"/>">supplier</a></li>
	 <li><a href="<c:url value="/product"/>">product</a></li>
	 <li><a href="<c:url value="/user"/>">user</a></li>
	 <li><a href="<c:url value="/category"/>">category</a></li>
	 </ul>
    <ul class="nav navbar-nav pull-right">
      <li ><a href="<c:url value="/home"/>"><span class="glyphicon glyphicon-home"></span>home</a></li>
      <li><a href="<c:url value="/contact"/>"><span class="glyphicon glyphicon-user"></span>contact</a></li>
      <li><a href="<c:url value="/about"/>">about us</a></li>
      <li><a href="<c:url value="/login"/>"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    <li><a href="<c:url value="/login"/>">logout</a></li>
    <li><a href="<c:url value="/home"/>"><span class="glyphicon glyphicon-user"></span> Sign out</a></li>
     </ul>

</nav>
</div>
 
 
<!-- <!-- insta icon--> -->
<!-- <span class="fa-stack fa-3x"> -->
<!--   <i class="fa fa-circle-thin fa-stack-2x"></i> -->
<!--   <i class="fa fa-instagram fa-stack-1x"></i> -->
<!-- </span> -->
<!-- <br> -->
<!-- <!-- whatsapp icon--> -->
<!-- <span class="fa-stack fa-3x"> -->
<!--   <i class="fa fa-circle-thin fa-stack-2x"></i> -->
<!--   <i class="fa fa-whatsapp fa-stack-1x"></i> -->
<!-- </span> -->
	
<!-- <!-- google icon--> -->
<!-- <span class="fa-stack fa-3x"> -->
<!--   <i class="fa fa-circle-thin fa-stack-2x"></i> -->
<!--   <i class="fa fa-chrome fa-stack-1x"></i> -->
<!-- </span>	 -->

<!-- <!-- linkedin icon--> -->
<!-- <span class="fa-stack fa-3x"> -->
<!--   <i class="fa fa-circle-thin fa-stack-2x"></i> -->
<!--   <i class="fa fa-linkedin fa-stack-1x"></i> -->
<!-- </span> -->
<%-- </center> --%>
<!--     </div> -->
	
<!-- 	<div class="col-sm-4"> -->
<!-- 	</div> -->
<!-- 	</div> -->
<!-- 	</div> -->
<!-- 	<br> -->
<!-- 	<br> -->
<!-- 	<br> -->
	
<!-- 	<!-- paragraph --> -->
<%-- <p><strong><center>11.4297</center></strong></p> --%>
<%-- <p><strong><center>info@.com</center></strong></p> --%>
<%-- <p><strong><center>122,avenue road</center></strong></p> --%>
<%-- <p><strong><center>Bangalore 560081</center></strong></p> --%>

	
  </body>
  </html>