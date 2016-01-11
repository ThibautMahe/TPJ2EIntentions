<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Action</title>
</head>
<body>
	<h1>Action</h1>
	<form method='get'>
		<table>
			<tr>
				<td>Action:</td>
				<td><input Name='Action' value="${Actions_Criminelles.action}" /></td>
			</tr>
			<tr>
				<td>&nbsp;<input type="hidden" Name='id'
					value="${Actions_Criminelles.ID}" /></td>
				<td><input type='reset' /><input name="submit" type='submit' value='Ok' /></td>
			</tr>
		</table>
	</form>
</body>
</html>