<%-- 
    Document   : statuscoche
    Created on : 4 ene. 2021, 11:13:40
    Author     : Dylan Abirham
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

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
        <div class="d-grid gap-2 d-md-block d-md-flex justify-content-md-end mb-3">
             <input  type="text" name="txtid" class="form-control mt-1" placeholder="Ingresa tel id del coche a verificar" required autofocus>
                <!--<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" data-whatever="@mdo">Open modal for @mdo</button>-->
                <a href="agregarMembresias.jsp"  class="btn btn-success text-uppercase mr-3 align-content-center" type="button">Buscar</a>
              
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
                                    <!-- Iteramos cada elemento de la lista de clientes -->
                                    <c:forEach var="empleado" items="${empleados}">
                                        <tr>
                                            <!--<td></td>-->
                                            <td>${empleado.num_empleado}</td>
                                            <td>${empleado.nss} </td>
                                            <td>${empleado.nombres}</td>
                                            <td>${empleado.ap} ${empleado.am}</td>
                                            <td>${empleado.telefono}</td>
                                            <td>${empleado.email}</td>
                                            <td>${empleado.tipoEmpleado}</td>

                                            <td>
                                                <div class="botones">
                                                    <!--BOTÓN EDITAR-->
                                                    <button onclick="location.href = '${pageContext.request.contextPath}/ServletEmpleado?accion=editar&num_empleado=${empleado.num_empleado}'" 
                                                            class="btn btn-secondary btn-warning btn-sm btn-block mb-1 pl-3 pr-3 editar"
                                                            <c:if test="${empleado.activo == true}">disabled</c:if>>
                                                        <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-gear" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                                        <path fill-rule="evenodd" d="M8.837 1.626c-.246-.835-1.428-.835-1.674 0l-.094.319A1.873 1.873 0 0 1 4.377 3.06l-.292-.16c-.764-.415-1.6.42-1.184 1.185l.159.292a1.873 1.873 0 0 1-1.115 2.692l-.319.094c-.835.246-.835 1.428 0 1.674l.319.094a1.873 1.873 0 0 1 1.115 2.693l-.16.291c-.415.764.42 1.6 1.185 1.184l.292-.159a1.873 1.873 0 0 1 2.692 1.116l.094.318c.246.835 1.428.835 1.674 0l.094-.319a1.873 1.873 0 0 1 2.693-1.115l.291.16c.764.415 1.6-.42 1.184-1.185l-.159-.291a1.873 1.873 0 0 1 1.116-2.693l.318-.094c.835-.246.835-1.428 0-1.674l-.319-.094a1.873 1.873 0 0 1-1.115-2.692l.16-.292c.415-.764-.42-1.6-1.185-1.184l-.291.159A1.873 1.873 0 0 1 8.93 1.945l-.094-.319zm-2.633-.283c.527-1.79 3.065-1.79 3.592 0l.094.319a.873.873 0 0 0 1.255.52l.292-.16c1.64-.892 3.434.901 2.54 2.541l-.159.292a.873.873 0 0 0 .52 1.255l.319.094c1.79.527 1.79 3.065 0 3.592l-.319.094a.873.873 0 0 0-.52 1.255l.16.292c.893 1.64-.902 3.434-2.541 2.54l-.292-.159a.873.873 0 0 0-1.255.52l-.094.319c-.527 1.79-3.065 1.79-3.592 0l-.094-.319a.873.873 0 0 0-1.255-.52l-.292.16c-1.64.893-3.433-.902-2.54-2.541l.159-.292a.873.873 0 0 0-.52-1.255l-.319-.094c-1.79-.527-1.79-3.065 0-3.592l.319-.094a.873.873 0 0 0 .52-1.255l-.16-.292c-.892-1.64.902-3.433 2.541-2.54l.292.159a.873.873 0 0 0 1.255-.52l.094-.319z"/>
                                                        <path fill-rule="evenodd" d="M8 5.754a2.246 2.246 0 1 0 0 4.492 2.246 2.246 0 0 0 0-4.492zM4.754 8a3.246 3.246 0 1 1 6.492 0 3.246 3.246 0 0 1-6.492 0z"/>
                                                        </svg>
                                                    </button>

                                                    <!--BOTÓN ELIMINAR-->
                                                    <button onclick="location.href = '${pageContext.request.contextPath}/ServletEmpleado?accion=eliminar&num_empleado=${empleado.num_empleado}'" 
                                                                    class="btn btn-secondary btn-danger btn-sm btn-block mb-1 pl-3 pr-3 borrar"
                                                                    <c:if test="${empleado.activo == true}">disabled</c:if>>
                                                        <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-trash-fill" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                                        <path fill-rule="evenodd" d="M2.5 1a1 1 0 0 0-1 1v1a1 1 0 0 0 1 1H3v9a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V4h.5a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H10a1 1 0 0 0-1-1H7a1 1 0 0 0-1 1H2.5zm3 4a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 .5-.5zM8 5a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7A.5.5 0 0 1 8 5zm3 .5a.5.5 0 0 0-1 0v7a.5.5 0 0 0 1 0v-7z"/>
                                                        </svg>
                                                    </button>
                                                        
                                                    <!--BOTÓN BLOQUEAR-->
                                                    <button onclick="location.href = 'ServletEmpleado?accion=bloquear&num_empleado=${empleado.num_empleado}'"
                                                        class="btn btn-primary btn-sm btn-block mb-1 pl-3 pr-3 bl" id="${empleado.num_empleado}"
                                                        <c:if test="${empleado.activo == true}">hidden</c:if>>
                                                        <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-lock-fill" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                                        <path d="M2.5 9a2 2 0 0 1 2-2h7a2 2 0 0 1 2 2v5a2 2 0 0 1-2 2h-7a2 2 0 0 1-2-2V9z"/>
                                                        <path fill-rule="evenodd" d="M4.5 4a3.5 3.5 0 1 1 7 0v3h-1V4a2.5 2.5 0 0 0-5 0v3h-1V4z"/>
                                                        </svg>
                                                    </button>

                                                    <!--BOTÓN DESBLOQUEAR-->
                                                    <button onclick="location.href = 'ServletEmpleado?accion=desbloquear&num_empleado=${empleado.num_empleado}'"
                                                        class="btn btn-primary btn-sm btn-block mb-1 pl-3 pr-3 dsb" id="${empleado.num_empleado}" 
                                                        <c:if test="${empleado.activo == false}">hidden</c:if>>  
                                                        <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-unlock-fill" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                                                        <path d="M.5 9a2 2 0 0 1 2-2h7a2 2 0 0 1 2 2v5a2 2 0 0 1-2 2h-7a2 2 0 0 1-2-2V9z"/>
                                                        <path fill-rule="evenodd" d="M8.5 4a3.5 3.5 0 1 1 7 0v3h-1V4a2.5 2.5 0 0 0-5 0v3h-1V4z"/>
                                                        </svg>
                                                    </button>
                                                </div>
                                            </td>
                                        </tr>
                                    </c:forEach>
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
