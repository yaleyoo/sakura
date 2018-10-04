<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Sakura Hotel</title>
	<link rel="stylesheet" href="css/bootstrap.css">
	</head>
	<body>
		<%@include file="jsp/common/navi.jsp"%>
		
		<div id="header-wrapper" style="width: 100%;
	            height: 100%;   
	            background-image: url(img/Konoha_Hot_Springs.png);
	            background-size: cover;
	            background-position: center center;">
	            
	            <button onclick="javascript:location.href='frontServlet?command=ViewRooms'" type="button" class="btn btn-info" style="
	            width: 30%;margin: 20% 35% 0 35%;height: 60px;"><i class="iconfont">&#xe601;</i>&nbsp;Book Your Room Now!</button>
	    </div>
	
		<style type="text/css">
			html,body{
				background-color:rgb(232,232,232)!important;
				height:100%;
				margin:0;
		    	padding:0;
			}
		</style>
		
		<script src="https://code.jquery.com/jquery-3.3.1.min.js"
        integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
        crossorigin="anonymous"></script>
        <script src="js/bootstrap.js"></script>
	</body>
</html>
