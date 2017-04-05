package fr.imie.presentation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fr.imie.business.IShape;
import fr.imie.business.ShapeType;
import fr.imie.util.AbstractFactory;

public class ShapePresentation {

	List<IShape> shapes = new ArrayList<>();
	AbstractFactory factory;

	
	public ShapePresentation(AbstractFactory factory) {
		super();
		this.factory = factory;
	}

	public void start(){
		
		String response ="";
		
		do{
		
			System.out.println("Quel type de forme voulez vous créeer?");
			Integer choiceCounter = 1;
			for (ShapeType shapeType: ShapeType.values()) {
				System.out.format("%S - %s\n",choiceCounter,shapeType.getLabel());
				choiceCounter++;
			}
			System.out.println("X - Sortir");
			

			
			Scanner sc = new Scanner(System.in);
			response = sc.nextLine();
			if (response.equals("X")){
				break;
			}
			
			
			Integer choice = Integer.parseInt(response);
			ShapeType shapeTypeChoiced = ShapeType.values()[choice-1];
			String[] parametersLabel = shapeTypeChoiced.getInitParams();
			
			Float[] params;
			IShape myShape= factory.buildShape(shapeTypeChoiced);
			
			params = typeParams(sc, parametersLabel);
			myShape.initialise(params);
			
			shapes.add(myShape);
			printAreaOf(myShape);
			printPerimeterOf(myShape);
		}
		while(!response.equals("X"));

		this.displayAreaSum();
		
	}

	private Float[] typeParams(Scanner sc, String[] parametersLabel) {
		String response;
		Float[] params = new Float[parametersLabel.length];
		Integer paramNum = 0;
		for (String parameter : parametersLabel) {
			System.out.format("saisir la valeur du paramètre %S\n", parameter);
			response = sc.nextLine();
			params[paramNum] = Float.parseFloat(response);
			paramNum++;
		}
		return params;
	}

	public void printAreaOf(IShape shape) {
		System.out.format("L'aire de mon %S est de %S\n", shape.getClass().getSimpleName(), shape.area());

	}

	public void printPerimeterOf(IShape shape) {
		System.out.format("Le périmètre de mon %S est de %S\n", shape.getClass().getSimpleName(), shape.perimeter());

	}

	private void displayAreaSum() {
		Float sum = 0f;
		for (IShape shape : shapes) {
			sum += shape.area();
		}
		System.out.format("La somme des aires est de %S\n", sum);

	}

}
