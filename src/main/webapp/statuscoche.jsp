<%-- 
    Document   : statuscoche
    Created on : 4 ene. 2021, 11:13:40
    Author     : Dylan Abirham
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page import="java.sql.ResultSet"%>

<!doctype html>
<html lang="en">
    <head>

        <link href="css/status.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
        <!--LETRA AUDIOWIDE-->
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Audiowide&display=swap" rel="stylesheet">
        <!--LETRA ASSISTANT BOLD-->
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Assistant:wght@400;700&display=swap" rel="stylesheet">

        <!--BOOTSTRAP
        <link rel="stylesheet" href="assets/css/bootstrap.min.css" >-->
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

        <title>Status Coche</title>
    </head>
    <body>
        <h2 class="text-center text-uppercase mt-5 mb-1 titulo">Status del Coche</h2>
        <div class="d-grid gap-2 d-md-block d-md-flex align-content-center mb-3">
            <input id="searchTerm" type="text" placeholder="Ingresa tel id del coche a verificar" required autofocus onkeyup="doSearch()" >
            <!--<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" data-whatever="@mdo">Open modal for @mdo</button>-->

        </div>

        <hr class="col-md-6 mb-5">

        <div class="container-fluid">

            <div class="row">
                <div class="col-md-8 ml-2">
                    <div class="card text-center">
                        <div class="table-responsive">
                            <table class="table table-striped card-text">
                                <thead class="cabecero">
                                    <tr>
                                        <th>ID</th>
                                        <th>Nombre del conductor</th>
                                        <th>Placas del coche</th>
                                        <th>Descripción</th>
                                        <th>Fecha entrada</th>
                                        <th>Fecha salida</th>
                                        <th>Estado</th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <jsp:useBean id="cn" class="ModeloDAO.cocheDAO" scope="page"></jsp:useBean>
                                    <%
                                        ResultSet rs = cn.listar();
                                        while (rs.next()) {
                                    %>
                                    <!-- Iteramos cada elemento de la lista de clientes -->
                                    <tr>
                                        <td><%=rs.getInt("idvehiculos")%></td>
                                        <td><%=rs.getString("idchofer")%></td>
                                        <td><%=rs.getString("placas")%></td>
                                        <td><%=rs.getString("marca")%></td>
                                        <td><%=rs.getString("modelo")%></td>
                                        <td><%=rs.getString("tipo")%></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--jQuey-->
        <script src="assets/js/jquery-1.12.0.min.js"></script>
        <!--AJAX-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <!--BOOTSTRAP-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>

        <script src="assets/js/comunes.js" type="text/javascript"></script>

    </body>
</html>
