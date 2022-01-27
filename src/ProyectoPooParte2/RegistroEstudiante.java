package ProyectoPooParte2;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;

import Conexiones.crudsqlEst;
import Enums.Genero;



import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import javax.swing.JList;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JToolBar;
import javax.swing.JPopupMenu;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTabbedPane;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.table.DefaultTableModel;

import Clases.Estudiante;

import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

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
	public JTextField txtDireccion;
	public JTextField txtEmail;
	public JTextField txtApellidos;
	public JTextField txtNombres;
	public JTextField txtCedula;
	public JTextField txtTelefono;
	public JComboBox cmbGenero;
	public JTable tblRegistros;
	private JTextField txtFechaNac;
	crudsqlEst objcrud = new crudsqlEst();
	Estudiante mod = new Estudiante();
	private JButton btnGuardarM;
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
	public RegistroEstudiante() {
		setBackground(SystemColor.window);
		
		setTitle("Estudiantes");
		setClosable(true);
		setResizable(true);
		setIconifiable(true);
		setBounds(100, 100, 650, 349);
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(494, 18, 130, 290);
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
		tabbedPane.setBounds(0, 0, 488, 308);
		getContentPane().add(tabbedPane);
		
		pnRegistroEst = new JPanel();
		
		tabbedPane.addTab("Registro Estudiantes", null, pnRegistroEst, null);
		tabbedPane.setEnabledAt(0, true);
		pnRegistroEst.setLayout(null);
		
		tblRegistros = new JTable();
		tblRegistros.addMouseListener(this);
		tblRegistros.setBounds(22, 32, 446, 214);
		tblRegistros.setModel(objcrud.mostrarEstudiantes());
		pnRegistroEst.add(tblRegistros);
		
		pnNuevo = new JPanel();
		tabbedPane.addTab("Nuevo/Modificar", null, pnNuevo, null);
		tabbedPane.setEnabledAt(1, true);
		pnNuevo.setLayout(null);
		
		lblNombres = new JLabel("Nombres:");
		lblNombres.setBounds(28, 58, 57, 15);
		lblNombres.setFont(new Font("Tahoma", Font.BOLD, 12));
		pnNuevo.add(lblNombres);
		
		lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(28, 91, 59, 15);
		lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 12));
		pnNuevo.add(lblApellidos);
		
		lblCedula = new JLabel("Cedula:");
		lblCedula.setBounds(28, 32, 45, 15);
		lblCedula.setFont(new Font("Tahoma", Font.BOLD, 12));
		pnNuevo.add(lblCedula);
		
		lblFechaNac = new JLabel("Fecha de Nac:");
		lblFechaNac.setBounds(246, 58, 82, 15);
		lblFechaNac.setFont(new Font("Tahoma", Font.BOLD, 12));
		pnNuevo.add(lblFechaNac);
		
		lblCorreo = new JLabel("Email:");
		lblCorreo.setBounds(28, 122, 35, 15);
		lblCorreo.setFont(new Font("Tahoma", Font.BOLD, 12));
		pnNuevo.add(lblCorreo);
		
		lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(28, 184, 74, 15);
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 12));
		pnNuevo.add(lblTelefono);
		
		lblGenero = new JLabel("Genero:");
		lblGenero.setBounds(259, 32, 47, 15);
		lblGenero.setFont(new Font("Tahoma", Font.BOLD, 12));
		pnNuevo.add(lblGenero);
		
		lblDireccion = new JLabel("Direccion:");
		lblDireccion.setBounds(28, 148, 74, 15);
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 12));
		pnNuevo.add(lblDireccion);
		
		txtDireccion = new JTextField();
		
		txtDireccion.setBounds(118, 146, 86, 20);
		txtDireccion.setColumns(10);
		pnNuevo.add(txtDireccion);
		
		txtEmail = new JTextField();
		
		txtEmail.setBounds(118, 120, 86, 20);
		txtEmail.setColumns(10);
		pnNuevo.add(txtEmail);
		
		txtApellidos = new JTextField();
		;
		txtApellidos.setBounds(118, 89, 86, 20);
		txtApellidos.setColumns(10);
		pnNuevo.add(txtApellidos);
		
		txtNombres = new JTextField();
		
		txtNombres.setBounds(118, 58, 86, 20);
		txtNombres.setColumns(10);
		pnNuevo.add(txtNombres);
		
		txtCedula = new JTextField();
		
		txtCedula.setBounds(118, 30, 86, 20);
		txtCedula.setColumns(10);
		pnNuevo.add(txtCedula);
		
		txtTelefono = new JTextField();
	
		txtTelefono.setBounds(118, 182, 86, 20);
		txtTelefono.setColumns(10);
		pnNuevo.add(txtTelefono);
		
		cmbGenero = new JComboBox();
		cmbGenero.setModel(new DefaultComboBoxModel(Genero.values()));
		cmbGenero.setBounds(338, 28, 86, 23);
		cmbGenero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		pnNuevo.add(cmbGenero);
		
		txtFechaNac = new JTextField();
		txtFechaNac.setBounds(338, 56, 86, 20);
		pnNuevo.add(txtFechaNac);
		txtFechaNac.setColumns(10);
		
		

	}

	public void actionPerformed(ActionEvent e) {
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
		
		
		tabbedPane.setSelectedIndex(1);
	
		btnGuardar.setEnabled(true);
		limpiar();
		
	}
	protected void actionPerformedBtnEditar(ActionEvent e) {
		
		tabbedPane.setSelectedIndex(1);

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
			mod.setFechaNac(txtFechaNac.getText());
			if(objcrud.registrarEst(mod))
			{
				JOptionPane.showMessageDialog(null, "Registro Guardado");
				tblRegistros.setModel(objcrud.mostrarEstudiantes());
				tabbedPane.setSelectedIndex(0);
				tabbedPane.setEnabledAt(1, false);
				btnGuardar.setEnabled(false);
				btnNuevo.setEnabled(true);
				limpiar();
			}
			else {
				JOptionPane.showMessageDialog(null, "Error al Guardar");
				btnGuardar.setEnabled(true);
				limpiar();
			}
			
	
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
        String cedula , nombres, apellidos, direccion, email, telefono,genero, fechaN;
        int Fila = tblRegistros.getSelectedRow();
        cedula = tblRegistros.getValueAt(Fila, 0).toString();
        nombres = tblRegistros.getValueAt(Fila, 1).toString();
        apellidos = tblRegistros.getValueAt(Fila, 2).toString();
        direccion = tblRegistros.getValueAt(Fila, 3).toString();
        email = tblRegistros.getValueAt(Fila, 4).toString();
        telefono = tblRegistros.getValueAt(Fila, 5).toString();
        genero = tblRegistros.getValueAt(Fila, 6).toString();
        fechaN = tblRegistros.getValueAt(Fila, 7).toString();
       txtCedula.setText(cedula);
       txtNombres.setText(nombres);
       txtApellidos.setText(apellidos);
       txtDireccion.setText(direccion);
       txtEmail.setText(email);
       txtTelefono.setText(telefono);
       cmbGenero.getModel().setSelectedItem(genero);
       txtFechaNac.setText(fechaN);
	}
	
	public void limpiar()
	{
		txtCedula.setText(null);
		txtNombres.setText(null);
		txtApellidos.setText(null);
		txtDireccion.setText(null);
		txtEmail.setText(null);
		txtTelefono.setText(null);
		cmbGenero.setModel(new DefaultComboBoxModel(Genero.values()));
		txtFechaNac.setText(null);
	}
	protected void actionPerformedBtnGuardarM(ActionEvent e) {
		mod.setCedula(Integer.parseInt(txtCedula.getText()));
		mod.setNombres(txtNombres.getText());
		mod.setApellidos(txtApellidos.getText());
		mod.setDireccion(txtDireccion.getText());
		mod.setEmail(txtEmail.getText());
		mod.setTelefono(Integer.parseInt(txtTelefono.getText()));
		mod.setGenero(String.valueOf(cmbGenero.getModel().getSelectedItem()));
		mod.setFechaNac(txtFechaNac.getText());
		if(objcrud.modificarEst(mod))
		{
			JOptionPane.showMessageDialog(null, "Registro Modificado");
			tblRegistros.setModel(objcrud.mostrarEstudiantes());
			tabbedPane.setSelectedIndex(0);
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
		mod.setCedula(Integer.parseInt(txtCedula.getText()));

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
}
