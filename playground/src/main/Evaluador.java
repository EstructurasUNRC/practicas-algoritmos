package main;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.io.FileWriter;
import algoritmos.evaluadores.EvaluadorExpresiones.TipoEvaluacion;
import algoritmos.evaluadores.EvaluadorExpresiones;
import java.util.Map;
import java.util.Map.Entry;

/**
* Evalúa líneas en un archivo de entrada para determinar si cada línea es palíndromo o tiene los paréntesis balanceados.
* El resultado es escrito en un archivo de salida con el mismo nombre que el original pero terminando en {@code _salida.txt}.
* Uso: Evaluador (archivo entrada) (PALINDROMO|PARENTESIS)
* Es posible llamar a Evaluador ayuda para obtener ayuda de como usar este programa.
*/
public class Evaluador {


	private static final String PALINDROMO = "palindromo";
	private static final String PARENTESIS = "parentesis";

	public static void main(String[] args) {
		if (args.length == 1 && args[0].compareToIgnoreCase("ayuda") == 0) {
			imprimirUso();
			return;		
		}
		if (args.length != 2) {
			imprimirUso();
			throw new IllegalArgumentException("uso: Evaluador <archivo entrada> <(PALINDROMO|PARENTESIS)>");
		}	
		String rutaEntrada = args[0];
		String tipoEvaluacion = args[1];
		File entrada = new File(rutaEntrada);
		if (!entrada.exists())
			throw new IllegalArgumentException("Archivo de entrada no existe (" + rutaEntrada + ")");
		if (!entrada.isFile())
			throw new IllegalArgumentException("Archivo de entrada no representa un archivo (" + rutaEntrada + ")");
		if (!entrada.canRead())
			throw new IllegalArgumentException("No se tiene permiso para leer el archivo (" + rutaEntrada + ")");
		TipoEvaluacion evaluacion;		
		switch (tipoEvaluacion.toLowerCase()) {
			case PALINDROMO: {
				evaluacion = TipoEvaluacion.PALINDROMO;
				break;
			}
			case PARENTESIS: {
				evaluacion = TipoEvaluacion.PARENTESIS;
				break;
			}
			default: {
				imprimirUso();
				throw new IllegalArgumentException("Valor inválido para el tipo de evaluación (" + tipoEvaluacion + ")");
			}
		}
		EvaluadorExpresiones evaluador = new EvaluadorExpresiones(entrada, evaluacion);
		Map<String, Boolean> resultados = evaluador.evaluar();
		escribirResultados(resultados, evaluacion, entrada);
	}

	/*
	* Toma los resultados de la evaluación (con EvaluadorExpresiones), el tipo de evaluación, el archivo de entrada
	* y escribe los resultados en un archivo de salida.
	*/
	private static void escribirResultados(Map<String, Boolean> resultados, TipoEvaluacion evaluacion, File entrada) {
		File salida = obtenerArchivoSalida(entrada);
		try {
			if (!salida.createNewFile())
				throw new IOException("Archivo de salida ya existe (" + salida.toString() + ")");
			FileWriter escritor = new FileWriter(salida);
			for (Entry<String, Boolean> resultado : resultados.entrySet()) {
				String linea = resultado.getKey() + " " + evaluacion.mensajeResultado(resultado.getValue());
				escritor.write(linea + "\n");
			}
		        escritor.close();
		} catch (IOException ioe) {
			throw new RuntimeException("Ocurrió un error durante la escritura de los resultados al archivo de salida", ioe);
		}
	}

	/*
	* Obtiene un archivo de salida a partir del archivo de entrada, cambia la extensión del archivo de entrada por
	* _salida.txt
	* Este método no crea el archivo, solo un objeto de tipo File.
	*/
	private static File obtenerArchivoSalida(File entrada) {
		Path directorio = entrada.toPath().getParent();
		String nombreArchivo = entrada.toPath().getFileName().toString();
		String nombreArchivoSinExtension = eliminarExtension(nombreArchivo);
		String nombreArchivoSalida = nombreArchivoSinExtension + "_salida.txt";
		File salida;
		if (directorio != null) {
			salida = Paths.get(directorio.toString(), nombreArchivoSalida).toFile();		
		} else {
			salida = new File(nombreArchivoSalida);
		}
		return salida;
	}

	/*
	* Retorna la subsecuencia de una cadena hasta el primer punto (excluído),
	* si la cadena no contiene punto entonces retorna la cadena original.
	*/
	private static String eliminarExtension(String original) {
		int primerPunto = original.indexOf('.');
		if (primerPunto > 0) {
			return original.substring(primerPunto - 1);
		} else {
			return original;		
		}
	}

	/*
	* Imprime por pantalla las instrucciones de uso para este programa.
	*/
	private static void imprimirUso() {
		String ayuda = "Evaluador de cadenas\n" + 
		"Uso:\n" +
		"java main.Evaluador ayuda     :     muestra este mensaje\n" +
		"java main.Evaluador <archivo> <evaluacion>\n" +
		"Evalúa cada línea en el archivo de entrada de acuerdo a los siguientes modos de evaluación:\n" + 
		"\tPALINDROMO     :     evalúa cada línea del archivo y verifica si es un palíndromo o no\n" +
		"\tPARENTESIS     :     evalúa cada línea del archivo y verifica si tiene paréntesis balanceados\n" +
		"\n" +
		"La salida se escribe en un archivo con el mismo nombre que el de entrada y terminando en _salida.txt\n";
		System.out.println(ayuda);
	}

}
