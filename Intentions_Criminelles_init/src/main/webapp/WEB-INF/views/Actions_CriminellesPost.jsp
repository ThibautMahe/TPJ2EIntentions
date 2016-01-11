<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Liste des actions criminelles</title>
</head>
<body>
	<div>
		<c:forEach var="action" items="${Action}">
			<ul>
				<li>${action.name}</li>
			</ul>
		</c:forEach>
	</div>
</body>