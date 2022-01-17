package ProyectoPooParte3;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;

public class MatriculacionEst extends JInternalFrame {
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField txtEst;
	private JComboBox cmbCarrera;
	private JComboBox cmbMaterias;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JComboBox cmbNivel;
	private JComboBox cmbPeriodo;
	private JButton btnNueva;
	private JButton btnGuardarInscripcion;
	private JButton btnCancelar;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MatriculacionEst frame = new MatriculacionEst();
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
	public MatriculacionEst() {
		setTitle("Matriculacion");
		setBounds(100, 100, 911, 426);
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Datos Matricula", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panel.setBounds(10, 11, 699, 374);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("Estudiante:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(25, 33, 74, 15);
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Carrera:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(25, 80, 56, 14);
		panel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Materias:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(25, 125, 56, 14);
		panel.add(lblNewLabel_2);
		
		txtEst = new JTextField();
		txtEst.setEditable(false);
		txtEst.setBounds(95, 31, 248, 20);
		panel.add(txtEst);
		txtEst.setColumns(10);
		
		cmbCarrera = new JComboBox();
		cmbCarrera.setBounds(98, 77, 245, 22);
		panel.add(cmbCarrera);
		
		cmbMaterias = new JComboBox();
		cmbMaterias.setBounds(95, 122, 248, 22);
		panel.add(cmbMaterias);
		
		lblNewLabel_3 = new JLabel("Nivel:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(387, 33, 46, 15);
		panel.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Periodo:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(387, 81, 46, 14);
		panel.add(lblNewLabel_4);
		
		cmbNivel = new JComboBox();
		cmbNivel.setBounds(443, 30, 230, 22);
		panel.add(cmbNivel);
		
		cmbPeriodo = new JComboBox();
		cmbPeriodo.setBounds(443, 77, 230, 22);
		panel.add(cmbPeriodo);
		
		table = new JTable();
		table.setBounds(10, 174, 667, 189);
		panel.add(table);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Opciones", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(717, 11, 161, 374);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		btnNueva = new JButton("Nueva Inscripcion");
		btnNueva.setBounds(10, 56, 141, 58);
		panel_1.add(btnNueva);
		
		btnGuardarInscripcion = new JButton("Guardar Inscripcion");
		btnGuardarInscripcion.setBounds(10, 158, 141, 58);
		panel_1.add(btnGuardarInscripcion);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(10, 252, 141, 65);
		panel_1.add(btnCancelar);

	}
}
