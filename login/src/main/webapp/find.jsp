<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Find User</title>
</head>
<body>

	<h1>Find User</h1>
	<form action=FindUser method=post>
		<label for=search-term>Search for:</label>
		<input type=text id=search-term name=search-term required>
		<br><br>
		<label for=search-category>Search in category:</label>
		<select id=search-category name=search-category>
			<option value=name>Name</option>
			<option value=mobNum>Number</option>
			<option value=email>E-mail</option>
		</select>
		<br><br>
		<button type=submit>Search</button>
	</form>

</body>
</html>