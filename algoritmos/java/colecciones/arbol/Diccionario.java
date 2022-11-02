package colecciones.arbol;

import java.util.List;

/**
* Diccionario, representa un grafo dirigido acíclico siguiendo las siguientes reglas de construcción:
* <ul>
*     <li>Un árbol vacío se representa por no tener ningún nodo asociado.</li>
*     <li>Un árbol no vacío se representa por un nodo inicial con dos subárboles disjuntos asociados, uno considerado como izquierdo, y otro como derecho.</li>
*     <li>Todo nodo tiene un valor de tipo {@code T} asociado.</li>
*     <li>Para todo nodo se debe cumplir que el máximo valor de los nodos del subárbol izquierdo debe ser menor al valor asociado a este.</li>
*     <li>Para todo nodo se debe cumplir que el mínimo valor de los nodos del subárbol derecho debe ser mayor al valor asociado a este.</li>
*     <li>Todo nodo en el árbol debe ser alcanzable desde la raíz por un único camino.</li>
* </ul>
* @param <T> el tipo del valor asociado a los nodos del árbol, debe ser posible definir un orden total para los mismos.
*/
public interface Diccionario<T> {

   /**
   * Orden de visita para los nodos de un árbol.
   */
   enum Orden {
      /**
      * El orden de visita es subárbol izquierdo, raíz, subárbol derecho.
      */
      INORDER,
      /**
      * El orden de visita es raíz, subárbol izquierdo, subárbol derecho.
      */
      PREORDER,
      /**
      * El orden de visita es subárbol izquierdo, subárbol derecho, raíz.
      */
      POSTORDER
   }

   /**
    * Inserta un elemento en el arbol, siempre que el elemento no exista.
    * @param elem El elemento a insertar.
    */
   void insertar( T elem );

   /**
    * Busca un elemento dentro del arbol.
    * @param elem El elemento a encontrar. No puede ser null.
    * @return {@code true} sii encuentra elem en el arbol.
    */
   boolean pertenece (T elem);

   /**
    * Elimina un elemento dado del arbol, si el elemento existe en el arbol.
    * @param elem elemento a borrar del arbol.
    */
   void borrar(T elem);

   /**
   * Elimina todos los nodos de este árbol, dejándolo vacío.
   */
   void vaciar();
   
   /**
   * Retorna el valor asociado a la raíz del árbol.
   * @return el valor asociado a la raíz
   * @throws IllegalStateException si el árbol está vacío
   */
   T raiz();

   /**
   * Retorna el subárbol izquierdo.
   * @return el subárbol izquierdo.
   */
   Diccionario<T> subArbolIzquierdo();
   
   /**
   * Retorna el subarbol derecho.
   * @return el subarbol derecho.
   */
   Diccionario<T> subArbolDerecho();
   
   /**
   * Retorna la cantidad de elementos en este árbol.
   * @return cuantos elementos contiene el árbol.
   */
   int elementos();
   
   /**
   * Retorna la altura del árbol, definida como:
   * <ul>
   * <li>La altura de un árbol vacío es {@code 0}</li>
   * <li>La altura de un árbol no vacío es {@code 1 + } el máximo de las alturas de los sub arboles izquierdo y derecho</li>
   * </ul>
   * @return la altura del árbol.
   */
   int altura();
   
   /**
   * Permite consultar si el árbol está vacío o no.
   * <p>
   * Este método es equivalente a <pre>elementos() == 0</pre> y <pre>altura() == 0</pre>
   * @return {@code true} sii este árbol está vacío.
   */
   boolean esVacio();


   /**
    * Retorna el mayor valor del arbol si no es vacio.
    * @return el mayor valor del arbol si no es vacio o null.
    */
   T mayorValor();

   /**
    * Retorna el menor valor del arbol si no es vacio.
    * @return el menor valor del arbol si no es vacio o null.
    */
   T menorValor();

   /**
    *  El sucesor de un elemento {@code elem} en el árbol es el elemento más pequeño mayor que elem.
    * @param elem elemento del que se quiere encontrar el inmediato sucesor.
    * @return inmediato sucesor del elemento dado si existe en el arbol.
    */
   T sucesor(T elem);

   /**
    *  El predecesor de un elemento {@code elem} en el árbol es el elemento más grande menor que elem.
    * @param elem elemento del que se quiere encontrar el inmediato predecesor.
    * @return inmediato predecesor del elemento dado si existe en el arbol.
    */
   T predecesor(T elem);

   /**
    * Verifica que esta instancia de {@code Diccionario} cumple con su invariante.
    * <p>
    * El invariante consiste en:
    * <ul>
    * <li>No hay ciclos, no se puede alcanzar a un nodo a partir de sus descendientes.</li>
    * <li>Todo nodo tiene a lo sumo dos descendientes (uno izquierdo y uno derecho) y no pueden ser iguales.</li>
    * <li>Todo nodo en un árbol no vacío es alcanzable desde la raíz.</li>
    * <li>Para cada nodo en el árbol existe un solo camino para alcanzarlo desde la raíz.</li>
    * <li>La cantidad de nodos en el árbol debe ser igual al resultado del método {@code elementos()}.</li>
    * <li> Los nodos del arbol se organizan en un orden total y deben cumplir que:
    *     <ul>
    *        <li> El subarbol izquierdo de un nodo contiene solo nodos con valores menores que el valor del nodo. </li>
    *        <li> El subarbol derecho de un nodo contiene solo nodos con valores mayores que el valor del nodo.</li>
    *        <li> Los subarboles izquierdo y derecho también deben ser un diccionario.</>
    *    </ul>
    * </li>
    * </ul>
    * @return {@code true} sii el invariante se cumple
    */
   boolean repOK();

   /**
    * Una representación del árbol ya sea en múltiples líneas mediante
    * una visita de arriba hacia abajo y de izquierda a derecha, o en una
    * sola línea utilizando un recorrido in order.
    * @return la representación de este árbol en forma de {@code String}.
    * @see Orden#INORDER
    */
   @Override
   String toString();

   /**
    * Compara dos árboles binarios, la comparación contempla no solo los valores almacenados, sino también la estructura.
    * @return {@code true} sii los árboles son iguales.
    */
   @Override
   boolean equals(Object other);

   /**
   * Retorna una lista con los elementos almacenados en este árbol usando un recorrido {@code INORDER}.
   * <p>
   * Llamar a este método es equivalente a llamar a <pre>aLista(Orden.INORDER)</pre>
   * @return retorna una lista con los elementos de este árbol según un recorrido {@code INORDER}.
   */
   List<T> aLista();
   
   /**
   * Retorna una lista con los elementos almacenados en este árbol usando un recorrido determinado.
   * @param orden define el recorrido que se va a utilizar para recolectar los valores.
   * @return retorna una lista con los elementos de este árbol según el recorrido definido por {@code orden}.
   */
   List<T> aLista(Orden orden);


}
