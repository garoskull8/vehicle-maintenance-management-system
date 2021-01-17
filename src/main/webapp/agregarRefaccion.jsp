<%-- 
    Document   : index
    Created on : 21/12/2020, 05:05:06 PM
    Author     : edgar
--%>

<%@page import="ModeloDAO.Refacciones"%>
<%@page import="ModeloDAO.RefaccionesOPDAO"%>
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
            String idTarea = request.getParameter("idTarea");
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
                <a href="refaccionOP.jsp?idTarea=<%=idTarea%>" class="btn btn-success">Regresar</a>
            </div>
            <br>
            <%
            if(request.getAttribute("error") != null){
                out.println("<div class=\"alert alert-danger alert-dismissible fade show\" id=\"mensaje3\">Error agregar refacción, almacen insuficiente </div>");
            }
     %>
            <div class="row">
                <div class="row">
                    <h1>Asignar refacción a la tarea <%=idTarea%></h1>
                </div>
                <br>

                <div class="container-fluid "  style="margin-left:40px"> 
                    <div class="row">
                        <form action="Operador" method="post">
                            <div class="row">
                                <label class="col-form-label" for="refaccion">Seleccionar refacción:</label>
                                <select id="refaccion" class="form-control" name="idRefaccion" required>
                                    <option value="" selected>Seleccionar</option>
                                    <%
                                        RefaccionesOPDAO dao = new RefaccionesOPDAO();
                                        List<Refacciones> list = dao.listarRefaccion(idTarea);
                                        Iterator<Refacciones> iter = list.iterator();
                                        Refacciones alu = null;
                                        while (iter.hasNext()) {
                                            alu = iter.next();


                                    %>
                                    <option value="<%=alu.getId()%>"><%=alu.getNombre()%></option>
                                    <%}%>           
                                </select>

                            </div>
                                <br>
                            <div class="row">
                                <label class="col-form-label" for="cantidad">Cantidad:</label>
                                <input type="number" min="1" class="form-control" name="cantidad" required>
                            </div>
                                <br>
                                <input type="text" name="accion" value="agregarRefaccion" hidden>
                                <button type="submit" class="btn btn-primary">Enviar</button>
                        </form>

                    </div>
                </div>
                                <br><br><br>
            </div>
        </div>

        <!-- /.container -->

        <!-- Footer -->
        <footer class="fixed-bottom py-5 bg-dark">
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