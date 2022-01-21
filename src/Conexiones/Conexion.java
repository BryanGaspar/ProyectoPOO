package Conexiones;
import java.sql.*;

import javax.swing.JOptionPane;
public class Conexion {
	Connection conexion = null;
	static final String URL = "jdbc:mysql://localhost:3306/matriculacion";
	static final String USER = "root";
	static final String PASS = "";
	
	public Connection crearConexion(){
		try {
		Class.forName("com.mysql.jdbc.Driver");
		 conexion = DriverManager.getConnection(URL, USER, PASS);
		
		} 
		catch(Exception e) {
			
				JOptionPane.showMessageDialog(null, "error al conectar " + e,"Error",JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
		}
		return conexion;
		
	}
}
