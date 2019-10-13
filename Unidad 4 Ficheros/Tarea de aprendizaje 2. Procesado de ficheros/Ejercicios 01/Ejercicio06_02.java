/*
Corrige el siguiente programa para que lea el fichero imdb.txt y diga cuántas películas tienen valoración media mayor que 8,5 y menor o igual que 8,7.

El fichero sigue el siguiente formato:

1 1649756 9.2 The Shawshank Redemption (1994)
2 1129349 9.2 The Godfather (1972)
3 770838 9.0 The Godfather: Part II (1974)

El resultado debería ser:

Total peliculas: 16
*/

import java.util.*;
import java.io.*;
public class Ejercicio06_02 {
   public static void main(String[] args) throws FileNotFoundException{
      Scanner leerFich = new Scanner(new File("..\\Ejemplos video\\imdb.txt"));  
      int cont = 0;
      while (leerFich.hasNextLine()) {
         String linea = leerFich.nextLine();
         if (procesarLinea(linea, cont)) {
            cont++;
         }  
      }
      System.out.println("Total peliculas: " + cont);
      leerFich.close();
   }
    
   public static boolean procesarLinea(String texto, int cont) {
      Scanner leer = new Scanner(texto);
      leer.useLocale(Locale.US);
      
      double posicion = leer.nextDouble();
      double numOpiniones = leer.nextDouble();
      double valoracionMedia = leer.nextDouble();
      String titulo = "";
      while (leer.hasNext()) {
         titulo += leer.next() + " ";
      }
      if(valoracionMedia > 8.5 && valoracionMedia <= 8.7){
         System.out.println((cont+1) + " " +  titulo);
      }
   
      return (valoracionMedia > 8.5 && valoracionMedia <= 8.7);
   }
}