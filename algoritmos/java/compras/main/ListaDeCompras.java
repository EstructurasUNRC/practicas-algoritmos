package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static main.ListaDeCompras.Opcion.*;

//TODO: importar las clases necesarias para almacenar los productos.

/**
* La clase {@code ListaDeCompras} implementa una aplicación simple para administrar una lista de compras.
* Esta clase no utiliza parámetros, la aplicación va leyendo las entradas del usuario hasta que se utilice el comando para salir.
* @version 1.0
*/
public class ListaDeCompras {


	/**
	* El enumerado {@code Opcion} representa las distintas opciones o comandos soportados por la aplicación.
	* Este enumerado ofrece el método estático {@code simboloOpcion()} para determinar cual es el símbolo que se debe anteponer a cada comando.
	* Cada valor en el enumerado implementa los siguientes métodos:
	* <ul>
	*   <li>opcion()	: Retorna el comando asociado a la opción.</li>
	*   <li>descripcion()	: Retorna una descripción de la opción junto a una breve descripción de su comportamiento.</li>
	* </ul>
	*/
	public static enum Opcion {
		AGREGAR {
			
			@Override
			public String opcion() {
				return simboloOpcion() + "agregar";
			}
			
			@Override
			public String descripcion() {
				return  opcion() + " <producto>\n" +
					"Agrega un nuevo producto a la lista de compras.";
			}
			
		},
		LISTAR {
			
			@Override
			public String opcion() {
				return simboloOpcion() + "mostrar";
			}
			
			@Override
			public String descripcion() {
				return  opcion() + "\n" +
					"Lista todos los elementos guardados hasta el momento en la lista de compras.";
			}
			
		},
		SALIR {
		
			@Override
			public String opcion() {
				return simboloOpcion() + "salir";
			}
			
			@Override
			public String descripcion() {
				return  opcion() + "\n" +
					"Sale del programa.";
			}
			
		},
		AYUDA {
		
			@Override
			public String opcion() {
				return simboloOpcion() + "ayuda";
			}
			
			@Override
			public String descripcion() {
				return  opcion() + "\n" +
					"Muestra las instrucciones de uso de este programa.";
			}
		
		};
		
		public static String simboloOpcion() {
			return ":";
		}
		
		public abstract String opcion();
		public abstract String descripcion();
	}
	
	
	//TODO: agregue una lista global para almacenar los productos
	
	/**
	* Un simple manejador de lista de compras, este programa no toma parámetros de entrada, es una aplicación interactiva.
	* Los comandos soportados por esta aplicación están definidos en el enumerado {@code Opcion}.
	* @param args los argumentos de la aplicación, no son utilizados.
	*/
	public static void main(String[] args) {
		bienvenida();
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			boolean salir = false;
			do {
				String entrada = reader.readLine();
				salir = responderAEntrada(entrada);
			} while (!salir);
			
			reader.close();

		} catch (IOException e) {
			e.printStackTrace(System.err);
			System.exit(2);
		}
	}
	
	private static boolean responderAEntrada(String entrada) {
		if (entrada.trim().isEmpty())
			return false;
		String[] args = entrada.split(" ", 2);
		String comando = args[0];
		if (!comando.startsWith(Opcion.simboloOpcion()))
			return false;
		if (comando.compareToIgnoreCase(AGREGAR.opcion()) == 0) {
			if (args.length < 2) {
				System.err.println("El commando " + AGREGAR.opcion() + " espera un argumento especificando el producto a agregar.");
				return false;
			}
			String producto = args[1];
			//TODO: agregar el producto a la lista de productos.
			return false;
		} else if (comando.compareToIgnoreCase(LISTAR.opcion()) == 0) {
			//TODO: imprimir todos los productos en la lista de productos.
		} else if (comando.compareToIgnoreCase(SALIR.opcion()) == 0) {
			return true;
		} else if (comando.compareToIgnoreCase(AYUDA.opcion()) == 0) {
			System.out.println("ListaDeCompras");
			System.out.println("Una simple aplicación para administrar una lista de compras.\n");
			System.out.println("Modo de uso: ");
			for (Opcion opcion : values()) {
				System.out.println(opcion.descripcion());
			}
			System.out.println();
			return false;
		} else {
			System.err.println("Comando " + comando + " no reconocido.\nUtilice " + AYUDA.opcion() + " para obtener ayuda de como utilizar la aplicación.");
			return false;
		}
		return false;
	}
	
	private static void bienvenida() {
		String mensajeDeInicio = "ListaDeCompras, una simple lista de compras.\n" +
					 "Una simple aplicación para adminisrar una lista de compras.\n" +
					 "Escriba " + AYUDA.opcion() + " para obtener ayuda de como utilizar la aplicación.\n"
		;
		System.out.println(mensajeDeInicio);
	} 




}
