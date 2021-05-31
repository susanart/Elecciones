<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Elecciones -Lista de candidatos</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"  style="background-color:red">
			<div>
				<a href="#" class="navbar-brand">ELECCIONES UFPS</a>
			</div>
			<ul class="navbar-nav">
				<li> <a href="<%=request.getContextPath()%>/list" class= "nav-link">Candidato</a> </li>		
			</ul>
		</nav>
	</header>
	<br>
	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='messege'>{{messege}}</div> -->
		<div class="container">
			<h3 class="text-center">Listado de Candidato</h3>
			<hr>
			<div class="container text-left">
				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Agregar Nuevo Candidato</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead >
					<tr>
						<th>ID</th>
						<th>Documento</th>
						<th>Nombre</th>
						<th>Apellido</th>
						<th>Eleccion</th>
						<th>Numero</th>
						<th>Acciones</th>
					</tr>
				</thead>
				<tbody>
					
					<c:forEach var="candidato" items="${listCandidatos}">
					<tr>
						<td>
							<c:out value="${candidato.id}" />
						</td>
						<td>
							<c:out value="${candidato.documento}" />
						</td>
						<td>
							<c:out value="${candidato.nombre}" />
						</td>
						<td>
							<c:out value="${candidato.apellido}" />
						</td>
						<td>
							<c:out value="${candidato.eleccion}" />
						</td>
						<td>
							<c:out value="${candidato.numero}" />
						</td>
						<td><a href="edit?id=<c:out value='${candidato.id}' />">Editar</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="delete?id=<c:out value='${candidato.id}'/>">Eliminar</a></td>
						</tr>
						</c:forEach>
											
				</tbody> 
			</table>
		</div>
	</div>	
</body>
</body>
</html>