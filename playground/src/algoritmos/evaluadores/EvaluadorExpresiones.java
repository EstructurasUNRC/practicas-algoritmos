package algoritmos.evaluadores;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import colecciones.cola.Cola;
import colecciones.pila.Pila;
//import colecciones.pila. la implementación de Pila que quieren usar
//import colecciones.cola. la implementación de Cola que quieren usar

/**
* Evaluador de expresiones (cadenas), permite evaluar si una cadena es o no un palíndromo, y también si tiene los paréntesis balanceados.
* El modo de evaluación se define mediante el enumerado {@code TipoEvaluacion}
* @see EvaluadorExpresiones.TipoEvaluacion
*/
public class EvaluadorExpresiones {

	/**
	* Modos de evaluación disponibles para {@code EvaluadorExpresiones}
	*/
	public static enum TipoEvaluacion {
		/**
		* Modo de evaluación que determina si una cadena es un palíndromo
		*/
		PALINDROMO {
			@Override
			public String mensajeResultado(boolean resultado) {
				if (resultado)
					return "es palíndromo";
				return "no es palíndromo";			
			}
		},
		/**
		* Modo de evaluación que determina si una cadena tiene los paréntesis balanceados
		*/
		PARENTESIS {
			@Override
			public String mensajeResultado(boolean resultado) {
				if (resultado)
					return "tiene los paréntesis balanceados";
				return "no tiene los paréntesis balanceados";
			}
		}
		;
		/**
		* Permite obtener una representación del resultado de una evaluación de acuerdo al modo utilizado.
		* @param resultado el resultado de la evaluación
		* @return una cadena con la representación apropiada del resultado
		*/
		public abstract String mensajeResultado(boolean resultado);
	}

	/*
	* El archivo que contiene las líneas a evaluar.
	*/
	private File archivoEntrada;
	/*
	* El modo de evaluación a utilizar.
	*/
	private TipoEvaluacion modoEvaluacion;
	

	/**
	* Constructor apto para rutas en forma de cadena.
	* @param archivoEntrada representa una ruta válida a un archivo existente y con permiso de lectura
	* @param modoEvaluacion el modo de evaluación
	* @see EvaluadorExpresiones.TipoEvaluacion
	*/
	public EvaluadorExpresiones(String archivoEntrada, TipoEvaluacion modoEvaluacion) {
		this(new File(archivoEntrada), modoEvaluacion);
	}

	/**
	* Constructor apto para rutas definidas por un {@code Path}.
	* @param archivoEntrada una ruta válida a un archivo existente y con permiso de lectura
	* @param modoEvaluacion el modo de evaluación
	* @see EvaluadorExpresiones.TipoEvaluacion
	*/
	public EvaluadorExpresiones(Path archivoEntrada, TipoEvaluacion modoEvaluacion) {
		this(archivoEntrada.toFile(), modoEvaluacion);
	}

	/**
	* Constructor apto para archivos ({@code File}).
	* @param archivoEntrada un archivo existente y con permiso de lectura
	* @param modoEvaluacion el modo de evaluación
	* @see EvaluadorExpresiones.TipoEvaluacion
	*/
	public EvaluadorExpresiones(File archivoEntrada, TipoEvaluacion modoEvaluacion) {
		if (archivoEntrada == null)
			throw new IllegalArgumentException("Archivo de entrada es nulo");
		if (modoEvaluacion == null)
			throw new IllegalArgumentException("Tipo de evaluacion es nulo");
		if (!archivoEntrada.exists())
			throw new IllegalArgumentException("Archivo de entrada no existe (" + archivoEntrada + ")");
		if (!archivoEntrada.isFile())
			throw new IllegalArgumentException("Archivo de entrada no representa un archivo (" + archivoEntrada + ")");
		if (!archivoEntrada.canRead())
			throw new IllegalArgumentException("No se tiene permiso para leer el archivo (" + archivoEntrada + ")");
		this.archivoEntrada = archivoEntrada;
		this.modoEvaluacion = modoEvaluacion;
	}

	/**
	* Evalúa cada línea en el archivo según el modo de evaluación y retorna un mapa (línea, resultado).
	* @return un mapa conteniendo para cada línea del archivo de entrada, el resultado obtenido de acuerdo al modo de evaluación
	* @see EvaluadorExpresiones.TipoEvaluacion
	*/
	public Map<String, Boolean> evaluar() {
		try {
			Map<String, Boolean> resultados = new HashMap<>();
			for (String line : Files.readAllLines(archivoEntrada.toPath())) {
				switch (modoEvaluacion) {
					case PALINDROMO: {
						resultados.put(line, esPalindromo(line));
						break;					
					}
					case PARENTESIS: {
						resultados.put(line, parentesisBalanceados(line));
						break;					
					}
				}
		    	}
			return resultados;
		} catch (IOException x) {
		    throw new IllegalStateException("Hubo un error al leer las líneas del archivo de entrada", x);
		}
	}

	/*
	* Utilizando una Pila y una Cola, este método determina si una cadena es palíndromo.
	*/
	private boolean esPalindromo(String cadena) {
		throw new UnsupportedOperationException("Método no implementado, implementar y reemplazar esta excepción");	
	}

	/*
	* Utilizando una Pila, este método determina si una cadena tiene paréntesis balanceados.
	*/
	private boolean parentesisBalanceados(String cadena) {
		throw new UnsupportedOperationException("Método no implementado, implementar y reemplazar esta excepción");
	}
	

}
