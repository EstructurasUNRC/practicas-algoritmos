package arraySorter;

import java.util.Arrays;

/**
* Clase ejecutable para demostrar el uso de {@code ArraySorter}
* @see arraySorter.ArraySorter
* @see arraySorter.ArrayGenerator
*/
public class Main {

   public static void main(String[] args) {

      Integer[] arreglo = ArrayGenerator.generarArregloDeLongitud(0, 100, 10);
      System.out.println("Arreglo random, tamaño 10 y valores entre 0 y 100:\n" + Arrays.toString(arreglo));
      ArraySorter.bubbleSort(arreglo);
      System.out.println("Arreglo ordenado con BubbleSort:\n" + Arrays.toString(arreglo));

      arreglo = ArrayGenerator.generarArregloDeLongitud(0, 100, 30);
      System.out.println("Arreglo random, tamaño 30 y valores entre 0 y 100:\n" + Arrays.toString(arreglo));
      ArraySorter.selectionSort(arreglo);
      System.out.println("Arreglo ordenado con SelectionSort:\n" + Arrays.toString(arreglo));

   }

   @SuppressWarnings("unchecked")
    private static <E> E[] crearArreglo(int elementos) {
        return (E[]) new Object[elementos];
    }

}
