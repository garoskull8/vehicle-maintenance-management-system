/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class cocheDAO {
    
     private final String SQL_SELECT = " SELECT  c.id_vehiculo as identificador, c.chofer_idchofer as chofer, c.placas as placas, m.descripcion as descripcion, m.horaLlegada as llegada, m.horaSalida as salida, m.validar as estado "
            + " FROM tiempos as m "
            + " INNER JOIN vehiculos as c ON m.id_vehiculo=c.id_vehiculo INNER JOIN chofer as d ON  c.chofer_idchofer = d.idchofer"
            + " GROUP BY c.id_vehiculo; ";
    
      public ResultSet listar(){
            Clase_Conexion cn= new Clase_Conexion();
       String com = "select * from vehiculos";
       ResultSet rs = cn.getDatos(com);
       return rs;
   }
      
      public List listarr() throws ClassNotFoundException {
       Clase_Conexion c = null;
        ResultSet rs = null;
        PreparedStatement pst = null;
        try {
            c = new Clase_Conexion();
            pst = c.getConnection().prepareStatement(SQL_SELECT);
            rs = pst.executeQuery(SQL_SELECT);
            rs = pst.executeQuery();

            while (rs.next()) {

                //MEMBRESIAS
                int id_vehiculo = rs.getInt("identificador");
                String chofer = rs.getString("chofer");
                String placas = rs.getString("placas");
                      String descripcion = rs.getString("descripcion");
                          String llegada = rs.getString("llegada");
                      String salida = rs.getString("salida");
                      String estado = rs.getString("validar");
          
            
          

                System.out.println("----------------------------------");
                System.out.println("id_membresia = " + id_membresia);
                System.out.println("nombre = " + nombre);
                System.out.println("precio = " + precio);
                System.out.println("visibilidad = " + visibilidad);
                System.out.println("nombre_carac = " + nombre_carac);
                System.out.println("descripcion = " + descripcion);
                System.out.println("----------------------------------");

                mem = new Caracteristicas(id_membresia, nombre, precio, visibilidad, nombre_carac, descripcion);
                listaMayor.add(mem);

            }
            System.out.println("listaMayor = " + listaMayor);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);

        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return listaMayor;
    }
    
    
}
