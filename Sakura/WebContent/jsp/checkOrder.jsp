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
	<div class="row">
		<div class="col-md-12">
			<div class="well">
			
				<h4>Your order details: </h4>
				<ul class="list-group">
					<li class="list-group-item">
						<span class="prefix">Customer name: </span>
						<span class="label label-success"> ${order.customer.name} </span>
					</li>
					<li class="list-group-item">
						<span class="prefix">Building Address: </span>
						<span class="label label-success"> ${order.room.building.address}  </span>
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
						<span class="label label-success"> ${order.checkIn} </span>
					</li>
					<li class="list-group-item">
						<span class="prefix">Check out Time: </span>
						<span class="label label-success"> ${order.checkOut} </span>
					</li>
					<li class="list-group-item">
						<span class="prefix">Total Price: </span>
						<span class="label label-success"> ${order.sum} </span>
					</li>
				</ul>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-md-12">
			<button type="button" id="btnConfirm" class="btn btn-success">
				Confirm
			</button>
			<button type="button" id="btnConfirm" class="btn">
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
</body>
</html>