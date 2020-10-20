package colecciones.arbol;

/**
* Clase auxiliar para árboles binarios implementados con nodos encadenados.
*/
class NodoBinario<T> {

   private T valor;
   private NodoBinario<T> izquierdo;
   private NodoBinario<T> derecho;
   
   static <E> NodoBinario<E> nuevaHoja(E valor) {
      return new NodoBinario<>(valor, null, null);
   }
   
   static <E> NodoBinario<E> conIzquierdo(E valor, NodoBinario<E> izquierdo) {
      return new NodoBinario<>(valor, izquierdo, null);
   }
   
   static <E> NodoBinario<E> conDerecho(E valor, NodoBinario<E> derecho) {
      return new NodoBinario<>(valor, null, derecho);
   }
   
   NodoBinario(T valor, NodoBinario<T> izquierdo, NodoBinario<T> derecho) {
      this.valor = valor;
      this.izquierdo = izquierdo;
      this.derecho = derecho;
   }
   
   T valor() {
      return valor;
   }
   
   void valor(T nuevoValor) {
      valor = nuevoValor;
   }
   
   NodoBinario<T> izquierdo() {
      return izquierdo;
   }
   
   void izquierdo(NodoBinario<T> nuevoIzquierdo) {
      izquierdo = nuevoIzquierdo;
   }
   
   NodoBinario<T> derecho() {
      return derecho;
   }
   
   void derecho(NodoBinario<T> nuevoDerecho) {
      derecho = nuevoDerecho;
   }

}
