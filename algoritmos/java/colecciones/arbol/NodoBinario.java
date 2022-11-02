package colecciones.arbol;

/**
 * Clase auxiliar para diccionarios implementados con nodos encadenados.
 */
public class NodoBinario<T>  {
    private T valor;
    private NodoBinario<T> izquierdo;
    private NodoBinario<T> derecho;
    private int altura;


    NodoBinario(T valor, NodoBinario<T> izquierdo, NodoBinario<T> derecho) {
       throw new UnsupportedOperationException("TODO: implementar");
    }

    public NodoBinario(){
        throw new UnsupportedOperationException("TODO: implementar");
    }

    public NodoBinario(T valor){
        throw new UnsupportedOperationException("TODO: implementar");
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
        throw new UnsupportedOperationException("TODO: implementar");
    }

    NodoBinario<T> derecho() {
        return derecho;
    }

    void derecho(NodoBinario<T> nuevoDerecho) {
        throw new UnsupportedOperationException("TODO: implementar");
    }

    public int altura() {
        return altura;
    }

    public void altura(int altura) {
        this.altura = altura;
    }


}
