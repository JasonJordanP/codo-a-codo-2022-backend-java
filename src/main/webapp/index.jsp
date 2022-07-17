<html>
	<head>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
		<link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">
	</head>
	
	<body>
		
		<main>
		<%@include file="navbar.jsp" %>
			<div class="container">
				<section>
				<br>
					<h1 style= "text-align: center">ABM de productos</h1>
					<br>
					<p style= "text-align: center">Bienvenido(a) al portal ABM de Codo a Codo. En esta página usted podrá realizar el alta, baja y/o modificación de los productos que pertenecen al inventario del programa Codo a Codo. 
					Para ello, complete los campos en la sección <a href="<%=request.getContextPath()%>/alta.jsp"><i>Alta</i></a> y luego consúltelos, edítelos o elimínelos en la pestaña <a href="<%=request.getContextPath()%>/api/ListadoController"><i>Listado</i></a>.<p>
					<br>
					<img src="<%=request.getContextPath()%>/css/abmprodu.png" style= "width: 60%; display: block; margin: 0 auto">
					
				</section>
			</div>
		</main>
	</body>
	<footer class="text-center" style="background-color: rgb(255, 191, 94); padding: 30px">
			      <p>© 2022 Jordan Pérez Urrutia para Codo a Codo. Todos los derechos reservados. 
			      <br>
	    <a class="text" href="https://github.com/JasonJordanP">https://github.com/JasonJordanP</a>
		
	</footer>
</html>