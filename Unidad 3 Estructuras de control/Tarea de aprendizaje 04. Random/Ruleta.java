/*Este programa simula una versión simplificada de la ruleta española
Mientras tenga dinero suficiente,
el jugador siempre apuesta la misma cantidad al número "menor" (1-18) 
Al girar la ruleta saldrá un número entre 0 y 36
El jugador gana si sale un número entre 1 y 18, ambos incluidos

Se utiliza la clase Random*/
import java.util.*;

public class Ruleta {
   public static final int APUESTA = 5;

   public static void main(String[] args) {
      Random r = new Random();
      int dinero = 100;
      int max = 100;
      int cont = 0;
      
      while (dinero >= APUESTA) {
         int tirada = r.nextInt(37);
         if(tirada >= 1 && tirada <= 18) {   // GANA
            dinero += APUESTA;
         } else { // PIERDE
            dinero -= APUESTA;
         }
         if(dinero > max) {
            max = dinero;
         }
         cont++;
         System.out.println("Tirada: " + tirada + ", Dinero disponible: " + dinero);
      }
      
      System.out.println("Máximo: " + max);
      System.out.println("Número tiradas: " + cont);
   }
}