<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
        }
        
        #container {
            max-width: 500px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
        
        h1 {
            text-align: center;
            color: #333;
        }
        
        table {
            margin: 20px auto;
        }
        
        td {
            padding: 10px;
        }
        
        input[type="text"],
        input[type="password"],
        input[type="number"],
        input[type="email"],
        input[type="submit"],
        input[type="reset"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
            font-size: 14px;
        }
        
        input[type="submit"],
        input[type="reset"] {
            background-color: #4CAF50;
            color: #fff;
            cursor: pointer;
        }
        
        input[type="submit"]:hover,
        input[type="reset"]:hover {
            background-color: #45a049;
        }
        
        a {
            text-decoration: none;
            color: #333;
        }
    </style>
</head>
<body>
    <div id="container">
        <form action="AddServlet" method="post">
            <table>
                <tr>
                    <td>Enter Name:</td>
                    <td><input type="text" name="txtName"></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="password" name="txtPwd"></td>
                </tr>
                <tr>
                    <td>Mobile Number:</td>
                    <td><input type="number" name="mobNum"></td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><input type="email" name="email"></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"></td>
                    <td><input type="reset"></td>
                </tr>
                <tr>
                    <td colspan="2" style="text-align: center;"><a href="login.jsp">Back</a></td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
