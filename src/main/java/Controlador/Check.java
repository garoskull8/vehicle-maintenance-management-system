/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.OperadorDAO;
import ModeloDAO.Tiempos;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author edwin
 */
@WebServlet(name = "Check", urlPatterns = {"/Check"})
public class Check extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            String id = request.getParameter("id");
            String fecha = request.getParameter("fechaI");
            String horaL= request.getParameter("hora");
            String accion = request.getParameter("llegada");
            System.out.println(horaL);
            System.out.println(accion);
             if(accion.equals("L")){
                  String com = request.getParameter("com");
                 OperadorDAO op = new OperadorDAO();
                 if(op.Checkin(id, horaL, com, fecha)){
                     accion= "/operadorDashboard.jsp";
                     Tiempos.setVar(1);
                     RequestDispatcher vista = request.getRequestDispatcher(accion);
                      vista.forward(request, response);
                 }
             } else if(accion.equals("S")){
                      OperadorDAO op2 = new OperadorDAO();
                      String idtiempo = request.getParameter("idtm");
                 if(op2.Checkout(id, idtiempo, horaL)){
                     accion= "/operadorDashboard.jsp";
                      Tiempos.setVar(0);
                     RequestDispatcher vista = request.getRequestDispatcher(accion);
                      vista.forward(request, response);
                 }
                  else {
                     accion= "/operadorDashboard.jsp";
                     RequestDispatcher vista = request.getRequestDispatcher(accion);
                      vista.forward(request, response);
                 }
             }
                      accion= "/operadorDashboard.jsp";
                     RequestDispatcher vista = request.getRequestDispatcher(accion);
                      vista.forward(request, response);
            
            
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
        processRequest(request, response);
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
        processRequest(request, response);
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
