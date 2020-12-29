/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author edgar
 */
public class RefaccionesOPDAO {

    public List listarRefaccionOP(String id) {
        Clase_Conexion cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        ArrayList<Refacciones> list = new ArrayList<>();
        String consulta = "SELECT tr.refacciones_idrefacciones as id ,r.nombre,tr.cantidad FROM tareasmantenimiento_has_refacciones tr\n"
                + "INNER JOIN refacciones r ON r.idrefacciones=tr.refacciones_idrefacciones WHERE tr.tareasMantenimiento_idtareasMantenimiento='" + id + "';";
        try {
            cn = new Clase_Conexion();
            pst = cn.getConnection().prepareStatement(consulta);
            rs = pst.executeQuery(consulta);
            rs = pst.executeQuery();
            while (rs.next()) {
                Refacciones h = new Refacciones();
                h.setId(rs.getString("id"));
                h.setCantidad(rs.getString("cantidad"));
                h.setNombre(rs.getString("nombre"));
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
