<%@page import="br.senai.sp.cotia.quiosque.controller.IndexController"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<style>
body {
	background: linear-gradient(to bottom, #66ffff 0%, #ffffff 100%);
	background-repeat: no-repeat;
	height: 900px;
}

table {
	margin: auto;
	background-color: snow;
}

th {
	border: solid 2px black;
	height: 50px;
	width: 80px;
}

td {
	border: solid 2px black;
	text-align: center;
}

h1 {
	text-align: center;
}

a {
	text-decoration: none;
	color: black;
}

</style>
<meta charset="ISO-8859-1">
<title>Estatísticas</title>
</head>
<body>

	<table style="border: solid 1px black;">
		<tr>
		
				<th>Feminino</th>
				<th>Masculino</th>
				<th>Jovem</th>
				<th>Adulto</th>
				<th>Idoso</th>
				<th>Domingo</th>
				<th>Segunda</th>
				<th>Terça</th>
				<th>Quarta</th>
				<th>Quinta</th>
				<th>Sexta</th>
				<th>Manha</th>
				<th>Tarde</th>
				<th>Noite</th>
			
			
		</tr>
		
			<tr>
				<td>${fem}</td>
				<td>${masc}</td>
				<td>${contJovem}</td>
				<td>${contAdulto}</td>
				<td>${contIdoso}</td>
				<td>${dom}</td>
				<td>${seg}</td>
				<td>${ter}</td>
				<td>${qua}</td>
				<td>${qui}</td>
				<td>${sex}</td>
				<td>${manha}</td>
				<td>${tarde}</td>
				<td>${noite}</td>
				
				
			</tr>
		
	</table>

</body>
</html>