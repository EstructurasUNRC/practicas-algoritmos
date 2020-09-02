package ejercicio11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LectorDeArchivos {

	/* Uso: LectorDeArchivos archivo.txt n, donde:
		- archivo.txt es el nombre de un archivo de texto valido
		- n es un entero
		*/
	public static void main(String [] args) {
		if (args.length != 2) 
			System.out.println("Error en los argumentos. Invocar con LectorDeArchivos archivo.txt n");
	
		try {
			BufferedReader reader = new BufferedReader(new FileReader(args[0]));
			/* TODO: Actualmente imprime todo el archivo. Modificar para que imprima 
				solo las ultimas n lineas
				*/
			String linea;
			while ((linea = reader.readLine()) != null) {
				System.out.println(linea);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Error al leer el archivo: " + args[0]);
		}
	}

}

