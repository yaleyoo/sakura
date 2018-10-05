
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
	<%@include file="../common/staffNavi.jsp"%>

<nav class="navbar navbar-light bg-light">
  <form class="form-inline text-center" action="frontServlet">
  	<input class="d-none" name="command" value="StaffEditOrder">
  	<input class="d-none" name="method" value="search">
    Order ID:&nbsp; <input id="order_id" name="orderId" class="form-control mr-sm-2" type="search" placeholder="Order ID" aria-label="Search">
    <button class="btn btn-outline-success my-2 my-sm-0">Search</button>
  </form>
</nav>	
	<div style="margin: 1% 5% 0 5%;">
		<div class="col-md-12">
			<div class="well">
				<c:if test="${order!=null}">
					<h4>Your order details: </h4>
					<form action="frontServlet">
						<input class="d-none" name="command" value="StaffEditOrder">
  						<input class="d-none" name="method" value="update">
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">Order ID</label>
							<div class="col-sm-10">
							<input type="text" readonly 
							class="form-control" 
							name="orderId" 
							value="${order.orderId}">
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">Customer ID</label>
							<div class="col-sm-10">
							<input type="text" 
							class="form-control" 
							name="customerId" 
							value="${order.customer.customerId}">
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">Customer FirstName</label>
							<div class="col-sm-10">
							<input type="text" 
							class="form-control" 
							readonly
							name="firstname" 
							value="${order.customer.firstname}">
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">Customer LastName</label>
							<div class="col-sm-10">
							<input type="text" 
							class="form-control" 
							readonly
							name="lastname" 
							value="${order.customer.lastname}">
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">Room ID</label>
							<div class="col-sm-10">
							<input type="text" 
							class="form-control" 
							name="roomId" 
							value="${order.room.roomId}">
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">Room Name</label>
							<div class="col-sm-10">
							<input type="text" 
							class="form-control" 
							name="roomId" 
							readonly
							value="${order.room.name}">
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">CheckIn Time</label>
							<div class="col-sm-10">
							<input type="text" 
							class="form-control" 
							name="checkInTime" 
							value="${order.timerange.checkInTime}">
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">Check-out Time</label>
							<div class="col-sm-10">
							<input type="text" 
							class="form-control" 
							name="checkOutTime" 
							value="${order.timerange.checkOutTime}">
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">Create Time</label>
							<div class="col-sm-10">
							<input type="text" 
							class="form-control" 
							name="createTime" 
							readonly
							value="${order.createTime}">
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">Summary</label>
							<div class="col-sm-10">
							<input type="text" 
							class="form-control" 
							name="sum" 
							value="${order.sum}">
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">Status</label>
							<div class="col-sm-10">
							<input type="text" 
							class="form-control" 
							name="status" 
							value="${order.status}">
							</div>
						</div>
						<button type="submit" class="btn btn-info" style="
			            text-align:right; margin: 10px 0 0 0;">Edit Order</button>
					</form>
					
		       	</c:if>
		       	<c:if test="${order==null}">
		       		<div class="alert alert-danger text-center" role="alert" style="margin:10%;width:80%;">
			  			<div style="font-size:20px;"><b>Order is not found.</b></div>
					</div>
		       	</c:if>
			</div>
		</div>
	</div>
		
		<script src="https://code.jquery.com/jquery-3.3.1.min.js"
        integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
        crossorigin="anonymous"></script>
        
        <script src="js/bootstrap.js"></script>
</body>
</html>