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
        String query = "SELECT email FROM administrador WHERE email='" + email + "' and pass ='" + pass + "';";
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
    
     public List DatosAdmon(String email) {
         Clase_Conexion cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
         ArrayList<DatosAdmon> list = new ArrayList<>();
        String consulta = "SELECT * FROM administrador where email='"+email+"';";
         try {
            cn = new Clase_Conexion();
            pst = cn.getConnection().prepareStatement(consulta);
            rs = pst.executeQuery(consulta);
            rs = pst.executeQuery();
            while (rs.next()) {
        DatosAdmon admon=new DatosAdmon();
               admon.setNom(rs.getString("nombre"));
               admon.setAp(rs.getString("ap"));
               admon.setAm(rs.getString("am"));
               admon.setEmail(rs.getString("email"));
               
                list.add(admon);
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
  public List listarTarea(String id) {

        Clase_Conexion cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<TAREAV> list = new ArrayList<>();
        String consulta = " SELECT t.idtareasMantenimiento,t.nombreTarea,t.descripcion,v.placas,t.FechaEntrada,t.FechaSalida,t.prioridad,t.estado \n" +
" FROM tareasmantenimiento t \n" +
" INNER JOIN vehiculos v \n" +
" ON v.idvehiculos = t.vehiculos_idvehiculos \n;" ;

        try {
            cn = new Clase_Conexion();
            pst = cn.getConnection().prepareStatement(consulta);
            rs = pst.executeQuery(consulta);
            rs = pst.executeQuery();
            while (rs.next()) {

                TAREAV h = new TAREAV();
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


 public boolean actualizarTareasAdmin(String id,String prioridad, String estado){
        PreparedStatement  pst=null;
        Clase_Conexion cn = null;
        try{
          cn = new Clase_Conexion();        
          String consulta="UPDATE tareasmantenimiento SET prioridad=?,estado=? WHERE idtareasMantenimiento=?";
          pst=cn.getConnection().prepareStatement(consulta);
          pst.setString(1,prioridad);
          pst.setString(2,estado);
          pst.setString(3,id);
          
          if(pst.executeUpdate()==1){ //afecto 1 fila
              return true;
          }
      }catch(Exception ex){
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

public boolean eliminarTarea(String idTarea, String idRefaccion, String cantidad) {
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
