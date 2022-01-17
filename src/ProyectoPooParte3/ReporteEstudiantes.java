package ProyectoPooParte3;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JTable;
import javax.swing.JButton;

public class ReporteEstudiantes extends JInternalFrame {
	private JPanel panel;
	private JTable table;
	private JButton btnGenerar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReporteEstudiantes frame = new ReporteEstudiantes();
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
	public ReporteEstudiantes() {
		setTitle("Reporte de estudiantes");
		setBounds(100, 100, 900, 450);
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Listado de Estudiantes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 864, 398);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		table = new JTable();
		table.setBounds(26, 27, 810, 303);
		panel.add(table);
		
		btnGenerar = new JButton("Generar Reporte");
		btnGenerar.setBounds(324, 353, 198, 34);
		panel.add(btnGenerar);

	}

}
