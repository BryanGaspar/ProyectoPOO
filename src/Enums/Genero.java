package Enums;

public enum Genero {
	Default("Seleccion una opci�n"),MALE("Masculino"), FEMALE("Femenino"), OTHER("Otro");
	private String imp_genero;
	
	Genero(String s) {
		imp_genero = s;
	}
	
	public String toString() {
		return imp_genero;
	}
}
