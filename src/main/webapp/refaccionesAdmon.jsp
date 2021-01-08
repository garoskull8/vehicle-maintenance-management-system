<%-- 
    Document   : refaccionesAdmon
    Created on : 7/01/2021, 05:33:14 PM
    Author     : yosah
--%>

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
        <div class="card mb-6" style="max-width: 540px;">
            <div class="row g-0">
                <div class="col-md-4">
                    <img src="img/mecanica.png" alt="...">
                </div>
                <div class="text-white bg-dark col-md-8">
                    <div class="card-body">
                        <h2 class="card-title text-center">Inventario de Refacciones</h2>
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
            </ul>

            <!-- Tab panes -->
            <div class="tab-content">
                <div id="registro" class="container tab-pane active"><br>
                    <!-- Formualrio del botón registro-->
                    <form  action="Logins" method="post">
                        <div class="form-label-group">
                            <label for="inputNombre">Nombre: </label>
                            <input type="text" id="inputNombre" class="form-control" placeholder="Nombre" name="nombre" required autofocus>                           
                        </div>
                        <div class="form-label-group">
                            <label for="inputCantidad">Cantidad </label>
                            <input type="number" id="inputNombre" class="form-control" placeholder="Cantidad" name="cantidad" required autofocus>                           
                        </div>
                        <input type="text"  id="accion" name="accion" value="regRefaccion" hidden>
                        <button class="btn btn-lg btn-primary btn-block btn-login text-uppercase font-weight-bold mb-2" type="submit">Registrar</button>
                    </form>
                </div>
                <!-- Tabla del botón consulta-->
                <div id="consulta" class="container tab-pane fade"><br>
                    <div class="container-fluid"  style="margin-left:100px"> 
                        <div class="row">
                            <table class="table table-hover  table-responsive table-bordered border-dark col-sm-18 display" id="myTable" border="5">
                                <thead>
                                    <tr>

                                        <th>ID</th>
                                        <th>NOMBRE</th>
                                        <th>CANTIDAD</th>
                                        <th>ACCIONES</th>

                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td><p>idRefaccion</p></td>
                                        <td><p>nomRefaccion</p></td>
                                        <td><p>cantRefaccion</p></td>
                                        <td> 
                                            <div class="container">                                             
                                                <!-- Nav tabs -->
                                                <ul class="nav nav-tabs nav-justified" role="tablist">
                                                    <li class="nav-item">
                                                        <a class="nav-link active" data-toggle="tab" href="#actualizar">Actulizar Stock</a>
                                                    </li>
                                                    <li class="nav-item">
                                                        <a class="nav-link" data-toggle="tab" href="#eliminar">Eliminar refacción</a>
                                                    </li>
                                                </ul>

                                                <!-- Tab panes -->
                                                <div class="tab-content">
                                                    <div id="actualizar" class="container tab-pane active"><br>
                                                        <h3>Actulizar</h3>
                                                    </div>
                                                    <div id="eliminar" class="container tab-pane fade"><br>
                                                        <h3>Eliminar</h3>
                                                    </div>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>    
    </body>
</html>
