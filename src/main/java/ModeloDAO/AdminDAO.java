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
public class AdminDAO {

    public boolean Login(String email, String pass) {
        String query = "SELECT email FROM administradores WHERE email='" + email + "' and pass ='" + pass + "';";
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

}
