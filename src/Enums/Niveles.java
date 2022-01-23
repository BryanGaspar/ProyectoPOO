package Enums;

public enum Niveles {
	Primero("1er. Nivel"), Segundo("2do. Nivel"), Tercero("3er. Nivel"), Cuarto("4to. Nivel"), Quinto("5to. Nivel"),
	Sexto("6to. Nivel"), Septimo("7to. Nivel"), Octavo("8to. Nivel");
	private String imp_nivel;
	
	Niveles(String s) {
		imp_nivel = s;
	}
	
	public String toString() {
		return imp_nivel;
	}
	
}
