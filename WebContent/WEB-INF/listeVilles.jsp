<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des villes</title>
<style>
table {
	border-collapse: collapse;
	padding: 35px 120px 30px 120px;
	background-color: rgba(128, 255, 255, 0.65);
	text-align: center;
	font-family: Times, sans-serif;
	color: rgb(0, 64, 128);
	border: rgb(0, 64, 128);
	border-width: 1px;
	border-style: groove;
	border-radius: 10px;
	
}

td, th {
	border: 1px solid blue;
}

body {
	font-family: Times, sans-serif;
	font-size: large;
	text-align: center;
}

#next{
		text-align: center;
}

#last{
		text-align: center;
}

</style>
</head>
<body>

	<h1>Villes de France :</h1>
	<table>
		<tr>
			<th>Code Insee</th>
			<th>Nom de la commune</th>
			<th>Code Postal</th>
			<th>Libelle acheminement</th>
			<th>Ligne 5</th>
			<th>Coordonnées</th>
		</tr>
		<c:choose>
			<c:when test="${bool}">
				<c:forEach var="i" begin="${taille}" end="${listeVille.size()-1}">
					<tr>
						<td><c:out value=" <a href='infosVille?insee=${listeVille.get(i).getCodeInsee()}'> ${listeVille.get(i).getCodeInsee()}" escapeXml="false" /></td>
				   		<td><c:out value="${listeVille.get(i).getNom()}" /></td>
						<td><c:out value="${listeVille.get(i).getCodePostal()}" /></td>
						<td><c:out value="${listeVille.get(i).getLibelle()}" /></td>
						<td><c:out value="${listeVille.get(i).getLigne5()}" /></td>
						<td><c:out value="${listeVille.get(i).getCoordonnees().getLatitude()}, ${listeVille.get(i).getCoordonnees().getLongitude()}" /></td>
					</tr>
				</c:forEach>
			</c:when>
			<c:when test="${!bool}">
				<c:forEach var="i" begin="${taille}" end="${taille+49}">
					<tr>
						<td><c:out value=" <a href='infosVille?insee=${listeVille.get(i).getCodeInsee()}'> ${listeVille.get(i).getCodeInsee()}" escapeXml="false" /></td>
						<td><c:out value="${listeVille.get(i).getNom()}" /></td>
						<td><c:out value="${listeVille.get(i).getCodePostal()}" /></td>
						<td><c:out value="${listeVille.get(i).getLibelle()}" /></td>
						<td><c:out value="${listeVille.get(i).getLigne5()}" /></td>
						<td><c:out value="${listeVille.get(i).getCoordonnees().getLatitude()}, ${listeVille.get(i).getCoordonnees().getLongitude()}" /></td>
					</tr>
				</c:forEach>
			</c:when>
		</c:choose>
	</table>
	<c:if test="${nbPage != 1 }">
		<p id="last"><a href="/com/listeVilles?page=${nbPage - 1 }"> Page précédente </a></p>
	</c:if>
	<c:if test="${!bool}">
		<p id="next"><a href="/com/listeVilles?page=${nbPage + 1 }"> Page suivante </a></p>
	</c:if>
	
	<a href="/com/distance">Retour à la page principale</a>
	
</body>
</html>