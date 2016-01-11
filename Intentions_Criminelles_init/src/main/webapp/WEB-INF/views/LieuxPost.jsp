<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Lieux</title>
</head>
<body>
	<h1>Lieux</h1>
	<form method='get'>
		<table>
			<tr>
				<td>Emplacement:</td>
				<td><input Name='Name' value="${Lieux.emplacement}" /></td>
			</tr>
			<tr>
				<td>&nbsp;<input type="hidden" Name='id'
					value="${Lieux.ID}" /></td>
				<td><input type='reset' /><input name="submit" type='submit' value='Ok' /></td>
			</tr>
		</table>
	</form>
</body>
</html>