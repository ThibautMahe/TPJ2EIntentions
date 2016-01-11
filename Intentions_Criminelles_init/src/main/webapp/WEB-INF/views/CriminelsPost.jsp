<!DOCTYPE html>
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
				<td><input Name='Name' value="${criminel.Name}"/></td>
			</tr>
			<tr>
				<td>Age:</td>
				<td><input Name='Age' value="${criminel.Age}"/></td>
				
			</tr>
			<tr>
				<td>&nbsp;<input type="hidden" Name='id' value="${criminel.id}"/></td>
				<td><input type='reset' /><input name="submit" type='submit' /></td>
			</tr>
		</table>
	</form>
</body>
</html>