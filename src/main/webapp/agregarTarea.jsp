<%-- 
    Document   : agregarTarea
    Created on : 15/01/2021, 08:32:14 PM
    Author     : Alondra Jelinet
--%>


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
                <a href="tareavehiculos.jsp" class="btn btn-success">Regresar</a>
            </div>
            <br>
            <div class="row">
                <div class="row">
                    <h1>Agregar Tarea </h1>
                </div>
                <br>
                <div class="container">
     
               <!--  <div class="form-group">
             
                    <label for="idTarea" class="control-label col-xs-4">ID:</label>
                    <input type="text" name="id" id="id" class="form-control" value="${estudiante.nombre}" required="true" />                                   

                    <label for="" class="control-label col-xs-4">Tarea:</label>                   
                    <input type="text" name="tarea" id="tarea" class="form-control" value="${estudiante.apellido}" required="true"/> 

                   <label for="apellido" class="control-label col-xs-4">Descripción:</label>                   
                    <input type="text" name="descripcion" id="descripcion" class="form-control" value="${estudiante.apellido}" required="true"/> 

                    <label for="vehiculo" class="control-label col-xs-4">Vehiculo:</label>                    
                    <input type="text" name="vehiculo" id="vehiculo" class="form-control" value="${estudiante.carrera}" placeholder="Ingrese placas" required="true"/> 

                     <label for="fechaEntrada" class="control-label col-xs-4">Fecha Entrada:</label>                 
                    <input type="text"  pattern="^\d{2}-\d{2}-\d{4}$" name="fechaEntrada" id="fechaEntrada" class="form-control" value="${estudiante.fechaNacimiento}" maxlength="10" placeholder="YYYY-MM-DD" required="true"/>
                      
                    <label for="fechaSalida" class="control-label col-xs-4">Fecha Salida:</label>                 
                    <input type="text"  pattern="^\d{2}-\d{2}-\d{4}$" name="fechaSalida" id="fechaSalida" class="form-control" value="${estudiante.fechaNacimiento}" maxlength="10" placeholder="YYYY-MM-DD" required="true"/>
                    
                    <label for="prioridad" class="control-label col-xs-4">Prioridad</label>
                    <input type="text" name="prioridad" id="prioridad" class="form-control" value="${estudiante.semestre}" required="true"/>

                    <label for="estado" class="control-label col-xs-4">Estado:</label>                   
                    <input type="text" name="estado" id="estado" class="form-control" value="${estudiante.email}"  required="true"/>
                    
                    <label for="operador" class="control-label col-xs-4">Operador:</label>                   
                    <input type="text" name="operador" id="operador" class="form-control" value="${estudiante.email}"  required="true"/>
                    <br>
                    <button type="submit" class="btn btn-primary">Guardar</button> 
                </div>  
                </div>
        </div>
             -->
         <table>

                        <form action="Administrador1" method="post">
                        <table>
                        <tr>
                        <td>ID:</td>
                        <td><input type="text" size="20" name="id"></td>
                        </tr>
                        <tr>
                        <td>Tarea:</td>
                        <td><input type="text" size="20" name="tarea"></td>
                        </tr>
                        <tr>
                        <td>Descripción:</td>
                        <td><input type="text" size="20" name="descripcion"></td>
                        </tr>
                        <tr>
                        <td>Vehiculo:</td>
                        <td><input type="text" size="20" name="vehiculos" placeholder="Insertar ID de vehiculo"></td>
                        </tr>
                        <tr>
                        <td>Fecha Entrada:</td>
                        <td><input type="text" size="20" name="fechaEntrada" placeholder="YYYY-MM-DD"></td>
                        </tr>
                        <tr>
                        <td>Fecha Salida:</td>
                        <td><input type="text" size="20" name="fechaSalida" placeholder="YYYY-MM-DD"></td>
                        </tr>
                         <tr>
                        <td>Prioridad:</td>
                        <td><input type="text" size="20" name="prioridad"></td>
                        </tr>
                         <tr>
                        <td>Estado:</td>
                        <td><input type="text" size="20" name="estado"></td>
                        </tr>
                        <tr>
                        <td>
                             <label class="col-form-label" for="refaccion">Seleccionar Operador:</label>
                                <select id="operador" class="form-control" name="operador" required>
                 
                         <option value="" selected>Seleccionar</option>
                                    <%
                                        AgregarTareaDAO dao = new AgregarTareaDAO();
                                        List<DatosOperador> list = dao.listarOperario(sesion);
                                        Iterator<DatosOperador> iter = list.iterator();
                                        DatosOperador alu = null;
                                        while (iter.hasNext()) {
                                            alu = iter.next();


                                    %>
                                    <option value="<%=alu.getIdOper()%>"><%=alu.getNom()%></option>
                                    <%}%>     </td>
                        </tr>
                        <tr>
                        <td colspan="2" align="center">
                                <input type="text" name="accion" value="insertarTarea" hidden>
                                <button type="submit" class="btn btn-primary">Enviar</button>
  
                        </tr>
                        </table>
                        </form>
                        </td>
                        </tr>
                        </table>
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
