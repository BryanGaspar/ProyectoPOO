package ProyectoPoo;
import java.sql.Connection;

import javax.swing.JOptionPane;
public class crudsql {
	Conexion con = new Conexion();
	
	public void insertarDatos(String Cedula,String Nombres,String Apellidos,String Usuario,String Email,String Contrasenia,String Genero,String FechaNac) {
		try {
			Connection conexion = con.crearConexion();
			java.sql.Statement st = conexion.createStatement();
			String sql ="INSERT INTO Estudiante(Cedula,Nombres,Apellidos,Usuario,Email,Contrasenia,Genero,FechaNac) VALUES('"+Cedula+"','"+Nombres+"','"+Apellidos+
					"','"+Usuario+"','"+Email+"','"+Contrasenia+"','"+Genero+"','"+FechaNac+"')" ;
			st.execute(sql);
			st.close();
			conexion.close();
			JOptionPane.showMessageDialog(null, "Registro Exitoso", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al crear el registro "+e,"Error",JOptionPane.ERROR_MESSAGE);
		}
	}
}
