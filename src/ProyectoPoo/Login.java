package ProyectoPoo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Conexiones.administradores;
import Conexiones.crudsql;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import java.awt.SystemColor;

public class Login extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField txtUsuario;
	private JButton btnIngresar;
	private JPasswordField pass;
	private JProgressBar progressBar;
	crudsql objcrud = new crudsql();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					
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
	
	public Login() {
		setBackground(SystemColor.window);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/ProyectoPoo/ImagenesProyecto/901-9019040_business-user-lock-1-image-business-user.png")));
		setTitle("LOGIN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 553, 226);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("LOGIN-INICION DE SESION");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(146, 11, 265, 42);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("USUARIO:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(32, 66, 86, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("CONTRASE\u00D1A:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(10, 103, 108, 14);
		contentPane.add(lblNewLabel_2);
		
		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtUsuario.setBounds(128, 64, 272, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		btnIngresar = new JButton("INGRESAR");
		btnIngresar.addActionListener(this);
		btnIngresar.setBackground(UIManager.getColor("Button.focus"));
		btnIngresar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnIngresar.setBounds(128, 133, 272, 23);
		contentPane.add(btnIngresar);
		
		pass = new JPasswordField();
		pass.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pass.setBounds(128, 102, 272, 20);
		contentPane.add(pass);
		
		progressBar = new JProgressBar();
		progressBar.setVisible(false);
		progressBar.setBackground(SystemColor.window);
		progressBar.setBounds(31, 167, 472, 14);
		contentPane.add(progressBar);
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnIngresar) {
			actionPerformedBtnNewButton(e);
		}
	}
	
	@SuppressWarnings("unchecked")
	protected void actionPerformedBtnNewButton(ActionEvent e) {
		administradores mod = new administradores();
		String usuario, passw;
		Menu men = new Menu();
		usuario = txtUsuario.getText();
		passw = pass.getText();
		if(usuario.isEmpty() || passw.isEmpty()) {
			JOptionPane.showMessageDialog(null,"Error, algun campo esta vacio");
		} else {
			mod.setAdmin(usuario);
			mod.setPass(passw);
			if(objcrud.login(mod)) {
				Thread hilo = new Thread() {
					@Override
					public void run() {
						for(int i=1; i<=100;i++) {
							 try {
								progressBar.setVisible(true);
								Thread.sleep(10);
								progressBar.setValue(i);
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							 
						 }
						JOptionPane.showMessageDialog(null,"Bienvenido" + " " + usuario.toUpperCase());
						men.setExtendedState(MAXIMIZED_BOTH);
						
						men.setVisible(true);
						dispose();
					}
				};
				hilo.start();
			}else {
				JOptionPane.showMessageDialog(null,"Su usario o contraseña es incorrecta");
			}
			
		}
		
		 
	                   
	        
	}
	
}
