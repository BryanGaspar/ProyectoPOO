package ProyectoPoo;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import Clases.Estudiante;
import Conexiones.crudsqlEst;
import Enums.Genero;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;


public class RegistroEstudiante extends JInternalFrame  implements ActionListener, MouseListener {
	private JPanel panel;
	private JButton btnNuevo;
	private JButton btnGuardar;
	private JButton btnEditar;
	private JButton btnEliminar;
	
	private JTabbedPane tabbedPane;
	private JPanel pnRegistroEst;
	private JPanel pnNuevo;
	private JLabel lblNombres;
	private JLabel lblApellidos;
	private JLabel lblCedula;
	private JLabel lblFechaNac;
	private JLabel lblCorreo;
	private JLabel lblTelefono;
	private JLabel lblGenero;
	private JLabel lblDireccion;
	private JTextField txtDireccion;
	private JTextField txtEmail;
	private JTextField txtApellidos;
	private JTextField txtNombres;
	private JTextField txtCedula;
	private JTextField txtTelefono;
	private JComboBox cmbGenero;
	private JTable tblRegistros;
	private crudsqlEst objcrud = new crudsqlEst();
	private Estudiante mod = new Estudiante();
	DefaultTableModel model;
	private JButton btnGuardarM;
	private JDateChooser dtFecha;
	private JTextField txtId;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel;
	private JTextField txtBuscar;
	private JButton btnBuscar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroEstudiante frame = new RegistroEstudiante();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public RegistroEstudiante() {
		setBackground(SystemColor.window);
		
		setTitle("Estudiantes");
		setClosable(true);
		setResizable(true);
		setIconifiable(true);
		setBounds(100, 100, 785, 361);
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(629, 18, 130, 290);
		getContentPane().add(panel);
		panel.setBorder(new TitledBorder(null, "Opciones", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel.setLayout(null);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.setBackground(UIManager.getColor("Button.highlight"));
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(10, 21, 111, 41);
		btnNuevo.setIcon(new ImageIcon(RegistroEstudiante.class.getResource("/ProyectoPoo/ImagenesProyecto/add-image-16.png")));
		panel.add(btnNuevo);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(this);
		btnGuardar.setBackground(UIManager.getColor("Button.highlight"));
		btnGuardar.setEnabled(false);
		btnGuardar.setIcon(new ImageIcon(RegistroEstudiante.class.getResource("/ProyectoPoo/ImagenesProyecto/folder-3-16.png")));
		btnGuardar.setBounds(10, 82, 111, 41);
		panel.add(btnGuardar);
		
		btnEditar = new JButton("Editar");
		btnEditar.setBackground(UIManager.getColor("Button.highlight"));
		btnEditar.addActionListener(this);
		btnEditar.setEnabled(false);
		btnEditar.setIcon(new ImageIcon(RegistroEstudiante.class.getResource("/ProyectoPoo/ImagenesProyecto/edit-property-16.png")));
		btnEditar.setBounds(10, 148, 111, 41);
		panel.add(btnEditar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBackground(UIManager.getColor("Button.highlight"));
		btnEliminar.setEnabled(false);
		btnEliminar.setIcon(new ImageIcon(RegistroEstudiante.class.getResource("/ProyectoPoo/ImagenesProyecto/delete-16.png")));
		btnEliminar.setBounds(10, 199, 111, 41);
		panel.add(btnEliminar);
		
		btnGuardarM = new JButton("Guardar");
		btnGuardarM.addActionListener(this);
		btnGuardarM.setVisible(false);
		btnGuardarM.setIcon(new ImageIcon(RegistroEstudiante.class.getResource("/ProyectoPoo/ImagenesProyecto/folder-3-16.png")));
		btnGuardarM.setBounds(10, 82, 111, 41);
		panel.add(btnGuardarM);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 619, 308);
		getContentPane().add(tabbedPane);
		
		pnRegistroEst = new JPanel();
		
		tabbedPane.addTab("Registro Estudiantes", null, pnRegistroEst, null);
		tabbedPane.setEnabledAt(0, true);
		pnRegistroEst.setLayout(null);
		
		tblRegistros = new JTable();
		tblRegistros.addMouseListener(this);
		tblRegistros.setBounds(22, 32, 582, 214);
		
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 38, 582, 214);
		pnRegistroEst.add(scrollPane);
		scrollPane.setRowHeaderView(tblRegistros);
		scrollPane.setViewportView(tblRegistros);
		
		try {
			 model = new DefaultTableModel() {
				//bloquear columnas
				public boolean isCellEditable(int filas, int col) {
					if((col == 0) || (col == 1) || (col == 2) || (col == 3) || (col == 4) || (col == 5)) {
						return false;
					}
					else {
						return true;
					}
					
				}
			};
			tblRegistros.setModel(model);
			tblRegistros.setModel(objcrud.mostrarEstudiantes());
			
			lblNewLabel = new JLabel("Buscar:");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel.setBounds(22, 11, 90, 14);
			pnRegistroEst.add(lblNewLabel);
			
			txtBuscar = new JTextField();
			txtBuscar.setBounds(95, 9, 142, 20);
			pnRegistroEst.add(txtBuscar);
			txtBuscar.setColumns(10);
			
			btnBuscar = new JButton("");
			btnBuscar.addActionListener(this);
			btnBuscar.setIcon(new ImageIcon(RegistroEstudiante.class.getResource("/ProyectoPoo/ImagenesProyecto/search-2-16.png")));
			btnBuscar.setBounds(247, 11, 22, 20);
			pnRegistroEst.add(btnBuscar);
		
		pnNuevo = new JPanel();
		tabbedPane.addTab("Nuevo/Modificar", null, pnNuevo, null);
		tabbedPane.setEnabledAt(1, false);
		pnNuevo.setLayout(null);
		
		lblNombres = new JLabel("Nombres:");
		lblNombres.setBounds(48, 66, 57, 15);
		lblNombres.setFont(new Font("Tahoma", Font.BOLD, 12));
		pnNuevo.add(lblNombres);
		
		lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(48, 99, 59, 15);
		lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 12));
		pnNuevo.add(lblApellidos);
		
		lblCedula = new JLabel("Cedula:");
		lblCedula.setBounds(48, 40, 45, 15);
		lblCedula.setFont(new Font("Tahoma", Font.BOLD, 12));
		pnNuevo.add(lblCedula);
		
		lblFechaNac = new JLabel("Fecha de Nac:");
		lblFechaNac.setBounds(266, 91, 82, 15);
		lblFechaNac.setFont(new Font("Tahoma", Font.BOLD, 12));
		pnNuevo.add(lblFechaNac);
		
		lblCorreo = new JLabel("Email:");
		lblCorreo.setBounds(48, 130, 35, 15);
		lblCorreo.setFont(new Font("Tahoma", Font.BOLD, 12));
		pnNuevo.add(lblCorreo);
		
		lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(48, 192, 74, 15);
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 12));
		pnNuevo.add(lblTelefono);
		
		lblGenero = new JLabel("Genero:");
		lblGenero.setBounds(291, 40, 47, 15);
		lblGenero.setFont(new Font("Tahoma", Font.BOLD, 12));
		pnNuevo.add(lblGenero);
		
		lblDireccion = new JLabel("Direccion:");
		lblDireccion.setBounds(48, 156, 74, 15);
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 12));
		pnNuevo.add(lblDireccion);
		
		txtDireccion = new JTextField();
		
		txtDireccion.setBounds(138, 154, 86, 20);
		txtDireccion.setColumns(10);
		pnNuevo.add(txtDireccion);
		
		txtEmail = new JTextField();
		
		txtEmail.setBounds(138, 128, 86, 20);
		txtEmail.setColumns(10);
		pnNuevo.add(txtEmail);
		
		txtApellidos = new JTextField();
		txtApellidos.setBounds(138, 97, 86, 20);
		txtApellidos.setColumns(10);
		pnNuevo.add(txtApellidos);
		
		txtNombres = new JTextField();
		
		txtNombres.setBounds(138, 66, 86, 20);
		txtNombres.setColumns(10);
		pnNuevo.add(txtNombres);
		
		txtCedula = new JTextField();
		
		txtCedula.setBounds(138, 38, 86, 20);
		txtCedula.setColumns(10);
		pnNuevo.add(txtCedula);
		
		txtTelefono = new JTextField();
	
		txtTelefono.setBounds(138, 190, 86, 20);
		txtTelefono.setColumns(10);
		pnNuevo.add(txtTelefono);
		
		cmbGenero = new JComboBox();
		cmbGenero.setModel(new DefaultComboBoxModel(Genero.values()));
		cmbGenero.setBounds(358, 36, 153, 23);
		cmbGenero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		pnNuevo.add(cmbGenero);
		
		dtFecha = new JDateChooser();
		dtFecha.setBounds(358, 91, 153, 20);
		dtFecha.getJCalendar().setMaxSelectableDate(new java.util.Date());
		dtFecha.setDateFormatString("yyyy-MM-dd");
		pnNuevo.add(dtFecha);
		
		txtId = new JTextField();
		txtId.setEnabled(false);
		txtId.setVisible(false);
		txtId.setBounds(138, 7, 86, 20);
		pnNuevo.add(txtId);
		txtId.setColumns(10);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error" + e);
		}
		

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnGuardarM) {
			actionPerformedBtnGuardarM(e);
		}
		if (e.getSource() == btnGuardar) {
			actionPerformedBtnGuardar(e);
		}
		if (e.getSource() == btnEditar) {
			actionPerformedBtnEditar(e);
		}
		if (e.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(e);
		}
	}
	protected void actionPerformedBtnNuevo(ActionEvent e) {
		tabbedPane.setEnabledAt(0, false);
		tabbedPane.setEnabledAt(1, true);
		tabbedPane.setSelectedIndex(1);
		txtCedula.setEnabled(true);
		btnGuardar.setEnabled(true);
		limpiar();
		
	}
	protected void actionPerformedBtnEditar(ActionEvent e) {
		tabbedPane.setEnabledAt(0, false);
		tabbedPane.setEnabledAt(1, true);
		tabbedPane.setSelectedIndex(1);
		txtCedula.setEnabled(false);
		btnGuardar.setVisible(false);
		btnGuardarM.setVisible(true);
	}
	protected void actionPerformedBtnGuardar(ActionEvent e) {
			
		 	mod.setCedula(Integer.parseInt(txtCedula.getText()));
			mod.setNombres(txtNombres.getText());
			mod.setApellidos(txtApellidos.getText());
			mod.setDireccion(txtDireccion.getText());
			mod.setEmail(txtEmail.getText());
			mod.setTelefono(Integer.parseInt(txtTelefono.getText()));
			mod.setGenero(String.valueOf(cmbGenero.getSelectedItem()));
			java.util.Date date = dtFecha.getDate();
			long d = date.getTime();
			java.sql.Date fechaDate = new java.sql.Date(d);
			mod.setFechaNac(fechaDate.toString());
			if(objcrud.registrarEst(mod))
			{
				JOptionPane.showMessageDialog(null, "Registro Guardado");
				tblRegistros.setModel(objcrud.mostrarEstudiantes());
				tabbedPane.setSelectedIndex(0);
				tabbedPane.setEnabledAt(1, false);
				tabbedPane.setEnabledAt(0, true);
				limpiar();
			}
			else {
				JOptionPane.showMessageDialog(null, "Error al Guardar");
				btnGuardar.setEnabled(true);
				limpiar();
			}
			
	
	}
	
	protected void actionPerformedBtnGuardarM(ActionEvent e) {
		mod.setId(Integer.parseInt(txtId.getText()));
		mod.setCedula(Integer.parseInt(txtCedula.getText()));
		mod.setNombres(txtNombres.getText());
		mod.setApellidos(txtApellidos.getText());
		mod.setDireccion(txtDireccion.getText());
		mod.setEmail(txtEmail.getText());
		mod.setTelefono(Integer.parseInt(txtTelefono.getText()));
		mod.setGenero(String.valueOf(cmbGenero.getModel().getSelectedItem()));
		java.util.Date date = dtFecha.getDate();
		long d = date.getTime();
		java.sql.Date fechaDate = new java.sql.Date(d);
		mod.setFechaNac(fechaDate.toString());
		if(objcrud.modificarEst(mod))
		{
			JOptionPane.showMessageDialog(null, "Registro Modificado");
			tblRegistros.setModel(objcrud.mostrarEstudiantes());
			tabbedPane.setSelectedIndex(0);
			tabbedPane.setEnabledAt(1, false);
			tabbedPane.setEnabledAt(0, true);
			btnGuardar.setEnabled(false);
			btnNuevo.setEnabled(true);
			limpiar();
		}
		else {
			JOptionPane.showMessageDialog(null, "Error al Modificar");
			btnGuardar.setEnabled(true);
			limpiar();
		}
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		mod.setId(Integer.parseInt(txtId.getText()));
		if(objcrud.eliminarEst(mod))
		{
			JOptionPane.showMessageDialog(null, "Usuario:" + txtNombres.getText() + " Eliminado");
			tblRegistros.setModel(objcrud.mostrarEstudiantes());
			
			limpiar();
		}
		else {
			JOptionPane.showMessageDialog(null, "Error al Eliminar");
		
			limpiar();
		}
	}
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		mod.setCedula(Integer.parseInt(txtBuscar.getText()));
		
		
			tblRegistros.setModel(objcrud.buscarEst(mod,0));
		
		
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tblRegistros) {
			try {
				mouseClickedTblRegistros(e);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mouseClickedTblRegistros(MouseEvent e) throws ParseException {
	
        btnEditar.setEnabled(true);
        btnEliminar.setEnabled(true);
        String id,cedula , nombres, apellidos, direccion, email, telefono,genero;
        String fechaN;
        int Fila = tblRegistros.getSelectedRow();
        id = tblRegistros.getValueAt(Fila, 0).toString();
        cedula = tblRegistros.getValueAt(Fila, 1).toString();
        nombres = tblRegistros.getValueAt(Fila, 2).toString();
        apellidos = tblRegistros.getValueAt(Fila, 3).toString();
        direccion = tblRegistros.getValueAt(Fila, 4).toString();
        email = tblRegistros.getValueAt(Fila, 5).toString();
        telefono = tblRegistros.getValueAt(Fila, 6).toString();
        genero = tblRegistros.getValueAt(Fila, 7).toString();
        fechaN = tblRegistros.getValueAt(Fila, 8).toString();
       txtId.setText(id);
       txtCedula.setText(cedula);
       txtNombres.setText(nombres);
       txtApellidos.setText(apellidos);
       txtDireccion.setText(direccion);
       txtEmail.setText(email);
       txtTelefono.setText(telefono);
       cmbGenero.getModel().setSelectedItem(genero);
       SimpleDateFormat s = new SimpleDateFormat("yyyy-mm-dd");
       java.util.Date fecha;
       try {
			fecha = (java.util.Date) s.parse(fechaN);
		    dtFecha.setDate(fecha);
		} catch (ParseException e2) {
			// TODO: handle exception
		}
   
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void limpiar()
	{
		txtId.setText(null);
		txtCedula.setText(null);
		txtNombres.setText(null);
		txtApellidos.setText(null);
		txtDireccion.setText(null);
		txtEmail.setText(null);
		txtTelefono.setText(null);
		cmbGenero.setModel(new DefaultComboBoxModel(Genero.values()));
		dtFecha.setDate(null);
	}
	
}
