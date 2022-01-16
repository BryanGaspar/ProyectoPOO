package ProyectoPooParte2;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class RegistroNiveles extends JInternalFrame {

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
		setBounds(100, 100, 450, 300);

	}

}
