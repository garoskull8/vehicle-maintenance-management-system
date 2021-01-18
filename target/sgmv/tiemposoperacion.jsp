<%-- 
    Document   : statuscoche
    Created on : 4 ene. 2021, 11:13:40
    Author     : Dylan Abirham
--%>
<%@page import="ModeloDAO.Tiempos"%>
<%@page import="ModeloDAO.cocheDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.TareaAsignadaOP"%>
<%@page import="ModeloDAO.OperadorDAO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <link href="css/status.css" rel="stylesheet" type="text/css"/>
        <title>STATUS COCHE</title>

        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

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
                <a class="navbar-brand" href="#">INICIO</a>
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

        <!-- Page Content -->

        <!-- Page Content -->
        <div style="margin-top: 50px;" class="container">
            <div class="row">
                <a href="operadorDashboard.jsp" class="btn btn-success">Regresar</a>
            </div>
            <div class="row">
                <h1>STATUS DEL COCHE</h1>
                <br>

                <div class="container-fluid "  style="margin-left:40px"> 
                    <div class="row">
                        <table class="table table-hover  table-responsive table-bordered border-dark col-sm-11 display" id="myTable" border="5">
                            <thead>
                                <tr>

                                    <th>ID</th>
                                    <th>Nombre</th>
                                    <th>AP</th>
                                    <th>AM</th>
                                    <th>FECHA</th>
                                    <th>H. ENTRADA</th>    
                                    <th>H. SALIDA</th> 
                                    <th>T. OPERACION</th> 
                                  

                                </tr>
                            </thead>
                            
                            <tbody>
                                <%
                                cocheDAO dao = new cocheDAO();
                                List<Tiempos> list = dao.tiempos(sesion);
                                Iterator<Tiempos> iter = list.iterator();
                                Tiempos alu = null;
                                while (iter.hasNext()) {
                                    alu = iter.next();


                            %>
                                <tr>
                                    <td><%=alu.getIdTiempo()%></td>
                                    <td><%=alu.getNombre()%></td>
                                    <td><%=alu.getAp()%></td>
                                    <td><%=alu.getAm()%></td>              
                                    <td><%=alu.getFechaE()%></td>
                                    <td><%=alu.getHoraE()%></td>
                                    <td><%=alu.getHoraS()%></td>
                                    <td><%=alu.getTiempo()%></td>
                                    
                                   
                                    
                                      
                                </tr>
                                <%}%>
                                </tbody>
                        </table>

                    </div>
                </div>
            </div>
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
        <script type="text/javascript" src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.js"></script>
        <script src="js/operador.js"></script>
        
    </body>

</html>