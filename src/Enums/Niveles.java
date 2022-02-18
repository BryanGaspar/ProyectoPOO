package Enums;
/**
 * @author Brian Bastidas
 * Se crea el enum Niveles
 */
public enum Niveles {
<<<<<<< HEAD
	Default("Seleccion una opción"),Primero("1er. Nivel"), Segundo("2do. Nivel"), Tercero("3er. Nivel"), Cuarto("4to. Nivel"), Quinto("5to. Nivel"),
	Sexto("6to. Nivel"), Septimo("7to. Nivel"), Octavo("8to. Nivel");
=======
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
>>>>>>> 0d73a44bf12f466324042377d692bee3c3a55a67
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