<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav id="top-nav" class="navbar navbar-expand-md navbar-dark bg-dark">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault"
            aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="">
                    Home <span class="sr-only">(current)</span>
                </a>
            </li>
           <li class="nav-item">
                <a class="nav-link" href="viewRooms">
                    Book A Room <span class="sr-only">(current)</span>
                </a>
            </li>
            <li class="nav-item">
            <a class="nav-link" href="getAvailableRooms?check_in_time=2018-09-08 19:00:00&check_out_time=2018-09-08 19:00:00&building_id=1">
            	<c:if test = "${sessionScope.customer != null}">
            		Hello, ${sessionScope.customer.firstname}</span>
            	</c:if>
            	<c:if test = "${sessionScope.customer == null}">
            		LOGIN</span>
            	</c:if>
            	
            </a>
            </li>
        </ul>
    </div>
</nav>
