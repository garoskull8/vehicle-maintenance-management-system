<%-- 
    Document   : OperadorDashboard
    Created on : 21/12/2020, 06:19:08 PM
    Author     : edgar
--%>

<%@page import="java.util.Iterator"%>
<%@page import="ModeloDAO.DatosOperador"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.OperadorDAO"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
          <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/vendor/icofont/icofont.min.css" rel="stylesheet">
  <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="assets/vendor/venobox/venobox.css" rel="stylesheet">
  <link href="assets/vendor/owl.carousel/assets/owl.carousel.min.css" rel="stylesheet">
  <link href="assets/vendor/aos/aos.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="assets/css/style.css" rel="stylesheet">
       
    </head>
    <body>
      <%
     
     
            
            Date dNow = new Date();
            SimpleDateFormat ft = 
            new SimpleDateFormat ("dd/MM/yyyy");
            String currentDate = ft.format(dNow);
             String sesion = null; 
            if (session.getAttribute("operador") != null){
            sesion= (String) session.getAttribute("operador");
            //out.println("Sesion iniciada: "+sesion );
            out.println("Sesion iniciada: "+sesion );
            }else{
            request.getSession().setAttribute("expiro", false);
            request.getRequestDispatcher("index.jsp").forward(request, response);
            }
             
              
              OperadorDAO dao = new OperadorDAO();
                List<DatosOperador>list=dao.DatosOp(sesion);
                Iterator<DatosOperador>iter=list.iterator();
                DatosOperador op=null;
                while(iter.hasNext()){
                    op=iter.next();
             %>
             <header id="header">
    <div class="d-flex flex-column">

      <div class="profile">
        <img src="img/oper1.jpg" alt="" class="img-fluid rounded-circle">
        <h1 class="text-light"><%=op.getNom()%></h1>
        
        <h5 class="text-light" style="text-align: center"><%=op.getAp()+" "+op.getAm()%></h5>
        <hr>
        <p class="text-light" style="text-align: center"> <%=op.getEmail()%></p>
         
       <!-- <div class="social-links mt-3 text-center">
          <a href="#" class="twitter"><i class="bx bxl-twitter"></i></a>
          <a href="#" class="facebook"><i class="bx bxl-facebook"></i></a>
          <a href="#" class="instagram"><i class="bx bxl-instagram"></i></a>
          <a href="#" class="google-plus"><i class="bx bxl-skype"></i></a>
          <a href="#" class="linkedin"><i class="bx bxl-linkedin"></i></a>
        </div> -->
      </div>
       


     <nav class="nav-menu">
        <ul> 
          <li class="active"><a href="operadorDashboard.jsp"><i class="bx bx-home"></i> <span>Inicio</span></a></li>
          <li><a href="#about"><i class="bx bx-user"></i> <span>check in & cheack out</span></a></li>
          <li><a href="#resume"><i class="bx bx-arrow-to-bottom"></i><form action="CerrarSesion" method="post">    
                                <span><input class="btn btn-link text-secondary" type="submit" value="Cerrar sesión"></span>
                            </form></a></li>
         <!--  <li><a href="#portfolio"><i class="bx bx-book-content"></i> Portfolio</a></li>
          <li><a href="#services"><i class="bx bx-server"></i> Services</a></li>
          <li><a href="#contact"><i class="bx bx-envelope"></i> Contact</a></li> -->

        </ul>
      </nav><!-- .nav-menu -->
      <button type="button" class="mobile-nav-toggle d-xl-none"><i class="icofont-navigation-menu"></i></button>

    </div>
  </header>
                     <%
                         
                         }
                    %>
     <main id="main" style="align-content: center;" >        
        <!-- Jumbotron Header -->
      <div >
    <header  class="jumbotron" >
      <h1 class="display-5">¡Bienvenido!</h1>
      <p class="lead">Sistema para la Gestión del Mantenimiento Vehicular (SGMV)</p>
      <h2 style="text-align: center">Plazco S.A. de C.V.</h2>
    </header>    
            </div> 
      
        <div>
        
             <div class="container">
          
          <div class="row" >
              
                  <div class="col-md-5 ">
        <div class="card h-100">
          <img class="card-img-top" src="img/mant.png" alt="">
          <div class="card-body">
              <h4 class="card-title" style="text-align: center"><strong>Tareas de mantenimiento vehicular</strong></h4>
            <p class="card-text" style="text-align: center">Revisa las tareas que te han sido asignadas</p>
          </div>
          <div class="card-footer">
            <a href="tareasMantenimientoOp.jsp" class="btn btn-info botonRedondo">Continuar</a>
          </div>
       
      </div>
                  
              </div>
             
                  <div class="col-md-5">
        <div class="card h-100">
          <img class="card-img-top" width="100" height="225" src="img/mes-trabajo.jpg" alt="">
          <div class="card-body">
              <h4 class="card-title" style="text-align: center"><strong>Tiempos de operación</strong></h4>
            <p class="card-text" style="text-align: center">Checa tus tiempos de operación</p>
          </div>
          <div class="card-footer">
            <a href="tareasMantenimientoOp.jsp" class="btn btn-danger botonRedondo">Continuar</a>
          </div>
        </div>
      </div>
                  
              
              
          </div>
        
      </div>
         
            </div>
        </main>
        
    </body>
</html>