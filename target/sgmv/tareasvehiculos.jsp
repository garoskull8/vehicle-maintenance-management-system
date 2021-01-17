<%-- 
    Document   : tareasvehiculos
    Created on : 11/01/2021, 09:46:59 PM
    Author     : Alondra Jelinet
--%>
<!--oPERADO dAO POR TareaVDAO Y Tarea asignadaOP por TAREAV-->
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.TAREAV"%>
<%@page import="ModeloDAO.AdminDAO"%>
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
                            <a class="nav-link" href="index.jsp">Home
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
                <a href="index.jsp" class="btn btn-success">Regresar</a>
                 <a href="agregarTarea.jsp" class="btn btn-success">Agregar Tarea</a>
            </div>
            <div class="row">
                <h1>Tareas de mantenimiento vehicular</h1>
                <br>

                <div class="container-fluid "  style="margin-left:40px"> 
                    <div class="row">
                        <table class="table table-hover  table-responsive table-bordered border-dark col-sm-11 display" id="myTable" border="5">
                            <thead>
                                <tr>

                                    <th>ID</th>
                                    <th>TAREA</th>
                                    <th>DESCRIPCION</th>
                                    <th>VEHICULO</th>
                                    <th>FECHAENTRADA</th>
                                    <th>FECHASALIDA</th>
                                    <th>PRIORIDAD</th>
                                    <th>ESTADO</th>
                                    <th>OPERARIOS</th>
                                    <th>ACCIONES</th>

                                </tr>
                            </thead>
                            
                            <tbody>
                                 <%
                                AdminDAO dao = new AdminDAO();
                                List<TAREAV> list = dao.listarTarea(sesion);
                                Iterator<TAREAV> iter = list.iterator();
                                TAREAV alu = null;
                                while (iter.hasNext()) {
                                    alu = iter.next();


                            %>
                                <tr>
                                    <td><%=alu.getId()%></td>
                                    <td><%=alu.getTarea()%></td>
                                    <td><%=alu.getDescripcion()%></td>
                                    <td><%=alu.getVehiculo()%></td>
                                    <td><%=alu.getFechaEntrada()%></td>
                            
                                    <td>
                                        <%=alu.getFechaEntrada()%>
                          

                                    </td>
                                    <form action="Administrador1" method="post">
                                    <td>
                                        
                                    <select class="form-control" name="prioridad">
                                            <option value="<%=alu.getPrioridad()%>" selected><%
                                                if (alu.getPrioridad().equals("0")) {
                                                    out.println("Baja");
                                                } else if (alu.getPrioridad().equals("1")) {
                                                    out.println("Media");
                                                } else if (alu.getPrioridad().equals("2")) {
                                                    out.println("Alta");
                                                }


                                                %></option>
                                            <option value="2">Alta</option>
                                            <option value="1">Media</option>
                                            <option value="0">Baja</option>
                                        </select> 
                                    </td>
                                    <td>
                                        <select class="form-control" name="estado">
                                            <option value="<%=alu.getEstado()%>" selected><%
                                                if (alu.getEstado().equals("0")) {
                                                    out.println("En reparación");
                                                } else if (alu.getEstado().equals("1")) {
                                                    out.println("Listo");
                                                }
                                                %></option>
                                            <option value="1">Listo</option>
                                            <option value="0">En reparación</option>
                                        </select>
                                        
                                    </td>
                                    <td> 
                                        <a class="btn btn-primary" href="agregarOperario.jsp?id=<%=alu.getId()%>">Operarios</a>
                                    </td>
                                    <td>
                                        <input type="text" value="<%=alu.getId()%>" name="idTarea" hidden>
                                        <input type="text" value="actualizaTareasAdmin" name="accion" hidden>
                                        <button type="submit" class="btn btn-success">Actualizar</button>
                                        <a class="btn btn-warning" href="Administrador1?accion=">Eliminar</a>
                                        
                                  
                                    </td>
                            </form>
                                </tr>
                                <%}%>
                                </tbody>
                        </table>

                    </div>
                </div>
            </div>
        </div>


        <!-- /.container -->

       z

        <!-- Bootstrap core JavaScript -->
        <script src="js/jquery-3.5.1.slim.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.js"></script>
        <script src="js/operador.js"></script>
        
    </body>

</html>
        