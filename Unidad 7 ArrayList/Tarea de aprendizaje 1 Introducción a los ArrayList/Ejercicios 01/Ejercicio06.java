/*
Corrige el método buscarPalabra para que reciba un ArrayList de String y una palabra, 
busque la palabra en la lista y devuelva el índice de esa palabra. Si no encuentra la palabra devolverá -1.

Cuando el método funcione el programa mostrará:

[rosa, verde, rojo, negro]
-1
3
1
*/
import java.util.*;

public class Ejercicio06 {
   public static void main(String[] args) {
      ArrayList<String> lista = new ArrayList<String>();
      lista.add("rosa");
      lista.add("verde");
      lista.add("rojo");
      lista.add("negro");
      
      System.out.println(lista);
      System.out.println(buscarPalabra(lista, "azul"));
      System.out.println(buscarPalabra(lista, "negro"));
      System.out.println(buscarPalabra(lista, "verde"));
   }
   
   // Metodo
   public static int buscarPalabra(ArrayList <String> lista, String palabra) {
      for (String elemento :  lista) {
      
         if (elemento.equals(palabra)) {
            return lista.indexOf(palabra);
         }
      }
      return -1;
   }
}