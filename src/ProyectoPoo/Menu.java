package ProyectoPoo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JDesktopPane;
import java.awt.Font;
import javax.swing.UIManager;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setExtendedState(MAXIMIZED_BOTH);
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
	public Menu() {
		setTitle("Matriculaci\u00F3n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 616, 406);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(UIManager.getColor("Button.highlight"));
		setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		mnArchivo.setMnemonic('A');
		mnArchivo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnArchivo);
		
		JMenuItem mnEstudiantes = new JMenuItem("Estudiantes");
		mnArchivo.add(mnEstudiantes);
		
		JMenuItem mnCarreras = new JMenuItem("Carreras");
		mnArchivo.add(mnCarreras);
		
		JMenuItem mnNiveles = new JMenuItem("Niveles");
		mnArchivo.add(mnNiveles);
		
		JMenuItem mnPeriodos = new JMenuItem("Periodos");
		mnArchivo.add(mnPeriodos);
		
		JMenuItem mnAsignaturas = new JMenuItem("Asignaturas");
		mnArchivo.add(mnAsignaturas);
		
		JMenu mnProceso = new JMenu("Proceso");
		mnProceso.setMnemonic('P');
		mnProceso.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnProceso);
		
		JMenuItem mnMatriculacion = new JMenuItem("Matriculacion");
		mnProceso.add(mnMatriculacion);
		
		JMenu mnReportes = new JMenu("Reportes");
		mnReportes.setMnemonic('R');
		mnReportes.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnReportes);
		
		JMenuItem mnEstudiantesMatriculados = new JMenuItem("Estudiantes Matriculados");
		mnEstudiantesMatriculados.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnReportes.add(mnEstudiantesMatriculados);
		
		JMenuItem mnCertificadoMatricula = new JMenuItem("Certificado de Matricula");
		mnCertificadoMatricula.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnReportes.add(mnCertificadoMatricula);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
