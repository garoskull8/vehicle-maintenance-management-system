package ModeloDAO;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Clase_Conexion{
	private Connection cn;

        private String user="root";
	private String password="garobeat123";
	private String url="jdbc:mysql://localhost:3306/vehicle-maintenance-management-system?useSSL=false";

        PreparedStatement pstm = null;
    ResultSet rs = null;


 
  public Clase_Conexion(){
	
	try{
            cn=null;
	 	Class.forName("com.mysql.jdbc.Driver");
		cn=DriverManager.getConnection(url,user,password);
			if(cn!=null){
				System.out.println("Conexion establecida");
			}
	}catch ( SQLException e){
		System.out.println("error al conectar"+e);
	}   catch (ClassNotFoundException ex) {
                Logger.getLogger(Clase_Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
  }

  public Connection getConnection(){
	return cn;
  }

  public static void main(String[]args){
      Clase_Conexion cn= new Clase_Conexion();
      
  }
 
  
    public ResultSet getDatos(String com){
        try {
            this.getConnection();
            rs = pstm.executeQuery(com);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error: "+e);
        }
        return rs;
    }
  
}