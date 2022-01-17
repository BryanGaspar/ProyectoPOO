package ProyectoPooParte2;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class RegistroNiveles extends JInternalFrame {
	private JPanel panel;
	private JTabbedPane tabbedPane;
	private JPanel pnlNiveles;
	private JPanel pnlNuevo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroNiveles frame = new RegistroNiveles();
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
	public RegistroNiveles() {
		setBounds(100, 100, 779, 403);
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 763, 373);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 763, 373);
		panel.add(tabbedPane);
		
		pnlNiveles = new JPanel();
		tabbedPane.addTab("Listado-Niveles", null, pnlNiveles, null);
		
		pnlNuevo = new JPanel();
		tabbedPane.addTab("Nuevo/Modificar", null, pnlNuevo, null);

	}
}
