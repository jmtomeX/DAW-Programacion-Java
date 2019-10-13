//Ordena el siguiente programa para que simule cinco lanzamientos de monedas de cara o cruz 
//y muestre el número de caras que han salido.
import java.util.*;
public class Ejercicio03 {
   public static void main(String[] args) {
      Random r = new Random();
      int num;
      int cont = 0;
      int cont2 = 0;
      for(int i = 0; i < 5; i++){
         num = r.nextInt(2);
         if(num == 0){
            cont++;
         }else{
            cont2++;
         }
      }
      System.out.println();
      System.out.println("Caras: " + cont);
      System.out.println("Cruces: " + cont2);
   }
}