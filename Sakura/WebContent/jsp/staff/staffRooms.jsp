<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rooms in Building - Sakura Hotel</title>
<link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
	<%@include file="../common/staffNavi.jsp"%>
	
<div id="roomList">
	<c:forEach var="room" items="${rooms}">
	<div class="card text-center room-card">
	  <div class="card-header">
	    ${room.type}
	  </div>
	  <div class="card-body">
	    <h5 class="card-title">${room.name}</h5>
	    <p class="card-text">$${room.price}/day</p>
	    <a class="btn btn-primary" href="frontServlet?command=StaffManageRoom&method=edit&roomId=${room.roomId}" role="button">Edit</a>
	    <a class="btn btn-light" href="frontServlet?command=StaffManageRoom&method=delete&roomId=${room.roomId}" role="button">Delete</a>
	  </div>
	</div>
	</c:forEach>
</div>
<a role="button" class="btn btn-primary btn-lg btn-block" href="frontServlet?command=StaffManageRoom&method=create&buildingId=${buildingId}">Add a New Room</a>
		<style type="text/css">
			html,body{
				background-color:rgb(232,232,232)!important;
				height:100%;
				margin:0;
		    	padding:0;
			}
			
			.room-card{
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