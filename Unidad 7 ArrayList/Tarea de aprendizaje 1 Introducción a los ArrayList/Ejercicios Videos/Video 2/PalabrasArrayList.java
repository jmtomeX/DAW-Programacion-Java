// Programa para demostrar el manejo de los ArrayLists
// y su uso como parámetros y return en los métodos
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
import java.io.*;

public class PalabrasArrayList {
   public static void main(String[] args) throws FileNotFoundException {
   
      // Creamos e inicializamos el ArrayList de String
      ArrayList<String> palabras = new ArrayList<String>();
      
      // Leemos un fichero y guardamos las palabras en el ArrayList
      leerPalabras(palabras);
      System.out.println(palabras);
      
      // Se copian las palabras que son plural (acaban por s) a otra lista
      ArrayList<String> plurales = copiarSoloPlurales(palabras);
      System.out.println(plurales);
      System.out.println(palabras);
      
      // Se eliminan las palabras en plural, acaban por "s"
      eliminarPlurales(palabras);
      System.out.println(palabras);
      
      // Introducimos un "-" entre cada 2 palabras
      introducirSeparadores(palabras, "-");
      System.out.println(palabras);
      
      // Eliminamos el guión que hemos introducido
      eliminarSeparadores(palabras);
      System.out.println(palabras);
   }
   
   // Leemos el fichero "palabras.txt" y guardamos las palabras en el ArrayList
   public static void leerPalabras(ArrayList<String> palabras) throws FileNotFoundException {
      Scanner input = new Scanner(new File("palabras.txt"));
      while (input.hasNext()) {
         String palabra = input.next();
         palabras.add(palabra);
      }
   }
   
   // Crea un nuevo ArrayList
   // Solo con las palabras en plural, acaban en "s"
   // Hay que reducir el índice para que funcione
   public static ArrayList<String> copiarSoloPlurales (ArrayList<String> palabras) {
      ArrayList<String> soloPlurales = new ArrayList<String>();
      for (String palabra : palabras) {
         if (palabra.endsWith("s")) {
            soloPlurales.add(palabra);
         }
      }
      return soloPlurales;
   }
   
   // Se eliminan las palabras en plural, acaban por "s"
   // Se utiliza un iterador y el método remove de ese iterador
   // No se puede eliminar directamente de la lista, si no a traves del iterador
   public static void eliminarPlurales(ArrayList<String> palabras) {
      Iterator<String> it = palabras.iterator();
      while (it.hasNext()) {
         String palabra = it.next();
         if (palabra.endsWith("s")) {
            it.remove();
         }
      }
   }
      
   // Introduce un elemento separador entre las palabras de la lista
   // Se puede recorrer el array en sentido contrario
   public static void introducirSeparadores(ArrayList<String> palabras, String separador){
      //Después de añadir hay que incrementar el índice
      /*for (int i = 1; i < palabras.size(); i++) {
         palabras.add(i, separador);
         i++;
      }*/
      
      /* Empezamos por el final. Se mueve lo que ya se ha recorrido */
      for (int i = palabras.size() - 1; i > 0 ; i--) {
         palabras.add(i, separador);
      }
   }
      
   //*Elimina el elemento separador entre las palabras de la lista
   public static void eliminarSeparadores(ArrayList<String> palabras){
      // En este caso funciona bien 
      for (int i = 1; i < palabras.size(); i++) {
         palabras.remove(i);
      }
      
      /* Con iteradores */
      Iterator<String> it = palabras.iterator();
      while (it.hasNext()) {
         String palabra = it.next();
         if (palabra.equals("-")) {
            it.remove();
         }
      }
   } 
}