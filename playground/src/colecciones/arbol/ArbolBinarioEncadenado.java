package colecciones.arbol;

import colecciones.arbol.ArbolBinario.Orden;
import java.util.List;
import java.util.LinkedList;

/**
* Una implementación de {@code ArbolBinario} mediante nodos encadenados (un nodo con referencia a un nodo izquierdo y otro derecho).
* Esta implementación provee tres métodos estáticos para construir árboles:
* <ul>
* <li>arbolVacio()                                                         : construye un nuevo árbol vacío.</li>
* <li>hoja({@code T})                                                      : construye un árbol con una raíz y sin subarboles.</li>
* <li>arbol({@code T}, {@code ArbolBinario<T>}, {@code ArbolBinario<T>})   : construye un árbol a partir de una raíz y un subarbol izquierdo y uno derecho.</li>
* </ul>
* @param T el tipo del valor asociado a cada nodo del árbol.
* @see NodoBinario
*/
public class ArbolBinarioEncadenado<T> implements ArbolBinario<T> {

   private NodoBinario<T> raiz;

   /**
   * Construye un nuevo árbol vacío.
   * @param <E> el tipo del valor asociado a cada nodo del árbol.
   * @return un nuevo árbol vacío.
   */
   public static <E> ArbolBinarioEncadenado<E> arbolVacio() {
      return new ArbolBinarioEncadenado<>(null, null, null);
   }
   
   /**
   * Construye un árbol con una raíz y sin subarboles.
   * @param <E> el tipo del valor asociado a cada nodo del árbol.
   * @param valor el valor de la raíz
   * @return un nuevo árbol con solo un nodo raíz
   */
   public static <E> ArbolBinarioEncadenado<E> hoja(E valor) {
      return new ArbolBinarioEncadenado<>(valor, null, null);
   }
   
   /**
   * Construye un árbol a partir de una raíz y un subarbol izquierdo y uno derecho.
   * @param <E> el tipo del valor asociado a cada nodo del árbol.
   * @param raiz valor el valor de la raíz, no puede ser {@code null}
   * @param subArbolIzquierdo el subarbol izquierdo, puede ser {@code null}
   * @param subArbolDerecho el subarbol derecho, puede ser {@code null}
   * @return un nuevo árbol con una raíz con el valor {@code raiz} y los subarboles izquierdo y derecho correspondientes a los argumentos
   */
   public static <E> ArbolBinarioEncadenado<E> arbol(E raiz, ArbolBinario<E> subArbolIzquierdo, ArbolBinario<E> subArbolDerecho) {
      ArbolBinarioEncadenado<E> nuevoArbol = new ArbolBinarioEncadenado<>(raiz, transformarEnArbolEncadenado(subArbolIzquierdo).raiz, transformarEnArbolEncadenado(subArbolDerecho).raiz);
      return nuevoArbol;
   }
   
   /* (non-Javadoc)
   * Convierte un ArbolBinario a un ArbolBinarioEncadenado.
   */
   private static <E> ArbolBinarioEncadenado<E> transformarEnArbolEncadenado(ArbolBinario<E> arbol) {
      throw new UnsupportedOperationException("TODO: implementar");
   }
   
   private ArbolBinarioEncadenado(T raiz, NodoBinario<T> subArbolIzquierdo, NodoBinario<T> subArbolDerecho) {
      if (raiz == null && (subArbolIzquierdo != null || subArbolDerecho != null))
         throw new IllegalArgumentException("raiz solo puede ser null cuando todos los argumentos son null");
      this.raiz = NodoBinario.nuevaHoja(raiz);
      this.raiz.izquierdo(subArbolIzquierdo);
      this.raiz.izquierdo(subArbolDerecho);
   }
   
   /**{@inheritDoc}*/
   @Override
   public ArbolBinario<T> unirADerecha(T raiz, ArbolBinario<T> subArbolIzquierdo) {
      throw new UnsupportedOperationException("TODO: implementar");
   }
   
