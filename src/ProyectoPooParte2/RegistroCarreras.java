package ProyectoPooParte2;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class RegistroCarreras extends JInternalFrame {
	private JTabbedPane tabbedPane;
	private JPanel pnlCarreras;
	private JPanel pnlNuevo;
	private JPanel panel;
	private JTable tblCarrera;
	private JButton btnGuardar;
	private JButton btnNuevo;
	private JButton btnEditar;
	private JButton btnEliminar;

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
		tabbedPane.setBounds(0, 0, 618, 371);
		getContentPane().add(tabbedPane);
		
		pnlCarreras = new JPanel();
		tabbedPane.addTab("Listado-Carreras", null, pnlCarreras, null);
		pnlCarreras.setLayout(null);
		
		tblCarrera = new JTable();
		tblCarrera.setBounds(10, 11, 582, 321);
		pnlCarreras.add(tblCarrera);
		
		pnlNuevo = new JPanel();
		tabbedPane.addTab("Nuevo/Modificar", null, pnlNuevo, null);
		pnlNuevo.setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Opciones", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(628, 23, 132, 337);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setIcon(new ImageIcon(RegistroCarreras.class.getResource("/ProyectoPoo/ImagenesProyecto/folder-3-16.png")));
		btnGuardar.setBounds(10, 97, 102, 47);
		panel.add(btnGuardar);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.setIcon(new ImageIcon(RegistroCarreras.class.getResource("/ProyectoPoo/ImagenesProyecto/add-image-16.png")));
		btnNuevo.setBounds(10, 35, 102, 47);
		panel.add(btnNuevo);
		
		btnEditar = new JButton("Editar");
		btnEditar.setIcon(new ImageIcon(RegistroCarreras.class.getResource("/ProyectoPoo/ImagenesProyecto/edit-property-16.png")));
		btnEditar.setBounds(10, 165, 102, 47);
		panel.add(btnEditar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon(RegistroCarreras.class.getResource("/ProyectoPoo/ImagenesProyecto/delete-16.png")));
		btnEliminar.setBounds(10, 234, 102, 47);
		panel.add(btnEliminar);

	}
}
