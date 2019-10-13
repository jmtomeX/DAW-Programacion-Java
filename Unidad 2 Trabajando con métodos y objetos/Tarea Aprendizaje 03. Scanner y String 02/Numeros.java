//Este programa muestra varios usos de la sentencia if-else
import java.util.*;

public class Numeros {
   public static void main(String[] args) {
      Scanner leerTeclado = new Scanner(System.in);
      
      System.out.print("Numero? ");
      if(leerTeclado.hasNextInt()){//hasNextDouble
         int numero = leerTeclado.nextInt();
         
         // comprueba si el numero es par o impar
         if(numero % 2 == 0) {
            System.out.println(numero + " es par");
         } else {
            System.out.println(numero + " es impar");
         }  
      
         // comprueba si el numero es positivo o negativo
         if(numero < 0) {
            System.out.println(numero + " es negativo");
         } else if(numero > 0) {
            System.out.println(numero + " es positivo");
         }
      
         // comprueba si el numero es multiplo de los 3 primeros numeros primos (2, 3 y 5)
         if(numero % 2 == 0) {
            System.out.println(numero + " es multiplo de 2");
         }
         if(numero % 3 == 0) {
            System.out.println(numero + " es multiplo de 3");
         }
         if(numero % 5 == 0) {
            System.out.println(numero + " es multiplo de 5");
         }
      } else {
         System.out.println("No has introducido un numero entero");
      }
   }  }