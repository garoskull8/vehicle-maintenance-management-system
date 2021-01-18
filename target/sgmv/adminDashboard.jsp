<%-- 
    Document   : adminDashboard
    Created on : 17/01/2021, 02:19:34 PM
    Author     : yosah
--%>

<%@page import="java.util.Iterator"%>
<%@page import="ModeloDAO.DatosAdmon"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.AdminDAO"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SGMV</title>
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
            SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy");
            String currentDate = ft.format(dNow);
            String sesion = null;
            if (session.getAttribute("admin") != null) {
                sesion = (String) session.getAttribute("admin");
                //out.println("Sesion iniciada: "+sesion );
                out.println("Sesion iniciada: " + sesion);
            } else {
                request.getSession().setAttribute("expiro", false);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }

           
        %>
        
        <header id="header">
            <div class="d-flex flex-column">

                <div class="profile">
                    <img src="img/Admin1.png" alt="" class="img-fluid rounded-circle">
                    <%
                        AdminDAO dao = new AdminDAO();
            List<DatosAdmon> list = dao.DatosAdmon(sesion);
            Iterator<DatosAdmon> iter = list.iterator();
            DatosAdmon admon = null;
            while (iter.hasNext()) {
                admon = iter.next();%>
                    <h1 class="text-light"><p><%=admon.getNom()%> <%=admon.getAp() %></p></h1>
                    <hr>
                    <p class="text-light" style="text-align: center"><%=admon.getEmail() %></p>
 <%}%>
                    
                </div>



                <nav class="nav-menu">
                    <ul> 
                        <li class="active"><a href="adminDashboard.jsp"><i class="bx bx-home"></i> <span>Inicio</span></a></li>
                        <li><a href="#"><i class="bx bx-arrow-to-bottom"></i><form action="CerrarSesion" method="post">    
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
                                <img class="card-img-top" src="img/refacciones1.png" alt="">
                                <div class="card-body">
                                    <h4 class="card-title" style="text-align: center"><strong>Refacciones</strong></h4>
                                    <p class="card-text" style="text-align: center">Registra, Consulta, Actualiza o Elimina las</p>
                                    <p class="card-text" style="text-align: center">las refacciones dentro del inventario</p>
                                </div>
                                <div class="card-footer">
                                    <a href="refaccionesAdmon.jsp" class="btn btn-info botonRedondo">Continuar</a>
                                </div>

                            </div>

                        </div>

                        <div class="col-md-5">
                            <div class="card h-100">
                                <img class="card-img-top" width="100" height="225" src="img/Tareas2.png" alt="">
                                <div class="card-body">
                                    <h4 class="card-title" style="text-align: center"><strong>Tareas</strong></h4>
                                    <p class="card-text" style="text-align: center">Control de las tareas pendientes</p>
                                </div>
                                <div class="card-footer">
                                    <a href="tareasvehiculos.jsp" class="btn btn-danger botonRedondo">Continuar</a>
                                </div>
                            </div>
                        </div>



                    </div>

                </div>

            </div>
        </main>
    </body>
</html>
