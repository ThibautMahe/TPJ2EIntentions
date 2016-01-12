<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Intentions</title>
</head>
<body>
	<h1>Intentions</h1>
	<form method='get'>
		<table>
			<tr>
				<td>Action criminelle:</td>
				<td><select Name="Action_Criminelle">
						<c:forEach var="Action" items="${Actions_Criminelles}">
							<option>${action.action}
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>Lieu:</td>
				<td><select Name="Lieu">
						<c:forEach var="lieu" items="${Lieux}">
							<option>${lieu.emplacement}
						</c:forEach>
				</select></td>

			</tr>
			<tr>
				<td>Criminelle:</td>
				<td><select Name="Criminel">
						<c:forEach var="criminel" items="${Criminels}">
							<option>${criminel.name}
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>&nbsp;<input type="hidden" Name='id'
					value="${Intentions_Criminelles.ID}" /></td>
				<td><input type='reset' /><input name="submit" type='submit'
					value='Ok' /></td>
			</tr>
		</table>
	</form>
</body>
</html>