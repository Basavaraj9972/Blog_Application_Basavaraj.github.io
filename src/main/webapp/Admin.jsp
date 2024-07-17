<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.tap.model.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
<style>
body {
    font-family: Arial, sans-serif;
    background-color: #e0f7fa;
    margin: 0;
    padding: 20px;
    display: flex;
    flex-direction: column;
    align-items: center;
    height: 100vh;
}

.button {
    padding: 15px 30px;
    margin: 30px;
    border: none;
    color: white;
    cursor: pointer;
    font-size: 16px;
}

.button-add {
    background-color: #4CAF50;
}

.button-update {
    background-color: #FF69B4;
}

.button-delete {
    background-color: #F44336;
}

.button:hover {
    opacity: 0.8;
}
#admin{
	border-radius: 50px;
	margin-left:1200px;
}
#name{
	margin-left:1217px;
}
#email{
	margin-left:1120px;
}
#phone{
	margin-left:1212px;
}
#Role{
	margin-left:1228px;
}
 #logout{
    	margin-left:1150px;
    }
</style>
</head>
<body>
<div>
	<a href="CallinLogOutServlet1?msg=logout_success"> <button  id = "logout" class="btn btn-danger"  value="Logout">Logout<img src="imgfolder/logout.png" height="35px" width="35px" alt="Logout"></img></button></a><br><br>
</div>
<div>
      <div id ="Role"> 
      		<% User user = (User)session.getAttribute("user"); %>
      		<%= user.getRole() %>
      </div>
	<img id="admin" src="imgfolder/Admin_Icon.jpg" height="105px" width="105px" alt="Admin logo not Available"></img><br>
	<div id="name"> 
        <%= user.getName() %></div>
    <div id ="email"> <%= user.getEmail() %></div>
     <div id ="phone"> <%= user.getPhoneNo() %></div>
    
</div>
    <div id="logoutOption" style="display: none;">
        <a href="#" onclick="logout()">Logout</a>
    </div>
</div>

<div>
<h1> Hello This is Admin DashBoard</h1>

 	<a href="Add.jsp"><button class="button button-add">Add</button></a>
    <a href="updateBlog.jsp"><button class="button button-update">Update</button></a>
    <a href="deleteBlog.jsp"><button class="button button-delete">Delete</button></a>

</div>


<% String login_msg = (String)session.getAttribute("login_success");
	if(login_msg != null && login_msg.equals("login_success")){ %>
		<script> alert("Login Success")</script>
		<% login_msg = null; %>
<%} session.removeAttribute("login_success");%>

<% String add_msg = (String)session.getAttribute("added_Successfully");
	if(add_msg != null && add_msg.equals("added_Successfully")){ %>
		<script> alert("Blog added Successfully")</script>
		<% add_msg = null; %>
<%} session.removeAttribute("added_Successfully");%>

<% String update_msg = (String)session.getAttribute("updated_Successfully");
	if(update_msg != null && update_msg.equals("updated_Successfully")){ %>
		<script> alert("Blog updated Successfully")</script>
		<% update_msg = null; %>
<%} session.removeAttribute("updated_Successfully");%>

<% String deleted_msg = (String)session.getAttribute("deleted_Successfully");
	if(deleted_msg != null && deleted_msg.equals("deleted_Successfully")){ %>
		<script> alert("Blog deleted Successfully")</script>
		<% deleted_msg = null; %>
<%} session.removeAttribute("deleted_Successfully");%>


<script>
//Function to show/hide the logout option
function toggleLogoutOption() {
    var logoutDiv = document.getElementById('logoutOption');
    if (logoutDiv.style.display === 'none') {
        logoutDiv.style.display = 'block';
    } else {
        logoutDiv.style.display = 'none';
    }
}

// Function to handle logout
function logout() {
    // Implement your logout logic here, e.g., redirect to logout endpoint or clear session
    alert('Logging out...');
    // Example: redirect to logout page
    window.location.href = '/logout';
}

// Add click event listener to the admin icon
document.getElementById('adminIcon').addEventListener('click', function() {
    toggleLogoutOption();
});



</script>













</body>
</html>