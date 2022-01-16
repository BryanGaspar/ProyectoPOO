package ProyectoPooParte2;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;

import Conexiones.crudsql;

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
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTabbedPane;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.JScrollPane;
import java.awt.Scrollbar;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

public class RegistroEstudiante extends JInternalFrame implements ActionListener, KeyListener, MouseListener {
	private JPanel panel;
	private JButton btnNuevo;
	private JButton btnGuardar;
	private JButton btnEditar;
	private JButton btnEliminar;
	crudsql objcrud = new crudsql();
	private JTabbedPane tabbedPane;
	private JPanel pnRegistroEst;
	private JPanel pnNuevo;
	private JLabel lblNombres;
	private JLabel lblApellidos;
	private JLabel lblCedula;
	private JLabel lblFechaNac;
	private JLabel lblCorreo;
	private JLabel lblPass;
	private JLabel lblGenero;
	private JLabel lblUsuario;
	public JTextField txtFechaNac;
	public JTextField txtUsuario;
	public JTextField txtEmail;
	public JTextField txtApellidos;
	public JTextField txtNombres;
	public JTextField txtCedula;
	public JTextField txtPass;
	public JComboBox cmbGenero;
	public JTable tblRegistros;

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
		setBounds(100, 100, 654, 349);
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Opciones", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel.setBounds(490, 11, 138, 275);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.setBackground(UIManager.getColor("Button.highlight"));
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(17, 21, 111, 41);
		btnNuevo.setIcon(new ImageIcon(RegistroEstudiante.class.getResource("/ProyectoPoo/ImagenesProyecto/add-image-16.png")));
		panel.add(btnNuevo);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(this);
		btnGuardar.setBackground(UIManager.getColor("Button.highlight"));
		btnGuardar.setEnabled(false);
		btnGuardar.setIcon(new ImageIcon(RegistroEstudiante.class.getResource("/ProyectoPoo/ImagenesProyecto/folder-3-16.png")));
		btnGuardar.setBounds(17, 81, 111, 41);
		panel.add(btnGuardar);
		
		btnEditar = new JButton("Editar");
		btnEditar.setBackground(UIManager.getColor("Button.highlight"));
		btnEditar.addActionListener(this);
		btnEditar.setEnabled(false);
		btnEditar.setIcon(new ImageIcon(RegistroEstudiante.class.getResource("/ProyectoPoo/ImagenesProyecto/edit-property-16.png")));
		btnEditar.setBounds(17, 151, 111, 41);
		panel.add(btnEditar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBackground(UIManager.getColor("Button.highlight"));
		btnEliminar.setEnabled(false);
		btnEliminar.setIcon(new ImageIcon(RegistroEstudiante.class.getResource("/ProyectoPoo/ImagenesProyecto/delete-16.png")));
		btnEliminar.setBounds(17, 203, 111, 41);
		panel.add(btnEliminar);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 638, 319);
		getContentPane().add(tabbedPane);
		
		pnRegistroEst = new JPanel();
		
		tabbedPane.addTab("Registro Estudiantes", null, pnRegistroEst, null);
		pnRegistroEst.setLayout(null);
		
