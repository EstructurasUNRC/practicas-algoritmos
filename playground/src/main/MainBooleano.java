package main;

import datos.booleanos.*;

public class MainBooleano {
  
  
	/**
	* Prueba de uso del TAD Booleano.
	* @param args entrada por consola.
	*/
	public static void main(String[] args) {
		Booleano v = BooleanoParImpar.verdadero();
		Booleano f = BooleanoNat.falso();

		System.out.println("V and V = " + v.conjuncion(v).toString()); 
		System.out.println("F and V = " + f.conjuncion(v).toString());  
		System.out.println("F and F = " + f.conjuncion(f).toString());  
		System.out.println("not V = " + v.negacion().toString()); 
		System.out.println("not F = " + f.negacion().toString()); 
		System.out.println("V or V = " + v.disyuncion(v).toString()); 
		System.out.println("F or V = " + f.disyuncion(v).toString()); 
		System.out.println("F or F = " + f.disyuncion(f).toString()); 
	}

}
