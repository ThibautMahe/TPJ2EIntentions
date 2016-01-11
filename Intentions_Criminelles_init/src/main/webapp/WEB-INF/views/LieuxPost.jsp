<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Liste des lieux</title>
</head>
<body>
	<div>
		<c:forEach var="Lieux" items="${Lieux}">
			<ul>
				<li>${lieux.name}</li>
			</ul>
		</c:forEach>
	</div>
</body>