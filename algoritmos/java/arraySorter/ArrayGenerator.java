package arraySorter;

import java.util.Random;

/**
* Genera arreglos de {@code Integer} random de una longitud dada.
*
*/
public final class ArrayGenerator {

   /**
   * La longitud por defecto para generar arreglos aleatorios de enteros.
   */
   public static final int DEFAULT_LONGITUD = 10;


   /**
   * Genera un arreglo de enteros con valores aleatorios.
   * Este método es equivalente a <pre>generarArreglo({@code min}, {@code max}, {@value #DEFAULT_LONGITUD}, {@code System.currentTimeMillis()})</pre>
   * @param min el limite inferior del rango de valores a generar
   * @param max el limite superior del rango de valores a generar, no puede ser menor a {@code min}
   * @return un arreglo de {@value #DEFAULT_LONGITUD} enteros aleatorios generados a partir de {@code System.currentTimeMillis()}
   * @see System#currentTimeMillis()
   */
   public static Integer[] generarArreglo(int min, int max) {
      return generarArreglo(min, max, DEFAULT_LONGITUD, System.currentTimeMillis());
   }
   
   /**
   * Genera un arreglo de enteros con valores aleatorios, utilizando una semilla particular.
   * Este método es equivalente a <pre>generarArreglo({@code min}, {@code max}, {@value #DEFAULT_LONGITUD}, {@code semilla})</pre>
   * @param min el limite inferior del rango de valores a generar
   * @param max el limite superior del rango de valores a generar, no puede ser menor a {@code min}
   * @param semilla la semilla utilizada por el generar aleatorio para la secuencia pseudo aleatoria, la misma semilla va a generar el mismo arreglo
   * @return un arreglo de {@value #DEFAULT_LONGITUD} enteros aleatorios generados a partir de {@code semilla}
   */
   public static Integer[] generarArregloConSemilla(int min, int max, long semilla) {
      return generarArreglo(min, max, DEFAULT_LONGITUD, semilla);
   }
   
   /**
   * Genera un arreglo de enteros con valores aleatorios, de una longitud particular.
   * Este método es equivalente a <pre>generarArreglo({@code min}, {@code max}, {@code longitud}, {@code System.currentTimeMillis()})</pre>
   * @param min el limite inferior del rango de valores a generar
   * @param max el limite superior del rango de valores a generar, no puede ser menor a {@code min}
   * @param longitud la cantidad de enteros que va a tener el arreglo, debe ser mayor o igual a {@code 0}
   * @return un arreglo de {@code longitud} enteros aleatorios generados a partir de {@code System.currentTimeMillis()}
   * @see System#currentTimeMillis()
   */
   public static Integer[] generarArregloDeLongitud(int min, int max, int longitud) {
      return generarArreglo(min, max, longitud, System.currentTimeMillis());
   }
   
   /**
   * Genera un arreglo de enteros con valores aleatorios, de una longitud particular, y utilizando una semilla particular.
   * @param min el limite inferior del rango de valores a generar
   * @param max el limite superior del rango de valores a generar, no puede ser menor a {@code min}
   * @param longitud la cantidad de enteros que va a tener el arreglo, debe ser mayor o igual a {@code 0}
   * @param semilla la semilla utilizada por el generar aleatorio para la secuencia pseudo aleatoria, la misma semilla va a generar el mismo arreglo
   * @return un arreglo de {@code longitud} enteros aleatorios generados a partir de {@code semilla}
   */
   public static Integer[] generarArreglo(int min, int max, int longitud, long semilla) {
      if (max < min)
         throw new IllegalArgumentException("El valor de max debe ser mayor o igual al valor de min");
      if (longitud < 0)
         throw new IllegalArgumentException("La longitud debe ser mayor o igual a 0");
      Integer[] arreglo = new Integer[longitud];
      Random rng = new Random(semilla);
      for (int idx = 0; idx < longitud; idx++) {
         arreglo[idx] = generarValorAleatorio(rng, min, max);
      }
      return arreglo;
   }
   
   
   private static Integer generarValorAleatorio(Random rng, int min, int max) {
      Integer valor = rng.nextInt(max - min + 1);
      return valor;
   }

}
