// Programa que muestra el manejo de ArrayLists de tipos primitivos
// Hay que usar clases especiales (wrapper)
// int      -->   Integer
// double   -->   Double
// char     -->   Character
// boolean  -->   Boolean


import java.util.*;
import java.io.*;

public class NumerosArrayList {
   public static void main(String[] args) throws FileNotFoundException {
   
      // Creamos la lista de enteros, calculamos su media y el valor máximo
      ArrayList<Integer> numeros = crearLista();
      System.out.println(numeros);
      
      System.out.printf("Valor medio: %.2f\n", obtenerMedia(numeros));
      
      System.out.println("Valor máximo: " + obtenerMax(numeros));
      
      // Separamos los números impares a otra lista y dejamos los pares en la original
      ArrayList<Integer> impares = separarImpares(numeros);
      System.out.println("Pares: " + numeros);
      System.out.println("Impares: " + impares);
      
      // Ordenamos las 2 listas y las mostramos por consola
      Collections.sort(numeros);
      System.out.println("Pares: " + numeros);
      Collections.sort(impares);
      System.out.println("Impares: " + impares);
   }
   
   // Creamos el ArrayList de int. Hay que usar la clase Integer
   // Guardamos los números leídos del fichero "numeros.txt". Eliminamos los números repetidos
   public static ArrayList<Integer> crearLista() throws FileNotFoundException {
   
      ArrayList<Integer> listaNumeros = new ArrayList<Integer>();
      Scanner leerDatos = new Scanner(new File("numeros.txt"));
      
      while (leerDatos.hasNextInt()) {
         int numero = leerDatos.nextInt();
         if (!listaNumeros.contains(numero)) {
            listaNumeros.add(numero);
         }
      }
      
      return listaNumeros;
   }
   
   // Obtiene el valor medio de los números dindeOfel ArrayList
   // Utiliza el bucle for-each
   public static double obtenerMedia (ArrayList<Integer> listaNumeros) {
   
      int suma = 0;
      for (int numero : listaNumeros) {
         suma += numero;
      }
      return (double) suma / listaNumeros.size();
   }

   // Obtiene el valor máximo de los números del ArrayList
   public static int obtenerMax (ArrayList<Integer> listaNumeros) {
   
      int max = listaNumeros.get(0);
      for (int i = 1; i < listaNumeros.size(); i++) {
         int numero = listaNumeros.get(i);
         max = Math.max(max, numero);
      }
      return max;
   }
      
   // Crea un ArrayList con los números impares
   // Los elimina del ArrayList original
   // Utiliza un iterador para recorrer el array
   public static ArrayList<Integer> separarImpares(ArrayList<Integer> listaNumeros) {
   
      ArrayList<Integer> listaImpares = new ArrayList<Integer>();
      
      Iterator<Integer> it = listaNumeros.iterator();
      while (it.hasNext()) {
         int num = it.next();
         if (num % 2 == 1) {
            listaImpares.add(num);
            it.remove();
         }
      }
      return listaImpares;      
   }
}