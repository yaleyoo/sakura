<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Room - Sakura Hotel</title>
<link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
	<%@include file="../common/staffNavi.jsp"%>
	<div class="row">
		<div class="col-md-12">
			<div class="well">
			<h4>Edit Room</h4>
			<form action="frontServlet?command=StaffEditRoom" method="POST">
			  <div class="form-group row">
			    <label for="staticRoomId" class="col-sm-2 col-form-label">Room ID</label>
			    <div class="col-sm-10">
			      <input type="text" readonly class="form-control-plaintext" id="staticRoomId" name="roomId" value="${room.roomId}">
			    </div>
			  </div>
			  <div class="form-group row">
			    <label for="inputRoomName" class="col-sm-2 col-form-label">Room Name</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" id="inputBuildingName" name="name" placeholder="original room name" value="${room.name}">
			    </div>
			  </div>
			  <div class="form-group row">
			    <label for="inputRoomType" class="col-sm-2 col-form-label">Room Type</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" id="inputBuildingAddress" name="type" placeholder="original room type" value="${room.type}">
			    </div>
			  </div>
			  <div class="form-group row">
			    <label for="inputRoomPrice" class="col-sm-2 col-form-label">Room Price</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" id="inputRoomPrice" name="price" placeholder="original room price" value="${room.price}">
			    </div>
			  </div>
			  <div class="form-group row">
			    <label for="inputRoomPrice" class="col-sm-2 col-form-label">Building Id</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" id="inputRoomPrice" name="buildingId" placeholder="original room price" value="${room.building.buildingId}">
			    </div>
			  </div>
			  <button type="submit" class="btn btn-primary">Confirm</button>
			  <button type="button" class="btn btn-light" onclick="javascript:history.go(-1);">Cancel</button>
			</form>
			</div>
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