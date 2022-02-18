package Enums;

public enum Carreras {
	Default("Seleccion una opci�n"),Uno("Tecnologias de la Informaci�n"), Dos("Medicina"), Tres("Agroindustrias"), Cuatro("Contabilidad y Auditoria"),
	Cinco("Dise�o Grafico");
	private String imp_carrera;
	
	Carreras(String c) {
		imp_carrera = c;
	}
	
	public String toString() {
		return imp_carrera;
	}
	
}
