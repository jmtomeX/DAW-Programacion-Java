//Estudia el siguiente método y elige las opciones correctas:
import java.util.*;
public class Ejercicio06 {
   public static void main(String[] args) {
      Random r = new Random();
      dibujaCuadros(r);
   }
   public static void dibujaCuadros(Random r) {
      char letra = (char) (r.nextInt(27) + 'a');
      for(int linea = 1; linea <= 4; linea++) {            
         for(int i = 0; i < linea - 1; i++){
            System.out.print(letra + "-");
         }
         System.out.println(letra);
      }
   }
}