package ProyectoPooParte2;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Periodos extends JInternalFrame {
	private JPanel panel;
	private JTabbedPane tabbedPane;
	private JPanel pnlPeriodos;
	private JPanel pnlNuevo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Periodos frame = new Periodos();
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
	public Periodos() {
		setClosable(true);
		setBounds(100, 100, 829, 414);
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 813, 384);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 813, 384);
		panel.add(tabbedPane);
		
		pnlPeriodos = new JPanel();
		tabbedPane.addTab("Listado-Periodos", null, pnlPeriodos, null);
		
		pnlNuevo = new JPanel();
		tabbedPane.addTab("Nuevo/Modificar", null, pnlNuevo, null);

	}

}
