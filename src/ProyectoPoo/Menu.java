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
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.Color;
import javax.swing.border.LineBorder;

import ProyectoPooParte2.Asignaturas;
import ProyectoPooParte2.RegistroCarreras;
import ProyectoPooParte2.RegistroEstudiante;
import ProyectoPooParte3.CertificadoMatricula;
import ProyectoPooParte3.MatriculacionEst;
import ProyectoPooParte3.ReporteEstudiantes;

public class Menu extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuItem mnEstudiantes;
	private JMenuItem mnCarreras;
	private JMenuItem mnAsignaturas;
	private JMenuItem mnMatriculacion;
	private JMenuItem mnEstMat;
	private JMenuItem mnCertMat;
	private JDesktopPane Desktop;
	RegistroEstudiante est = new RegistroEstudiante();
	RegistroCarreras carr = new RegistroCarreras();
	Asignaturas asg = new Asignaturas();
	MatriculacionEst matEst = new MatriculacionEst();
	ReporteEstudiantes repEst = new ReporteEstudiantes();
	CertificadoMatricula certMat = new CertificadoMatricula();

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/ProyectoPoo/ImagenesProyecto/menu-4-16.png")));
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
		
		mnEstudiantes = new JMenuItem("Estudiantes");
		mnEstudiantes.addActionListener(this);
		mnEstudiantes.setIcon(new ImageIcon(Menu.class.getResource("/ProyectoPoo/ImagenesProyecto/student-16.png")));
		mnArchivo.add(mnEstudiantes);
		
		mnCarreras = new JMenuItem("Carreras");
		mnCarreras.addActionListener(this);
		mnCarreras.setIcon(new ImageIcon(Menu.class.getResource("/ProyectoPoo/ImagenesProyecto/engineering-16.png")));
		mnArchivo.add(mnCarreras);
		
		mnAsignaturas = new JMenuItem("Asignaturas");
		mnAsignaturas.addActionListener(this);
		mnAsignaturas.setIcon(new ImageIcon(Menu.class.getResource("/ProyectoPoo/ImagenesProyecto/book-16-16.png")));
		mnArchivo.add(mnAsignaturas);
		
		JMenu mnProceso = new JMenu("Proceso");
		mnProceso.setMnemonic('P');
		mnProceso.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnProceso);
		
		mnMatriculacion = new JMenuItem("Matriculacion");
		mnMatriculacion.addActionListener(this);
		mnMatriculacion.setIcon(new ImageIcon(Menu.class.getResource("/ProyectoPoo/ImagenesProyecto/pages-4-16.png")));
		mnProceso.add(mnMatriculacion);
		
		JMenu mnReportes = new JMenu("Reportes");
		mnReportes.setIcon(null);
		mnReportes.setMnemonic('R');
		mnReportes.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnReportes);
		
		mnEstMat = new JMenuItem("Estudiantes Matriculados");
		mnEstMat.addActionListener(this);
		mnEstMat.setIcon(new ImageIcon(Menu.class.getResource("/ProyectoPoo/ImagenesProyecto/inbox-5-16.png")));
		mnEstMat.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnReportes.add(mnEstMat);
		
		mnCertMat = new JMenuItem("Certificado de Matricula");
		mnCertMat.addActionListener(this);
		mnCertMat.setIcon(new ImageIcon(Menu.class.getResource("/ProyectoPoo/ImagenesProyecto/pdf-file-16.png")));
		mnCertMat.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnReportes.add(mnCertMat);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		Desktop = new JDesktopPane();
		contentPane.add(Desktop, "name_95837756417400");
	}
	

	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mnEstudiantes) {
			actionPerformedMnEstudiantes(e);
		}
		if (e.getSource() == mnCarreras) {
			actionPerformedMnCarreras(e);
		}
		if (e.getSource() == mnAsignaturas) {
			actionPerformedMnAsignaturas(e);
		}
		if (e.getSource() == mnMatriculacion) {
			actionPerformedMnMatriculacion(e);
		}
		if (e.getSource() == mnEstMat) {
			actionPerformedmnEstMat(e);
		}
		if (e.getSource() == mnCertMat) {
			actionPerformedmnCertMat(e);
		}
	}
protected void actionPerformedmnCertMat(ActionEvent e) {
		
		this.Desktop.add(certMat);
		certMat.setVisible(true);

	}
protected void actionPerformedmnEstMat(ActionEvent e) {
	
	this.Desktop.add(repEst);
	repEst.setVisible(true);

	
}

protected void actionPerformedMnMatriculacion(ActionEvent e) {
		
		this.Desktop.add(matEst);
		matEst.setVisible(true);
	}
	
	protected void actionPerformedMnEstudiantes(ActionEvent e) {
		
		this.Desktop.add(est);
		est.setVisible(true);

	
	}
	protected void actionPerformedMnCarreras(ActionEvent e) {
		this.Desktop.add(carr);
		carr.setVisible(true);
	}
	protected void actionPerformedMnAsignaturas(ActionEvent e) {
		
		this.Desktop.add(asg);
		asg.setVisible(true);

	}
}
