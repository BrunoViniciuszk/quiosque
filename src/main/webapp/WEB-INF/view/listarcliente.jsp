<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Clientes</title>
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
</head>
<body>
	<h1>Lista de Clientes</h1>

	<table style="border: solid 1px black;">
		<tr>
			<th>Id</th>
			<th>Nome</th>
			<th>Endereco</th>
			<th>Email</th>
			<th>Telefone</th>
			<th>Data de Nascimento</th>
			<th>Excluir</th>
			<th>Alterar</th>
		</tr>
		<c:forEach items="${clientes}" var="c">
			<tr>
				<td>${c.id}</td>
				<td>${c.nome}</td>
				<td>${c.endereco}</td>
				<td>${c.email}</td>
				<td>${c.telefone}</td>
				<td><fmt:formatDate pattern="dd/MM/yyyy" value="${c.dataNascimento.time}"/></td>
				<td><a href="excluirCliente?idCliente=${c.id}">Excluir</a></td>
				<td><a href="alterarCliente?idCliente=${c.id}">Alterar</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>