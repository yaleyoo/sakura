<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Room List - Sakura Hotel</title>
<link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
	<%@include file="common/navi.jsp"%>

<nav class="navbar navbar-light bg-light">
  <form class="form-inline text-center">
    Check in time:&nbsp; <input id="check_in_time" class="form-control mr-sm-2" type="search" placeholder="yyyy-mm-dd hh:mm:ss" aria-label="Search">
    Check out time:&nbsp; <input id="check_out_time"class="form-control mr-sm-2" type="search" placeholder="yyyy-mm-dd hh:mm:ss" aria-label="Search">
	<select class="form-control" id="buildingSelector">
      <c:forEach var="building" items="${buildings}">
      	<option value="${building.buildingId}">${building.buildingName}</option>
      </c:forEach>      
    </select>
    <button class="btn btn-outline-success my-2 my-sm-0" onclick="javascript:search()">Search</button>
  </form>
</nav>	
<div id="roomList">
	<c:forEach var="room" items="${rooms}">
	<div class="card text-center room-card">
	  <div class="card-header">
	    ${room.type}
	  </div>
	  <div class="card-body">
	    <h5 class="card-title">${room.name}</h5>
	    <p class="card-text">$${room.price}/day</p>
	    <!-- <a href="checkOrder?checkIn=dd&&checkOut=dd&&roomId=ff" class="btn btn-primary">Book</a>  -->
	  </div>
	</div>
	</c:forEach>
</div>

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
        	$().ready(function(){
        	  $("form").submit(function(e){
        	    e.preventDefault();
        	  });
        	});
        	function search(){
        		var check_in_time = $("#check_in_time").val();
        		var check_out_time = $("#check_out_time").val();
        		var building_id = $("#buildingSelector").val();
        		$.ajax({
        	        type: "GET",
        	        url: "getAvailableRooms",
        	        async: false,
        	        data:{
        	        	check_in_time:check_in_time,
        	        	check_out_time:check_out_time,
        	        	building_id:building_id
        	        },
        	        dataType: "json",
        	        success: function (data) {
        	            var roomList = data.result;
        	            $("#roomList").html("");
        	            roomList.forEach((room) => {
        	            	$("#roomList").append("<div class=\"card text-center room-card\">"+
        	            			  "<div class=\"card-header\">"+
        	        	    room.type+"</div>"+
        	        	  "<div class=\"card-body\">"+
        	            			"<h5 class=\"card-title\">"+room.name+"</h5>"+
        	            		    "<p class=\"card-text\">$"+room.price+"/day</p>"+
        	            		    "<a href=\"checkOrder?check_in_time="+check_in_time+"&&check_out_time="+check_out_time+"&&room_id="+room.roomId+"\" class=\"btn btn-primary\">Book</a>"+
        	            		    		"</div>"+
        	            		    		"</div>");
        	            });
        	        },
        	        error: function (jqXHR, textStatus, errorThrown) {
        	            alert("something going WRONG there.\n" +
        	                "Caused by:" + textStatus);
        	        }
        	    });
        	}
        </script>
</body>
</html>