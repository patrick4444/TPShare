/**
 * 
 */
package fr.imie;

/**
 * @author imiedev
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		IBibliotheque bibliotheque = new Bibliotheque();

		for (Emprunt emprunt : bibliotheque.listerEmprunts()) {
			System.out.println(emprunt);
		}
		

	}

}
