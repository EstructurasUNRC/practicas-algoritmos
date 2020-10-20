package colecciones.arbol;

import java.util.List;

/**
* Árbol binario, representa una estructura de nodos, cada uno con un valor {@code T} tal que:
* <ul>
* <li>Cada nodo tiene a lo sumo un nodo a su izquierda y un nodo a su derecha, los cuales deben ser distintos</li>
* <li>Un nodo no puede ser alcanzado a partir de sus descendientes</li>
* <li>Todo nodo debe ser alzanzable desde el nodo raíz del árbol, salvo en un árbol vacío sin nodos</li>
* </ul>
* @param T el tipo del valor asociado a cada nodo del árbol.
*/
public interface ArbolBinario<T> {

   /**
   * Orden de visita para los nodos de un árbol.
   */
   public static enum Orden {
      /**
      * El orden de visita es subarbol izquierdo, raíz, subarbol derecho.
      */
      INORDER,
      /**
      * El orden de visita es raíz, subarbol izquierdo, subarbol derecho.
      */
      PREORDER,
      /**
      * El orden de visita es subarbol izquierdo, subarbol derecho, raíz.
      */
      POSTORDER
   }
   
   /**
   * Crea un nuevo árbol binario a partir de una raíz y un subarbol izquierdo, donde este árbol es el subarbol derecho.
   * @param raiz la raíz del nuevo árbol, no puede ser {@code null}.
   * @param subArbolIzquierdo un árbol que va a constituir el subarbol izquierdo del nuevo árbol.
   * @return un nuevo árbol formado por {@code raiz}, {@code subArbolIzquierdo}, {@code this}.
   */
   public ArbolBinario<T> unirADerecha(T raiz, ArbolBinario<T> subArbolIzquierdo);
   
   /**
   * Crea un nuevo árbol binario a partir de una raíz y un subarbol derecho, donde este árbol es el subarbol izquierdo.
   * @param raiz la raíz del nuevo árbol, no puede ser {@code null}.
   * @param subArbolDerecho un árbol que va a constituir el subarbol derecho del nuevo árbol.
   * @return un nuevo árbol formado por {@code raiz}, {@code this}, {@code subArbolDerecho}.
   */
   public ArbolBinario<T> unirAIzquierda(T raiz, ArbolBinario<T> subArbolDerecho);
   
   /**
   * Convierte este árbol en un árbol vacío.
   */
   public void vaciar();
   
   /**
   * Retorna el valor asociado a la raíz del árbol.
   * @return la raíz
   */
   public T raiz();

   /**
   * Retorna el subarbol izquierdo.
   * @return el subarbol izquierdo.
   */
   public ArbolBinario<T> subArbolIzquierdo();
   
   /**
   * Retorna el subarbol derecho.
   * @return el subarbol derecho.
   */
   public ArbolBinario<T> subArbolDerecho();
   
   /**
   * Retorna la cantidad de elementos en este árbol.
   * @return cuantos elementos contiene el árbol.
   */
   public int elementos();
   
   /**
   * Retorna la altura del árbol, definida como:
   * <ul>
   * <li>La altura de un árbol vacío es {@code 0}</li>
   * <li>La altura de un árbol no vacío es {@code 1 + } el máximo de las alturas de los subarboles izquierdo y derecho</li>
   * </ul>
   * @return la altura del árbol.
   */
   public int altura();
   
   /**
   * Permite consultar si el árbol está vacío o no.#
   * <p>
   * Este método es equivalente a <pre>elementos() == 0</pre> y <pre>altura() == 0</pre>.
   * @return {@code true} sii este árbol está vacío.
   */
   public boolean esVacio();
   
   /**
   * Retorna una lista con los elementos almacenados en este árbol usando un recorrido {@code INORDER}.
   * <p>
   * Llamar a este método es equivalente a llamar a <pre>aLista(Orden.INORDER)</pre>.
   * @return retorna una lista con los elementos de este árbol según un recorrido {@code INORDER}.
   */
   public List<T> aLista();
   
   /**
   * Retorna una lista con los elementos almacenados en este árbol usando un recorrido determinado.
   * @param orden define el recorrido que se va a utilizar para recolectar los valores.
   * @return retorna una lista con los elementos de este árbol según el recorrido definido por {@code orden}.
   */
   public List<T> aLista(Orden orden);
   
   /**
   * Retorna un arreglo con los elementos almacenados en este árbol usando un recorrido {@code INORDER}.
   * <p>
   * Llamar a este método es equivalente a llamar a <pre>aArreglo(Orden.INORDER)</pre>.
   * @return retorna un arreglo con los elementos de este árbol según un recorrido {@code INORDER}.
   */
   public T[] aArreglo();
   
   /**
   * Retorna un arreglo con los elementos almacenados en este árbol usando un recorrido determinado.
   * @param orden define el recorrido que se va a utilizar para recolectar los valores.
   * @return retorna un arreglo con los elementos de este árbol según el recorrido definido por {@code orden}.
   */
   public T[] aArreglo(Orden orden);
   
   /**
   * Verifica que esta instancia de {@code ArbolBinario} cumple con su invariante.
   * <p>
   * El invariante consiste en:
   * <ul>
   * <li>No hay ciclos, no se puede alcanzar a un nodo a partir de sus descendientes.</li>
   * <li>Todo nodo tiene a lo sumo dos descendientes (uno izquierdo y uno derecho) y no pueden ser iguales.</li>
   * <li>Todo nodo en un árbol no vacío es alcanzable desde la raíz.</li>
   * <li>Para cada nodo en el árbol existe un solo camino para alcanzarlo desde la raíz.</li>
   * <li>La cantidad de nodos en el árbol debe ser igual al resultado del método {@code elementos()}.</li>
   * </ul>
   * @return {@code true} sii el invariante se cumple
   */
   public boolean repOK();
   
   /**
   * Una representación del árbol ya sea en múltiples líneas mediante
   * una visita de arriba hacia abajo y de izquierda a derecha, o en una
   * sola línea utilizando un recorrido in order.
   * @return la representación de este árbol en forma de {@code String}.
   * @see Orden#INORDER
   */
   @Override
   public String toString();
   
   /**
   * Compara dos árboles binarios, la comparación contempla no solo los valores almacenados sino también la estructura.
   * @return {@code true} sii los árboles son iguales.
   */
   @Override
   public boolean equals(Object other);

}
