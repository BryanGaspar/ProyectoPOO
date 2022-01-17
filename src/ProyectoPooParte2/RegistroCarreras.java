package ProyectoPooParte2;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;

public class RegistroCarreras extends JInternalFrame {
	private JTabbedPane tabbedPane;
	private JPanel pnlCarreras;
	private JPanel pnlNuevo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroCarreras frame = new RegistroCarreras();
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
	public RegistroCarreras() {
		setBounds(100, 100, 786, 401);
		getContentPane().setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 770, 371);
		getContentPane().add(tabbedPane);
		
		pnlCarreras = new JPanel();
		tabbedPane.addTab("Listado-Carreras", null, pnlCarreras, null);
		
		pnlNuevo = new JPanel();
		tabbedPane.addTab("Nuevo/Modificar", null, pnlNuevo, null);

	}
}
