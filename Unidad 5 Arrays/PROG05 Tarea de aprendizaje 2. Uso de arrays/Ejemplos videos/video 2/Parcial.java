// Programa que calcula estadísticas de las calificaciones parciales
// Se utiliza el array valores para guardar los datos de un fichero y
// poder operar con ellos todas las veces que queramos
// Se utiliza el array conts como array de contadores
// para saber cuántas veces se repite cada valor

import java.util.*;
import java.io.*;

public class Parcial {

   public static void main(String[] args) throws FileNotFoundException {
   
      Scanner leerFich = new Scanner(new File("parcial.txt"));
      
      // Leemos el primer dato: el número de valores que hay en el fichero
      // Creamos el array de ese tamaño
      int total = leerFich.nextInt();
      int[] valores = new int[total];
      
      // Recorremos el array y vamos guardando cada uno de los valores del fichero en el array
      // Además vamos sumando todos sus valores
      int suma = 0;
      for (int i = 0; i < valores.length; i++) {
         valores[i] = leerFich.nextInt();
         suma += valores[i];
      }     
      
      // Calculamos y mostramos la media
      System.out.println("Media: " + (double) suma / valores.length);
      
      // Recorremos el array y calculamos el valor máximo del array
      int max = valores[0];
      for (int i = 1; i < valores.length; i++) {
         //max = Math.max(max, valores[i]);
         if(valores[i] < max){
            max = valores[i];
         }
      }
      System.out.println("calificación máxima: " + max);
      System.out.println();
   
      // Contamos cuantas veces se repite cada uno de los valores entre 0 y max
      // el array tendrá max + 1 elementos. El 0 también se cuenta
      int[] conts = new int[max + 1];
      for (int i = 0; i < valores.length; i++) {
         int valor = valores[i];
         conts[valor]++;
      }
   
      // Dibujamos mediante líneas de estrellas las veces que se repite cada valor
      // que están almacenado en el array valores
      // Tanto en el fichero "contadores.txt" como por consola
      PrintStream escribirFich = new PrintStream(new File("contados.txt"));
      
      // Recorremos el array de contadores
      for (int i = 0; i < conts.length; i++) {
         escribirFich.printf("%3d | ", i);
         System.out.printf("%3d | ", i);
         
         // Dibujamos las estrellas correspondientes al valor del contador
         for (int j = 0; j < conts[i]; j++) {
            escribirFich.print("*");
            System.out.print("*");
         }
         
         escribirFich.println(" (" + conts[i] + ")");
         System.out.println(" (" + conts[i] + ")");
      }
   }
}