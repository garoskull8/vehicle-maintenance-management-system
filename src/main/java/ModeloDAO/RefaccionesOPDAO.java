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
    
    
    public List listarRefaccion(String id) {
        Clase_Conexion cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<Refacciones> list = new ArrayList<>();
        String consulta = "SELECT idrefacciones as id,nombre,cantidad FROM refacciones WHERE cantidad>0;";
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
    public boolean insertarRefaccionOP(String idTarea, String idRefaccion, String cantidad){
        Clase_Conexion cn=null;
        PreparedStatement pst=null;
        ResultSet rs=null;
        String consulta="INSERT INTO tareasmantenimiento_has_refacciones VALUES(?,?,?)";
        try{
            cn = new Clase_Conexion();
            pst = cn.getConnection().prepareStatement(consulta);
            pst.setString(1, idTarea);
            pst.setString(2, idRefaccion);
            pst.setString(3, cantidad);
             if(pst.executeUpdate()==1){
              System.out.println("datos actualizados");
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
    
    public boolean actualizarRefaccion(String idRefaccion, int cantidad){
        Clase_Conexion cn=null;
        PreparedStatement pst=null;
        ResultSet rs=null;
        String consulta="UPDATE refacciones SET cantidad=? WHERE idrefacciones=?";
        try{
            cn = new Clase_Conexion();
            pst = cn.getConnection().prepareStatement(consulta);
            pst.setString(2, idRefaccion);
            pst.setInt(1, cantidad);
             if(pst.executeUpdate()==1){
              System.out.println("datos actualizados");
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
    
    public boolean actualizarRefaccionOP(String idTarea, String idRefaccion, String cantidad){
        Clase_Conexion cn=null;
        PreparedStatement pst=null;
        ResultSet rs=null;
        String consulta="UPDATE tareasmantenimiento_has_refacciones SET cantidad=? "
                + "WHERE tareasMantenimiento_idtareasMantenimiento=? AND refacciones_idrefacciones=?";
        try{
            cn = new Clase_Conexion();
            pst = cn.getConnection().prepareStatement(consulta);
            pst.setString(1, cantidad);
            pst.setString(2, idTarea);
            pst.setString(3, idRefaccion);
             if(pst.executeUpdate()==1){
              System.out.println("datos actualizados");
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
    
    public boolean eliminarRefaccion(String idTarea, String idRefaccion, String cantidad) {
        String query = "DELETE FROM tareasmantenimiento_has_refacciones WHERE tareasMantenimiento_idtareasMantenimiento=?"
                + "AND refacciones_idrefacciones=?";
        ResultSet rs=null;
        PreparedStatement  pst=null;
        Clase_Conexion cn = null;
        try{
            cn = new Clase_Conexion();  
        pst=cn.getConnection().prepareStatement(query);
         pst.setString(1, idTarea);
         pst.setString(2, idRefaccion);
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
