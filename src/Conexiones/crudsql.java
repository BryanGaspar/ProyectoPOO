package Conexiones;
import java.sql.*;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class crudsql extends Conexion {
	public boolean registrar(Estudiante est) {
		PreparedStatement ps = null;
		Connection con = getConexion();
		
		String sql = "INSERT INTO estudiante (Cedula,Nombres,Apellidos,Direccion,Email,Telefono,Genero,FechaNac) VALUES(?,?,?,?,?,?,?,?)";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, est.getCedula());
			ps.setString(2, est.getNombres());
			ps.setString(3, est.getApellidos());
			ps.setString(4, est.getDireccion());
			ps.setString(5, est.getEmail());
			ps.setInt(6, est.getTelefono());
			ps.setString(7, est.getGenero());
			ps.setString(8, est.getFechaNac());
			ps.execute();
			return true;
		} catch (SQLException e) {
			System.err.println(e);
			return false;
		} finally {
			try {
				con.close();
				
			}catch (SQLException e) {
				System.err.println(e);
			}
		}	
	}

	public boolean modificar(Estudiante est) {
		PreparedStatement ps = null;
		Connection con = getConexion();
		
		String sql = "UPDATE estudiante SET Cedula=?,Nombres=?,Apellidos=?,Direccion=?,Email=?,Telefono=?,Genero=?,FechaNac=?"
				+ "WHERE Cedula=?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, est.getCedula());
			ps.setString(2, est.getNombres());
			ps.setString(3, est.getApellidos());
			ps.setString(4, est.getDireccion());
			ps.setString(5, est.getEmail());
			ps.setInt(6, est.getTelefono());
			ps.setString(7, est.getGenero());
			ps.setString(8, est.getFechaNac());
			ps.setInt(9, est.getCedula());
			ps.execute();
			return true;
		} catch (SQLException e) {
			System.err.println(e);
			return false;
		} finally {
			try {
				con.close();
				
			}catch (SQLException e) {
				System.err.println(e);
			}
		}	
	}
 
	public boolean eliminar(Estudiante est) {
		PreparedStatement ps = null;
		Connection con = getConexion();
		
		String sql = "DELETE FROM estudiante WHERE Cedula=?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, est.getCedula());
			ps.execute();
			return true;
		} catch (SQLException e) {
			System.err.println(e);
			return false;
		} finally {
			try {
				con.close();
				
			}catch (SQLException e) {
				System.err.println(e);
			}
		}	
	}

	public boolean buscar(Estudiante est) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConexion();
		
		String sql = "SELECT * FROM estudiante WHERE Cedula=?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, est.getCedula());
			rs = ps.executeQuery();
			
			if(rs.next()) {
				est.setCedula(rs.getInt("Cedula"));
				est.setNombres(rs.getString("Nombres"));
				est.setApellidos(rs.getString("Apellidos"));
				est.setDireccion(rs.getString("Direccion"));
				est.setEmail(rs.getString("Email"));
				est.setTelefono(rs.getInt("Telefono"));
				est.setGenero(rs.getString("Genero"));
				est.setFechaNac(rs.getString("FechaNac"));
				return true;
			}
			
			return false;
		} catch (SQLException e) {
			System.err.println(e);
			return false;
		} finally {
			try {
				con.close();
				
			}catch (SQLException e) {
				System.err.println(e);
			}
		}	
	}
	public DefaultTableModel mostrarEstudiantes() {
		String []  nombresColumnas = {"Cedula","Nombres","Apellidos","Direccion","Email","Telefono","Genero","Fecha Nac"};
        String [] registros = new String[8];
        
        DefaultTableModel modelo = new DefaultTableModel(null,nombresColumnas);
        
        String sql = "SELECT * FROM estudiante";
        
        
        PreparedStatement pst = null;
        
        ResultSet rs = null;
        Connection cn = getConexion();

        try
        {
          
            
            pst = cn.prepareStatement(sql);                        
            
            rs = pst.executeQuery();
            
            while(rs.next())
            {
                registros[0] = rs.getString("Cedula");
                
                registros[1] = rs.getString("Nombres");
                
                registros[2] = rs.getString("Apellidos");
                
                registros[3] = rs.getString("Direccion");
                
                registros[4] = rs.getString("Email");
                
                registros[5] = rs.getString("Telefono");
                
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
		String sql = "SELECT Usuario, Pass FROM administrador Where Usuario = ?";
		PreparedStatement ps = null;
		Connection con = getConexion();
		ResultSet rs = null;
		try
        {
			
			ps = con.prepareStatement(sql);                        
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
                
                if (con != null) con.close();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
        }   
		
	}
	
}
