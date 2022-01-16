package ProyectoPoo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Registrarse extends JFrame {

	private JPanel contentPane;
	private JTextField txtCedula;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtFechaNac;
	private JTextField txtEmail;
	private JTextField txtPass;
	private JTextField txtConfirmarPass;
	private JTextField txtUsuario;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registrarse frame = new Registrarse();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 *
	 */
	
	public Registrarse() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 845, 372);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombres = new JLabel("Nombres");
		lblNombres.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNombres.setBounds(50, 97, 119, 24);
		contentPane.add(lblNombres);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblApellidos.setBounds(50, 132, 109, 24);
		contentPane.add(lblApellidos);
		
		JLabel lblCedula = new JLabel("Cedula");
		lblCedula.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCedula.setBounds(50, 65, 119, 21);
		contentPane.add(lblCedula);
		
		JLabel lblNewLabel_5 = new JLabel("REGISTRATE");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_5.setBounds(304, 11, 137, 24);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblFechaNac = new JLabel("Fecha de Nac");
		lblFechaNac.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblFechaNac.setBounds(442, 97, 152, 24);
		contentPane.add(lblFechaNac);
		
		JLabel lblCorreo = new JLabel("Email");
		lblCorreo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCorreo.setBounds(50, 202, 128, 24);
		contentPane.add(lblCorreo);
		
		JLabel lblPass = new JLabel("Contrase\u00F1a");
		lblPass.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPass.setBounds(50, 237, 128, 24);
		contentPane.add(lblPass);
		
		JLabel lblConfirmarPass = new JLabel("Confirmar Contrase\u00F1a");
		lblConfirmarPass.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblConfirmarPass.setBounds(50, 272, 247, 24);
		contentPane.add(lblConfirmarPass);
		
		txtCedula = new JTextField();
		txtCedula.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtCedula.setBounds(193, 66, 164, 20);
		contentPane.add(txtCedula);
		txtCedula.setColumns(10);
		
		txtNombres = new JTextField();
		txtNombres.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtNombres.setBounds(193, 101, 164, 20);
		contentPane.add(txtNombres);
		txtNombres.setColumns(10);
		
		txtApellidos = new JTextField();
		txtApellidos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtApellidos.setBounds(193, 136, 164, 20);
		contentPane.add(txtApellidos);
		txtApellidos.setColumns(10);
		
		txtFechaNac = new JTextField();
		txtFechaNac.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtFechaNac.setBounds(589, 101, 130, 20);
		contentPane.add(txtFechaNac);
		txtFechaNac.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtEmail.setColumns(10);
		txtEmail.setBounds(193, 206, 164, 20);
		contentPane.add(txtEmail);
		
		txtPass = new JTextField();
		txtPass.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtPass.setColumns(10);
		txtPass.setBounds(193, 241, 164, 20);
		contentPane.add(txtPass);
		
		txtConfirmarPass = new JTextField();
		txtConfirmarPass.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtConfirmarPass.setColumns(10);
		txtConfirmarPass.setBounds(290, 276, 109, 20);
		contentPane.add(txtConfirmarPass);
		
		JLabel lblGenero = new JLabel("Genero");
		lblGenero.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblGenero.setBounds(442, 65, 89, 21);
		contentPane.add(lblGenero);
		
		JComboBox cmbGenero = new JComboBox();
		cmbGenero.setBackground(UIManager.getColor("Button.highlight"));
		cmbGenero.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Femenino"}));
		cmbGenero.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cmbGenero.setBounds(591, 66, 128, 22);
		contentPane.add(cmbGenero);
		crudsql objcrud = new crudsql();
		JButton btnGuardar = new JButton("GUARDAR");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				objcrud.insertarDatos(txtCedula.getText(), txtNombres.getText(), txtApellidos.getText(), txtEmail.getText(), 
						txtUsuario.getText(), txtPass.getText(), cmbGenero.getSelectedItem().toString(),txtFechaNac.getText());
			}
		});
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnGuardar.setBounds(498, 182, 152, 37);
		contentPane.add(btnGuardar);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUsuario.setBounds(50, 167, 109, 24);
		contentPane.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(193, 171, 164, 20);
		contentPane.add(txtUsuario);
	}
	
}
