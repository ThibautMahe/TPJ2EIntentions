<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Liste des lieux</title>
</head>
<body>
	<a href="/Intentions_Criminelles"> <input type="button"
		value="Retour"></a>
	<h1>Liste des lieux</h1>
	<div>
		<form method='post'>
			<table>
				<c:forEach var="lieu" items="${Lieux}">
					<tr>
						<td>Lieu</td>
						<td>: ${lieu.emplacement}</td>
						<td>&nbsp;&nbsp;</td>
						<td><input name="Modifier${lieu.ID}" type="submit"
							value="Modifier"></td>
						<td><input name="Supprimer${lieu.ID}" type="submit"
							value="Supprimer"></td>
					</tr>
				</c:forEach>
				<tr>
					<td>&nbsp;</td>
					<td><input name="Ajouter lieu" type="submit"
						value="Ajouter lieu"></td>
				</tr>
			</table>
		</form>
	</div>
</body>