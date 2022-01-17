package ProyectoPooParte2;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Asignaturas extends JInternalFrame {
	private JPanel panel;
	private JTabbedPane tabbedPane;
	private JPanel pnlAsignaturas;
	private JPanel pnlNuevo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Asignaturas frame = new Asignaturas();
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
	public Asignaturas() {
		setBounds(100, 100, 789, 388);
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 773, 358);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 773, 358);
		panel.add(tabbedPane);
		
		pnlAsignaturas = new JPanel();
		tabbedPane.addTab("Listado-Asignaturas", null, pnlAsignaturas, null);
		
		pnlNuevo = new JPanel();
		tabbedPane.addTab("Nuevo/Modificar", null, pnlNuevo, null);

	}

}
