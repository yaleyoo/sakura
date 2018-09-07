<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav id="top-nav" class="navbar navbar-expand-md navbar-dark bg-dark">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault"
            aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="viewMain">
                    Home <span class="sr-only"></span>
                </a>
            </li>
           <li class="nav-item">
                <a class="nav-link" href="viewRooms">
                    Book A Room <span class="sr-only"></span>
                </a>
            </li>
            <li class="nav-item">
            <c:if test = "${sessionScope.loggedCustomer != null}">
	            <a class="nav-link" href="viewCustomer">
	            	Hello, ${sessionScope.loggedCustomer.firstname}</span>
	            </a>	
            </c:if>
           	<c:if test = "${sessionScope.loggedCustomer == null}">
           		<a class="nav-link" href="">
            		LOGIN</span>
	            </a>
           	</c:if>
            
            </li>
        </ul>
    </div>
</nav>
