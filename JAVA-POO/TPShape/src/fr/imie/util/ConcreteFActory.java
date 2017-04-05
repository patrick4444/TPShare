package fr.imie.util;

import fr.imie.business.Circle;
import fr.imie.business.IShape;
import fr.imie.business.Polygon;
import fr.imie.business.Rectangle;
import fr.imie.business.ShapeType;
import fr.imie.business.Square;
import fr.imie.business.Triangle;

public class ConcreteFActory implements AbstractFactory {

	@Override
	public IShape buildShape(ShapeType shapeType) {
		IShape out = null;
		switch (shapeType) {
		case Square:
			out = new Square();
			break;
		case Rectangle:
			out = new Rectangle();
			break;
		case Circle:
			out = new Circle();
			break;
		case Polygon:
			out = new Polygon();
			break;
		case Triangle:
			out = new Triangle();
			break;
		default:
			break;
		}

		return out;
	}

}
