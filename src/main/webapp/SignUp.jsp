<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>SignUp page</title>
<script src="forms_SingnUp.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
<style>
    #form {
    background-image: url('imgfolder/seaimage.jpg'); /* URL of the background image */
    background-size: cover; /* Adjust the size of the background image */
    background-position: center; /* Position the background image */
    margin: 0px;
    padding-top: 1px;
    height: 900px;
    width: 100%;
}
	#signUp{
	padding:20px;
	padding-left:30px;
	margin-left:400px;
	margin-top:100px;
	max-width:500px;
	background-color:white;
	border-radius: 8px;
	box-shadow: 10px 5px 15px grey;
	}
	#name{
	background-image: url('imgfolder/user.png');
	}
	#email{
	background-image: url('imgfolder/email.png');
	}
	#phone{
	background-image: url('imgfolder/phone.png');
	}
	#userName
	{
	background-image: url('imgfolder/user.png');
	}
	#password{
	background-image: url('imgfolder/password.png');
	}
	label{
	font-size:20px;
	}
	
	
	input[type="text"], input[type="password"],input[type="submit"],input[type="email"]{
    font-size:20px;
    width: 350px;
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
    background-position: 10px center; /* Adjust the position of the icon */

  }
  #already_acc{
  	margin-left: 50px;
  	margin-right: 50px;
  }
   #signword{
  margin-right:50px;
  font-size:25px;
  }
  #role{
  	padding:10px;
  }
</style>
</head>
<body>
<div id="form">
	<div id="signUp" >
		<span id="signword"  ><b>Sign Up</b></span><span style="font-size:20px;">if you have account click on <a href="SignIn.jsp">Login</a></span>
		<form onsubmit="return validate()" action="SignUpServlet" method="post">
		<table>
			<tr>
				<td><label for="name"> Name*</label></td>
				<td> <input type="text" class="form-control" name="name" id="name"  placeholder="Name" ></input></td>
            </tr>
            <tr>
               <td colspan="2"><span id="msg" style="color:red"></span></td>
            </tr>
			<tr>
				<td><label for="email">Email*</label></td>
				<td><input type="text" class="form-control"  name="email" id="email"  placeholder="Email"></input></td>
            </tr>
            <tr>
				<td colspan="2"><span id="msg1" style="color:red"></span></td>
            </tr>
			<tr>
				<td><label for="phone">Phone*</label></td>
				<td><input type="text" class="form-control" name="phone" id="phone"  placeholder="Phone"></input></td>
            </tr>
            <tr>
				<td colspan="2"><span id="msg2" style="color:red"></span></td>
            </tr>
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
			
            <tr >
                <td colspan="2"><span id="msg4" style="color:red"></span></td>
            
            </tr>
            <tr>
				<td><label for="role">Role*</label></td>
            	<td><select id ="role" name="role">
            			<option value="Admin">Admin</option>
            			<option value="Viewer">Viewer</option>
        			</select>
            	</td>
            </tr>
            
			<tr>
				<td> <button type="submit" class="btn btn-primary">Submit</button></td>
            </td>
			</tr>
		</table>

		</form>
	</div>
</div>
</body>
</html>