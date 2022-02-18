package Enums;
/**
 * @author Brian Bastidas
 * Se crea el enum Genero
 */
public enum Genero {
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
