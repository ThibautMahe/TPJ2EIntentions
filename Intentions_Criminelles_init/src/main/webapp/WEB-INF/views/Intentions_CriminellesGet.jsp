<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Intentions Criminelles</title>
</head>
<body>
	<h1>Intentions Criminelles</h1>
	<form method='post'>
		<table>
			<c:forEach var="intention" items="${Intentions_Criminelles}">
				<tr>
					<td><h5>Action criminelle</h5></td>
					<td>&nbsp;</td>
					<td><h5>Lieu</h5></td>
					<td>&nbsp;</td>
					<td><h5>Criminel</h5></td>
				</tr>
				<tr>
					<td>${intention.action_Criminelle.action}</td>
					<td>&nbsp;</td>
					<td>${intention.lieu.emplacement}</td>
					<td>&nbsp;</td>
					<td>${intention.criminel.name}</td>
					<td>&nbsp;</td>
					<td><input name="Modifier${intention.ID}" type="submit"
						value="Modifier"></td>
					<td><input name="Supprimer${intention.ID}" type="submit"
						value="Supprimer"></td>
				</tr>
			</c:forEach>
			<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td><input name="Ajouter intention criminelle" type="submit"
					value="Ajouter intention criminelle"></td>
			</tr>
		</table>
		<table>
			<tr>
				<td><a href="/Intentions_Criminelles/Criminels"> <input
						type="button" value="Criminel">
				</a></td>
				<td><a href="/Intentions_Criminelles/Actions_Criminelles">
						<input type="button" value="Action criminelle">
				</a></td>
				<td><a href="/Intentions_Criminelles/Lieux"> <input
						type="button" value="Lieu">
				</a></td>
			</tr>
		</table>
	</form>
</body>
</html>