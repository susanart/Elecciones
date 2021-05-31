<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Candidato</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>   
	<header>
		<nav class="navbar navbar-expand-md navbar-dark" style="background-color:red">
			<div>
				<a href="#" class="navbar-brand">Gesti�n de candidato</a>
			</div>
			<ul class="navbar-nav">
				<li> <a href="<%=request.getContextPath()%>/list" class= "nav-link">Candidatos</a> </li>		
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
			
				<c:if test="${candidato != null }">
					<form action="update" method="post">
				</c:if>
				<c:if test="${candidato == null }">
					<form action="insert" method="post">
				</c:if>
				
				<caption>
					<h2>
						<c:if test="${candidato != null }">
							Editar Candidato
						</c:if>
						<c:if test="${candidato == null }">
							Agregar Nuevo Candidato
						</c:if>
					</h2>	
				</caption>
				
				<c:if test="${candidato != null }">
					<input type="hidden" name="id" value="<c:out value='${candidato.id}'/>" />
				</c:if>
				
				<fieldset class="form-group">
					<label>Documento del Candidato:</label> <input type="text" value="<c:out value ='${candidato.documento}'/>" class="form-control" name="documento" required="required">
					<label>Nombre del Candidato:</label> <input type="text" value="<c:out value ='${candidato.nombre}'/>" class="form-control" name="nombre" required="required">
					<label>Apellido del Candidato:</label> <input type="text" value="<c:out value ='${candidato.apellido}'/>" class="form-control" name="apellido">
					<label>Elecci�n del Candidato:</label> <input type="number" value="<c:out value ='${candidato.eleccion}'/>" class="form-control" name="eleccion">
					<label>Numero del Candidato:</label> <input type="number" value="<c:out value ='${candidato.numero}'/>" class="form-control" name="numero">					 
				</fieldset>
				<button type="submit" class="btn btn-success">Guardar</button>
				</form>	
			</div>
		</div>
	</div>	
</body>
</html>