<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>Creditos Xideral</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>BANCO XIDERAL - Estatus de Credito</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Customer -->
		
			<input type="button" value="Agregar"
				   onclick="window.location.href='mostrarFormAgregar'; return false;"
				   class="add-button"
			/>
		
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>Nombre(s)</th>
					<th>Apellido(s)</th>
					<th>Email</th>
					<th>Estatus Credito</th>
					<th>Opciones</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempCliente" items="${clientes}">
				
					<!-- construct an "update" link with customer id -->
					<c:url var="actualizarLink" value="/cliente/mostrarFormActualizar">
						<c:param name="clienteId" value="${tempCliente.id}" />
					</c:url>					

					<!-- construct an "delete" link with customer id -->
					<c:url var="eliminarLink" value="/cliente/eliminar">
						<c:param name="clienteId" value="${tempCliente.id}" />
					</c:url>					
					
					<tr>
						<td> ${tempCliente.nombre} </td>
						<td> ${tempCliente.apellido} </td>
						<td> ${tempCliente.email} </td>
						<td> ${tempCliente.estatus} </td>
						
						<td>
							<!-- display the update link -->
							<a href="${actualizarLink}">Actualizar</a>
							|
							<a href="${eliminarLink}"
							   onclick="if (!(confirm('¿Esta seguro de que desea dar de baja a ${tempCliente.nombre}?'))) return false">Eliminar</a>
						</td>
						
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>









