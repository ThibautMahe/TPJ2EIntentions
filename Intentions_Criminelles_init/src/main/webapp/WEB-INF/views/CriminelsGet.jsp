<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Liste des criminels</title>
</head>
<body>
	<h1>Liste des criminels</h1>
	<div>
		<form method='post'>
			<table>
				<c:forEach var="criminel" items="${Criminels}">
				<tr>
					<td>${criminel.name}</td>
					<td>: ${criminel.age}</td>
					<td>ans</td>
					<td>&nbsp;</td>
					<td><input name="Modifier${criminel.ID}" type="submit"
						value="Modifier"></td>
					<td><input name="Supprimer${criminel.ID}" type="submit"
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