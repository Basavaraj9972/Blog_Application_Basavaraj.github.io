<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.tap.model.Blog" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Blog Details</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f0f0f0;
        margin: 0;
        padding: 20px;
    }
    .container {
        max-width: 800px;
        margin: 0 auto;
        background-color: #fff;
        padding: 20px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    .blog-header {
        text-align: center;
        margin-bottom: 20px;
    }
    .blog-header h1 {
        margin: 0;
        font-size: 2em;
        color: #333;
    }
    .blog-details {
        margin-bottom: 20px;
    }
    .blog-details p {
        margin: 10px 0;
        line-height: 1.6;
        color: #555;
    }
    .blog-details img, .blog-details video {
        max-width: 100%;
        height: auto;
        display: block;
        margin: 10px 0;
    }
    .blog-footer {
        text-align: center;
    }
    .blog-footer button {
        background-color: #007BFF;
        color: #fff;
        border: none;
        padding: 10px 20px;
        cursor: pointer;
        font-size: 1em;
    }
    .blog-footer button:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>

<%
    Blog blog = (Blog) session.getAttribute("blogInformation");
    if (blog == null) {
%>
    <div class="container">
        <p>No blog information available.</p>
    </div>
<%
    } else {
%>
    <div class="container">
        <div class="blog-header">
            <h1><%= blog.getTitle() %></h1>
        </div>
        <div class="blog-details">
            <p><strong>Blog ID:</strong> <%= blog.getBlogId() %></p>
            <p><strong>Contents:</strong> <%= blog.getContents() %></p>
            <% if (blog.getImage_Video() != null && !blog.getImage_Video().isEmpty()) { %>
                <% String imageVideo = blog.getImage_Video();
                   if (imageVideo.endsWith(".jpg") || imageVideo.endsWith(".png") || imageVideo.endsWith(".gif")) { %>
                        <img src="<%= imageVideo %>" alt="Blog Image">
                <% } else if (imageVideo.endsWith(".mp4") || imageVideo.endsWith(".webm")) { %>
                        <video controls>
                            <source src="<%= imageVideo %>" type="video/<%= imageVideo.substring(imageVideo.lastIndexOf('.') + 1) %>">
                            Your browser does not support the video tag.
                        </video>
                <% } %>
            <% } %>
            <p><strong>Created Date:</strong> <%= blog.getCreatedDate() %></p>
            <p><strong>Updated Date:</strong> <%= blog.getUpdatedDate() %></p>
            <p><strong>User ID:</strong> <%= blog.getUserId() %></p>
        </div>
        <div class="blog-footer">
            <button onclick="window.location.href='editBlog.jsp?blogId=<%= blog.getBlogId() %>'">Edit</button>
        </div>
    </div>
<%
    }
%>

</body>
</html>