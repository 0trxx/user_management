<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>

<form action=AddServlet method=post>

<table>

<tr><td>Enter Name:</td>  <td><input type=text name=txtName></td></tr>
<tr><td>Password:</td>  <td><input type=password name=txtPwd></td></tr>
<tr><td>Mobile Number:</td>  <td><input type=number name=mobNum></td></tr>
<tr><td>Email:</td>  <td><input type=email name=email></td></tr>
<tr><td><input type=submit value=Submit></td>  <td><input type=reset></td> </tr>
<tr> <td><a href=login.jsp> Back </a></td> </tr>

</table>
</form>
</body>
</html>