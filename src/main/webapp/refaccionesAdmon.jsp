<%-- 
    Document   : refaccionesAdmon
    Created on : 7/01/2021, 05:33:14 PM
    Author     : yosah
--%>
<%@page import="ModeloDAO.Refacciones"%>
<%@page import="ModeloDAO.RefaccionesAdminDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html lang="en">
    <head>
        <title>SGMV</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

        <link href="css/main.css" rel="stylesheet">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    </head>
    <body>
        <div class="card mb-6" style="justify-content: center;">
            <div class="row g-0">
                <div class="col-md-3" style="margin-left: 20px">
                    <img src="img/refacciones.png" alt="...">
                </div>
                <div class="text-white bg-dark col-md-8">
                    <div class="card-body">
                        <h2 class="card-title text-center ">Inventario de Refacciones</h2>
                    </div>
                </div>
            </div>
        </div>
        <br>
        
        <br>
        <!-- Nav tabs -->
        <div class= "container p-5">
            <ul class="nav nav-tabs nav-justified" role="tablist">
                <li class="nav-item">
                    <a class="nav-link active" data-toggle="tab" href="#registro">Registro refacciones</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" data-toggle="tab" href="#consulta">Consulta de refacciones</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" data-toggle="tab" href="#actualizar">Actualizar stock</a>
                </li>
            </ul>

            <!-- Tab panes -->
            <div class="tab-content">
                <div id="registro" class="container tab-pane active"><br>
                    <!-- Formualrio del botón registro-->
                    <form  action="Administrador" method="post" >
                        <div class="form-label-group">
                            <label for="inputNombre">Nombre: </label>
                            <input type="text" id="inputNombre" class="form-control" placeholder="Nombre" name="nombre" required autofocus>                           
                        </div>
                        <div class="form-label-group">
                            <label for="inputCantidad">Cantidad </label>
                            <input type="number" min="1" id="inputNombre" class="form-control" placeholder="Cantidad" name="cant" required >                           
                        </div>
                        <input type="text"  id="accion" name="accion" value="regRefaccion" hidden>
                        <br><button class="btn btn-lg btn-primary btn-block btn-login text-uppercase font-weight-bold mb-2" type="submit">Registrar</button>
                    </form>
                </div>
                <!-- Tabla del botón consulta-->
                <div id="consulta" class="container tab-pane fade"><br>
                    <div class="container-fluid"  style="margin-left: 300px"> 
                        <div class="row">
                            <table class="table table-hover  table-responsive table-bordered border-dark col-sm-5 display" id="myTable" border="5">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>NOMBRE</th>
                                        <th>CANTIDAD</th>
                                        <th>ACCIONES</th>
                                    </tr>
                                </thead>
                                
                                <tbody>
                                    <%
                                    RefaccionesAdminDAO dao = new RefaccionesAdminDAO();
                                    List<Refacciones> list = dao.listarRefaccion();
                                    Iterator<Refacciones> iter = list.iterator();
                                    Refacciones alu = null;
                                    while (iter.hasNext()) {
                                        alu = iter.next();
                                    %>
                                    <tr>
                                        <td><%=alu.getId()%></td>
                                        <td><%=alu.getNombre()%></td>
                                        <td><%=alu.getCantidad()%></td>
                                        <td>
                                            <a class="btn btn-danger"  href="Administrador?accion=eliminarRefaccion&idRefaccion=<%=alu.getId()%>">Eliminar</a>
                                        </td>
                                    </tr> 
                                    <%}%>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <div id="actualizar" class="container tab-pane "><br>
                    <!-- Formualrio para actualizar stock-->
                    <form  action="Administrador" method="post" >
                        <label class="col-form-label" for="refaccion">Seleccionar refacción:</label>
                        <div class="row">
                            <select id="refaccion" class="form-control" name="idRefaccion" required>
                                <option value="" selected>Seleccionar</option>
                                <%
                                    RefaccionesAdminDAO refAct = new RefaccionesAdminDAO();
                                    List<Refacciones> lisAct = refAct.listarRefaccion();
                                    Iterator<Refacciones> iterAct = lisAct.iterator();
                                    Refacciones recAct = null;
                                    while (iterAct.hasNext()) {
                                        recAct = iterAct.next();
                                %>
                                <option value="<%=recAct.getId()%>"><%=recAct.getNombre()%></option>         
                                <%}%>
                            </select>  
                        </div>
                        <div class="row">
                            <label class="col-form-label" for="cantidad">Cantidad a sumar en Stock:</label>
                            <input type="number" min="1" class="form-control" name="cantidad" required>
                        </div>
                            <br><input type="text" name="accion" value="actualizaRefaccion" hidden>
                        <button type="submit" class="btn btn-primary">Actualizar</button>
                    </form>
                </div>
            </div>
        </div> 
                            
        <!-- /.container -->

        <!-- Footer -->
        <footer class="fixed-bottom py-3 bg-dark">
            <div class="container">
                <p class="m-0 text-center text-white">Copyright &copy; Equipo 1 2020</p>
            </div>
            <!-- /.container -->
        </footer>
    </body>
</html>
