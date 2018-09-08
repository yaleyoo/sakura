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
	<%@include file="common/navi.jsp"%>
	<c:forEach var="order" items="${orders}">
	<div class="row">
		<div class="col-md-12">
			<div class="well">
			
				<h4>Your order details: </h4>
				<ul class="list-group">
					<li class="list-group-item">
						<span class="prefix">Customer name: </span>
						<span class="label label-success"> ${order.customer.firstname}&nbsp;${order.customer.lastname} </span>
					</li>
					<li class="list-group-item">
						<span class="prefix">Building Address: </span>
						<span class="label label-success">${order.room.building.address}</span>
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
						<span class="prefix">Order Create Time: </span>
						<span class="label label-success"> ${order.createTime} </span>
					</li>
					<li class="list-group-item">
						<span class="prefix">Total Price: </span>
						<span class="label label-success"> ${order.sum} </span>
					</li>
					<li class="list-group-item">
						<span class="prefix">Stauts: </span>
						<span class="label label-success"> ${order.status} </span>
					</li>
				</ul>
				<c:if test="${order.status != 'cancel'}">
					<button onclick="javascript:location.href='cancelOrder?order_id=${order.orderId}'" type="button" class="btn btn-info" style="
		            text-align:right; margin: 10px 0 0 0;">Cancel Order</button>
	            </c:if>
			</div>
		</div>
	</div>
	<hr>
	</c:forEach>

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