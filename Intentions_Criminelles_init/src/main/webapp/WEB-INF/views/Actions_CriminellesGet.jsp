<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Liste des actions criminelles</title>
</head>
<body>
	<h1>Liste des actions criminelles</h1>
	<div>
		<form method='post'>
			<table>
				<c:forEach var="action" items="${Actions}">
					<tr>
						<td>Action:</td>
						<td><input Name='Action' /></td>
						<td>&nbsp;</td>
						<td><input name="Modifier${action.ID}" type="submit"
							value="Modifier"></td>
						<td><input name="Supprimer${action.ID}" type="submit"
							value="Supprimer"></td>
					</tr>
				</c:forEach>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td><input name="Ajouter criminel" type="submit"
						value="Ajouter criminel"></td>
				</tr>
			</table>
		</form>
	</div>
</body>