<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
<script src="updateBlogValidation.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css">
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #e6f7ff;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }
    form {
        background-color: #fff;
        padding: 40px 100px;
        border-radius: 10px;
        box-shadow: 0 0 50px rgba(0, 0, 0, 0.1);
    }
    label {
        display: block;
        margin-bottom: 8px;
        font-weight: bold;
    }
    input[type="text"],
    input[type="number"] {
        width: 500px;
        padding: 10px;
        margin-bottom: 2px;
        border: 1px solid #ccc;
        border-radius: 5px;
        box-sizing: border-box;
    }
    input[type="submit"] {
        background-color: #4CAF50;
        color: white;
        padding: 10px 15px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        font-size: 16px;
    }
    input[type="submit"]:hover {
        background-color: #45a049;
    }
    .error {
         color: red;
     }
</style>
</head>
<body>
	  <form onsubmit="return validateForm()" action="UpdateBlogSevlet" method="post" >
        <div>
            <label for="title">Title:</label>
            <input type="text" id="title" name="title"><br>
            <span class="error" id="titleError"></span>
        </div>
        <div>
            <label for="content">Content:</label>
            <input type="text" id="content" name="content"><br>
            <span class="error" id="contentError"></span>
        </div>
        <div>
            <label for="image_video">Image/Video Link:</label>
            <input type="text" id="image_video" name="image_video"><br>
            <span class="error" id="imageVideoError"></span>
        </div>
        <div>
            <label for="userId">UserId:</label>
            <input type="number" id="userId" name="userId"><br>
            <span class="error" id="userIdError"></span>
        </div>
        <div>
            <label for="blogId">BlogId:</label>
            <input type="number" id="blogId" name="blogId"><br>
            <span class="error" id="blogIdError"></span>
        </div>
        <div>
            <button type="submit">Submit</button>
        </div>
    </form>
    
    
<% String error_msg = (String)session.getAttribute("Problem_occur_try_Again");
	if(error_msg != null && error_msg.equals("Problem_occur_try_Again")){ %>
		<script> alert("Invalid UserId or BlogId,Enter correct UserId and BlogId please try Again")</script>
		<% error_msg = null; %>
<%} session.removeAttribute("Problem_occur_try_Again");%>
    
</body>
</html>