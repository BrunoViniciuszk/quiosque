<%@ page language="java" contentType="text/html;charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de Produto</title>
<style>
body {

	background-color: #C7D1D9;
	
}

h11 {
	color: red;
}

#logo {
	width: 50%;
	height: 50%;
}

.panel-heading {
	font-size: 150%;
}

.form-horizontal {
	width: 500px;
	position: absolute;
	top: 20%;
	left: 35%;
}

.padd20 {
	padding-top: 20px;
}

.marg20{

	margin-top:20px
}

.wid500 {
	width: 500px;
	height: 30px;
	border: #4F4D8C solid 2px;
	border-radius: 10px;
}

.wid300 {
	width: 300px;
	border: #4F4D8C solid 2px;
	border-radius: 10px;
	height: 30px;
}

label {
	color: #4F4D8C;
}

.campo {
	border-radius: 30px;
	border: #4F4D8C solid 5px;
	background-color: white;
}

button {
	width: 60px;
	height: 30px;
	color: #4F4D8C;
	background-color: white;
	border-radius: 10px;
}

button:hover {
	background-color: #4F4D8C;
	color: white;
	cursor: pointer;
}
</style>
</head>
<body>

	<form class="form-horizontal" action="SalvarCliente" method="post">
	<input type="hidden" value="${cliente.id}" name="id">
		<fieldset class="campo">
			<div>
				<h3 style="color: #4F4D8C">Cadastro de Cliente</h3>

				<div>
					<div>

						<div>
						<div>
							<label>Nome <h11>*</h11></label>
							
								<input name="nome" placeholder="Insira seu Nome"
									required="required" type="text" class="wid500" value="${cliente.nome }">
							</div>
							<div class="marg20">
							<label>Endereco<h11>*</h11></label>
							
								<input name="endereco" placeholder="Insira seu endereço"
									required="required" type="text" class="wid500" value="${cliente.endereco }">
							</div>
							
							<div  class="marg20">
							<label>Data de Nascimento<h11>*</h11></label>
							
							
								<input name="dataNascimento" placeholder="Insira sua data de nascimento"
									required="required" type="date" class="wid500"  value="<fmt:formatDate pattern="yyyy-MM-dd" value="${cliente.dataNascimento.time}"/>">
							</div>
							
							
						</div>

					</div>
				</div>
			</div>

			<div class="padd20">
				<label>Selecione seu gênero</label><br> <label> <input
					name="genero" value="feminino" type="radio" required="required" <c:if test="${cliente.genero.equals('feminino')}">checked</c:if>>
					Feminino
				</label>
				 <label>
				 <input name="genero" type="radio"
					required="required" value="masculino" <c:if test="${cliente.genero.equals('masculino')}">checked</c:if>> 
					 Masculino
				</label> 
			</div>
			<div class="padd20">
				<label>Email <h11>*</h11></label>
				<div>
					<div>
						<span><i></i></span> <input class="wid500" name="email"
							placeholder="email@email.com" required="required" type="text"
							pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" value="${cliente.email }">
					</div>
				</div>
			</div>

			<div class="padd20">
				<div>
					<span style="color: #4F4D8C">Telefone <h11>*</h11></span><br> <input
						class="wid300" name="telefone"
						placeholder="Insira seu telefone" required="required"
						type="text" value="${cliente.telefone }">
				</div>
			</div>
			
			

			
	<div class="marg20" >
			<label>Produto de Interesse</label> <select name="produtoInteresse">

				<c:forEach items="${tipos}" var="t">

					<option value="${t }">${t.toString() }</option>


				</c:forEach>

			</select> <br>
		</div>	
		
		<div class="marg20">
			<button type="submit">Enviar!</button>
			</div>

		</fieldset>

	</form>



</body>
</html>