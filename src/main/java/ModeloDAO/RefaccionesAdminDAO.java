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
 * @author yosah
 */
public class RefaccionesAdminDAO {
    public List listarRefaccion() {
        Clase_Conexion cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        ArrayList<Refacciones> list = new ArrayList<>();
        String consulta = "SELECT * FROM refacciones;";
        try {
            cn = new Clase_Conexion();
            pst = cn.getConnection().prepareStatement(consulta);
            rs = pst.executeQuery(consulta);
            rs = pst.executeQuery();
            
            while (rs.next()) {
                Refacciones h = new Refacciones();
                h.setId(rs.getString("idrefacciones"));
                h.setNombre(rs.getString("nombre"));
                h.setCantidad(rs.getString("cantidad"));
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
    public boolean actualizaStock(String idRefaccion, int cantidad){
        Clase_Conexion cn=null;
        PreparedStatement pst=null;
        ResultSet rs=null;
        String consulta="UPDATE refacciones SET cantidad= ? WHERE idrefacciones=?";
        try{
            cn = new Clase_Conexion();
            pst = cn.getConnection().prepareStatement(consulta);
            pst.setInt(1, cantidad);
            pst.setString(2, idRefaccion); 
          
             if(pst.executeUpdate()==1){
              System.out.println("stock actualizado");
              return true;
          }
        }catch (Exception e) {
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
        return false;
    }
    public String consultarRefaccion(String id) {
        String cantidadStock="-1";
        Clase_Conexion cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            cn = new Clase_Conexion();
            String consulta = "SELECT idrefacciones as id,nombre,cantidad FROM refacciones WHERE idrefacciones='"+id+"';";
            pst = cn.getConnection().prepareStatement(consulta);
            //pst.setString(1,id);
            rs = pst.executeQuery(consulta);
            rs = pst.executeQuery();
            if(rs.absolute(1)){//Si tiene registro 
                System.out.println("Tiene registro");
                cantidadStock=rs.getString("cantidad");
                System.out.println("Cantidad en stock actual "+cantidadStock);
                return cantidadStock;
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
        return cantidadStock;
    }
    
    public boolean registroRefaccion(int idRefaccion, String nombre, int cantidad){
        Clase_Conexion cn=null;
        PreparedStatement pst=null;
        ResultSet rs=null;
        String consulta="INSERT INTO refacciones VALUES(?,?,?)";
        try{
            cn = new Clase_Conexion();
            pst = cn.getConnection().prepareStatement(consulta);
            pst.setInt(1, idRefaccion);
            pst.setString(2, nombre);
            pst.setInt(3, cantidad);
             if(pst.executeUpdate()==1){
              System.out.println("Refaccion registrada");
              return true;
          }
        }catch (Exception e) {
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
        return false;
    }
    public String consultaIdRefaccion(){
        String idUltimo = "-1";
        Clase_Conexion cn=null;
        PreparedStatement pst=null;
        ResultSet rs=null;
        String consulta="SELECT * FROM refacciones order by idRefacciones desc limit 1";
        try{
            cn = new Clase_Conexion();
            pst = cn.getConnection().prepareStatement(consulta);
            rs = pst.executeQuery(consulta);
            rs = pst.executeQuery();
            if(rs.absolute(1)){
                idUltimo=rs.getString("idrefacciones");
                System.out.println("ultimo id "+idUltimo);
              return idUltimo;
          }
        }catch (Exception e) {
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
        return idUltimo;
    }
    
    public boolean eliminarRefaccion(String idrefaccion) {
        String query = "DELETE FROM refacciones WHERE idrefacciones=?";
        ResultSet rs=null;
        PreparedStatement  pst=null;
        Clase_Conexion cn = null;
        try{
            cn = new Clase_Conexion();  
        pst=cn.getConnection().prepareStatement(query);
         pst.setString(1, idrefaccion);
          if(pst.executeUpdate()==1){
              return true;
          }
        }catch(SQLException ex){
          System.err.println("Error"+ex);
        }finally{
          try{
          if(cn.getConnection()!=null)cn.getConnection().close();
          if(pst!=null)pst.close();
          }catch(Exception e){
                  System.err.println("Error"+e);
                  }
      }
        return false;
    }
}
