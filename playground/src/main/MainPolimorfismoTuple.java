package main;

import polimorfism.Tuple;
import polimorfism.TupleGen;
import polimorfism.TupleGenSame;
import polimorfism.Racional;

public class MainPolimorfismoTuple {

	public static void main(String[] args) {
		Tuple tuple = new Tuple(new Racional(1,2), "Hola Mundo!");
		//Es necesario castear los elementos a sus tipos correspondientes al accederlos		
		//Racional r = (Racional) tuple.first();
		//String s = (String) tuple.second();
		System.out.println(tuple.toString());
		//puedo reemplazar el segundo elemento de la tupla por cualquier cosa		
		tuple.setSecond(new Integer(3));
		System.out.println(tuple.toString());
		TupleGen<Racional, String> tupleGen = new TupleGen<>(new Racional(8,3), "Usa la fuerza Luke!");
		//No es necesario castear los elementos		
		//Racional r = tupleGen.first();
		//String s = tupleGen.second();
		//no puedo reemplazar un elemento de la tupla por un tipo distinto con el que se creo originalmente
		//tupleGen.setSecond(new Integer(3)); //esto no compila
		System.out.println(tupleGen.toString());
		//Escribir una clase sin contenido usualmente no es buena idea, pero TupleGenSame es un ejemplo de como extender una clase con genericidad
		TupleGenSame<String> tupleGenSame = new TupleGenSame("Hola", "Mundo!");
		System.out.println(tupleGenSame.toString());
	}

}
