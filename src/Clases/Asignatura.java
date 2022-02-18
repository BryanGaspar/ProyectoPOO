package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import Conexiones.Conexion;

public class Asignatura {
	String nombreA;
	String nombreNString;
	String nombreCarrera;
	int id;

	public Asignatura(String nombreA, String nombreNString, String nombreCarrera, int id) {
	
		this.nombreA = nombreA;
		this.nombreNString = nombreNString;
		this.nombreCarrera = nombreCarrera;
		this.id = id;
	}
	public Asignatura() {
		
	
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombreA() {
		return nombreA;
	}
	public void setNombreA(String nombreA) {
		this.nombreA = nombreA;
	}
	public String getNombreNString() {
		return nombreNString;
	}
	public void setNombreNString(String nombreNString) {
		this.nombreNString = nombreNString;
	}
	

	
	public String getNombreCarrera() {
		return nombreCarrera;
	}
	public void setNombreCarrera(String nombreCarrera) {
		this.nombreCarrera = nombreCarrera;
	}
	public String toString() {
		return this.nombreA;
	}
	
}
