package ProyectoPooParte2;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JMenuItem;
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

public class RegistroEstudiante extends JInternalFrame implements ActionListener {
	private JPanel panel;
	private JButton btnNuevo;
	private JButton btnGuardar;
	private JButton btnEditar;
	private JButton btnEliminar;
	private JMenuBar menuBar;
	private JPanel pnRegistros;
	private JTable tblRegistros;
	private JButton btnRegistro;
	private JButton btnModificar;
	private JPanel panelModificar;
	private JLabel lblNombres;
	private JLabel lblApellidos;
	private JLabel lblCedula;
	private JLabel lblFechaNac;
	private JLabel lblCorreo;
	private JLabel lblPass;
	private JLabel lblConfirmarPass;
	private JLabel lblGenero;
	private JLabel lblUsuario;
	

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
		
		setTitle("Estudiantes");
		setClosable(true);
		setResizable(true);
		setIconifiable(true);
		setBounds(100, 100, 654, 349);
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Opciones", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel.setBounds(490, 11, 138, 275);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(17, 21, 111, 41);
		btnNuevo.setIcon(new ImageIcon(RegistroEstudiante.class.getResource("/ProyectoPoo/ImagenesProyecto/add-image-16.png")));
		panel.add(btnNuevo);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setEnabled(false);
		btnGuardar.setIcon(new ImageIcon(RegistroEstudiante.class.getResource("/ProyectoPoo/ImagenesProyecto/folder-3-16.png")));
		btnGuardar.setBounds(17, 81, 111, 41);
		panel.add(btnGuardar);
		
		btnEditar = new JButton("Editar");
		btnEditar.setEnabled(false);
		btnEditar.setIcon(new ImageIcon(RegistroEstudiante.class.getResource("/ProyectoPoo/ImagenesProyecto/edit-property-16.png")));
		btnEditar.setBounds(17, 151, 111, 41);
		panel.add(btnEditar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setEnabled(false);
		btnEliminar.setIcon(new ImageIcon(RegistroEstudiante.class.getResource("/ProyectoPoo/ImagenesProyecto/delete-16.png")));
		btnEliminar.setBounds(17, 203, 111, 41);
		panel.add(btnEliminar);
		
		menuBar = new JMenuBar();
		menuBar.setBounds(10, 11, 257, 22);
		getContentPane().add(menuBar);
		
		btnRegistro = new JButton("Registro estudiantes");
		btnRegistro.addActionListener(this);
		menuBar.add(btnRegistro);
		
		btnModificar = new JButton("Nuevo/Modificar");
		btnModificar.addActionListener(this);
		menuBar.add(btnModificar);
		
		panelModificar = new JPanel();
		panelModificar.setVisible(false);
		panelModificar.setBounds(20, 22, 514, 286);
		getContentPane().add(panelModificar);
		panelModificar.setLayout(null);
		
		lblNombres = new JLabel("Nombres");
		lblNombres.setBounds(26, 52, 90, 25);
		lblNombres.setFont(new Font("Tahoma", Font.BOLD, 12));
		panelModificar.add(lblNombres);
		
		lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(36, 84, 92, 25);
		lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 12));
		panelModificar.add(lblApellidos);
		
		lblCedula = new JLabel("Cedula");
		lblCedula.setBounds(36, 27, 69, 25);
		lblCedula.setFont(new Font("Tahoma", Font.BOLD, 12));
		panelModificar.add(lblCedula);
		
		lblFechaNac = new JLabel("Fecha de Nac");
		lblFechaNac.setBounds(233, 84, 135, 25);
		lblFechaNac.setFont(new Font("Tahoma", Font.BOLD, 12));
		panelModificar.add(lblFechaNac);
		
		lblCorreo = new JLabel("Email");
		lblCorreo.setBounds(36, 156, 55, 25);
		lblCorreo.setFont(new Font("Tahoma", Font.BOLD, 12));
		panelModificar.add(lblCorreo);
		
		lblPass = new JLabel("Contrase\u00F1a");
		lblPass.setBounds(30, 191, 114, 25);
		lblPass.setFont(new Font("Tahoma", Font.BOLD, 12));
		panelModificar.add(lblPass);
		
		lblConfirmarPass = new JLabel("Confirmar Contrase\u00F1a");
		lblConfirmarPass.setBounds(26, 227, 221, 25);
		lblConfirmarPass.setFont(new Font("Tahoma", Font.BOLD, 12));
		panelModificar.add(lblConfirmarPass);
		
		lblGenero = new JLabel("Genero");
		lblGenero.setBounds(245, 52, 73, 25);
		lblGenero.setFont(new Font("Tahoma", Font.BOLD, 12));
		panelModificar.add(lblGenero);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(26, 120, 77, 25);
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		panelModificar.add(lblUsuario);
		
		pnRegistros = new JPanel();
		pnRegistros.setVisible(false);
		pnRegistros.setBounds(20, 44, 455, 235);
		getContentPane().add(pnRegistros);
		pnRegistros.setLayout(null);
		
		tblRegistros = new JTable();
		tblRegistros.setBounds(0, 0, 455, 235);
		pnRegistros.add(tblRegistros);

	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if (e.getSource() == btnRegistro) {
			actionPerformedBtnRegistro(e);
		}
		if (e.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(e);
		}
	}
	protected void actionPerformedBtnNuevo(ActionEvent e) {
		btnModificar.setVisible(true);
		btnModificar.requestFocus();
		pnRegistros.setVisible(false);
		panelModificar.setVisible(true);
		btnEditar.setEnabled(true);
		btnGuardar.setEnabled(true);
		btnEliminar.setEnabled(true);
	}
	protected void actionPerformedBtnRegistro(ActionEvent e) {
		panelModificar.setVisible(false);
		btnModificar.setVisible(false);
		pnRegistros.setVisible(true);
		btnEditar.setEnabled(true);
		btnGuardar.setEnabled(false);
		btnEliminar.setEnabled(true);
	}
	protected void actionPerformedBtnModificar(ActionEvent e) {
		
	}
}
