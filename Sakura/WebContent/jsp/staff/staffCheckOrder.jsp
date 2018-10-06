<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Check the Order - Sakura Hotel</title>
<link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
	<%@include file="../common/staffNavi.jsp"%>
	<div class="row">
		<div class="col-md-12">
			<div class="well">
			
				<h4>Order details: </h4>
				<ul class="list-group">
					<li class="list-group-item">
						<span class="prefix">Customer name: </span>
						<span class="label label-success"> ${order.customer.firstname}&nbsp;${order.customer.lastname} </span>
					</li>
					<li class="list-group-item">
						<span class="prefix">Building Address: </span>
						<span class="label label-success"> ${order.room.building.address}</span>
					</li>
					<li class="list-group-item">
						<span class="prefix">Building Name: </span>
						<span class="label label-success"> ${order.room.building.buildingName} </span>
					</li>
					<li class="list-group-item">
						<span class="prefix">Room Name: </span>
						<span class="label label-success"> ${order.room.name} </span>
					</li>
					<li class="list-group-item">
						<span class="prefix">Room Type: </span>
						<span class="label label-success"> ${order.room.type} </span>
					</li>
					<li class="list-group-item">
						<span class="prefix">Check in Time: </span>
						<span class="label label-success"> ${order.timerange.checkInTime} </span>
					</li>
					<li class="list-group-item">
						<span class="prefix">Check out Time: </span>
						<span class="label label-success"> ${order.timerange.checkOutTime} </span>
					</li>
					<li class="list-group-item">
						<span class="prefix">Total Price: </span>
						<span class="label label-success"> ${order.sum} </span>
					</li>
				</ul>
			</div>
		</div>
	</div>

	<div class="row" style="margin: 0 1%; text-align:right;">
		<div class="col-md-12">
			<button onclick="javascript:confirm()" type="button" id="btnConfirm" class="btn btn-success">
				Confirm
			</button>
			<button onclick="javascript:location.href='frontServlet?command=StaffIndex'" type="button" id="btnConfirm" class="btn">
				Cancel
			</button>
		</div>
	</div>
	<style type="text/css">
			html,body{
				background-color:rgb(232,232,232)!important;
				height:100%;
				margin:0;
		    	padding:0;
			}
			
			.well {
				min-height: 20px;
				padding: 19px;
				margin-bottom: 20px;
				background-color: #f5f5f5;
				border: 1px solid #e3e3e3;
				border-radius: 4px;
				-webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.05);
				box-shadow: inset 0 1px 1px rgba(0,0,0,.05);
			}
		</style>
		
		<script src="https://code.jquery.com/jquery-3.3.1.min.js"
        integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
        crossorigin="anonymous"></script>
        
        <script src="js/bootstrap.js"></script>
        <script type="text/javascript">
        	var formatted_in;
        	var formatted_out;
        	$().ready(function(){
        		
        	});
        	function confirm(){
        		var check_in_time = "${order.timerange.checkInTime}"
            	var check_out_time = "${order.timerange.checkOutTime}"
     			//var url = "placeOrder?check_in_time="+formatTime(check_in_time)+
        		//		"&check_out_time="+formatTime(check_out_time)+"&room_id="+${order.room.roomId};
        		var url = "frontServlet?command=StaffPlaceOrder&order_id="+${order.orderId};
        		location.href=url;
        	}
        	
        	function formatTime(time){
        		var formatted;
        		var array = time.split(" ");
        		var year;
        		var mon;
        		var day;
        		var dayTime;
        		array.forEach((i) => {
        			//match month
        			if (i.match(/Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec/)){
        				switch (i){
	        	            case "Jan":
	        	                month="01";
	        	                break;
	        	            case "Feb":
	        	                month="02";
	        	                break;
	        	            case "Mar":
	        	                month="03";
	        	                break;
	        	            case "Apr":
	        	                month="04";
	        	                break;
	        	            case "May":
	        	                month="05";
	        	                break;
	        	            case "Jun":
	        	                month="06";
	        	                break;
	        	            case "Jul":
	        	                month="07";
	        	                break;
	        	            case "Aug":
	        	                month="08";
	        	                break;
	        	            case "Sep":
	        	                month="09";
	        	                break;
	        	            case "Oct":
	        	                month="10";
	        	                break;
	        	            case "Nov":
	        	                month="11";
	        	                break;
	        	            case "Dec":
	        	                month="12";
	        	                break;
        	        	}
        			}
        			//match year
        			else if (i.match(/\d{4}/)){
        				year = i;
        			}
        			//match day
        			else if (i.match(/^\d{2}$/)){
        				day = i;
        			}
        			//match time
        			else if (i.match(/\d{2}:\d{2}:\d{2}/)){
        				dayTime = i;
        			}
        			
        		});
        		return year+"-"+month+"-"+day+" "+dayTime;
        	}
        </script>
</body>
</html>