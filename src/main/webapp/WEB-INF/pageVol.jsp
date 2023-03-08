<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
<thead >
<tr><th>id</th><th>Heure Arrivée</th><th>Heure Depart</th><th>Ville Arrivee</th><th>Ville Depart</th></tr>
</thead>

<c:forEach var="vol" items="${listeVol }">
<tr>
<td><a href="/TP1Groupe3/Reservation?idV=${vol.getId() }&idC=${idClient}" >${vol.getId() }</a></td><td>${vol.getDateDepart() }</td><td>${vol.getDateArrivee() }</td><td>${ vol.getAeroportDepart().getVille().getNom()}</td><td>${vol.getAeroportArrivee().getVille().getNom() }</td>
</tr>

</c:forEach>
</table>
	
</body>
</html>