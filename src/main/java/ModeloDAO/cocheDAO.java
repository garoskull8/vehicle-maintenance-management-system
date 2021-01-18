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
    /*
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
          
            
          
/*
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
    */
     public List statuscoche() {
        Clase_Conexion cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

   ArrayList<TareaAsignadaOP> list = new ArrayList<>();
        String consulta = "SELECT t.idtareasMantenimiento, v.chofer_idchofer,v.placas,t.descripcion,t.FechaEntrada,t.FechaSalida,t.estado FROM operarios_has_tareasmantenimiento ot\n"
                + "INNER JOIN operarios o ON o.idoperarios=ot.operarios_idoperarios\n"
                + "INNER JOIN tareasmantenimiento t ON t.idtareasMantenimiento=ot.tareasMantenimiento_idtareasMantenimiento \n"
                + "INNER JOIN vehiculos v ON v.idvehiculos=t.vehiculos_idvehiculos INNER JOIN chofer p ON  v.chofer_idchofer = p.idchofer WHERE v.chofer_idchofer=p.idchofer LIMIT 1";
        try {
            cn = new Clase_Conexion();
            pst = cn.getConnection().prepareStatement(consulta);
            rs = pst.executeQuery(consulta);
            rs = pst.executeQuery();
            while (rs.next()) {
                TareaAsignadaOP h = new TareaAsignadaOP();
                h.setId(rs.getString("idtareasMantenimiento"));
                h.setIdchofer(rs.getString("chofer_idchofer"));
                  h.setVehiculo(rs.getString("placas"));
                h.setDescripcion(rs.getString("descripcion"));
                h.setFechaEntrada(rs.getString("FechaEntrada"));
                h.setFechaSalida(rs.getString("FechaSalida"));
                h.setEstado(rs.getString("estado"));
                list.add(h);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (cn.getConnection() != null) {
                    cn.getConnection().close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                System.err.println("Error" + e);
            }
        }
        return list;
    
    
}
     
      public List tiempos(String id) {
        Clase_Conexion cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

       ArrayList<Tiempos> list = new ArrayList<>();

        
         String consulta = "SELECT t.operarios_idoperarios, o.nombre,o.ap,o.am,t.fecha,t.horaLlegada,t.horaSalida, EXTRACT(hour FROM TIMEDIFF(horaLlegada, horaSalida)) as horas FROM tiempos t \n"
                + "INNER JOIN operarios o ON t.operarios_idoperarios=o.idoperarios \n"
                + "INNER JOIN operarios_has_tareasmantenimiento c ON o.idoperarios=c.operarios_idoperarios \n"
                + "INNER JOIN tareasmantenimiento g ON g.idtareasMantenimiento=c.tareasMantenimiento_idtareasMantenimiento \n"
                + "INNER JOIN vehiculos v ON v.idvehiculos=g.vehiculos_idvehiculos WHERE o.email='" + id + "' ;";
         
        
        try {
            cn = new Clase_Conexion();
            pst = cn.getConnection().prepareStatement(consulta);
            rs = pst.executeQuery(consulta);
            rs = pst.executeQuery();
            while (rs.next()) {
                Tiempos h = new Tiempos();
                h.setIdTiempo(rs.getString("operarios_idoperarios"));
                h.setNombre(rs.getString("nombre"));
                   h.setAp(rs.getString("ap"));
                h.setAm(rs.getString("am"));
                h.setFechaE(rs.getString("fecha"));
                h.setHoraE(rs.getString("horaLlegada"));
                      h.setHoraS(rs.getString("horaSalida"));
                      h.setTiempo(rs.getString("horas"));
                list.add(h);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (cn.getConnection() != null) {
                    cn.getConnection().close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                System.err.println("Error" + e);
            }
        }
        return list;
      }
}
