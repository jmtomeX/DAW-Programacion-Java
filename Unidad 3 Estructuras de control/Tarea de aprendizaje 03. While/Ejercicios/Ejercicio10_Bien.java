   /*
Crea un programa que calcule la media de las calificaciones introducidas. El programa pedirá valores hasta que se introduzca
un número menor que 0. Si el primer número introducido es negativo no mostrará nada.
Haz que el programa sea robusto frente a valores incorrectos. Es decir, no leerá el dato hasta comprobar
 que el valor introducido es realmente un número real. Para ello crea el método leerDouble().
Por ejemplo:
Introduce calificacion: 
-10
Introduce calificacion: 
6,75
Introduce calificacion: 
abc
Valor no valido. Introduce calificacion:
7,25
Introduce calificacion: 
-5
Media: 7.0
*/
import java.util.*;
public class Ejercicio10_Bien {
   public static void main(String[] args) {
      Scanner leerTeclado = new Scanner(System.in);
      int cont = 0;
      double suma = 0;
      System.out.println("Introduce calificacion:");
      double num = leerDouble(leerTeclado);
      while(num >= 0) {
         cont++;
         suma += num;
         System.out.println("Introduce calificacion:");
         num = leerDouble(leerTeclado);
      }
      if(cont > 0) {
         System.out.println("Media: " + suma / cont);
      }
   }
   public static double leerDouble(Scanner teclado) {
      while(!teclado.hasNextDouble()) {
         teclado.nextLine();
         System.out.println("Dato no valido. Introduce calificacion:");
      }
      double num = teclado.nextDouble();
      teclado.nextLine();
      return num;
   }
}