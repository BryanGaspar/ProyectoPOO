package Conexiones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.PseudoColumnUsage;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import Clases.Asignatura;







public class crudsqlAsig extends Conexion {
	
	public boolean registrarEst(Asignatura asg) {
		PreparedStatement ps = null;
		Connection con = getConexion();
		
		String sql = "INSERT INTO asignatura (NombreA,NombreC,NombreN) VALUES(?,?,?)";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, asg.getNombreA());
			ps.setString(2, asg.getNombreCarrera());
			ps.setString(3, asg.getNombreNString());

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
	

	public boolean modificarAsg(Asignatura asg) {
		PreparedStatement ps = null;
		Connection con = getConexion();

		String sql = "UPDATE asignatura SET NombreA=?,NombreC=?,NombreN=?"
				+ "WHERE Id=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, asg.getNombreA());
			ps.setString(2, asg.getNombreCarrera());
			ps.setString(3, asg.getNombreNString());
			ps.setInt(4, asg.getId());
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
 
	public boolean eliminarAsg(Asignatura asg) {
		PreparedStatement ps = null;
		Connection con = getConexion();
		
		String sql = "DELETE FROM asignatura WHERE Id=?";
		
		try {
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, asg.getId());
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
	public DefaultTableModel buscarAsg(Asignatura Asignatura , int aux) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = getConexion();
		DefaultTableModel model = null;
	
		
		try {
		
			
			model = new DefaultTableModel(){
    			//bloquear columnas
    			public boolean isCellEditable(int filas, int col) {
    				if((col == 0) || (col == 1) || (col == 2) || (col == 3) || (col == 4) || (col == 5)) {
    					return false;
    				}
    				else {
    					return true;
    				}
    				
    			}};
    		  
    			model.addColumn("Nº");
    			model.addColumn("NombreA");
    			model.addColumn("NombreC");
    			model.addColumn("NombreN");
    		
    	
    			if (aux==0)
				{
    				ps=con.prepareStatement("SELECT * FROM asignatura WHERE NombreA=?");
					ps.setString(1, Asignatura.getNombreA());	
					}
				
			
    			rs = ps.executeQuery();
          
           

            ResultSetMetaData rstabla = (ResultSetMetaData) rs.getMetaData();
			int numCampos = rstabla.getColumnCount();
            while(rs.next())
            {
     
            	Object [] filas = new Object[numCampos];
				for (int iterator = 0; iterator<numCampos; iterator++) {
					filas[iterator] = rs.getObject(iterator+1);	
				}
				model.addRow(filas);
				
			}
		} catch (SQLException e) {
			System.err.println(e);
			
		} finally {
			try {
				con.close();
				
			}catch (SQLException e) {
				System.err.println(e);
			}
		}
		return model;	
	}
	public DefaultTableModel mostrarAsig() {

        
		 DefaultTableModel modelo = null;
        
        String sql = "SELECT * FROM asignatura";
        
        
        PreparedStatement pst = null;
        
        ResultSet rs = null;
        Connection cn = getConexion();

        try
        {
          
        	modelo = new DefaultTableModel(){
    			//bloquear columnas
    			public boolean isCellEditable(int filas, int col) {
    				if((col == 0) || (col == 1) || (col == 2) || (col == 3) || (col == 4) ) {
    					return false;
    				}
    				else {
    					return true;
    				}
    				
    			}};
    			modelo.addColumn("Nº");
    			modelo.addColumn("NombreA");
    			modelo.addColumn("NombreC");
    			modelo.addColumn("NombreN");
    		
            pst = cn.prepareStatement(sql);                        
            
            rs = pst.executeQuery();
            ResultSetMetaData rstabla = (ResultSetMetaData) rs.getMetaData();
			int numCampos = rstabla.getColumnCount();
            while(rs.next())
            {

            	Object [] filas = new Object[numCampos];
				for (int iterator = 0; iterator<numCampos; iterator++) {
					filas[iterator] = rs.getObject(iterator+1);	
				}
				modelo.addRow(filas);
          
                
              
                
                
                
                
            }
            
           
        }
        catch(SQLException e)
        {
            
            JOptionPane.showMessageDialog(null,"Error al conectar" + e);
            
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

	public void cmbCarrera() {
		PreparedStatement ps = null;
		Connection con = getConexion();
		ResultSet rs = null;
		String sql = "SELECT * FROM asignatura";
		JComboBox model = null;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				model.addItem(rs.getString("NombreC"));
				
			}
			rs.close();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
}
