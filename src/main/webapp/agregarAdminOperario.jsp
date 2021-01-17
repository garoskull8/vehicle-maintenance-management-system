<%-- 
    Document   : agregarTarea
    Created on : 15/01/2021, 08:32:14 PM
    Author     : Alondra Jelinet
--%>


<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="ModeloDAO.Clase_Conexion"%>
<%@page import="ModeloDAO.AgregarTareaDAO"%>
<%@page import="ModeloDAO.TareaAdmin"%>
<%@page import="ModeloDAO.DatosOperador"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
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

        <title>SGMV</title>

        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

    </head>

    <body>
        <%
            Date dNow = new Date();
            SimpleDateFormat ft
                    = new SimpleDateFormat("dd/MM/yyyy");
            String currentDate = ft.format(dNow);
            String sesion = null;
            String idTarea = request.getParameter("idTarea");
            if (session.getAttribute("admin") != null) {
                sesion = (String) session.getAttribute("admin");
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
                            <a class="nav-link" href="#">Home
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
                <a href="tareasvehiculos.jsp" class="btn btn-success">Regresar</a>
            </div>
            <%
            if(request.getAttribute("error") != null){
                out.println("<div class=\"alert alert-danger alert-dismissible fade show\" id=\"mensaje3\">Error</div>");
            }
     %>
            <br>
            <div class="row">
                <div class="row">
                    <h1>Agregar Operario a la tarea <%=idTarea%> </h1>
                </div>
                <br>
                <div class="container">

                   
                

                        <form action="Administrador1" method="post">
                            
                            <label>Seleccione operario: </label>
                                        <select class="form-control" id="select1" name="idOperario" required onchange="ShowSelected();">
                                <option value="" selected>Seleccione</option>

                                <%
                                    Clase_Conexion cn = null;
                                    PreparedStatement pst = null;
                                    ResultSet rs = null;
                                    String consulta="";
                                    try {
                                        cn = new Clase_Conexion();
                                        
                                         consulta = "SELECT idoperarios,nombre,ap,am FROM operarios;";
                                       
                                        pst = cn.getConnection().prepareStatement(consulta);
                                        rs = pst.executeQuery(consulta);
                                        rs = pst.executeQuery();

                                        while (rs.next()) {

                                            out.println("<option value=" + rs.getString("idoperarios") + ">" + rs.getString("nombre") + "  " + rs.getString("ap") + "  " + rs.getString("am")+ "</option>");

                                        }

                                    } catch (Exception e) {
                                        out.println(e.toString());
                                    } finally {
                                        try {
                                            if (cn.getConnection() != null) {
                                                cn.getConnection().close();
                                            }
                                            if (pst != null) {
                                                pst.close();
                                            }
                                        } catch (Exception e) {
                                            System.err.println("Error" + e);
                                        }
                                    }

                                %>
                            </select> 
                               
                                        <input type="text" name="accion" value="insertarAdminOP" hidden>
                                        <input type="text" name="idTarea" value="<%=idTarea%>" hidden>
                                       
                                        <button type="submit" class="btn btn-primary">Enviar</button>

                                
                           
                        </form>
                 

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
