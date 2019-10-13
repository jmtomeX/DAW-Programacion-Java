// Este programa utiliza nuevos tipos de bucles:
//   bucles while y do-while.

import java.util.*;

public class BuclesWhile {
   public static void main(String[] args) {
      Scanner leerTeclado = new Scanner(System.in);
         
      //sumaHasta(leerTeclado, 500);
      
      System.out.println();
      int num = leerEntero2(leerTeclado);
      System.out.println("Número: " + num);
      sumaHasta(leerTeclado);
   }
   
   // Pide y suma números hasta que se supera el máximo permitido
   //
   // int max - limite para el valor de la suma
   // Scanner teclado - objeto de tipo Scanner para leer los números por teclado
   public static void sumaHasta(Scanner teclado) {
      int suma = 0;
      while(suma < 1000) {
         System.out.print("Introduce número: ");
         int num = teclado.nextInt();
         suma += num;
         System.out.println("La suma es " + suma);
      }
      System.out.println("El total es " + suma);
   }

   // Comprueba que el número introducido es realmente un entero antes de leerlo
   // Si no lo es, lo descarta y pide otro
   //
   // Scanner teclado - objeto de tipo Scanner para leer los números por teclado
   public static int leerEntero(Scanner teclado) {
      System.out.print("Introduce número: ");
      while(!teclado.hasNextInt()) {
         System.out.print("Dato no valido. Introduce número: ");
         teclado.next();//de esta manera se borraría el dato si no es la condición del while.
      }
      
      return teclado.nextInt();
   }
   public static int leerEntero2(Scanner teclado) {
      System.out.print("Introduce númer: ");
      while(teclado.hasNextInt() != true){
         System.out.print("Dato no valido, Introduce número: ");
         teclado.next();
      }
      int num = teclado.nextInt();
      return num;
   }
   
}