package Enums;

public enum Carreras {
	Default("Seleccion una opción"),Uno("Tecnologias de la Información"), Dos("Medicina"), Tres("Agroindustrias"), Cuatro("Contabilidad y Auditoria"),
	Cinco("Diseño Grafico");
	private String imp_carrera;
	
	Carreras(String c) {
		imp_carrera = c;
	}
	
	public String toString() {
		return imp_carrera;
	}
	
}
