package Conexiones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Clases.Carrera;

public class crudsqlCarr extends Conexion{
	public boolean registrarNiv(Carrera carr) {
		PreparedStatement ps = null;
		Connection con = getConexion();
		
		String sql = "INSERT INTO carrera (Nombre, Descripcion) VALUES(?,?)";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, carr.getCarreras());
			ps.setString(2, carr.getDescripcion());
	
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
	
	public boolean modificarNiv(Carrera carr) {
		PreparedStatement ps = null;
		Connection con = getConexion();
		
		String sql = "UPDATE carrera SET Nombre=? Descripcion=? WHERE Nombre=?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, carr.getCarreras());
			ps.setString(2, carr.getDescripcion());
	
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
	public boolean eliminarNiv(Carrera carr) {
		PreparedStatement ps = null;
		Connection con = getConexion();
		
		String sql = "DELETE FROM  carrera WHERE Nombre=?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, carr.getCarreras());
	
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
	public DefaultTableModel mostrarCarreras() {
		String []  nombresColumnas = {"Nombres","Descripcion"};
        String [] registros = new String[2];
        
        DefaultTableModel modelo = new DefaultTableModel(null,nombresColumnas);
        
        String sql = "SELECT * FROM carrera";
        
        
        PreparedStatement pst = null;
        
        ResultSet rs = null;
        Connection cn = getConexion();

        try
        {
          
            
            pst = cn.prepareStatement(sql);                        
            
            rs = pst.executeQuery();
            
            while(rs.next())
            {
                registros[0] = rs.getString("Nombres");
                
                registros[1] = rs.getString("Descripcion");
                

                
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
}
