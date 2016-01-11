<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Criminels</title>
</head>
<body>
	<h1>Criminels</h1>
	<form method='get'>
		<table>
			<tr>
				<td>Name:</td>
				<td><input Name='Name' value="${Criminels.name}" /></td>
			</tr>
			<tr>
				<td>Age:</td>
				<td><input Name='Age' value="${Criminels.age}" /></td>
			</tr>
			<tr>
				<td>&nbsp;<input type="hidden" Name='id'
					value="${Criminels.ID}" /></td>
				<td><input type='reset' /><input name="submit" type='submit' value='Ok' /></td>
			</tr>
		</table>
	</form>
</body>
</html>