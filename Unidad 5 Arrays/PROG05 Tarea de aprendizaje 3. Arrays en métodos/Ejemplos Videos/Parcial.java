// Programa que calcula estadísticas de las calificaciones parciales
// Se utilizan arrays como parámetros y return en métodos

import java.util.*;
import java.io.*;

public class Parcial {
   
   // Método principal
   public static void main(String[] args) throws FileNotFoundException {
   
      Scanner leerFich = new Scanner(new File("parcial.txt"));      
      int[] notas = leerNotas(leerFich);
      
      System.out.println("Media: " + calcularMedia(notas));
      
      int max =calcularMax(notas);
      System.out.println("calificación máxima: " + max);
   
      int[] conts = cuentaNotas(notas, max);
      
      System.out.println();
      
      PrintStream escribirFich = new PrintStream(new File("grafico.txt")); 
      dibujarGrafica(conts, escribirFich);
      dibujarGrafica(conts, System.out);
   }

   // Leemos el primer dato: el número de valores que hay en el fichero
   // Creamos el array de ese tamaño y vamos guardando cada uno de los valores del fichero en el array
   // Parámetros:
   //    Scanner leerFichero: conexión con el fichero del que vamos a leer todos los datos
   // Return: un array de enteros con todos lo datos del fichero
   public static int[] leerNotas(Scanner leerFichero) {
   
      int total = leerFichero.nextInt();
      int[] valores = new int[total];
            
      for (int i = 0; i < valores.length; i++) {
         valores[i] = leerFichero.nextInt();
      }
      
      return valores;   
   }

   // Método que recorre un array, suma todos sus valores y calcula la media
   // Parámetros:
   //    int[] valores: array de enteros con todos los valores cuya media se quiere calcular
   // Return: double con el valor de la media   
   public static double calcularMedia(int[] valores) {
      int suma = 0;
      for (int i = 0; i < valores.length; i++) {
         suma += valores[i];
      }
      
      return (double) suma / valores.length;
   }

   // Método que recorre un array y obtiene su valor mayor
   // Parámetros:
   //    int[] valores: array de enteros cuyo valor máximo se quiere calcular
   // Return: int con el valor mayor      
   public static int calcularMax(int[] valores) {
      // Si el array está vacío, no hay que buscar nada
      if (valores.length < 1) {
         return 0;
      }
      
      int max = valores[0];
      for (int i = 1; i < valores.length; i++) {
         // max = Math.max(max, values[i]);
         if (valores[i] > max) {
            max = valores[i];
         }
      }
      return max;
   }

   // Método que recorre un array y cuenta cuantas veces se repite cada valor entre 0 y el máximo
   // Parámetros:
   //    int[] valores: array de enteros cuyo valores se quiere contar
   //    int max: valor máximo del array
   // Return: array de int con las veces que se repite cada número     
   public static int[] cuentaNotas(int[] valores, int max) {
      int[] conts = new int[max + 1];
      for (int i = 0; i < valores.length; i++) {
         int valor = valores[i];
         conts[valor]++;
      }
      return conts;
   }

   // Método que recorre un array y dibuja cada valor con el número de estrellas correspondiente
   // Parámetros:
   //    int[] valores: array de enteros cuyo valores se quiere dibujar
   // Return: no devuelve nada     
   public static void dibujarGrafica(int[] valores, PrintStream escribir) {
      for (int i = 0; i < valores.length; i++) {
         escribir.printf("%3d | ", i);
         for (int j = 0; j < valores[i]; j++) {
            escribir.print("*");
         }
         escribir.println(" (" + valores[i] + ")");
      }
   }
}