<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav id="top-nav" class="navbar navbar-expand-md navbar-dark bg-dark">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault"
            aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse order-1">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" data-toggle="dropdown" 
                role="button" aria-haspopup="true" aria-expanded="false" href="frontServlet?command=ManageOrder">
                    <i class="iconfont">&#xeb2a;</i>&nbsp;Manage Orders <span class="sr-only"></span>
                </a>
                <div class="dropdown-menu">
                	<a class="dropdown-item" href="frontServlet?command=StaffChooseCustomer">Place New Order</a>
                	<div class="dropdown-divider"></div>
                	<a class="dropdown-item" href="frontServlet?command=">Check Current Orders</a>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="frontServlet?command=ViewBuildings">
                    <i class="iconfont">&#xe600;</i>&nbsp;Manage Properties <span class="sr-only"></span>
                </a>
            </li>            
            
        </ul>
    </div>
    
    <div class="navbar-collapse collapse order-2">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item ml-3">
            <c:if test = "${sessionScope.loggedUser != null}">
            	<a class="nav-link" href="frontServlet?command=ViewCustomer">
	            	Hello, ${sessionScope.loggedUser.firstname} <i class="iconfont">&#xe674;</i>
	            </a>	
            </c:if>
            <c:if test = "${sessionScope.loggedUser == null}">
	            <li class="nav-item ml-3">
		            <a class="nav-link" href="frontServlet?command=Login&&role=manager">
	           			MANAGER
		            </a>
	            </li>
	            <li class="nav-item ml-3">
		            <a class="nav-link" href="frontServlet?command=Login&&role=receptionist">
	           			RECEPTIONIST
		            </a>
	            </li>
            </c:if>        
            <li class="nav-item ml-3">
	            <c:if test = "${sessionScope.loggedUser != null}">
	            	<a class="nav-link" href="frontServlet?command=LogOut">Log Out</a>
	            </c:if>
            </li>
        </ul>
    </div>
</nav>

<style type="text/css">
@font-face {
  font-family: 'iconfont';  /* project id 828466 */
  src: url('//at.alicdn.com/t/font_828466_occazemv8d.eot');
  src: url('//at.alicdn.com/t/font_828466_occazemv8d.eot?#iefix') format('embedded-opentype'),
  url('//at.alicdn.com/t/font_828466_occazemv8d.woff') format('woff'),
  url('//at.alicdn.com/t/font_828466_occazemv8d.ttf') format('truetype'),
  url('//at.alicdn.com/t/font_828466_occazemv8d.svg#iconfont') format('svg');
}
.iconfont{
    font-family:"iconfont" !important;
    font-size:16px;font-style:normal;
    -webkit-font-smoothing: antialiased;
    -webkit-text-stroke-width: 0.2px;
    -moz-osx-font-smoothing: grayscale;}
</style>
