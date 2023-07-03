<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Find User</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        h1 {
            text-align: center;
        }

        .container {
            width: 400px;
            margin: 20px auto;
            padding: 20px;
            background-color: #ffffff;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }

        .form-group {
            margin-bottom: 10px;
        }

        label {
            display: block;
            font-weight: bold;
        }

        input[type="text"],
        select {
            width: 100%;
            padding: 8px;
            border-radius: 5px;
            border: 1px solid #ccc;
        }

        button[type="submit"] {
            background-color: #4CAF50;
            color: #fff;
            border: none;
            padding: 10px 20px;
            font-size: 16px;
            border-radius: 5px;
            cursor: pointer;
        }

        button[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>

<div class="container">
    <h1>Find User</h1>
    <form action="FindUser" method="post">
        <div class="form-group">
            <label for="search-term">Search for:</label>
            <input type="text" id="search-term" name="name" required>
        </div>
        <div class="form-group">
            <label for="search-category">Search in category:</label>
            <select id="search-category" name="search-category">
                <option value="name">Name</option>
                <option value="mobNum">Number</option>
                <option value="email">E-mail</option>
            </select>
        </div>
        <button type="submit">Search</button>
    </form>
</div>

</body>
</html>
