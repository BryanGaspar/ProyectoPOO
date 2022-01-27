package ProyectoPooParte2;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Enums.Niveles;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class Asignaturas extends JInternalFrame {
	private JPanel panel;
	private JTabbedPane tabbedPane;
	private JPanel pnlAsignaturas;
	private JPanel pnlNuevo;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField txtNomAsg;
	private JComboBox cmbCarrera;
	private JComboBox cmbNivel;
	private JTable table;
	private JPanel panel_1;
	private JButton btnGuardar;
	private JButton btnModifcar;
	private JButton btnNuevo;
	private JButton btnEliminar;

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
		setClosable(true);
		setTitle("Asignaturas");
		setBounds(100, 100, 789, 388);
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 773, 358);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 624, 358);
		panel.add(tabbedPane);
		
		pnlAsignaturas = new JPanel();
		tabbedPane.addTab("Listado-Asignaturas", null, pnlAsignaturas, null);
		pnlAsignaturas.setLayout(null);
		
		table = new JTable();
		table.setBounds(25, 27, 566, 277);
		pnlAsignaturas.add(table);
		
		pnlNuevo = new JPanel();
		tabbedPane.addTab("Nuevo/Modificar", null, pnlNuevo, null);
		pnlNuevo.setLayout(null);
		
		lblNewLabel = new JLabel("Nombre de la Asignatura:");
		lblNewLabel.setBounds(22, 41, 142, 14);
		pnlNuevo.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Carrera:");
		lblNewLabel_1.setBounds(39, 111, 46, 14);
		pnlNuevo.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Nivel:");
		lblNewLabel_2.setBounds(39, 216, 46, 14);
		pnlNuevo.add(lblNewLabel_2);
		
		txtNomAsg = new JTextField();
		txtNomAsg.setBounds(151, 38, 99, 20);
		pnlNuevo.add(txtNomAsg);
		txtNomAsg.setColumns(10);
		
		cmbCarrera = new JComboBox();
		cmbCarrera.setBounds(151, 107, 99, 22);
		pnlNuevo.add(cmbCarrera);
		
		cmbNivel = new JComboBox();
		cmbNivel.setBounds(147, 212, 103, 22);
		cmbNivel.setModel(new DefaultComboBoxModel(Niveles.values()));
		pnlNuevo.add(cmbNivel);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Opciones", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(636, 27, 127, 320);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setIcon(new ImageIcon(Asignaturas.class.getResource("/ProyectoPoo/ImagenesProyecto/folder-3-16.png")));
		btnGuardar.setBounds(10, 103, 107, 40);
		panel_1.add(btnGuardar);
		
		btnModifcar = new JButton("Modficar");
		btnModifcar.setIcon(new ImageIcon(Asignaturas.class.getResource("/ProyectoPoo/ImagenesProyecto/edit-property-16.png")));
		btnModifcar.setBounds(10, 168, 107, 42);
		panel_1.add(btnModifcar);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.setIcon(new ImageIcon(Asignaturas.class.getResource("/ProyectoPoo/ImagenesProyecto/add-image-16.png")));
		btnNuevo.setBounds(10, 50, 107, 42);
		panel_1.add(btnNuevo);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon(Asignaturas.class.getResource("/ProyectoPoo/ImagenesProyecto/delete-16.png")));
		btnEliminar.setBounds(10, 221, 107, 40);
		panel_1.add(btnEliminar);

	}
}
