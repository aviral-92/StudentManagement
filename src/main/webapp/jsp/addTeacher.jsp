<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/teacher/addteacher" name="addteacher" method="post">
		<table>
			<th><h3>Teacher details</h3></th>
			<tr>
				<td><label>Teacher Id</label></td>
				<td><input type="text" name="Id" id="Id"></td>
			</tr>
			<tr>
				<td><label>Teacher Name</label></td>
				<td><input type="text" name="name" id="name" /></td>
			</tr>
			<tr>
				<td><label>Teacher Address</label></td>
				<td><input type="text" name="address" id="address"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>