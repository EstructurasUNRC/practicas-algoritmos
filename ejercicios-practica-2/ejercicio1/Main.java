package ejercicio1;


public class Main {
    
    public static void main(String args[]) {

        Libro l1 = new Libro();
        l1.asignarTitulo("Harry Potter");
        l1.asignarAutor("J. K. Rowling");
        l1.asignarNroPag(600); 
        System.out.println(l1.toString());

        Libro l2 = new Libro("The Lord of the Rings", "J. R. R. Tolkien", 1000);
        String s = l1.obtenerAutor();
        System.out.println(l2.toString());
       
        // TODO: Crear un libro nuevo y mostrarlo.
    }

}
