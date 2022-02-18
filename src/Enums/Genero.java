package Enums;
/**
 * @author Brian Bastidas
 * Se crea el enum Genero
 */
public enum Genero {
<<<<<<< HEAD
	Default("Seleccion una opción"),MALE("Masculino"), FEMALE("Femenino"), OTHER("Otro");
=======
	/**
	 * Decalarar enum MALE
	 */
	MALE("Masculino"),
	/**
	 * Decalarar enum MALE
	 */
	FEMALE("Femenino"),
	/**
	 * Decalarar enum OTHER
	 */
	OTHER("Otro");
	/**
	 * Se decalata variable String
	 */
>>>>>>> 0d73a44bf12f466324042377d692bee3c3a55a67
	private String imp_genero;
	/**
	 * 
	 * @param Recibe la variable s
	 */
	Genero(String s) {
		imp_genero = s;
	}
	/**
	 * Se delcara metodo ToString
	 */
	public String toString() {
		return imp_genero;
	}
}