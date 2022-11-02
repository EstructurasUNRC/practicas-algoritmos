package test.colecciones.arbol;

import colecciones.arbol.Avl;

import java.util.Comparator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestAvl {
    Comparator<Integer> comp = Comparator.naturalOrder();
    Avl<Integer> arbol = new Avl<>(comp);

    @Before
    public void setup(){
        arbol.vaciar();
    }

    @Test
    public void testInsertar100() {
        for (int i=0; i < 100; i++)
            arbol.insertar(i);
        assertEquals(100, arbol.elementos());
    }

    @Test
    public void testInsertarMuchos() {
        Integer [] a = {477,1193,2130,398,1393,946,422,1381,1767,830,570,1085,741,598,1658,1801,487,1921,1918,258,135,975,1870};
        for (Integer integer : a) arbol.insertar(integer);
        assertEquals(1193, (int) arbol.raiz());
        assertEquals(1767, (int) arbol.subArbolDerecho().raiz());
        assertEquals(1393, (int) arbol.subArbolDerecho().subArbolIzquierdo().raiz());
        assertEquals(1921, (int) arbol.subArbolDerecho().subArbolDerecho().raiz());
        assertEquals(1870, (int) arbol.subArbolDerecho().subArbolDerecho().subArbolIzquierdo().raiz());
        assertEquals(1801, (int) arbol.subArbolDerecho().subArbolDerecho().subArbolIzquierdo().subArbolIzquierdo().raiz());
        assertEquals(2130, (int) arbol.subArbolDerecho().subArbolDerecho().subArbolDerecho().raiz());
        assertEquals(2130, (int) arbol.mayorValor());
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
            if (a[i] == 830)
                assertEquals(1, Math.abs(arbol.subArbolIzquierdo().balance()));
        }
        assertEquals(477, (int) arbol.raiz());
        assertEquals(0, arbol.balance());
        assertEquals(1, arbol.elementos());
        assertEquals(477,(int) arbol.mayorValor());
        assertTrue(arbol.subArbolDerecho().esVacio());
        assertTrue(arbol.subArbolIzquierdo().esVacio());
    }

    @Test
    public void testBorrarConDesbalance1() {
        arbol.insertar(3);
        arbol.insertar(2);
        arbol.insertar(4);
        arbol.insertar(1);

        arbol.borrar(4);
        assertEquals(0, arbol.balance());
        assertEquals(2, (int) arbol.raiz());
    }

    @Test
    public void testBorrarConDesbalance2() {
        arbol.insertar(10);
        arbol.insertar(8);
        arbol.insertar(12);
        arbol.insertar(9);

        arbol.borrar(12);

        assertEquals(0, arbol.balance());
        assertEquals(9, (int) arbol.raiz());
    }



    @Test
    public void testBorrarSinRotacion() {
        arbol.insertar(2);
        arbol.insertar(3);
        arbol.insertar(1);
        assertEquals(2, (int)arbol.raiz());

        arbol.borrar(3);
        assertEquals(1, Math.abs(arbol.balance()));

        // borrar raiz
        arbol.borrar(2);
        arbol.borrar(1);
        assertEquals(0, arbol.elementos());
    }

    @Test
    public void testMaximo() {
        arbol.insertar(100);
        arbol.insertar(61);
        arbol.insertar(15);
        arbol.insertar(78);
        assertEquals(arbol.mayorValor(), (Integer)100);
    }





}
