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
    

    public boolean actualizarTareasOP(String id,String fechaSalida, String prioridad, String estado){
        PreparedStatement  pst=null;
        Clase_Conexion cn = null;
        try{
          cn = new Clase_Conexion();        
          String consulta="UPDATE tareasmantenimiento SET FechaSalida=?,prioridad=?,estado=? WHERE idtareasMantenimiento=?";
          pst=cn.getConnection().prepareStatement(consulta);
          pst.setString(1,fechaSalida);
          pst.setString(2,prioridad);
          pst.setString(3,estado);
          pst.setString(4,id);
          
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
    public List DatosOp(String email) {
        Clase_Conexion cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        ArrayList<DatosOperador> list = new ArrayList<>();
        String consulta = "SELECT * FROM operarios where email='"+email+"';";
        try {
            cn = new Clase_Conexion();
            pst = cn.getConnection().prepareStatement(consulta);
            rs = pst.executeQuery(consulta);
            rs = pst.executeQuery();
            while (rs.next()) {
               DatosOperador pro=new DatosOperador();
               pro.setNom(rs.getString("nombre"));
               pro.setAp(rs.getString("ap"));
               pro.setAm(rs.getString("am"));
               pro.setCurp(rs.getString("curp"));
               pro.setFecha(rs.getString("fechaNacimiento"));
               pro.setCalle(rs.getString("calle"));
               pro.setNumero("numero");
               pro.setColonia(rs.getString("colonia"));
               pro.setEstado(rs.getString("estado"));
               pro.setEmail(rs.getString("email"));
               pro.setIdOper(rs.getString("idoperarios"));
                list.add(pro);
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
    
        public List DatosTiempo(String id, String fecha) {
        Clase_Conexion cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        ArrayList<Tiempos> list = new ArrayList<>();
        String consulta = "Select idTiempos, operarios_idoperarios, horaLlegada, fecha  from tiempos where  operarios_idoperarios="+id+" and  fecha='"+fecha+"' and validar= 0; ";
        try {
            cn = new Clase_Conexion();
            pst = cn.getConnection().prepareStatement(consulta);
            rs = pst.executeQuery(consulta);
            rs = pst.executeQuery();
            while (rs.next()) {
               Tiempos pro=new Tiempos();
               pro.setIdTiempo(rs.getString("idTiempos"));
               pro.setIdOper(rs.getString("operarios_idoperarios"));
               pro.setHoraE(rs.getString("horaLlegada"));
               pro.setFechaE(rs.getString("fecha"));
                list.add(pro);
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
    

    
    
     public boolean Checkin(String id, String hora, String com, String fecha){
        
        PreparedStatement  pst=null;
        Clase_Conexion cn = null;
        try{
          cn = new Clase_Conexion();        
          String consulta="insert into tiempos (operarios_idoperarios, horaLlegada, descripcion, fecha) values (?,?,?,?)";
          pst=cn.getConnection().prepareStatement(consulta);
          pst.setString(1,id);
          pst.setString(2,hora);
          pst.setString(3,com);
          pst.setString(4,fecha);
          
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
  public boolean Checkout(String idop,String idtiempo, String hora){
         
        PreparedStatement  pst=null;
        Clase_Conexion cn = null;
        try{
          cn = new Clase_Conexion();        
          String consulta="update tiempos set horaSalida= ?, validar= 1 where idTiempos= ? and operarios_idoperarios= ?;";
          pst=cn.getConnection().prepareStatement(consulta);
          pst.setString(1,hora);
          pst.setString(2,idtiempo);
          pst.setString(3,idop);
         
          
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

}
