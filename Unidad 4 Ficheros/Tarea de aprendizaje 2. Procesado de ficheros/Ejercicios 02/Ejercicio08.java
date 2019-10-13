/*
Corrige el siguiente programa para que lea el fichero imdb.txt y diga cuántas películas empiezan po "Ci" y cuáles son.
El fichero sigue el siguiente formato:
1 1649756 9.2 The Shawshank Redemption (1994)
2 1129349 9.2 The Godfather (1972)
3 770838 9.0 The Godfather: Part II (1974)

El resultado debería ser:
City of God (2002): 8.6
City Lights (1931): 8.5
Citizen Kane (1941): 8.4
Total peliculas: 3
*/
import java.util.*;
import java.io.*;

public class Ejercicio08 {
   public static void main(String[] args) throws FileNotFoundException {
      Scanner leerFich = new Scanner(new File("..\\Ejemplos video\\imdb.txt"));  
      
      int cont = 0;  
      while (leerFich.hasNextLine()) {
         String linea = leerFich.nextLine();
         if (procesarLinea(linea)) {
            cont++;
         }  
      }
      System.out.println("Total peliculas: " + cont);
      leerFich.close();
   }
    
   public static boolean procesarLinea(String leer) {
      boolean test = false ;
      Scanner informacion = new Scanner(leer);
      informacion.useLocale(Locale.US);
      int posicion = informacion.nextInt();
      int numOpiniones = informacion.nextInt();
      double valoracionMedia = informacion.nextDouble();
      String pelicula = informacion.nextLine();
      pelicula = pelicula.substring(1);
      
      if (pelicula.startsWith("Ci")) {
         test = true;
         System.out.println(pelicula + ": " + valoracionMedia);
      }
      return test;
   }
}
