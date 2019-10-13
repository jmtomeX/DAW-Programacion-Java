/*
Ordena el programa para pida un número hasta que el usuario haya introducido un número entero. Cuando el dato introducido sea correcto mostrará el mensaje: "Por fin has introducido un entero".
Por ejemplo:
Introduce un numero:
rewrw
Introduce un numero:
45.6
Introduce un numero:
56
Por fin has introducido un entero
*/
import java.util.*;
public class Ejercicio07 {
   public static void main(String[] args) {
      Scanner teclado = new Scanner(System.in);
      System.out.println("introduce un número: ");
      while(!teclado.hasNextInt()) {
         teclado.next();
         System.out.println("introduce un número: ");
      }
      int num = teclado.nextInt();
      System.out.println("Por fin has introducido un entero. ");
   }

}