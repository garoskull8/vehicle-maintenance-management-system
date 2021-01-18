/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.AdminDAO;
import ModeloDAO.OperadorDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author edgar
 */
@WebServlet(name = "Logins", urlPatterns = {"/Logins"})
public class Logins extends HttpServlet {
 
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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Logins</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Logins at " + request.getContextPath() + "</h1>");
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
        response.setContentType("text/html;charset=UTF-8");
        try(PrintWriter out = response.getWriter()) {
            String accion= request.getParameter("accion");
            String email = request.getParameter("email");
            String pass = request.getParameter("pass");
            System.out.println("Email"+email);
            HttpSession session = request.getSession(true);
            if(accion.equals("loginOp")){
                OperadorDAO op = new OperadorDAO();
                if(op.Login(email, pass)){
                    System.out.println("VALE");
                    session.setAttribute("operador",email); // SE CONFIGURA LA SESION CON UNA VARIABLE
                    session.setMaxInactiveInterval(5000); // SE DEFINE EL TIEMPO MAXIMO DE INACTIVIDAD (5000segundos)
                    System.out.println("Sesion iniciada");
                    request.getRequestDispatcher("operadorDashboard.jsp").forward(request, response);
                }else{
                    request.getSession().setAttribute("err",false);
                    request.getRequestDispatcher("operador_login.jsp").forward(request, response);
                    System.out.println("Datos incorrectos");
                    Cookie cookie = new Cookie("0","Usuario o contraseña incorrectos");
                    response.addCookie(cookie);
                }
            } else if(accion.equals("loginAD")){
                AdminDAO op = new AdminDAO();
                if(op.Login(email, pass)){
                    System.out.println("VALE");
                    session.setAttribute("admin",email); // SE CONFIGURA LA SESION CON UNA VARIABLE
                    session.setMaxInactiveInterval(5000); // SE DEFINE EL TIEMPO MAXIMO DE INACTIVIDAD (5000segundos)
                    System.out.println("Sesion iniciada");
                    request.getRequestDispatcher("adminDashboard.jsp").forward(request, response);
                }else{
                    request.getSession().setAttribute("err",false);
                    request.getRequestDispatcher("Login_Admin.jsp").forward(request, response);
                    System.out.println("Datos incorrectos");
                    Cookie cookie = new Cookie("0","Usuario o contraseña incorrectos");
                    response.addCookie(cookie);
                }
            }
        } catch (Exception e) {
            request.getSession().setAttribute("err", false);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
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
