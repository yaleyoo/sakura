<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
	<%@include file="common/navi.jsp"%>

<nav class="navbar navbar-light bg-light">
  <form class="form-inline text-center">
    <input class="form-control mr-sm-2" type="search" placeholder="Check in time: yy-mm-dd hh:mm:ss" aria-label="Search">
    <input class="form-control mr-sm-2" type="search" placeholder="Check out time: yy-mm-dd hh:mm:ss" aria-label="Search">
	<select class="form-control" id="exampleFormControlSelect1">
      <c:forEach var="building" items="${buildings}">
      	<option>${building.name}</option>
      </c:forEach>      
    </select>
    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
  </form>
</nav>	
<c:forEach var="room" items="${rooms}">
<div class="card text-center room-card">
  <div class="card-header">
    ${room.type}
  </div>
  <div class="card-body">
    <h5 class="card-title">${room.name}</h5>
    <p class="card-text">${room.price}/day</p>
    <a href="#" class="btn btn-primary">Book</a>
  </div>
</div>
</c:forEach>

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
</body>
</html>