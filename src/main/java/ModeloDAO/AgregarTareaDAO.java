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
 * @author Alondra Jelinet
 */
public class AgregarTareaDAO {

 public List listarTareas(String id) {
        Clase_Conexion cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<TareaAdmin> list = new ArrayList<>();
        String consulta = "SELECT * from tareasvehiculos;";
        try {
            cn = new Clase_Conexion();
            pst = cn.getConnection().prepareStatement(consulta);
            rs = pst.executeQuery(consulta);
            rs = pst.executeQuery();
            while (rs.next()) {
                TareaAdmin h = new TareaAdmin();
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

  public boolean insertarTarea(String idtareasMantenimiento, String vehiculos_idvehiculos , String nombreTarea,String descripcion, String FechaEntrada, String FechaSalida,String estado, String prioridad){
        Clase_Conexion cn=null;
        PreparedStatement pst=null;
        ResultSet rs=null;
        String consulta="INSERT INTO tareasmantenimiento VALUES(?,?,?,?,?,?,?,?);";
        try{
            cn = new Clase_Conexion();
            pst = cn.getConnection().prepareStatement(consulta);
            pst.setString(1, idtareasMantenimiento);
            pst.setString(2, vehiculos_idvehiculos);
            pst.setString(3, nombreTarea);
            pst.setString(4, descripcion);
            pst.setString(5, FechaEntrada);
            pst.setString(6, FechaSalida);
            pst.setString(7, estado);
            pst.setString(8, prioridad);

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

public List listarOperario(String IdOper) {
        Clase_Conexion cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        ArrayList<DatosOperador> list = new ArrayList<>(); 
        String consulta = "SELECT idoperarios,nombre FROM operarios;";
        try {
            cn = new Clase_Conexion();
            pst = cn.getConnection().prepareStatement(consulta);
            rs = pst.executeQuery(consulta);
            rs = pst.executeQuery();
            while (rs.next()) {
                DatosOperador h = new DatosOperador();
                h.setIdOper(rs.getString("idoperarios"));
                h.setNom(rs.getString("nombre"));
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
  public boolean eliminarTarea(String idtareasMantenimiento, String vehiculos_idevehiculos , String nombreTarea,String descripcion, String FechaEntrada, String FechaSalida,String estado, String prioridad) {
        String query = "DELETE FROM tareasmantenimiento ;";
        ResultSet rs=null;
        PreparedStatement  pst=null;
        Clase_Conexion cn = null;
        try{
            cn = new Clase_Conexion();  
        pst=cn.getConnection().prepareStatement(query);
            pst.setString(1, idtareasMantenimiento);
            pst.setString(2, vehiculos_idevehiculos);
            pst.setString(3, nombreTarea);
            pst.setString(4, descripcion);
            pst.setString(5, FechaEntrada);
            pst.setString(6, FechaSalida);
            pst.setString(7, estado);
            pst.setString(8, prioridad);

      

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
  /* public boolean insertarTarea(TareaAdmin tarea){
  boolean agregado=false;
     Clase_Conexion cn=null;
  try {
    cn = new Clase_Conexion();
    pst = cn.getConnection().prepareStatement(consulta);
   if(con!=null){
    Statement st;
    st = con.createStatement();
    st.executeUpdate("INSERT INTO `tareasmantenimiento` (`idtareasMantenimiento`, `vehiculos_idvehiculos`, `nombreTarea`, `descripcion`, `FechaEntrada`, `FechaSalida`, `estado`, `prioridad`) VALUES('"+tarea.getId()+"','"+tarea.getTarea()+"',"+tarea.getDescripcion()+",'"+tarea.getVehiculo()+"','"+tarea.getFechaEntrada()+"','"+tarea.getFechaSalida()+"','"+tarea.getPrioridad()+"','"+tarea.getFechaEstado()+"')");
    agregado=true;
    st.close();
   }
  } catch (SQLException e) {
   agregado=false;
   e.printStackTrace();
  }
  return agregado;
 }*/
}
   

