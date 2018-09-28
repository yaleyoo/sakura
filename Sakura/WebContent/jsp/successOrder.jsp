<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Success - Sakura Hotel</title>
	<link rel="stylesheet" href="css/bootstrap.css">
	</head>
	<body>
		<%@include file="common/navi.jsp"%>
		
		<div class="alert alert-success" role="alert" style="margin: 10%; width:80%;">
  			Your order has been placed!
		</div>
		<button type="button" style="text-align: right; margin:0 10%;" class="btn btn-success" onclick="javascript:location.href='frontServlet?command=HomePage'">Return</button>
	
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
