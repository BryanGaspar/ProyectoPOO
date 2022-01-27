package Conexiones;
import java.sql.*;
public class Conexion {
	private final String base = "matriculacion";
	private final String user = "root";
	private final String pass = "";
	private final String url = "jdbc:mysql://localhost:3306/" + base;
	private Connection con = null;
	
	
	public Connection getConexion() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = (Connection)DriverManager.getConnection(this.url,this.user,this.pass);
		} catch(SQLException e) {
			System.err.println(e);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
		
		
		
	}
}
