/*
Completa el programa que pregunte el número filas que va a tener el triángulo y
dibuje un triágulo como en el ejemplo:

Introduce altura del triangulo: 
5
TRIANGULO
1
2 2
3 3 3
4 4 4 4
5 5 5 5 5
*/
import java.util.*;
public class Ejercicio14 {
   public static void main(String[] args) {
      Scanner teclado = new Scanner(System.in);
      System.out.println("Numero de filas del triangulo");
      int numFilas = teclado.nextInt();
      System.out.println(triangulo(numFilas));
   }
   
   public static String triangulo(int filas) {
      for(int i = 0; i <= filas; i++){
         for(int j = 1; j <= i; j++){
            System.out.print(i);
         }
         System.out.println();
         
      }
      return "";
   }
}