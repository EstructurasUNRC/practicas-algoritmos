package main;

import polimorfism.InsertionList;
import polimorfism.Racional;
import polimorfism.ValuePrinter;

public class MainPolimorfismo {

	public static void main(String[] args) {
		InsertionList<Integer> insertionListOfIntegers = new InsertionList<>();
		insertionListOfIntegers.add(8);
		insertionListOfIntegers.add(3);
		insertionListOfIntegers.add(5);
		insertionListOfIntegers.add(1);
		insertionListOfIntegers.add(4);
		insertionListOfIntegers.add(9);
		System.out.println(insertionListOfIntegers.toString());
		InsertionList<Racional> insertionListOfRacionals = new InsertionList<>();
		insertionListOfRacionals.add(new Racional(8,3));
		insertionListOfRacionals.add(new Racional(1,2));
		insertionListOfRacionals.add(new Racional(1,5));
		insertionListOfRacionals.add(new Racional(4,2));
		insertionListOfRacionals.add(new Racional(15,4));
		System.out.println(insertionListOfRacionals.toString());
		ValuePrinter commaSeparatedPrinter = new ValuePrinter(',');
		System.out.println(commaSeparatedPrinter.toString(1, 2));
		System.out.println(commaSeparatedPrinter.toString(2.0f));
		System.out.println(commaSeparatedPrinter.toString(new Object[] {new Racional(15,4), "Hola", new Integer(3), new Float(4.5f), Boolean.TRUE}));
	}

}
