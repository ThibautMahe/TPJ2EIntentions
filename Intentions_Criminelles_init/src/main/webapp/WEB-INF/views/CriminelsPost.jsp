<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Liste des criminelles</title>
</head>
<body>
	<h1>Liste des criminelles</h1>
	<div>
		<c:forEach var="criminel" items="${Criminels}">
			<ul>
				<li>${criminel.name} : ${criminel.age}</li>
			</ul>
		</c:forEach>
	</div>
</body>