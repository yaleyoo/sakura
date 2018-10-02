<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Building List - Sakura Hotel</title>
<link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
	<%@include file="common/staffNavi.jsp"%>

<div id="buildingList">
	<c:forEach var="building" items="${buildings}">
	<div class="card text-center building-card">
	  <div class="card-body">
	    <h5 class="card-title">${building.buildingName}</h5>
        <p class="card-text">${building.address}</p>
	    <a class="btn btn-primary" href="#" role="button">Check Rooms</a>
	    <a class="btn btn-primary" href="#" role="button">Edit</a>
	    <a class="btn btn-light" href="#" role="button">Delete</a>
	  </div>
	</div>
	</c:forEach>
</div>
<a role="button" class="btn btn-primary btn-lg btn-block" href="#">Add a New Building</a>

		<style type="text/css">
			html,body{
				background-color:rgb(232,232,232)!important;
				height:100%;
				margin:0;
		    	padding:0;
			}
			
			.building-card{
				margin:20px;
			}
			
		</style>
		
		<script src="https://code.jquery.com/jquery-3.3.1.min.js"
        integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
        crossorigin="anonymous"></script>
        
        <script src="js/bootstrap.js"></script>
        <script type="text/javascript">
        	
        </script>
</body>
</html>