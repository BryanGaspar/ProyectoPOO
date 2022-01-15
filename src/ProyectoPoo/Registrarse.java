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

public class Registrarse extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

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
	 */
	public Registrarse() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 788, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombres = new JLabel("Nombres");
		lblNombres.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNombres.setBounds(50, 81, 119, 24);
		contentPane.add(lblNombres);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblApellidos.setBounds(50, 116, 109, 24);
		contentPane.add(lblApellidos);
		
		JLabel lblCedula = new JLabel("Cedula");
		lblCedula.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCedula.setBounds(50, 49, 119, 21);
		contentPane.add(lblCedula);
		
		JLabel lblNewLabel_5 = new JLabel("REGISTRATE");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_5.setBounds(304, 11, 137, 24);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblFechaNac = new JLabel("Fecha de Nac");
		lblFechaNac.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblFechaNac.setBounds(50, 151, 152, 24);
		contentPane.add(lblFechaNac);
		
		JLabel lblCorreo = new JLabel("Correo Electronico");
		lblCorreo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCorreo.setBounds(50, 186, 198, 24);
		contentPane.add(lblCorreo);
		
		JLabel lblPass = new JLabel("Contrase\u00F1a");
		lblPass.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPass.setBounds(50, 221, 128, 24);
		contentPane.add(lblPass);
		
		JLabel lblConfirmarPass = new JLabel("Confirmar Contrase\u00F1a");
		lblConfirmarPass.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblConfirmarPass.setBounds(50, 256, 247, 24);
		contentPane.add(lblConfirmarPass);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setBounds(193, 48, 212, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_1.setBounds(193, 85, 212, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_2.setBounds(193, 120, 212, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_3.setBounds(193, 155, 212, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_4.setColumns(10);
		textField_4.setBounds(241, 186, 164, 20);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_5.setColumns(10);
		textField_5.setBounds(193, 221, 212, 20);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_6.setColumns(10);
		textField_6.setBounds(289, 262, 116, 20);
		contentPane.add(textField_6);
		
		JLabel lblGenero = new JLabel("Genero");
		lblGenero.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblGenero.setBounds(442, 56, 89, 21);
		contentPane.add(lblGenero);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(UIManager.getColor("Button.highlight"));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Femenino"}));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox.setBounds(529, 57, 128, 22);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("GUARDAR");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(498, 182, 152, 37);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\Clases\\GitHub\\ProyectoPoo\\src\\ProyectoPoo\\ImagenesProyecto\\fondo-login-web.jpg"));
		lblNewLabel.setBounds(0, 0, 772, 316);
		contentPane.add(lblNewLabel);
	}
}
