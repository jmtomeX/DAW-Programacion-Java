/****************FALLA**********************************
Corrige el programa para que pida números hasta que el usuario introduzca el valor -5. Al final dirá cuál es el número mayor y menor de los introducidos.
Por ejemplo:
Introduce un numero:
5
Introduce un numero:
15
Introduce un numero:
25
Introduce un numero:
-5
El mayor es 25 y el menor es 5

Introduce un numero:
-5
No has introducido ningun numero
*/
import java.util.*;
public class Ejercicio07 {
   public static final int FINAL = -5;
   public static void main(String[] args) {
      Scanner teclado = new Scanner(System.in);
      System.out.println("Introduce un numero:");
      int num = teclado.nextInt();
      int mayor = num;
      int menor = num;
      while(num != FINAL) {
         mayor = Math.max(mayor, num);
         menor = Math.min(menor, num);
         System.out.println("Introduce un numero:");
         num = teclado.nextInt();
      }
      if(mayor != FINAL) {
         System.out.println("El mayor es " + mayor + " y el menor es " +  menor);
      } else {
         System.out.println("No has introducido ningun numero");
      }
   }
}