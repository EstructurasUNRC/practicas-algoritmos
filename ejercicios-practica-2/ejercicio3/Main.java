package ejercicio3;


public class Main {
    
    public static void main(String args[]){

        Libro l1 = new Libro("The Lord of the Rings", "J. R. R. Tolkien", 1000);
        Libro l2 = new Libro("Harry Potter", "J. K. Rowling", 600);
        Catalogo c1 = new Catalogo();
        c1.agregarLibro(l1);
        c1.agregarLibro(l2);
        System.out.println("Catalogo 1:");
        c1.mostrar();

   }

}
