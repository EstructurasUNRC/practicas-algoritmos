package test.colecciones.arbol;


import colecciones.arbol.ABB;

import java.util.Comparator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class TestABB {
    Comparator<Integer> comp = Comparator.naturalOrder();
    ABB<Integer> arbol = new ABB<>(comp);

    @Before
    public void setup(){
        arbol.vaciar();
    }

    @Test
    public void testInsertarBorrar() {
        arbol.insertar(10);
        arbol.insertar(16);
        arbol.insertar(1);
        arbol.insertar(8);
        assertTrue(arbol.pertenece(10));
        assertTrue(arbol.pertenece(16));
        assertTrue(arbol.pertenece(1));
        assertFalse(arbol.pertenece(9));
        assertEquals(4, arbol.elementos());
        arbol.borrar(16);
        arbol.borrar(1);
        assertEquals(2, arbol.elementos());
        assertFalse(arbol.pertenece(16));
        assertFalse(arbol.pertenece(1));
    }

    @Test
    public void testMaximo() {
        arbol.insertar(10);
        arbol.insertar(16);
        arbol.insertar(1);
        arbol.insertar(8);
        assertEquals(arbol.mayorValor(), (Integer)16);
    }

    @Test
    public void testMinimo() {
        arbol.insertar(100);
        arbol.insertar(61);
        arbol.insertar(15);
        arbol.insertar(78);
        assertEquals(arbol.menorValor(), (Integer)15);
    }

    @Test
    public void testInsertar1000() {
        for (int i=0; i < 1000; i++)
            arbol.insertar(i);
        assertEquals(1000, arbol.elementos());
    }

    @Test
    public void testBorrarRaiz() {
        arbol.insertar(8);
        arbol.borrar(8);
        assertEquals(0, arbol.elementos());
        assertTrue(arbol.esVacio());
    }

    @Test
    public void testBorrarMuchos() {
        Integer [] a = {477,1193,2130,398,1393,946,422,1381,1767,830,570,1085,741,598,1658,1801,487,1921,1918,258,135,975,1870};
        for (Integer integer : a) arbol.insertar(integer);
        for (int i = a.length-1; i > 0; i--) {
            arbol.borrar(a[i]);
        }
        assertEquals(477, (int) arbol.raiz());
        assertEquals(1, arbol.elementos());
        assertEquals(477,(int) arbol.mayorValor());
        assertTrue(arbol.subArbolDerecho().esVacio());
        assertTrue(arbol.subArbolIzquierdo().esVacio());
    }

}
