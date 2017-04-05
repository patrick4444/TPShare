/**
 * 
 */
package fr.imie.util;

import fr.imie.business.IShape;
import fr.imie.business.ShapeType;

/**
 * @author imiedev
 *
 */
public interface AbstractFactory {
	
	public abstract IShape buildShape(ShapeType shapeType);

}
