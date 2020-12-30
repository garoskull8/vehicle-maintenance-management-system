/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.OperadorDAO;
import ModeloDAO.Refacciones;
import ModeloDAO.RefaccionesOPDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author edgar
 */
public class Operador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private String refacciones = "refaccionOP.jsp";
    private String tareas = "tareasMantenimientoOp.jsp";
    private String agregarRefaccion = "agregarRefaccion.jsp";
    private String accion = "";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Operador</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Operador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String acceso = "";
        accion = request.getParameter("accion");

        if (accion.equals("editarROP")) {
            acceso = refacciones;
        } else if (accion.equals("agregarRefaccion")) {
            acceso = agregarRefaccion;
        }else if(accion.equals("eliminarRefaccionOP")){
            String idTarea = request.getParameter("idTarea");
            String idRefaccion = request.getParameter("idRefaccion");
            String cantidad = request.getParameter("cantidad");
            RefaccionesOPDAO rDAO = new RefaccionesOPDAO();
            int cantidadStock =Integer.parseInt(rDAO.consultarRefaccion(idRefaccion));
            if(rDAO.eliminarRefaccion(idTarea, idRefaccion, cantidad)){
                System.out.println("Eliminado");
                int cantidadEliminada=Integer.parseInt(cantidad);
                cantidadStock=cantidadStock+cantidadEliminada;
                if(rDAO.actualizarRefaccion(idRefaccion, cantidadStock)){
                            request.setAttribute("idTarea", idTarea);
                            acceso=refacciones;
                        }else{
                           System.out.println("Refaccion NO actualizada"); 
                           request.setAttribute("idTarea", idTarea);
                            acceso=refacciones;
                        }
                
            }else{
                request.setAttribute("idTarea", idTarea);
                 acceso=refacciones;
            }
            
        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String acceso = "";
        accion = request.getParameter("accion");

        if (accion.equals("actualizaTareasOP")) {
            OperadorDAO op = new OperadorDAO();
            String idTarea = request.getParameter("idTarea");
            String fechaSalida = request.getParameter("fechaSalida");
            String prioridad = request.getParameter("prioridad");
            String estado = request.getParameter("estado");
            if (op.actualizarTareasOP(idTarea, fechaSalida, prioridad, estado)) {
                acceso = tareas;
            } else {
                System.out.println("Error");
                acceso = tareas;

            }

        } else if (accion.equals("agregarRefaccion")) {
            String idTarea = request.getParameter("idTarea");
            String idRefaccion = request.getParameter("idRefaccion");
            String cantidad = request.getParameter("cantidad");
            System.out.println("cantidad"+cantidad);
            RefaccionesOPDAO rDAO = new RefaccionesOPDAO();
                int cantidadDeseada = Integer.parseInt(cantidad);
                int cantidadStock =Integer.parseInt(rDAO.consultarRefaccion(idRefaccion));
                System.out.println("Cantidad en stock"+cantidadStock);
                if (cantidadStock >= cantidadDeseada) {
                    System.out.println("Cantidad en stock"+cantidadStock);
                    System.out.println("Hay stock");
                    if(rDAO.insertarRefaccionOP(idTarea, idRefaccion, cantidad)){
                        System.out.println("Refaccion registrada");
                        
                        cantidadStock=cantidadStock-cantidadDeseada;
                        if(rDAO.actualizarRefaccion(idRefaccion, cantidadStock)){
                            request.setAttribute("idTarea", idTarea);
                            acceso=refacciones;
                        }else{
                           System.out.println("Refaccion NO actualizada"); 
                           request.setAttribute("idTarea", idTarea);
                            acceso=refacciones;
                        }
                    }else{
                        acceso=refacciones;
                        request.setAttribute("idTarea", idTarea);
                        request.setAttribute("error", true);
                    }
                } else {
                    System.out.println("No hay stock");
                    acceso = agregarRefaccion;
                    request.setAttribute("idTarea", idTarea);
                    request.setAttribute("error", true);
                }
            }else if(accion.equals("editarRefaccionOP")){
                String idTarea = request.getParameter("idTarea");
                String idRefaccion = request.getParameter("idRefaccion");
                String cantidad = request.getParameter("cantidad");
                String cantidadDeseada = request.getParameter("cantidadDeseada");
                System.out.println("Actualizar refaccion");
                int cantidadd=Integer.parseInt(cantidad);
                int cantidadDeseadaa=Integer.parseInt(cantidadDeseada);
                int residuo=cantidadd-cantidadDeseadaa;
                RefaccionesOPDAO rDAO = new RefaccionesOPDAO();
                int cantidadStock =Integer.parseInt(rDAO.consultarRefaccion(idRefaccion));
                int cantidadActualizada=cantidadStock+residuo;
                if (cantidadStock+residuo >= 0){
                    if(rDAO.actualizarRefaccionOP(idTarea, idRefaccion, cantidadDeseada)){
                        System.out.println("Refaccion actualizada");
                        if(rDAO.actualizarRefaccion(idRefaccion, cantidadActualizada)){
                            request.setAttribute("idTarea", idTarea);
                            acceso=refacciones;
                        }else{
                           System.out.println("Refaccion NO actualizada"); 
                           request.setAttribute("idTarea", idTarea);
                            acceso=refacciones;
                        }
                    }else{
                        acceso=refacciones;
                        request.setAttribute("idTarea", idTarea);
                        request.setAttribute("error", true);
                    }
                    
                    
                }else{
                    System.out.println("No hay stock");
                    acceso = refacciones;
                    request.setAttribute("idTarea", idTarea);
                    request.setAttribute("error", true);
                }
                
            }

        
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
