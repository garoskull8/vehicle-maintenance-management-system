<%-- 
    Document   : chequear
    Created on : 28 dic. 2020, 21:39:24
    Author     : edwin
--%>

<%@page import="ModeloDAO.Tiempos"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.DatosOperador"%>
<%@page import="ModeloDAO.OperadorDAO"%>
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
            SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat ft2 = new SimpleDateFormat("hh:mm:ss");
            String currentDate = ft.format(dNow);
            String hora = ft2.format(dNow);
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
                <div class="container" style="margin-top: 50px;">
                    <div class="raw">
                        <div class="col-md-12">
                            <div class="card h-100">

                                <div class="card-body">
                                    <h4 class="card-title" style="text-align: center"><strong>Check in & Check out</strong></h4>
                                    <p class="card-text" style="text-align: center">Registra tus tiempos de entrada y salida</p>
                                </div>
           
                          
                            </div>
                        </div>
                    </div>
                    <% 
                
                 if(Tiempos.var == 0){  
                 System.out.println("Entrada"+Tiempos.var);
                OperadorDAO dao = new OperadorDAO();
                List<DatosOperador>list=dao.DatosOp(sesion);
                Iterator<DatosOperador>iter=list.iterator();
                DatosOperador op=null;
                while(iter.hasNext()){
                    op=iter.next();
                    Tiempos.idestatico = op.getIdOper();
                    Tiempos.name =op.getNom()+" "+op.getAp()+" "+op.getAm();
                    Tiempos.fecha_entrada = currentDate;
                    %>
                    <div style="margin-top: 20px;" class="raw">
                        <div class="col-md-12">               
                            <div class="card h-100">
                                <div class="card-footer" >
                                    <div >
                                        <h4  class="card-title" style="text-align: left; display:inline"><strong>Nombre:</strong></h4> 
                                        <h5 style="text-align: left; display:inline"><%=op.getNom()+" "+op.getAp()+" "+op.getAm() %></h5>
                                 
                                    </div>
                                    <div>
                                        <form action="Check" method="get">
                                    <div class="form-group">
                                        <label for="pwd">Fecha:</label> 
                                        <input type="text"  name="fechaI" class="form-control"   value="<%= currentDate%>" readonly>
                                    </div>
                                    <div class="form-group">
                                        <label for="comment">Comentario:</label>
                                        <textarea class="form-control" rows="5" id="comment" name="com"></textarea>
                                    </div>
                                    <input id="prodId" name="id" type="hidden" value="<%=op.getIdOper()%>">
                                     <input id="prodId" name="hora" type="hidden" value="<%=hora%>">
                                     <input id="prodId" name="llegada" type="hidden" value="L">
                                      <button type="submit"  class="btn btn-success">Check in</button>
                                    </form>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div><% }
                        } %>
                    <hr>
<% 
                
                if (Tiempos.var == 1){
                System.out.println("salida"+Tiempos.var);
                OperadorDAO dao2 = new OperadorDAO();
                List<Tiempos>list2=dao2.DatosTiempo(Tiempos.idestatico,  Tiempos.fecha_entrada);
                Iterator<Tiempos>iter2=list2.iterator();
                Tiempos op2= null;
                while(iter2.hasNext()){
                    op2=iter2.next();
                    
                 
                
                  
                    %>
                    <div class="raw" style="margin-bottom: 50px">
                        <div class="col-md-12">               
                            <div class="card h-100">
                                <div class="card-footer" >
                                   
                                    
                                    <div >
                                        <h4  class="card-title" style="text-align: left; display:inline"><strong>Nombre:</strong></h4> 
                                        <h5 style="text-align: left; display:inline"><%= Tiempos.getName()%> </h5>
                                 
                                    </div>
                                    <form action="Check" method="get">
                                        <div class="row"> 
                                            <div class="col-4">
                                    <div class="form-group">
                                        <label for="pwd">Fecha:</label> 
                                        <input type="text"  name="fechaI" class="form-control"   value="<%= currentDate%>" readonly>
                                    </div>
                                    </div>
                                    <div class="col-4">
                                    <div class="form-group">
                                        <label for="pwd">ID :</label> 
                                        <input type="text"   class="form-control"   value="<%= op2.idTiempo %>" readonly>
                                    </div>
                                    </div>
                                     <div class="col-4">
                                    <div class="form-group">
                                        <label for="pwd">Hora Entrada :</label> 
                                        <input type="text"   class="form-control"   value="<%= op2.horaE %>" readonly>
                                    </div>
                                    </div>
                                    
                                        </div>
                                  
                                    <input id="prodId" name="id" type="hidden" value="<%= op2.idOper %>">
                                    <input id="prodId" name="idtm" type="hidden" value="<%= op2.idTiempo %>">
                                     <input id="prodId" name="hora" type="hidden" value="<%=hora%>">
                                     <input id="prodId" name="llegada" type="hidden" value="S">
                                      <button type="submit"  class="btn btn-danger">Check out</button>
                                    </form>
                                   
                                </div>
                            </div>
                        </div>

                    </div><%}
                  } %>

                   
                </div>
    </body>
</html>
