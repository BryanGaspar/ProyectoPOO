package Clases;

import Conexiones.Conexion;

public class Estudiante extends Conexion{
/**
 * @author Brian Bastidas
 * Se crea la class Estudiante
 */
//public class Estudiante {
	/**
	 * Se declaran variables
	 */
	private int cedula;
	private int id;
	private String nombres;
	private String apellidos;
	private String direccion;
	private String email;
	private int telefono;
	private String genero;
	private String fechaNac;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Metodos getters
	 * @param admin
	 */
	public int getCedula() {
		return cedula;
	}
	/**
	 * Metodos setters 
	 * @param admin
	 */
	public void setCedula(int cedula) {
		this.cedula = cedula;
	}
	/**
	 * Metodos getters
	 * @param admin
	 */
	public String getNombres() {
		return nombres;
	}
	/**
	 * Metodos setters 
	 * @param admin
	 */
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	/**
	 * Metodos getters
	 * @param admin
	 */
	public String getApellidos() {
		return apellidos;
	}
	/**
	 * Metodos setters 
	 * @param admin
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	/**
	 * Metodos getters
	 * @param admin
	 */
	public String getDireccion() {
		return direccion;
	}
	/**
	 * Metodos setters 
	 * @param admin
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	/**
	 * Metodos getters
	 * @param admin
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * Metodos setters 
	 * @param admin
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * Metodos getters
	 * @param admin
	 */
	public int getTelefono() {
		return telefono;
	}
	/**
	 * Metodos setters 
	 * @param admin
	 */
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	/**
	 * Metodos getters
	 * @param admin
	 */
	public String getGenero() {
		return genero;
	}
	/**
	 * Metodos setters 
	 * @param admin
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}
	/**
	 * Metodos getters
	 * @param admin
	 */
	public String getFechaNac() {
		return fechaNac;
	}
	/**
	 * Metodos setters 
	 * @param admin
	 */
	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}
}