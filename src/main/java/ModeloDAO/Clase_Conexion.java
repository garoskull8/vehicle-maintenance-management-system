package ModeloDAO;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Clase_Conexion{
	private Connection cn;

        private String user="root";
	private String password="garobeat123";
	private String url="jdbc:mysql://localhost:3306/vehicle-maintenance-management-system";
        


 
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
 
  
}