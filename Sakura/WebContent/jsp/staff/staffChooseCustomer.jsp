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
								<form id="js-create-customer-form" action="frontServlet?command=StaffPlaceOrder">
								  <div class="form-group">
								    
								    <input type="text" class="form-control" name="c_first_name" id="c_first_name" placeholder="First Name">
								  </div>
								  <div class="form-group">
								    
								    <input type="text" class="form-control" id="c_last_name" name="c_last_name" placeholder="Last Name">
								  </div>
								  <div class="form-group">
								    
								    <input type="text" class="form-control" id="c_email" name="c_email" placeholder="Email">
								  </div>
								  <div class="form-row">
								    <div class="col-6">
								      <input type="text" class="form-control" id="c_title" name="c_title" placeholder="Title">
								    </div>
								    <div class="col-6">
								      <input type="text" class="form-control" id="c_iden_type" name="c_iden_type" placeholder="Identity Type">
								    </div>
								  </div>
								  <div class="form-row">
								    <div class="col">
								      <input type="text" class="form-control" id="c_iden_num" name="c_iden_num" placeholder="Identity Number">
								    </div>
								    <div class="col">
								      <input type="text" class="form-control" id="c_mob_num" name="c_mob_num" placeholder="Mobile Number">
								    </div>
								  </div>
								  <div class="form-row">
								    <div class="col-12">
										<button type="button" role="button" class="btn btn-primary js-create-customer">Create</button> 
										<button type="submit" class="btn btn-primary">Next</button>   
										<button type="button" class="btn btn-primary btn-secondary"
											onclick="javascript:window.location='frontServlet?command=StaffIndex'">Cancel</button>     
								    </div>
								  </div>
								</form>						  
						  <!-- NEW CUSTOMER FORM END -->
						  </div>
						  <div class="tab-pane fade" id="exsiting-customer" role="tabpanel" aria-labelledby="nav-exsiting-customer-tab">
						  <!-- EXSISTING CUSTOMER FORM START -->
								<form action="frontServlet?command=StaffPlaceOrder">
								  <div class="form-group">
								    
								    <input type="text" class="form-control" id="InputFirstName" placeholder="First Name">
								  </div>
								  <div class="form-group">
								    
								    <input type="text" class="form-control" id="InputLastName" placeholder="Last Name">
								  </div>
								  <div class="form-group">
								    
								    <input type="text" class="form-control" id="InputEmail" placeholder="Email">
								  </div>
								  <a role="button" class="btn btn-primary"
								  	href="frontServlet?command=StaffSearchCustomer">Search</a>								
								<hr>
	
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
										<button type="button" class="btn btn-primary btn-secondary"
											onclick="javascript:window.location='frontServlet?command=StaffIndex'">Cancel</button>  
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
        <script type="text/javascript">
			$(()=>{
				$(".js-create-customer").click(createCustomer);
			});
			
			function createCustomer() {
				let firstName = $("#c_first_name").val();
				let lastName = $("#c_last_name").val();
				let email = $("#c_email").val();
				let title = $("#c_title").val();
				let identityType = $("#c_iden_type").val();
				let identityNumber = $("#c_iden_num").val();
				let mobileNumber = $("#c_mob_num").val();
				
        		$.ajax({
        	        type: "GET",
        	        url: "frontServlet",
        	        async: false,
        	        data:{
        	        	first_name:firstName,
        	        	last_name:lastName,
        	        	email:email,
        	        	title: title,
        	        	identity_type: identityType,
        	        	identity_number: identityNumber,
        	        	mobile_number: mobileNumber,
        	        	command: "StaffCreateCustomer"
        	        },
        	        dataType: "json",
        	        success: function (data) {
        	            /*
        	            $("#js-create-customer-form input").each(()=>{
        	            	let original_text = $(this).val();
        	            	console.log(original_text);
        	            	let new_text = $(this).attr("placeholder")+": "+original_text;
        	            	console.log(original_text);
        	            	$(this).val(new_text);
        	            });
        	            */
        	            $("#js-create-customer-form input")
        	            	.removeClass("form-control")
        	            	.addClass("form-control-plaintext")
        	            	.prop('readonly', true);
        	        },
        	        error: function (jqXHR, textStatus, errorThrown) {
        	            alert("something going WRONG there.\n" +
        	                "Caused by:" + textStatus);
        	        }
        	    })				
			}

        </script>
	</body>
</html>
