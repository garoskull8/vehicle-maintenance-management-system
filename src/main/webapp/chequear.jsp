<%-- 
    Document   : chequear
    Created on : 28 dic. 2020, 21:39:24
    Author     : edwin
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <%

            Date dNow = new Date();
            SimpleDateFormat ft
                    = new SimpleDateFormat("dd/MM/yyyy");
            String currentDate = ft.format(dNow);
            String sesion = null;
            if (session.getAttribute("operador") != null) {
                sesion = (String) session.getAttribute("operador");
                //out.println("Sesion iniciada: "+sesion );
                out.println("Sesion iniciada: " + sesion);
            } else {
                request.getSession().setAttribute("expiro", false);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        %>
                <!-- Navigation -->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
            <div class="container">
                <a class="navbar-brand" href="">INICIO</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="operadorDashboard.jsp">Home
                                <span class="sr-only">(current)</span>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Acerca</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Servicios</a>
                        </li>
                        <li class="nav-item">
                            <form action="CerrarSesion" method="post">    
                                <input class="btn btn-link text-white" type="submit" value="Cerrar sesión">
                            </form>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <h1>Hello World!</h1>
    </body>
</html>
