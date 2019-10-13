import java.util.*;

public class ArticuloMain {
   public static void main(String[] args) {
      String[] palabras = {"Rojo", "Azul", "Blanco"};

      System.out.println(Arrays.toString(palabras));
      Arrays.sort(palabras);
      System.out.println(Arrays.toString(palabras));

      // Creamos un array de Articulos
      Articulo[] arrayArticulos = { new Articulo("Naranja", 5), new Articulo("Chocolate", 2), new Articulo("Galletas", 1)};
      
      System.out.println(Arrays.toString(arrayArticulos));
      Arrays.sort(arrayArticulos);
      System.out.println(Arrays.toString(arrayArticulos));
   }
}