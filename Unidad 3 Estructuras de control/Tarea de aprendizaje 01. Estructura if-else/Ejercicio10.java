/*
Escribe un programa que pida un número y diga si es positivo, negativo o 0.

Ejemplo:

Introduce un numero: 4
El numero es positivo.

Introduce un numero: -5
El numero es negativo.

Introduce un numero: 0
El numero es 0.
*/
import java.util.*;
public class Ejercicio10 {
   public static void main(String[] args) {
      Scanner teclado = new Scanner(System.in);
      System.out.println("Introduce un numero:");
      int numero = teclado.nextInt();
      if(numero > 0){
         System.out.println("El numero es positivo.");
      } else if(numero < 0){
         System.out.println("El numero es negativo.");
      }else{
         System.out.println("El numero es 0.");
      }
   
   }
}