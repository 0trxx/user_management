<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Successful</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        .container {
            width: 400px;
            margin: 100px auto;
            padding: 20px;
            background-color: #ffffff;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            text-align: center;
        }

        h1 {
            font-size: 24px;
            color: #4CAF50;
            margin-bottom: 20px;
        }

        .emoji {
            font-size: 60px;
            margin-bottom: 20px;
        }

        .message {
            font-size: 16px;
            color: #888;
            margin-bottom: 20px;
        }

        .home-link {
            display: inline-block;
            background-color: #4CAF50;
            color: #ffffff;
            padding: 10px 20px;
            font-size: 16px;
            border-radius: 5px;
            text-decoration: none;
        }

        .home-link:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>

<div class="container">
    <h1>Login Successful<span class="emoji">😄</span></h1>
    <p class="message">Welcome! You are now logged in.</p>
    <a href="login.jsp" class="home-link">signout</a>
</div>

</body>
</html>
