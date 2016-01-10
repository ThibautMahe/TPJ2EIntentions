<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Liste des intentions</title>
</head>
<body>
	<div>
		<c:forEach var="criminel" items="${Criminels}">
			<ul>
				<li>${criminel.name} : ${criminel.age}</li>
			</ul>
		</c:forEach>
	</div>
</body>