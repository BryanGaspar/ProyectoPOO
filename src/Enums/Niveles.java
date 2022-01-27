package Enums;
/**
 * @author Brian Bastidas
 * Se crea el enum Niveles
 */
public enum Niveles {
	/**
	 * Se delcara el enum Primero
	 */
	Primero("1er. Nivel"),
	/**
	 * Se delcara el enum Segundo
	 */
	Segundo("2do. Nivel"),
	/**
	 * Se delcara el enum Tercero
	 */
	Tercero("3er. Nivel"),
	/**
	 * Se delcara el enum Cuarto
	 */
	Cuarto("4to. Nivel"),
	/**
	 * Se delcara el enum Quinto
	 */
	Quinto("5to. Nivel"),
	/**
	 * Se delcara el enum Sexto
	 */
	Sexto("6to. Nivel"),
	/**
	 * Se delcara el enum Septimo
	 */
	Septimo("7to. Nivel"),
	/**
	 * Se delcara el enum Octavo
	 */
	Octavo("8to. Nivel");
	/**
	 * Se decalata variable String
	 */
	private String imp_nivel;
	/**
	 * 
	 * @param Recibe la variable s
	 */
	Niveles(String s) {
		imp_nivel = s;
	}
	/**
	 * Se delcara metodo ToString
	 */
	public String toString() {
		return imp_nivel;
	}	
}