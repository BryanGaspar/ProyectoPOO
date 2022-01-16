package ProyectoPooParte2;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class Asignaturas extends JInternalFrame {

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
		setBounds(100, 100, 450, 300);

	}

}
