<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
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

navR {
	float: Right;
	max-width: 160px;
	margin: 0;
	padding: 1em;
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
</
script
>
</style>
</head>
<body>
	<header> <a href="home"><img src="/images/logo.png"
		onclick="window.open(home)"
		style="float: left; margin-right: 10px; width: 200px; height: 150px; border: none;">
	</a>
	<h1 align="center">
		<font size="200"> Witaj w swiniarni! </font>
	</h1>
	</header>
	<div class="container">

		<navR>
		<ul>
			<div style="background-color: rgba(135, 206, 250, 0.5)">
				<center>
					<li><a href="login">Login</a></li>
					<li><a href="reg">Register</a></li>
					<center>
			</div>
		</ul>
		</navR>

		<nav>
		<ul>
			<div style="background-color: rgba(135, 206, 250, 0.5)">
				<center>
					<li><a href="admin">Admin</a></li>
					<li><a href="forum">Forum</a></li>
					<li><a href="UserPanel">User Panel</a></li>
					<li><a href="users">All Users</a></li>


				</center>
			</div>
		</ul>
		</nav>

		<article>
		<div style="background-color: rgba(135, 206, 250, 0.5)">
			<center>
				<div id="Reg-box">

					<h3>Registration</h3>

					<c:if test="${not empty error}">
						<div class="error">${error}</div>
					</c:if>
					<c:if test="${not empty msg}">
						<div class="msg">${msg}</div>
					</c:if>

					<form name='RegForm' action='saveContact' method='POST' modelAttribute="users">
						<table>
							<tr>
								<td>User:</td>
								<td><input type='text' name='username'></td>
							</tr>
							<tr>
								<td>Password:</td>
								<td><input type='password' name='password' /></td>
							</tr>
							<tr>
								<td colspan='2'><input name="submit" type="submit"
									value="submit" /></td>
							</tr>
						</table>

						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />

					</form>
				</div>
			</center>
		</div>
		</article>
	</div>
</body>
</html>