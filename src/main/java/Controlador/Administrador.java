package Controlador;

import ModeloDAO.RefaccionesAdminDAO;
import ModeloDAO.Refacciones;
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
 * @author yosah
 */
@WebServlet(name = "Administrador", urlPatterns = {"/Administrador"})
public class Administrador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private String refacciones = "refaccionesAdmon.jsp";
    private String accion = "";
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Administrador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Administrador at " + request.getContextPath() + "</h1>");
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
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String acceso = "";
        accion = request.getParameter("accion");
        
        if(accion.equals("eliminarRefaccion")){
            RefaccionesAdminDAO adminRef = new RefaccionesAdminDAO();
            //Obtenemos parámetros para actualizar stock
            String idRefaccion = request.getParameter("idRefaccion");
            System.out.println("Eliminar refaccion");
            
            if (adminRef.eliminarRefaccion(idRefaccion)) {
                acceso = refacciones;
                System.out.print("Refacción eliminada");
            } else {
                acceso = refacciones;
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
        processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String acceso = "";
        accion = request.getParameter("accion");

        if(accion.equals("actualizaRefaccion")){
            RefaccionesAdminDAO adminRef = new RefaccionesAdminDAO();
            //Obtenemos parámetros para actualizar stock
            String idRefaccion = request.getParameter("idRefaccion");
            String cantidad = request.getParameter("cantidad");
            System.out.println("cantidad "+cantidad);
            System.out.println("Actualizar refaccion");
            
            //Se convierte la cantidad ingresada para sumar al stock
            int cantidadSumar=Integer.parseInt(cantidad);
            //Obtengo cantidad actual de stock 
            int cantidadStock =Integer.parseInt(adminRef.consultarRefaccion(idRefaccion));
 
            //Variable con la cantidad final en stock
            int cantidadStockFinal=cantidadStock+cantidadSumar;
            
            System.out.print("cantidad final: "+cantidadStockFinal);
            
            if (adminRef.actualizaStock(idRefaccion, cantidadStockFinal)) {
                request.setAttribute("mensaje",1 );
                acceso = refacciones;
            } else {
                request.setAttribute("mensaje",2);
                acceso = refacciones;
            }
        } else if(accion.equals("regRefaccion")){
            RefaccionesAdminDAO adminRef = new RefaccionesAdminDAO();
            //Obtenemos parámetros para actualizar stock
            String nombre = request.getParameter("nombre");
            String cantidad = request.getParameter("cant");
            System.out.println("cantidad "+cantidad);
            System.out.println("Registro refaccion");
            
            int ultimoId = Integer.parseInt(adminRef.consultaIdRefaccion());
            int idFinal = ultimoId + 1;
            if (adminRef.registroRefaccion(idFinal, nombre, Integer.parseInt(cantidad))) {
                request.setAttribute("mensaje",3 );
                acceso = refacciones;
            } else {
                request.setAttribute("mensaje", 2);
                acceso = refacciones;
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
