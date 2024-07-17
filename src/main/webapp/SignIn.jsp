<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.lang.String" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
<script src="forms_SignIn.js" ></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
<style>
    #form {
    background-image: url('imgfolder/natur.jpg'); /* URL of the background image */
    background-size: cover; /* Adjust the size of the background image */
    background-position: center; /* Position the background image */
    margin: 0px;
    padding-top: 50px;
    height: 650px;
    width: 100%;
}
	#signIn{
	padding:20px;
	padding-left:30px;
	margin-left:400px;
	margin-top:100px;
	max-width:430px;
	background-color:white;
	border-radius: 8px;
	}
	 input[type="text"], input[type="password"]{
     	font-size:20px;
    	width: 270px;
    	padding: 10px;
    	padding-left:50px;
    	padding-right:20px;
    	margin-top: 7px;
    	margin-bottom: 10px;
    	border-radius: 10px;
    	border: 2px solid #ccc;
    	box-sizing: border-box;
    	box-shadow: 10px 5px 15px grey;
    	background-size: 30px; /* Adjust the size of the icon */
    	background-repeat: no-repeat;
    	background-position: 10px center;
  }
  #userName
	{
	background-image: url('imgfolder/user.png');
	}
	#password{
	background-image: url('imgfolder/password.png');
	}
  #signword{
  margin-right:20px;
  font-size:25px;
  }
  label{
	font-size:20px;
	}
  h4{
  text-align:center;
  }
  #Success{
  color:green;
  }
  #Invalid{
  color:red;
  }
</style>
</head>
<body>
<div id="form" >
	<div id="signIn">
		<span id="signword"><b>Sign In</b></span><span style="font-size:18px;">Dont't have you account? <a href="SignUp.jsp">sign Up</a></span>
		<form onsubmit="return validate()" action="UserValidation" method="post">
		<table>
			<tr>
				<td><label for="userName">UserName*</label></td>
				<td><input type="text" class="form-control" name="userName" id="userName"  placeholder="UserName"></input></td>
            </tr>
            <tr>
				<td colspan="2"><span id="msg3" style="color:red"></span></td>
            </tr>
			<tr>
				<td><label for="password">Password*</label></td>
				<td><input type="password" class="form-control" name="password" id="password"  placeholder="Password" ></input></td>
			</tr>
            <tr>
                <td colspan="2"><span id="msg4" style="color:red"></span></td>
            </tr>
			<tr>
			    <td> <button type="submit" class="btn btn-primary">Submit</button></td>
			</tr>
			<tr>
				<td colspan="2">
					
	<div>
	<%
	  	String respAcknowledgement = null;
		int count = 0;
		respAcknowledgement = (String)session.getAttribute("response");
		
		Integer countObj = (Integer)session.getAttribute("count");
		if(countObj != null){
			count = countObj.intValue();
		}
	  	if(respAcknowledgement!= null){
	  %>
		<h4 id="Success"><%= respAcknowledgement %></h4>
		<%
		session.setAttribute("response", null);
		respAcknowledgement = null; 
	  	 }
	  	else if(count != 0){
	  		%>
			<h4 id="Invalid"><%= "Invalid username and password try you have "+count+" attempts"%></h4>
			<% 
			session.setAttribute("count", 0);
	  	}%>  
	</div>
				</td>
			</tr>
		</table>
	</form>
	</div>
	
</div>
</body>
</html>