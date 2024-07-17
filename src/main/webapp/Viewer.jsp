<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Blog Viewer</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            padding: 20px;
        }
        .container {
            max-width: 600px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        h1 {
            text-align: center;
            margin-bottom: 20px;
        }
        .search-container {
            display: flex;
            align-items: center;
            margin-bottom: 20px;
        }
        .search-container select,
        .search-container input[type="text"],
        .search-container input[type="submit"] {
            margin-right: 10px;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 16px;
            flex: 1;
        }
        .search-container input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }
        .search-container input[type="submit"]:hover {
            background-color: #45a049;
        }
        .error {
            color: red;
            margin-top: 5px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Welcome to Blog Viewer</h1>
        
        <form name="searchForm" action="SearchTitleDateServlet" method="post" onsubmit="return validateForm()">
            <div class="search-container">
                <select name="TitleorDate">
                    <option value="title">Search by Title</option>
                    <option value="date">Search by Date</option>
                </select>
                <input type="text" name="blogSearch" id="blogSearch" placeholder="Enter title or date to search" required>
                <input type="submit" value="Search">
            </div>
            <div id="error-message" class="error"></div>
        </form>

        <% String login_msg = (String)session.getAttribute("login_success");
            if(login_msg != null && login_msg.equals("login_success")){ %>
                <script> alert("Login Success")</script>
                <% login_msg = null; %>
        <% } session.removeAttribute("login_success"); %>
    </div>

    <script>
        function validateForm() {
            var searchType = document.forms["searchForm"]["TitleorDate"].value;
            var searchTerm = document.forms["searchForm"]["blogSearch"].value.trim();
            var errorMessage = document.getElementById("error-message");

            // Basic validation: ensure search term is not empty
            if (searchTerm === "") {
                errorMessage.textContent = "Please enter a title or date to search.";
                return false;
            }

            // Additional validation for date format (YYYY-MM-DDTHH:MM:SS)
			if (searchType === 'date') {
    		var dateTimeRegex = /^\d{4}-\d{2}-\d{2} \d{2}:\d{2}:\d{2}$/;
    		if (!dateTimeRegex.test(searchTerm)) {
        		errorMessage.textContent = "Please enter a valid date-time format (YYYY-MM-DD HH:MM:SS).";
        		return false;
    			}
			}

            // Clear error message if validation passed
            errorMessage.textContent = "";
            return true;
        }
    </script>
</body>
</html>
