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


    T getValor() {
        return valor;
    }

    void setValor(T nuevoValor) {
        valor = nuevoValor;
    }

    NodoBinario<T> getIzquierdo() {
        return izquierdo;
    }

    void setIzquierdo(NodoBinario<T> nuevoIzquierdo) {
        throw new UnsupportedOperationException("TODO: implementar");
    }

    NodoBinario<T> getDerecho() {
        return derecho;
    }

    void setDerecho(NodoBinario<T> nuevoDerecho) {
        throw new UnsupportedOperationException("TODO: implementar");
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }


}