   /**{@inheritDoc}*/
   @Override
   public ArbolBinario<T> unirAIzquierda(T raiz, ArbolBinario<T> subArbolDerecho) {
      throw new UnsupportedOperationException("TODO: implementar");
   }
   
   /**{@inheritDoc}*/
   @Override
   public void vaciar() {
      throw new UnsupportedOperationException("TODO: implementar");
   }
   
   /**{@inheritDoc}*/
   @Override
   public T raiz() {
      return raiz.valor();
   }

   /**{@inheritDoc}*/
   @Override
   public ArbolBinario<T> subArbolIzquierdo() {
      throw new UnsupportedOperationException("TODO: implementar");
   }
   
   /**{@inheritDoc}*/
   @Override
   public ArbolBinario<T> subArbolDerecho() {
      throw new UnsupportedOperationException("TODO: implementar");
   }
   
   /**{@inheritDoc}*/
   @Override
   public int elementos() {
      throw new UnsupportedOperationException("TODO: implementar");
   }
   
   /**{@inheritDoc}*/
   @Override
   public int altura() {
      throw new UnsupportedOperationException("TODO: implementar");
   }
   
   /**{@inheritDoc}*/
   @Override
   public boolean esVacio() {
      throw new UnsupportedOperationException("TODO: implementar");
   }
   
   /**{@inheritDoc}*/
   @Override
   public List<T> aLista() {
      return aLista(Orden.INORDER);
   }
   
   /**{@inheritDoc}*/
   @Override
   public List<T> aLista(Orden orden) {
      List<T> elementos = new LinkedList<>();
      switch (orden) {
         case INORDER : return aListaInOrder(raiz, elementos);
         case PREORDER : return aListaPreOrder(raiz, elementos);
         case POSTORDER : return aListaPostOrder(raiz, elementos);
      }
      return elementos;
   }
   
   /* (non-Javadoc)
   * Este método toma un nodo (que puede ser null), una lista de elementos (que no puede ser null)
   * y va llenando la lista con los elementos del árbol según un recorrido in order.
   * Si bien el prefil está pensando para una implementación recursiva, puede probar con una implementación iterativa.
   */
   private List<T> aListaInOrder(NodoBinario<T> raiz, List<T> elementos) {
      throw new UnsupportedOperationException("TODO: implementar");
   }
   
   /* (non-Javadoc)
   * Este método toma un nodo (que puede ser null), una lista de elementos (que no puede ser null)
   * y va llenando la lista con los elementos del árbol según un recorrido pre order.
   * Si bien el prefil está pensando para una implementación recursiva, puede probar con una implementación iterativa.
   */
   private List<T> aListaPreOrder(NodoBinario<T> raiz, List<T> elementos) {
      throw new UnsupportedOperationException("TODO: implementar");
   }
   
   /* (non-Javadoc)
   * Este método toma un nodo (que puede ser null), una lista de elementos (que no puede ser null)
   * y va llenando la lista con los elementos del árbol según un recorrido post order.
   * Si bien el prefil está pensando para una implementación recursiva, puede probar con una implementación iterativa.
   */
   private List<T> aListaPostOrder(NodoBinario<T> raiz, List<T> elementos) {
      throw new UnsupportedOperationException("TODO: implementar");
   }
   
   /**{@inheritDoc}*/
   @Override
   public T[] aArreglo() {
      return aArreglo(Orden.INORDER);
   }
   
   /**{@inheritDoc}*/
   @Override
   public T[] aArreglo(Orden orden) {
      throw new UnsupportedOperationException("TODO: implementar");
   }
   
   /**{@inheritDoc}*/
   @Override
   public boolean repOK() {
      throw new UnsupportedOperationException("TODO: implementar");
   }
   
   /**{@inheritDoc}*/
   @Override
   public String toString() {
      throw new UnsupportedOperationException("TODO: implementar");
   }
   
   /**{@inheritDoc}*/
   @Override
   public boolean equals(Object other) {
      throw new UnsupportedOperationException("TODO: implementar");
   }

}
