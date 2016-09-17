<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<style>
div.container {
        
    height: 400px;
    width: 100%;
  
}

header, footer {
	height: 135px;
	padding: 1em;
    color: white;
    background-color: black;
    clear: left;
}

body { 
    background-image: url('/images/back.png');
    background-position: -80px; 
}

nav {
    float: left;
    max-width: 160px;
    margin: 0;
    padding: 1em;
}
navR {
    float: Right;
    max-width: 160px;
    margin: 0;
    padding: 1em;
}

nav ul {
    list-style-type: none;
    padding: 0;
}
   
nav ul a {
    text-decoration: none;
}

article {
	height: 370px;
    margin-left: 170px;
   
    backgorund-color: light blue;
    padding: 1em;
    overflow: hidden;
}

</script>


</style>
</head>
<body >

<header>
<a href="home"><img src="/images/logo.png" onclick="window.open(home)"
   style="float:left; margin-right:10px; width:200px; height:150px; border:none;">
  </a>  <h1 align="center"><font size="200"> Witaj w swiniarni! </font></h1>
</header>


<div class="container" > 

<navR>
<ul>
<div style="background-color: rgba(135,206,250, 0.5)">
<center>
	<li><a href="login">Login</a></li>
    <li><a href="reg">Register</a></li>
    <center>
</div>
</ul>
</navR>


<nav >
  <ul>
  <div style="background-color: rgba(135,206,250, 0.5)">
  <center>
  <li><a href="admin">Admin</a></li>
    <li><a href="forum">Forum</a></li>
    <li><a href="UserPanel">User Panel</a></li>
    <li><a href="users">All Users</a></li>
		
    <sec:authorize access="hasRole('ROLE_USER')">
		<!-- For login user -->
		<c:url value="/logout" var="logoutUrl" />
		<form action="${logoutUrl}" method="post" id="logoutForm">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>
		<script>
			function formSubmit() {
				document.getElementById("logoutForm").submit();
			}
		</script>

		<c:if test="${pageContext.request.userPrincipal.name != null}">
			
				User : ${pageContext.request.userPrincipal.name} | <a
					href="javascript:formSubmit()"> Logout</a>
			
		</c:if>
	</sec:authorize>
	</center>
	</div>
  </ul>
</nav>

  
<article>

    	<div align="center">
	        <h1>Users List</h1>
	        <table border="1">
	        	<th>No</th>
	        	<th>Name</th>
	        	<th>Password</th>
	 			<th>Action</th>       	
				<c:forEach var="users" items="${listUsers}" varStatus="status">
	        	<tr>
	        		<td>${status.index + 1}</td>
					<td>${users.username}</td>
					<td>${users.password}</td>	
					<td>
					<a href="deleteContact?id=${users.id}">Delete</a>
					</td>			
	        	</tr>
				</c:forEach>	        	
			</table>
    	</div>
    	<article>
    </body>
</html>