package ProyectoPoo;

import java.awt.EventQueue;


import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Enums.Carreras;
import Enums.Niveles;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import Clases.Asignatura;

import Conexiones.crudsqlAsig;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;

public class Asignaturas extends JInternalFrame implements ActionListener, MouseListener {
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
	private JTable tblAsig;
	private JPanel panel_1;
	private JButton btnGuardar;
	private JButton btnModifcar;
	private JButton btnNuevo;
	private JButton btnEliminar;
	private Asignatura mod = new Asignatura();
	crudsqlAsig objCrudsqlAsig = new crudsqlAsig();
	private JButton btnModificarG;
	private JTextField txtId;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel_3;
	private JTextField txtBuscar;
	private JButton btnBuscar;
	
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
	@SuppressWarnings("static-access")
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
		
		tblAsig = new JTable();
		tblAsig.addMouseListener(this);
		tblAsig.setBounds(25, 27, 566, 277);
		
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 39, 566, 265);
		pnlAsignaturas.add(scrollPane);
		scrollPane.setRowHeaderView(tblAsig);
		scrollPane.setViewportView(tblAsig);
		tblAsig.setModel(objCrudsqlAsig.mostrarAsig());
		
		lblNewLabel_3 = new JLabel("Buscar:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(24, 14, 59, 17);
		pnlAsignaturas.add(lblNewLabel_3);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(82, 14, 151, 20);
		pnlAsignaturas.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		btnBuscar = new JButton("");
		btnBuscar.addActionListener(this);
		btnBuscar.setIcon(new ImageIcon(Asignaturas.class.getResource("/ProyectoPoo/ImagenesProyecto/search-2-16.png")));
		btnBuscar.setBounds(243, 13, 28, 23);
		pnlAsignaturas.add(btnBuscar);
		pnlNuevo = new JPanel();
		tabbedPane.addTab("Nuevo/Modificar", null, pnlNuevo, null);
		pnlNuevo.setLayout(null);
		
		lblNewLabel = new JLabel("Nombre de la Asignatura:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(66, 73, 161, 14);
		pnlNuevo.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Carrera:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(66, 133, 125, 14);
		pnlNuevo.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Nivel:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(98, 185, 73, 14);
		pnlNuevo.add(lblNewLabel_2);
		
		txtNomAsg = new JTextField();
		txtNomAsg.setBounds(237, 70, 242, 20);
		pnlNuevo.add(txtNomAsg);
		txtNomAsg.setColumns(10);
		
		cmbCarrera = new JComboBox();
		cmbCarrera.setBounds(237, 124, 242, 22);
		cmbCarrera.setModel(new DefaultComboBoxModel(Carreras.values()));
	
		pnlNuevo.add(cmbCarrera);
		
		cmbNivel = new JComboBox();
		cmbNivel.setBounds(237, 182, 211, 22);
		
		cmbNivel.setModel(new DefaultComboBoxModel(Niveles.values()));
		pnlNuevo.add(cmbNivel);
		
		txtId = new JTextField();
		txtId.setEnabled(false);
		txtId.setBounds(237, 28, 96, 20);
		txtId.setVisible(false);
		pnlNuevo.add(txtId);
		txtId.setColumns(10);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Opciones", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(636, 27, 127, 320);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(this);
		btnGuardar.setIcon(new ImageIcon(Asignaturas.class.getResource("/ProyectoPoo/ImagenesProyecto/folder-3-16.png")));
		btnGuardar.setBounds(10, 103, 107, 40);
		panel_1.add(btnGuardar);
		
		btnModifcar = new JButton("Modficar");
		btnModifcar.addActionListener(this);
		btnModifcar.setIcon(new ImageIcon(Asignaturas.class.getResource("/ProyectoPoo/ImagenesProyecto/edit-property-16.png")));
		btnModifcar.setBounds(10, 168, 107, 42);
		panel_1.add(btnModifcar);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		btnNuevo.setIcon(new ImageIcon(Asignaturas.class.getResource("/ProyectoPoo/ImagenesProyecto/add-image-16.png")));
		btnNuevo.setBounds(10, 50, 107, 42);
		panel_1.add(btnNuevo);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setIcon(new ImageIcon(Asignaturas.class.getResource("/ProyectoPoo/ImagenesProyecto/delete-16.png")));
		btnEliminar.setBounds(10, 221, 107, 40);
		panel_1.add(btnEliminar);
		
		btnModificarG = new JButton("Guardar");
		btnModificarG.addActionListener(this);
		btnModificarG.setIcon(new ImageIcon(Asignaturas.class.getResource("/ProyectoPoo/ImagenesProyecto/folder-3-16.png")));
		btnModificarG.setBounds(10, 103, 107, 40);
		panel_1.add(btnModificarG);
		

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(e);
		}
		if (e.getSource() == btnModificarG) {
			actionPerformedBtnModificarG(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnModifcar) {
			actionPerformedBtnModifcar(e);
		}
		if (e.getSource() == btnGuardar) {
			actionPerformedBtnGuardar(e);
		}
		if (e.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(e);
		}
	}
	protected void actionPerformedBtnNuevo(ActionEvent e) {
		tabbedPane.setSelectedIndex(1);
		btnGuardar.setVisible(true);
		btnModificarG.setVisible(false);
		btnGuardar.setEnabled(true);
		//limpiar();
	}
	protected void actionPerformedBtnGuardar(ActionEvent e) {
		
		  
	
		mod.setNombreA(txtNomAsg.getText());
		mod.setNombreCarrera(String.valueOf(cmbCarrera.getSelectedItem()));
		mod.setNombreNString(String.valueOf(cmbNivel.getSelectedItem()));
		
		if(objCrudsqlAsig.registrarEst(mod))
		{
			JOptionPane.showMessageDialog(null, "Registro Guardado");
			tblAsig.setModel(objCrudsqlAsig.mostrarAsig());
			tabbedPane.setSelectedIndex(0);
			tabbedPane.setEnabledAt(1, false);
			btnGuardar.setEnabled(false);
			btnNuevo.setEnabled(true);
			//limpiar();
		}
		else {
			JOptionPane.showMessageDialog(null, "Error al Guardar");
			btnGuardar.setEnabled(true);
			//limpiar();
		}
	}
	protected void actionPerformedBtnModifcar(ActionEvent e) {
		tabbedPane.setSelectedIndex(1);
		
		btnGuardar.setVisible(false);
		btnModificarG.setVisible(true);
		
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		int r;
		r = JOptionPane.showConfirmDialog(null, "¿Esta seguro?", "Eliminar registro",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		if(r == 0) {
		mod.setId(Integer.valueOf(txtId.getText()));
		if(objCrudsqlAsig.eliminarAsg(mod))
		{
			JOptionPane.showMessageDialog(null, "Asignatura "+ txtNomAsg.getText() + " Eliminada");
			tblAsig.setModel(objCrudsqlAsig.mostrarAsig());

			//limpiar();
		}
		else {
			JOptionPane.showMessageDialog(null, "Error al Eliminar");
		
			//limpiar();
		}
		}
	}
	protected void actionPerformedBtnModificarG(ActionEvent e) {
		
		mod.setNombreA(txtNomAsg.getText());
		mod.setNombreCarrera(String.valueOf(cmbCarrera.getSelectedItem()));
		mod.setNombreNString(String.valueOf(cmbNivel.getSelectedItem()));
		mod.setId(Integer.valueOf(txtId.getText()));
	
		if(objCrudsqlAsig.modificarAsg(mod))
		{
			JOptionPane.showMessageDialog(null, "Registro Modificado");
			tblAsig.setModel(objCrudsqlAsig.mostrarAsig());
			tabbedPane.setSelectedIndex(0);
			btnGuardar.setEnabled(false);
			btnNuevo.setEnabled(true);
			//limpiar();
		}
		else {
			JOptionPane.showMessageDialog(null, "Error al Modificar");
			btnGuardar.setEnabled(true);
			//limpiar();
		}
	}
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		mod.setNombreA(txtBuscar.getText());
		
		
		tblAsig.setModel(objCrudsqlAsig.buscarAsg(mod,0));
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tblAsig) {
			mouseClickedTblAsig(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mouseClickedTblAsig(MouseEvent e) {
		btnModifcar.setEnabled(true);
        btnEliminar.setEnabled(true);
        String id,nombreA , nombreC,nombreN;
        int Fila = tblAsig.getSelectedRow();
        id = tblAsig.getValueAt(Fila, 0).toString();
        nombreA = tblAsig.getValueAt(Fila, 1).toString();
        nombreC = tblAsig.getValueAt(Fila, 2).toString();
        nombreN = tblAsig.getValueAt(Fila, 3).toString();
       txtId.setText(id);
       txtNomAsg.setText(nombreA);
       cmbCarrera.getModel().setSelectedItem(nombreC);
       cmbNivel.getModel().setSelectedItem(nombreN);
		
	}
	
}
