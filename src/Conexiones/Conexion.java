package Conexiones;
import java.sql.*;

import javax.swing.JOptionPane;
public class Conexion {
	Connection conexion = null;
	static final String URL = "jdbc:postgresql://localhost:5432/Matriculacion";
	static final String USER = "postgres";
	static final String PASS = "Pucese2021";
	
	public Connection crearConexion(){
		try {
		Class.forName("org.postgresql.Driver");
		 conexion = DriverManager.getConnection(URL, USER, PASS);
		 JOptionPane.showMessageDialog(null, "Conexion Exitosa ");
		} catch(Exception e) {
			
				JOptionPane.showMessageDialog(null, "error al conectar "+e,"Error",JOptionPane.ERROR_MESSAGE);
		}
		return conexion;
		
	}
}
