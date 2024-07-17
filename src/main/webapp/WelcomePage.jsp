<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
<style>
	#wel_Section #wel_Tap{
		height:200px;
		width:100%;
		
	}
	#siu{
	margin-top:36px;
	text-align:center;
	font-size:25px;
	}
	a[href="SignIn.jsp"],a[href="SignUp.jsp"]{
	margin-left:20px;
	
	}
	button{
	 font-size:35px;
	 padding:50px;
     margin-left:30px;
	}
	#wel_Tap{
		text-align:center;
		padding-left:400px;
	}
</style>
</head>
<body>
<div>
	<div style="text-align: center"> 
		<h1> Mini Project: </h1>
	</div>
	<div style="text-align: center">
		<h1> Blog Application with User Roles and Authentication (Java Intern)</h1>
	</div>
</div>
	<span id="wel_Tap" style="text-align:center; font-size: 50px; font-weight: bold; text-shadow: 2px 2px 4px #888;"> Welcome to Blog Application</span>
	</div>
	<div id="siu">
		<span ><a href="SignIn.jsp"> <button type="button" class="btn btn-success">Login</button></a></span> <span><a  href="SignUp.jsp"><button type="button" class="btn btn-success">Register</button></a></span>
	</div>
	
	
	<% String msg = request.getParameter("msg"); 
			if(msg!=null && msg.equals("logout_success")){
				%>
				<script>alert("Logout Successfully")</script>
			<% 
			}
		%>
	
</body>
</html>