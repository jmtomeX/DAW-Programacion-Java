// Programa para demostrar el manejo básico de los ArrayLists
//
// Operaciones con arrays:
//    String[] arr         ==> ArrayList<String> lista
//    new String[n]        ==> new ArrayList<String>()   
//    String s = arr[i];   ==> String s = lista.get(i);
//    arr[i] = s;          ==> lista.set(i, s);
//    arr.length           ==> lista.size()
//
// Nuevas operaciones con ArrayLists:
//    lista.add(s)         ==> añade un nuevo elemento al final de la lista
//    lista.add(i, s)      ==> añade un nuevo elemento en la posición indicada por el índice i,
//                             mueve los elementos siguientes hacia la derecha
//    lista.remove(i)      ==> borra el elemento en la posición indicada por el índice i,
//                             mueve los elementos siguientes hacia la izquierda
//    lista.clear()        ==> removes all elements of the list
//    lista.indexOf(s)     ==> devuelve el índice del elemento indicado. -1 si no lo encuentra

import java.util.*;

public class ArrayListEjemplos {
   public static void main(String[] args) {
   
      // Crea la lista
      ArrayList<String> palabras = new ArrayList<String>();
      
      // Añade elementos al final de la lista.
      palabras.add("hola");
      palabras.add("AGUR");
      
      // Añade elementos en un posición concreta
      palabras.add(1, "Adios");
      
      // Obtiene el valor de los elementos 0 y 1, los concatena y los guarda al final de la lista
      String s1 = palabras.get(0);
      String s2 = palabras.get(1);
      palabras.add(s1 + "-" + s2);
      
      // Borra elemento 0
      palabras.remove(0);
      
      // Modifica el valor del elemento 1
      palabras.set(1, "kaixo");
      
      // Muestra los elementos de la lista con un bucle for
      System.out.print("Bucle for: ");
      for (int i = 0; i < palabras.size(); i++) {
         System.out.print(palabras.get(i) + " ");
      }
      System.out.println();
      
      // Muestra los elementos de la lista con un bucle for-each
      System.out.print("Bucle for-each: ");
      for (String palabra : palabras) {
         System.out.print(palabra + " ");
      }
      System.out.println();
      
      // Muestra los elementos de la lista con un objeto Iterador
      System.out.print("Iterador: ");
      Iterator<String> it = palabras.iterator();
      while (it.hasNext()) {
         String palabra = it.next();
         System.out.print(palabra + " ");
      }
      System.out.println();
      
      // Busca el índice del elemento "Adios" y modifica su valor por "Agur"
      int indice = palabras.indexOf("Adios");
      palabras.set(indice, "Agur");
      
      // Muestra la lista utilizando el método toString implícitamente
      System.out.println(palabras);
      
      palabras.clear();
   }
}