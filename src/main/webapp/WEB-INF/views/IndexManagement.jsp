<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>  
		<meta charset="utf-8"/>
		<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
		<title>Home</title>
		<meta name="description" content=""/>
		<meta name="viewport" content="width=device-width"/>
		<base href="/"/>
    	<link rel="stylesheet" href="https://bootswatch.com/4/lux/bootstrap.min.css"> 
		<!--
		<link rel="stylesheet" type="text/css" href="/webjars/bootstrap/css/bootstrap.min.css"/>
		-->
		<link rel="stylesheet" href="/webjars/font-awesome/css/font-awesome.min.css"></link>
	    <link href="<c:url value='css/app.css' />" rel="stylesheet"></link>
	    <link href="<c:url value='css/style.css' />" rel="stylesheet"></link>
	    <script type="text/javascript" src="/webjars/jquery/jquery.min.js"></script>
    	<script type="text/javascript" src="/webjars/bootstrap/js/bootstrap.min.js"></script>
  	</head>
  	<body ng-app="myApp" class="ng-cloak">
    	<div class="" ng-controller="UserController as ctrl">
          
			<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
				<a class="navbar-brand" href="#">CRB</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
		  			<span class="navbar-toggler-icon"></span>
				</button>
				
				<div class="collapse navbar-collapse" id="navbarColor01">
					<ul class="navbar-nav mr-auto">
						<li class="nav-item active">
							<a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="/pack">Packs</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="/customer">Customers</a>
						</li>
					</ul>
					<form class="form-inline my-2 my-lg-0">
						<input class="form-control mr-sm-2" type="text" placeholder="Search">
						<button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
					</form>
				</div>
			</nav>          

      	</div>
      
		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
		<script src="<c:url value='js/app.js' />"></script>
		<script src="<c:url value='js/service/user_service.js' />"></script>
		<script src="<c:url value='js/controller/user_controller.js' />"></script>
	</body>
</html>