<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Choose Customer - Sakura Hotel</title>
	<link rel="stylesheet" href="css/bootstrap.css">
	</head>
	<body>
		<%@include file="../common/staffNavi.jsp"%>
		
		<div class="container-fluid text-center">
			<div class="row">
			<div class="col-3"></div>
				<div class="col-6">
					<div class="well">
						<h4>Place Order - Choose Customer</h4>
						<nav>
						  <div class="nav nav-tabs nav-center choose-customer-nav" id="nav-tab" role="tablist">
						    <a class="nav-item nav-link active" id="nav-new-customer-tab" data-toggle="tab" href="#new-customer" role="tab" aria-controls="nav-home" aria-selected="true">New Customer</a>
						    <a class="nav-item nav-link" id="nav-exsiting-customer-tab" data-toggle="tab" href="#exsiting-customer" role="tab" aria-controls="nav-profile" aria-selected="false">Exsiting Customer</a>
						  </div>
						</nav>
						<div class="tab-content choose-customer-form" id="nav-tabContent">
						  <div class="tab-pane fade show active" id="new-customer" role="tabpanel" aria-labelledby="nav-new-customer-tab">
						  <!-- NEW CUSTOMER FORM START -->
								<form>
								  <div class="form-group">
								    
								    <input type="text" class="form-control" id="InputFirstName" placeholder="First Name">
								  </div>
								  <div class="form-group">
								    
								    <input type="text" class="form-control" id="InputLastName" placeholder="Last Name">
								  </div>
								  <div class="form-group">
								    
								    <input type="text" class="form-control" id="InputEmail" placeholder="Email">
								  </div>
								  <div class="form-row">
								    <div class="col-6">
								      <input type="text" class="form-control" placeholder="Title">
								    </div>
								    <div class="col-6">
								      <input type="text" class="form-control" placeholder="Identity Type">
								    </div>
								  </div>
								  <div class="form-row">
								    <div class="col">
								      <input type="text" class="form-control" placeholder="Identity Number">
								    </div>
								    <div class="col">
								      <input type="text" class="form-control" placeholder="Mobile Number">
								    </div>
								  </div>
								  <div class="form-row">
								    <div class="col-12">
										<button type="submit" class="btn btn-primary">Create</button>  
										<button class="btn btn-primary btn-secondary">Cancel</button>     
								    </div>
								  </div>
								</form>						  
						  <!-- NEW CUSTOMER FORM END -->
						  </div>
						  <div class="tab-pane fade" id="exsiting-customer" role="tabpanel" aria-labelledby="nav-exsiting-customer-tab">
						  <!-- EXSISTING CUSTOMER FORM START -->
								<form>
								  <div class="form-group">
								    
								    <input type="text" class="form-control" id="InputFirstName" placeholder="First Name">
								  </div>
								  <div class="form-group">
								    
								    <input type="text" class="form-control" id="InputLastName" placeholder="Last Name">
								  </div>
								  <div class="form-group">
								    
								    <input type="text" class="form-control" id="InputEmail" placeholder="Email">
								  </div>
								  <button type="submit" class="btn btn-primary">Search</button>
								</form>
								<hr>
								<form>
								  <div class="form-row">
								    <div class="col-6">
								      <input type="text" class="form-control" placeholder="Title">
								    </div>
								    <div class="col-6">
								      <input type="text" class="form-control" placeholder="Identity Type">
								    </div>
								  </div>
								  <div class="form-row">
								    <div class="col">
								      <input type="text" class="form-control" placeholder="Identity Number">
								    </div>
								    <div class="col">
								      <input type="text" class="form-control" placeholder="Mobile Number">
								    </div>
								  </div>
								  <div class="form-row">
								    <div class="col-12">
										<button type="submit" class="btn btn-primary">Next</button>    
										<button class="btn btn-primary btn-secondary">Cancel</button>     
								    </div>
								  </div>
								</form>			
		  					<!-- EXSISTING CUSTOMER FORM END -->
						  </div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-3"></div>
		</div>
	
		<style type="text/css">
			.nav-tabs.nav-center {
			    position: absolute;
			    left: 50%;
			    transform: translatex(-50%);
			}
			.well {
				min-height: 20px;
				padding: 19px;
				margin-top: 30px;
				margin-bottom: 20px;
				background-color: #f5f5f5;
				border: 1px solid #e3e3e3;
				border-radius: 4px;
				-webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.05);
				box-shadow: inset 0 1px 1px rgba(0,0,0,.05);
			}		
			
			.choose-customer-form {
				padding: 90px;
			}	
			
			.choose-customer-nav {
				margin-top: 20px;
				
			}
			
			.form-row {
				padding-top: 20px;
			}
			
			form {
				max-width: 500px;
			}
		</style>
		
		<script src="https://code.jquery.com/jquery-3.3.1.min.js"
        integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
        crossorigin="anonymous"></script>
        <script src="js/bootstrap.js"></script>
	</body>
</html>
