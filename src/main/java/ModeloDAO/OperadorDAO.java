/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author edgar
 */
public class OperadorDAO {

    public boolean Login(String email, String pass) {
        String query = "SELECT email FROM operarios WHERE email='" + email + "' and pass ='" + pass + "';";
        Clase_Conexion c = null;
        ResultSet rs = null;
        PreparedStatement pst = null;
        try {
            c = new Clase_Conexion();
            pst = c.getConnection().prepareStatement(query);
            rs = pst.executeQuery(query);
            rs = pst.executeQuery();

            if (rs.absolute(1)) { //tiene registro
                return true;
            }
            rs.close();
        } catch (SQLException ex) {
            System.err.println("Error" + ex);
        } finally {
            try {
                if (c.getConnection() != null) {
                    c.getConnection().close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.err.println("Error" + e);
            }
        }
        return false;
    }

    public List listarTarea(String id) {
        Clase_Conexion cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        ArrayList<TareaAsignadaOP> list = new ArrayList<>();
        String consulta = "SELECT t.idtareasMantenimiento,t.nombreTarea,t.descripcion,v.placas,t.FechaEntrada,t.FechaSalida,t.prioridad,t.estado FROM operarios_has_tareasmantenimiento ot\n"
                + "INNER JOIN operarios o ON o.idoperarios=ot.operarios_idoperarios\n"
                + "INNER JOIN tareasmantenimiento t ON t.idtareasMantenimiento=ot.tareasMantenimiento_idtareasMantenimiento \n"
                + "INNER JOIN vehiculos v ON v.idvehiculos=t.vehiculos_idvehiculos WHERE o.email='" + id + "';";
        try {
            cn = new Clase_Conexion();
            pst = cn.getConnection().prepareStatement(consulta);
            rs = pst.executeQuery(consulta);
            rs = pst.executeQuery();
            while (rs.next()) {
                TareaAsignadaOP h = new TareaAsignadaOP();
                h.setId(rs.getString("idtareasMantenimiento"));
                h.setTarea(rs.getString("nombreTarea"));
                h.setDescripcion(rs.getString("descripcion"));
                h.setVehiculo(rs.getString("placas"));
                h.setFechaEntrada(rs.getString("FechaEntrada"));
                h.setFechaSalida(rs.getString("FechaSalida"));
                h.setPrioridad(rs.getString("prioridad"));
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

}
