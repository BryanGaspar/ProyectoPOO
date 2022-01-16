package Conexiones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import ProyectoPoo.Login;


public class crudsql {
	Conexion con = new Conexion();
	
	
	public DefaultTableModel mostrarEstudiantes() {
		String []  nombresColumnas = {"Cedula","Nombres","Apellidos","Usuario","Email","Contraseña","Genero","Fecha Nac"};
        String [] registros = new String[8];
        
        DefaultTableModel modelo = new DefaultTableModel(null,nombresColumnas);
        
        String sql = "SELECT * FROM Estudiante";
        
        Connection cn = null;
        
        PreparedStatement pst = null;
        
        ResultSet rs = null;


        try
        {
            cn = con.crearConexion();
            
            pst = cn.prepareStatement(sql);                        
            
            rs = pst.executeQuery();
            
            while(rs.next())
            {
                registros[0] = rs.getString("Cedula");
                
                registros[1] = rs.getString("Nombres");
                
                registros[2] = rs.getString("Apellidos");
                
                registros[3] = rs.getString("Usuario");
                
                registros[4] = rs.getString("Email");
                
                registros[5] = rs.getString("Contrasenia");
                
                registros[6] = rs.getString("Genero");
                
                registros[7] = rs.getString("FechaNac");
                
                modelo.addRow(registros);
                
                
            }
            
           
        }
        catch(SQLException e)
        {
            
            JOptionPane.showMessageDialog(null,"Error al conectar");
            
        }
        finally
        {
            try
            {
                if (rs != null) rs.close();
                
                if (pst != null) pst.close();
                
                if (cn != null) cn.close();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
        }
         return modelo;
	}
	public boolean login(administradores usr) {
		String sql = "SELECT Usuario, Pass FROM Administrador Where Usuario = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection cn = null;
		try
        {
            cn = con.crearConexion();
            
            ps = cn.prepareStatement(sql);                        
            ps.setString(1, usr.getAdmin());
            rs = ps.executeQuery();
            while(rs.next())
            {
            	if(usr.getPass().equals(rs.getString(2))) {
            		usr.setAdmin(rs.getString(1));
            		usr.setPass(rs.getString(2));
            		return true;
            	}
            	else{
            	return false;
            	}
            }
            return false;
        }
        catch(SQLException e)
        {
            
            JOptionPane.showMessageDialog(null,"Error al conectar");
            return false;
            
        }
        finally
        {
            try
            {
                if (rs != null) rs.close();
                
                if (ps != null) ps.close();
                
                if (cn != null) cn.close();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
        }   
		
	}
	
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
