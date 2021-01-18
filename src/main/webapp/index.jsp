<%-- 
    Document   : index
    Created on : 21/12/2020, 05:05:06 PM
    Author     : edgar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>SGMV</title>

  <!-- Bootstrap core CSS -->
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <link href="css/main.css" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  	<!--FontIcon-->
  <script src="https://kit.fontawesome.com/aed56cebe5.js" crossorigin="anonymous"></script>

</head>

<body>

  <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="index.jsp">INICIO&nbsp;<i class="fas fa-home"></i></a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item active">
            <a class="nav-link" href="index.jsp">Home
              <span class="sr-only">(current)</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="acerca_de.jsp">Acerca</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="Servicios.jsp">Servicios</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="Contacto.jsp">Contacto</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>

  <!-- Page Content -->
  <div class="container">

    <!-- Jumbotron Header -->
    <header class="jumbotron my-4">
      <h1 class="display-3">¡Bienvenido!</h1>
      <p class="lead">Sistema para la Gestión del Mantenimiento Vehicular (SGMV)</p>
      <h2 style="text-align: center">Plazco S.A. de C.V.</h2>
    </header>

    <!-- Page Features -->
    <div class="row text-center">

      <div class="col-lg-3 col-md-6 mb-4">
        <div class="card h-100">
          <img class="card-img-top" src="img/administrador.png" alt="">
          <div class="card-body">

              <h4 class="card-title"><strong>Administrador</strong></h4>
            <p class="card-text">Iniciar sesión como Administrador.</p>

          </div>
          <div class="card-footer">
            <a href="Login_Admin.jsp" class="btn btn-success botonRedondo">Continuar</a>
          </div>
        </div>
      </div>

      <div class="col-lg-3 col-md-6 mb-4">
        <div class="card h-100">
          <img class="card-img-top" src="img/operador.png" alt="">
          <div class="card-body">
              <h4 class="card-title"><strong>Operador</strong></h4>
            <p class="card-text">Iniciar sesión como operario.</p>
          </div>
          <div class="card-footer">
            <a href="operador_login.jsp" class="btn btn-success botonRedondo">Continuar</a>
          </div>
        </div>
      </div>

       <div class="col-lg-3 col-md-6 mb-4">
        <div class="card h-100">
          <img class="card-img-top" src="img/status.png" alt="">
          <div class="card-body">
              <h4 class="card-title"><strong>Status del Coche</strong></h4>
            <p class="card-text">Verificar el Status del Coche en revisión.</p>
          </div>
          <div class="card-footer">
            <a href="statuscoche.jsp" class="btn btn-success botonRedondo">Continuar</a>
          </div>
        </div>
      </div>

      

    </div>
    <!-- /.row -->

  </div>
  <!-- /.container -->

  <!-- Footer -->
  <footer class="py-5 bg-dark">
    <div class="container">
      <p class="m-0 text-center text-white">Copyright &copy; Equipo 1 2020</p>
    </div>
    <!-- /.container -->
  </footer>

  <!-- Bootstrap core JavaScript -->
  <script src="js/jquery-3.5.1.slim.min.js"></script>
  <script src="js/bootstrap.min.js"></script>

</body>

</html>