package ProyectoPooParte2;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import Clases.Carrera;
import Conexiones.crudsqlCarr;
import Enums.Genero;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class RegistroCarreras extends JInternalFrame implements ActionListener, MouseListener {
	private JTabbedPane tabbedPane;
	private JPanel pnlCarreras;
	private JPanel pnlNuevo;
	private JPanel panel;
	private JTable tblCarrera;
	private JButton btnGuardar;
	private JButton btnNuevo;
	private JButton btnEditar;
	private JButton btnEliminar;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField txtNomCarr;
	private JTextField txtDesc;
	private crudsqlCarr objcrud = new crudsqlCarr();
	private Carrera mod = new Carrera();
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
		setTitle("Carreras");
		setClosable(true);
		setBounds(100, 100, 786, 401);
		getContentPane().setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 618, 360);
		getContentPane().add(tabbedPane);
		
		pnlCarreras = new JPanel();
		tabbedPane.addTab("Listado-Carreras", null, pnlCarreras, null);
		pnlCarreras.setLayout(null);
		
		tblCarrera = new JTable();
		tblCarrera.addMouseListener(this);
		tblCarrera.setBounds(10, 11, 582, 321);
		tblCarrera.setModel(objcrud.mostrarCarreras());
		pnlCarreras.add(tblCarrera);
		
		pnlNuevo = new JPanel();
		tabbedPane.addTab("Nuevo/Modificar", null, pnlNuevo, null);
		pnlNuevo.setLayout(null);
		
		lblNewLabel = new JLabel("Nombre de la Carrera:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(67, 63, 125, 14);
		pnlNuevo.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Descripci\u00F3n (opcional):");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(67, 164, 125, 18);
		pnlNuevo.add(lblNewLabel_1);
		
		txtNomCarr = new JTextField();
		txtNomCarr.setBounds(202, 61, 244, 18);
		pnlNuevo.add(txtNomCarr);
		txtNomCarr.setColumns(10);
		
		txtDesc = new JTextField();
		txtDesc.setBounds(202, 164, 244, 20);
		pnlNuevo.add(txtDesc);
		txtDesc.setColumns(10);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Opciones", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(628, 23, 132, 337);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(this);
		btnGuardar.setIcon(new ImageIcon(RegistroCarreras.class.getResource("/ProyectoPoo/ImagenesProyecto/folder-3-16.png")));
		btnGuardar.setBounds(10, 97, 102, 47);
		panel.add(btnGuardar);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(this);
		btnNuevo.setIcon(new ImageIcon(RegistroCarreras.class.getResource("/ProyectoPoo/ImagenesProyecto/add-image-16.png")));
		btnNuevo.setBounds(10, 35, 102, 47);
		panel.add(btnNuevo);
		
		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(this);
		btnEditar.setIcon(new ImageIcon(RegistroCarreras.class.getResource("/ProyectoPoo/ImagenesProyecto/edit-property-16.png")));
		btnEditar.setBounds(10, 165, 102, 47);
		panel.add(btnEditar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setIcon(new ImageIcon(RegistroCarreras.class.getResource("/ProyectoPoo/ImagenesProyecto/delete-16.png")));
		btnEliminar.setBounds(10, 234, 102, 47);
		panel.add(btnEliminar);

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnEditar) {
			actionPerformedBtnEditar(e);
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
		
		btnGuardar.setEnabled(true);
		limpiar();
	}
	protected void actionPerformedBtnGuardar(ActionEvent e) {
		mod.setCarreras(txtNomCarr.getText());
		mod.setDescripcion(txtDesc.getText());
		
		if(objcrud.registrarCarr(mod))
		{
			JOptionPane.showMessageDialog(null, "Registro Guardado");
			tblCarrera.setModel(objcrud.mostrarCarreras());
			tabbedPane.setSelectedIndex(0);
			tabbedPane.setEnabledAt(1, false);
			btnGuardar.setEnabled(false);
			btnNuevo.setEnabled(true);
			limpiar();
		}
		else {
			JOptionPane.showMessageDialog(null, "Error al Guardar");
			btnGuardar.setEnabled(true);
			limpiar();
		}
		
	}
	
	
	protected void actionPerformedBtnEditar(ActionEvent e) {
		tabbedPane.setSelectedIndex(1);

		btnGuardar.setVisible(false);
		//btnGuardarM.setVisible(true);
		
		
	}
	
	
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		mod.setCarreras(txtNomCarr.getText());

		if(objcrud.eliminarCarr(mod))
		{
			JOptionPane.showMessageDialog(null, "Usuario:" + txtNomCarr.getText() + " Eliminado");
			tblCarrera.setModel(objcrud.mostrarCarreras());

			limpiar();
		}
		else {
			JOptionPane.showMessageDialog(null, "Error al Eliminar");
		
			limpiar();
		}
		
	}
	
	
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tblCarrera) {
			mouseClickedTblCarrera(e);
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
	protected void mouseClickedTblCarrera(MouseEvent e) {
		btnEditar.setEnabled(true);
        btnEliminar.setEnabled(true);
        String nombreC , descC;
        int Fila = tblCarrera.getSelectedRow();
        nombreC = tblCarrera.getValueAt(Fila, 0).toString();
        descC = tblCarrera.getValueAt(Fila, 1).toString();
       
       txtNomCarr.setText(nombreC);
       txtDesc.setText(descC);
       
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void limpiar()
	{
		txtNomCarr.setText(null);
		txtDesc.setText(null);
	
	}
}
