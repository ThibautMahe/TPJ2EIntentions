<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Liste des lieux</title>
</head>
<body>
	<h1>Liste des lieux</h1>
	<div>
		<table>
			<c:forEach var="lieu" items="${Lieux}">
				<tr>
					<td>${lieu.name}</td>
					<td>: ${lieu.age}</td>
					<td>ans</td>
					<td>&nbsp;&nbsp;</td>
					<td><input type="button" value="Modifier"></td>
					<td><input type="button" value="Supprimer"></td>
				</tr>
			</c:forEach>
			<tr>
				<td>&nbsp;</td>
				<td><input type="button" value="Ajouter lieu"></td>
			</tr>
		</table>
	</div>
</body>