/**
 * 
 */
package fr.imie.runner;

import fr.imie.presentation.ShapePresentation;
import fr.imie.util.AbstractFactory;
import fr.imie.util.ConcreteFActory;

/**
 * @author imiedev
 *
 */
public class ShapeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AbstractFactory factory = new ConcreteFActory();
		ShapePresentation presentation = new ShapePresentation(factory);
		presentation.start();
	}



}
