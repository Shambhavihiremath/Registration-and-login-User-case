<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Page</title>
</head>
<body>
<%

response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");//it wont take back to welcome
if(session.getAttribute("user")==null){
response.sendRedirect("login.jsp");

}
%>

<h2>Welcome to ${ user}</h2>
<div class="container">

<a href="welcome.jsp">Home</a>
<a href="about.jsp">About us</a>
<a href="admin.jsp">Admin </a>

</div>
<br>
<form action="logout">
<input type="submit" value="logout">
</form>
</body>
</html>