package ProyectoPooParte3;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTable;

public class CertificadoMatricula extends JInternalFrame {
	private JPanel panel;
	private JLabel lblNewLabel;
	private JTextField txtEstudiante;
	private JButton btnBuscar;
	private JLabel lblNewLabel_1;
	private JTable table;
	private JButton btnGenerar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CertificadoMatricula frame = new CertificadoMatricula();
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
	public CertificadoMatricula() {
		setTitle("Reporte de Inscripcion");
		setBounds(100, 100, 758, 480);
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Datos del Estudiante", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 722, 426);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("Estudiante:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(24, 45, 74, 15);
		panel.add(lblNewLabel);
		
		txtEstudiante = new JTextField();
		txtEstudiante.setEditable(false);
		txtEstudiante.setBounds(105, 43, 430, 20);
		panel.add(txtEstudiante);
		txtEstudiante.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(552, 42, 89, 23);
		panel.add(btnBuscar);
		
		lblNewLabel_1 = new JLabel("Asignaturas Inscritas");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(240, 86, 248, 23);
		panel.add(lblNewLabel_1);
		
		table = new JTable();
		table.setBounds(24, 130, 673, 230);
		panel.add(table);
		
		btnGenerar = new JButton("Generar Certificado");
		btnGenerar.setBounds(227, 376, 261, 23);
		panel.add(btnGenerar);

	}

}
