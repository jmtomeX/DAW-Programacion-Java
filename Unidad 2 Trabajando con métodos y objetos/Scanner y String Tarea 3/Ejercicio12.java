/*
Crea un programa que pida 5 números por teclado y realice su producto.

Por ejemplo:
Introduce numero 1: 2
Introduce numero 2: 4
Introduce numero 3: 2
Introduce numero 4: 3
Introduce numero 4: 1
El resultado es 48

48 es igual a 2 x 4 x 2 x 3 x 1
*/
import java.util.*;
public class Ejercicio12{
   public static Scanner teclado = new Scanner(System.in);
   public static int numero= 0;
   public static int product= 1;
   
   public static void main(String[] args) {
   
      Scanner teclado = new Scanner(System.in);
      int numero= 0;
      int product= 1;
      for(int i = 1; i <= 5;i++){
         System.out.print("Introduce  numero " + i + ":");
         numero = teclado.nextInt();
         product*=numero;
      }         
      System.out.print("El resultado es " + product);
   }
}