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
								<form id="js-create-customer-form" action="frontServlet?command=StaffOrderRooms">
								  <div class="form-group js-create-customer-id" style="display:none;">			    
								    <input type="text" class="form-control js-create-customer-id-input" name="c_customer_id" id="c_customer_id" placeholder="Customer ID">
								  </div>
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
										<button type="button" class="btn btn-primary js-create-customer-next" style="display:none;">Next</button>   
										<button type="button" class="btn btn-primary btn-secondary"
											onclick="javascript:window.location='frontServlet?command=StaffIndex'">Cancel</button>     
								    </div>
								  </div>
								</form>						  
						  <!-- NEW CUSTOMER FORM END -->
						  </div>
						  <div class="tab-pane fade" id="exsiting-customer" role="tabpanel" aria-labelledby="nav-exsiting-customer-tab">
						  <!-- EXSISTING CUSTOMER FORM START -->
								<form id="js-search-customer-form">

								  <div class="form-group">
								    
								    <input type="text" class="form-control" name="s_email" id="s_email" placeholder="Email">
								  </div>
								  <button type="button" class="btn btn-primary js-search-customer">Search</button>								
									
									<div class="back-value" style="display:none;">
									<hr>
									  <div class="form-group">
									    <input type="text" class="form-control back-input" name="s_customer_id" id="customerId" placeholder="Customer ID">
									  </div>
									  <div class="form-group">						    
									    <input type="text" class="form-control back-input" name="s_first_name" id="firstname" placeholder="First Name">
									  </div>
									  <div class="form-group">
									    <input type="text" class="form-control back-input" name="s_last_name" id="lastname" placeholder="Last Name">
									  </div>
									  <div class="form-group">
									    <input type="text" class="form-control back-input" name="s_title" id="title" placeholder="Title">
									  </div>
									  <div class="form-group">
									    <input type="text" class="form-control back-input" name="s_iden_type" id="identityType" placeholder="Identity Type">
									  </div>
									  <div class="form-group">
									    <input type="text" class="form-control back-input" name="s_iden_num" id="identityNumber" placeholder="Identity Number">
									  </div>
									  <div class="form-group">
									    <input type="text" class="form-control back-input" name="s_mob_num" id="number" placeholder="Mobile Number">
									  </div>									 
									  
									  <div class="form-row">
									    <div class="col-12">
											<button type="button" class="btn btn-primary js-search-customer-next" style="display: none;">Next</button>    
											<button type="button" class="btn btn-primary btn-secondary"
												onclick="javascript:window.location='frontServlet?command=StaffIndex'">Cancel</button>  
									    </div>
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
        	var customerId;
			$(()=>{
				$(".js-create-customer").click(createCustomer);
				$(".js-create-customer-next").click(redirectToOrderRooms);
				$(".js-search-customer").click(searchCustomer);
				$(".js-search-customer-next").click(redirectToOrderRooms);
			});
			function redirectToOrderRooms() {
				let newUrl = "frontServlet?command=StaffOrderRooms&&customer_id="+customerId;
				window.location = newUrl;
			}

			function searchCustomer() {
				let email = $("#s_email").val();
				
        		$.ajax({
        	        type: "GET",
        	        url: "frontServlet",
        	        async: false,
        	        data:{
        	        	email:email,
        	        	command: "StaffSearchCustomer"
        	        },
        	        dataType: "json",
        	        success: function (data) {
        	        	console.log(data.customer);
        	        	
        	            $("#js-search-customer-form input.back-input").each((i,e)=>{
        	            	let attributeName = $(e).attr("id");
        	            	let original_text = data.customer[attributeName];
        	            	//console.log(original_text);
        	            	let new_text = $(e).attr("placeholder")+": "+original_text;
        	            	console.log(new_text);
        	            	$(e).val(new_text);
        	            });
        	                   	            
        	            $(".back-value").show();
        	            $("#js-search-customer-form input.back-input")
        	            	.removeClass("form-control")
        	            	.addClass("form-control-plaintext")
        	            	.prop('readonly', true);
        	            
        	            $(".js-search-customer-next").show();
        	            customerId = data.customer.customerId;
        	        },
        	        error: function (jqXHR, textStatus, errorThrown) {
        	            alert("something going WRONG there.\n" +
        	                "Caused by:" + textStatus);
        	        }
        	    });
			}
			
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
        	        	
        	        	if(data.result === "successful") {
            	            
            	            $("#js-create-customer-form input").each((i,e)=>{
            	            	let original_text = $(e).val();
            	            	//console.log(original_text);
            	            	let new_text = $(e).attr("placeholder")+": "+original_text;
            	            	console.log(new_text);
            	            	$(e).val(new_text);
            	            });
            	            
            	            //console.log(data.customer);
            	            $("#js-create-customer-form input")
            	            	.removeClass("form-control")
            	            	.addClass("form-control-plaintext")
            	            	.prop('readonly', true);
            	            
            	            $(".js-create-customer").hide();
            	            $(".js-create-customer-next").show();
            	            $(".js-create-customer-id").show();
            	            $(".js-create-customer-id-input").val("Customer ID: "+data.customer.customerId);
            	            customerId = data.customer.customerId;        	        		
        	        	} else if (data.result === "failed") {
        	        		alert(data.reason);
        	        	}

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
