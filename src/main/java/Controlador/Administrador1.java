/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.AdminDAO;
import ModeloDAO.AgregarTareaDAO;
import ModeloDAO.TareaAdmin;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author Alondra Jelinet
 */
@WebServlet(name = "Administrador1", urlPatterns = {"/Administrador1"})
public class Administrador1 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private String agregarTarea = "agregarTarea.jsp";
    private String accion = "";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Administrador1</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Administrador1 at " + request.getContextPath() + "</h1>");
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
        String acceso="";
        String accion = request.getParameter("accion");


        if(accion.equals("eliminarTarea")){
         
             String idTarea = request.getParameter("idTarea");
             System.out.println("id de la tarea: "+idTarea);
           AgregarTareaDAO rDAO = new AgregarTareaDAO();
            if(rDAO.eliminarTarea(idTarea)){
                System.out.println("Eliminado de operarios_has_tareasmantenimiento");
                    }
                   else{
                    System.out.println("No eliminado de operarios_has_tareasmantenimiento");
                    }
            if(rDAO.eliminarTarea2(idTarea)){
                System.out.println("Eliminado de tareasmantenimiento_has_refacciones");
                    }
                   else{
                    System.out.println("No Eliminado de tareasmantenimiento_has_refacciones");
                    }
            if(rDAO.eliminarTarea3(idTarea)){
               System.out.println("Eliminado de tareasmantenimiento");
               acceso="tareasvehiculos.jsp";
            }else{ 
                System.out.println("No eliminado de tareasmantenimiento");
                acceso="tareasvehiculos.jsp";
                }
            } else if (accion.equals("eliminarOperadorAdmin")) {
            String idTarea = request.getParameter("idTarea");
            String idOperario = request.getParameter("idOperario");
            System.out.println(idTarea + idOperario);
            AgregarTareaDAO rDAO = new AgregarTareaDAO();
            if (rDAO.eliminarOperario(idTarea, idOperario)) {
                acceso = "administradorTareaOperarios.jsp";
                System.out.println("Operador borrado actualizada");
                request.setAttribute("idTarea", idTarea);
            } else {
                acceso = "administradorTareaOperarios.jsp";
                System.out.println("Operador No borrado actualizada");
                request.setAttribute("idTarea", idTarea);
                request.setAttribute("error", true);
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
        String accion = request.getParameter("accion");
        

        if (accion.equals("actualizaTareasAdmin")) {
            String idTarea = request.getParameter("idTarea");
            String prioridad = request.getParameter("prioridad");
            String estado = request.getParameter("estado");
            AdminDAO dao = new AdminDAO();
            if (dao.actualizarTareasAdmin(idTarea, prioridad, estado)) {
                System.out.println("Actualizado");
                acceso = "tareasvehiculos.jsp";
                System.out.println(acceso);
            } else {
                System.out.println("No actualizado");
                acceso = "tareasvehiculos.jsp";
            }
        }
        if (accion.equals("insertarTarea")) {
            String idtareasMantenimiento = request.getParameter("id");
            String vehiculos_idevehiculos = request.getParameter("vehiculos");
            String nombreTarea = request.getParameter("tarea");
            String descripcion = request.getParameter("descripcion");
            String FechaEntrada = request.getParameter("fechaEntrada");
            String FechaSalida = request.getParameter("fechaSalida");
            String estado = request.getParameter("estado");
            String prioridad = request.getParameter("prioridad");

            AgregarTareaDAO dao = new AgregarTareaDAO();
            System.out.println("este es el id" + idtareasMantenimiento);
            if (dao.insertarTarea(idtareasMantenimiento, vehiculos_idevehiculos, nombreTarea, descripcion, FechaEntrada, FechaSalida, estado, prioridad)) {
                System.out.println("Agregado");
                acceso = "tareasvehiculos.jsp";
                System.out.println(acceso);
            } else {
                System.out.println("No agregado");
                acceso = "tareasvehiculos.jsp";
            }
        } else if (accion.equals("insertarAdminOP")) {
            String idTarea = request.getParameter("idTarea");
            String idOperario = request.getParameter("idOperario");
            AgregarTareaDAO rDAO = new AgregarTareaDAO();
            if (rDAO.insertarAdminOperario(idTarea, idOperario)) {
                acceso = "administradorTareaOperarios.jsp";
                System.out.println("Operador insertado");
                request.setAttribute("idTarea", idTarea);
            } else {
                acceso = "administradorTareaOperarios.jsp";
                System.out.println("Operador no insertado");
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
