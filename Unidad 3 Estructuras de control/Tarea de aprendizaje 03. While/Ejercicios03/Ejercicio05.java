//Estudia el siguiente método y elige las opciones correctas:
import java.util.*;
public class Ejercicio05 {
   public static void main(String[] args) {
      Scanner leerTeclado = new Scanner(System.in);
      int cont = 0;
      double suma = 0;
      System.out.println("Introduce calificacion:");
      double num = leerTeclado.nextDouble();
      while(num >= 0) {
         cont++;
         suma += num;
         System.out.println("Introduce calificacion:");
         num = leerTeclado.nextDouble();
      }
      if(cont > 0) {
         System.out.println("Media: " + suma / cont);
      }
   }
}