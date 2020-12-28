<%-- 
    Document   : OperadorDashboard
    Created on : 21/12/2020, 06:19:08 PM
    Author     : edgar
--%>

<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            
            Date dNow = new Date();
            SimpleDateFormat ft = 
            new SimpleDateFormat ("dd/MM/yyyy");
            String currentDate = ft.format(dNow);
            String sesion = null; 
            if (session.getAttribute("operador") != null){
            sesion= (String) session.getAttribute("operador");
            //out.println("Sesion iniciada: "+sesion );
            out.println("Sesion iniciada: "+sesion );
            }else{
            request.getSession().setAttribute("expiro", false);
            request.getRequestDispatcher("index.jsp").forward(request, response);
            }
             %>
        <h1>Hello World!</h1>
        <a href="tareasMantenimientoOp.jsp">Tareas de Mantenimiento</a>
    </body>
</html>
