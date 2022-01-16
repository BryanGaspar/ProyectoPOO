package ProyectoPooParte2;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class RegistroEstudiante extends JInternalFrame {
	private JTable table;
	private JPanel panel;
	private JButton btnNewButton;
	private JButton btnEditar;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroEstudiante frame = new RegistroEstudiante();
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
	public RegistroEstudiante() {
		
		setTitle("Estudiantes");
		setClosable(true);
		setResizable(true);
		setIconifiable(true);
		setBounds(100, 100, 654, 349);
		getContentPane().setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 11, 470, 275);
		getContentPane().add(table);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Opciones", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel.setBounds(490, 11, 138, 275);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		btnNewButton = new JButton("Nuevo");
		btnNewButton.setBounds(17, 21, 111, 41);
		btnNewButton.setIcon(new ImageIcon(RegistroEstudiante.class.getResource("/ProyectoPoo/ImagenesProyecto/add-image-16.png")));
		panel.add(btnNewButton);
		
		btnEditar = new JButton("Guardar");
		btnEditar.setEnabled(false);
		btnEditar.setIcon(new ImageIcon(RegistroEstudiante.class.getResource("/ProyectoPoo/ImagenesProyecto/folder-3-16.png")));
		btnEditar.setBounds(17, 81, 111, 41);
		panel.add(btnEditar);
		
		btnNewButton_1 = new JButton("Editar");
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.setIcon(new ImageIcon(RegistroEstudiante.class.getResource("/ProyectoPoo/ImagenesProyecto/edit-property-16.png")));
		btnNewButton_1.setBounds(17, 151, 111, 41);
		panel.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Eliminar");
		btnNewButton_2.setEnabled(false);
		btnNewButton_2.setIcon(new ImageIcon(RegistroEstudiante.class.getResource("/ProyectoPoo/ImagenesProyecto/delete-16.png")));
		btnNewButton_2.setBounds(17, 203, 111, 41);
		panel.add(btnNewButton_2);

	}
}
