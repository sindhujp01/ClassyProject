<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c1" %> 
<%@ taglib uri="http://www.springframework.org/tags" prefix="c" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<!doctype html>
<html lang="en">
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
  .carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
      width: 50%;
      margin: auto;
  }
   body{
  background-color:#f3d8a5;
  }
 h2{
 font-family: verdana;}
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
	 welcome ${pageContext.request.userPrincipal.name}
     <li><a href="<c:url value="/home"/>"><span class="glyphicon glyphicon-user"></span> Sign out</a></li>
    
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
      <li><a href="<c:url value="/pay"/>">pay</a></li>
      <li><a href="<c:url value="/table"/>">table</a></li>
      <li><a href="<c:url value="/viewcart"/>"><span class="glyphicon glyphicon-cart"></span>cart</a></li>
         
     <c1:if test="${pageContext.request.userPrincipal.name==null}">
     
     <li><a href="<c:url value="/login"/>"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
       <li><a href="<c:url value="/user"/>"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
     </c1:if>
    
     
     </ul>

</nav>
</div>
<center><h2 >FASHIONABLE DRESSES</h2></center>

  <div class="container">
<br>
<div id="myCarousel" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
    <li data-target="#myCarousel" data-slide-to="3"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner" role="listbox">
    <div class="item active">
      <img src="${img}/c1.jpg" alt="A" height="250" width="250">
	  <div class="carousel-caption">
	  <h3>blue</h3>
    </div>
	</div>

    <div class="item">
      <img src="${img}/c11.jpg" alt="C" height="250" width="250">
    </div>

    <div class="item">
      <img src="${img}/c12.jpg" alt="F"  height="250" width="250">
    </div>

    <div class="item">
      <img src="${img}/c4.jpg" alt="F" height="250" width="250">
    </div>
  </div>

  <!-- Left and right controls -->
  <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
<br>
<div class="row">

  <div class="col-sm-4">
  <a href="<c:url value="/indian"/>">
  <img src="${img}/i1.jpg" class="img-rounded" alt="fancy" width="304" height="300"></a>
  <center><p><a href="<c:url value="/indian"/>">Indian dress</a></p></center>
  </div>

  <div class="col-sm-4">
  <a href="<c:url value="/modern"/>">
  <img src="${img}/m10.jpg" class="img-rounded" alt="fancy" width="304" height="300"></a>
 <center><p><a href="<c:url value="/modern"/>">Modern dress</a></p></center>
  </div>  

  <div class="col-sm-4">
 <a href="<c:url value="/summer"/>">
 <img src="${img}/s1.jpg" class="img-rounded" alt="fancy" width="304" height="300"></a>
  <center><p><a href="<c:url value="/summer"/>">Summer dress</a></p></center>
  </div>  
</div>
</div>
</body>

</html>
