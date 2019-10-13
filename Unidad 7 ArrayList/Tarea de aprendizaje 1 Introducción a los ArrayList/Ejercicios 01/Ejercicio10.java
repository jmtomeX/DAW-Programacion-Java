/*
Crea el método eliminar para que reciba un ArrayList de String y elimine todas las palabras que tenga un número impar de letras.

Cuando el método funcione, el programa mostrará:

[rosa, rojo]

Prueba a utilizar un iterador para recorrer la lista.
*/



import java.util.*;
public class Ejercicio10 {
   public static void main(String[] args) {
      ArrayList<String> lista = new ArrayList<String>();
      lista.add("rosa");
      lista.add("verde");
      lista.add("rojo");
      lista.add("negro");
      eliminar(lista);
      System.out.println(lista);
   }
   public static void eliminar(ArrayList<String> palabras) {
      for(int i = 0; i < palabras.size(); i++) {
         String palabra = palabras.get(i);
         int countWord = palabra.length();
         if(countWord % 2 == 1) {
            palabras.remove(i);
         }
      }
   }
}