		tblRegistros = new JTable();
		tblRegistros.addMouseListener(this);
		tblRegistros.setBackground(Color.WHITE);
		tblRegistros.setBounds(10, 11, 463, 248);
		tblRegistros.setModel(new DefaultTableModel(
			new Object[][] {
				{"12345678", "Bryan", "Apellidos", "bryan202gaspar@hotmail.com", "BGaspar", "12345", "Masculino", "2002-11-12"},
				{"123456", "gas", "asdf", "1asdasd", "dad", "12345", "Masculino", "2001-08-12"},
				{"123", "asd", "da", "das", "dsa", "123", "Masculino", "2002-04-12"},
				{"1234", "adsasd", "dasasd", "asdad", "dasasd", "123", "Masculino", "2002-04-12"},
				{"850594573", "BRYAN", "GASPAR", "BRYAN202GASPAR@HOTMAIL.COM", "BGASPAR", "12345", "Masculino", "2002-04-02"},
				{"5647131", "BRYAN", "GASPAR", "BRYAN2@HOTMAIL", "ASDW2", "12345", "Masculino", "2002-04-02"},
			},
			new String[] {
				"Cedula", "Nombres", "Apellidos", "Usuario", "Email", "Contrase\u00F1a", "Genero", "Fecha Nac"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		pnRegistroEst.add(tblRegistros);
		
		pnNuevo = new JPanel();
		tabbedPane.addTab("Nuevo/Modificar", null, pnNuevo, null);
		tabbedPane.setEnabledAt(1, false);
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
		
		lblPass = new JLabel("Contrase\u00F1a:");
		lblPass.setBounds(28, 184, 74, 15);
		lblPass.setFont(new Font("Tahoma", Font.BOLD, 12));
		pnNuevo.add(lblPass);
		
		lblGenero = new JLabel("Genero:");
		lblGenero.setBounds(259, 32, 47, 15);
		lblGenero.setFont(new Font("Tahoma", Font.BOLD, 12));
		pnNuevo.add(lblGenero);
		
		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(28, 148, 49, 15);
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		pnNuevo.add(lblUsuario);
		
		txtFechaNac = new JTextField();
		txtFechaNac.addKeyListener(this);
		txtFechaNac.setBounds(338, 56, 86, 20);
		txtFechaNac.setColumns(10);
		pnNuevo.add(txtFechaNac);
		
		txtUsuario = new JTextField();
		txtUsuario.addKeyListener(this);
		txtUsuario.setBounds(118, 146, 86, 20);
		txtUsuario.setColumns(10);
		pnNuevo.add(txtUsuario);
		
		txtEmail = new JTextField();
		txtEmail.addKeyListener(this);
		txtEmail.setBounds(118, 120, 86, 20);
		txtEmail.setColumns(10);
		pnNuevo.add(txtEmail);
		
		txtApellidos = new JTextField();
		txtApellidos.addKeyListener(this);
		txtApellidos.setBounds(118, 89, 86, 20);
		txtApellidos.setColumns(10);
		pnNuevo.add(txtApellidos);
		
		txtNombres = new JTextField();
		txtNombres.addKeyListener(this);
		txtNombres.setBounds(118, 58, 86, 20);
		txtNombres.setColumns(10);
		pnNuevo.add(txtNombres);
		
		txtCedula = new JTextField();
		txtCedula.addKeyListener(this);
		txtCedula.setBounds(118, 30, 86, 20);
		txtCedula.setColumns(10);
		pnNuevo.add(txtCedula);
		
		txtPass = new JTextField();
		txtPass.addKeyListener(this);
		txtPass.setBounds(118, 182, 86, 20);
		txtPass.setColumns(10);
		pnNuevo.add(txtPass);
		
		cmbGenero = new JComboBox();
		cmbGenero.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Femenino"}));
		cmbGenero.setBounds(338, 28, 86, 23);
		cmbGenero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		pnNuevo.add(cmbGenero);
		
		

	}

	public void actionPerformed(ActionEvent e) {
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
		tabbedPane.setEnabledAt(1, true);
		tabbedPane.setEnabledAt(0, false);
		habilitarBotonGuardar();
		
	}
	protected void actionPerformedBtnEditar(ActionEvent e) {
		
		tabbedPane.setSelectedIndex(1);
		tabbedPane.setEnabledAt(1, true);
		tabbedPane.setEnabledAt(0, false);
		habilitarBotonGuardar();
		btnNuevo.setEnabled(false);
		

	}
	protected void actionPerformedBtnGuardar(ActionEvent e) {
		
		objcrud.insertarDatos(txtCedula.getText(), txtNombres.getText(), txtApellidos.getText(), txtEmail.getText(), 
				txtUsuario.getText(), txtPass.getText(), cmbGenero.getSelectedItem().toString(),txtFechaNac.getText());
		tabbedPane.setSelectedIndex(0);
		tabbedPane.setEnabledAt(1, false);
		btnGuardar.setEnabled(false);
		
	}
	public void habilitarBotonGuardar() {
		if(!txtCedula.getText().isEmpty()  && !txtNombres.getText().isEmpty()  && !txtApellidos.getText().isEmpty() 
				&& !txtEmail.getText().isEmpty() && !txtUsuario.getText().isEmpty()  && !txtPass.getText().isEmpty() && 
				!txtFechaNac.getText().isEmpty() )
		{
			btnGuardar.setEnabled(true);
		
		}else {
		btnGuardar.setEnabled(false);
		}
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == txtPass) {
			keyReleasedTxtPass(e);
		}
		if (e.getSource() == txtEmail) {
			keyReleasedTxtEmail(e);
		}
		if (e.getSource() == txtNombres) {
			keyReleasedTxtNombres(e);
		}
		if (e.getSource() == txtFechaNac) {
			keyReleasedTxtFechaNac(e);
		}
		if (e.getSource() == txtUsuario) {
			keyReleasedTxtUsuario(e);
		}
		if (e.getSource() == txtApellidos) {
			keyReleasedTxtApellidos(e);
		}
		if (e.getSource() == txtCedula) {
			keyReleasedTxtCedula(e);
		}
	}
	public void keyTyped(KeyEvent e) {
	}
	protected void keyReleasedTxtCedula(KeyEvent e) {
		habilitarBotonGuardar();
	}
	protected void keyReleasedTxtApellidos(KeyEvent e) {
		habilitarBotonGuardar();
	}
	protected void keyReleasedTxtUsuario(KeyEvent e) {
		habilitarBotonGuardar();
	}
	protected void keyReleasedTxtFechaNac(KeyEvent e) {
		habilitarBotonGuardar();
	}
	protected void keyReleasedTxtNombres(KeyEvent e) {
		habilitarBotonGuardar();
	}
	protected void keyReleasedTxtEmail(KeyEvent e) {
		habilitarBotonGuardar();
	}
	protected void keyReleasedTxtPass(KeyEvent e) {
		habilitarBotonGuardar();
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tblRegistros) {
			mouseClickedTblRegistros(e);
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
	protected void mouseClickedTblRegistros(MouseEvent e) {
		btnNuevo.setEnabled(false);
		btnEditar.setEnabled(true);
		String cedula , nombres, apellidos, usuario, email, pass, fechaN;
        int Fila = tblRegistros.getSelectedRow();
        cedula = tblRegistros.getValueAt(Fila, 0).toString();
        nombres = tblRegistros.getValueAt(Fila, 1).toString();
        apellidos = tblRegistros.getValueAt(Fila, 2).toString();
        usuario = tblRegistros.getValueAt(Fila, 3).toString();
        email = tblRegistros.getValueAt(Fila, 4).toString();
        pass = tblRegistros.getValueAt(Fila, 5).toString();
        
        fechaN = tblRegistros.getValueAt(Fila, 7).toString();
       txtCedula.setText(cedula);
       txtNombres.setText(nombres);
       txtApellidos.setText(apellidos);
       txtUsuario.setText(usuario);
       txtEmail.setText(email);
       txtPass.setText(pass);
       cmbGenero.getSelectedItem();
        txtFechaNac.setText(fechaN);
		
		
	}
}
