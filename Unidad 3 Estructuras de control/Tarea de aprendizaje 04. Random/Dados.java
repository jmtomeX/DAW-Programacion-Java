// Se utiliza la clase Random
import java.util.*;

public class Dados {
   public static void main(String[] args) {
      Random rand = new Random();
        
        // Si la suma es distinta de 7 vuelvo a tirar los dados y sumarlos
      int intentos = 0;
      int suma;
      do {
         int tirada1 = rand.nextInt(6) + 1;
         int tirada2 = rand.nextInt(6) + 1;
         suma = tirada1 + tirada2;
         System.out.println("Dado 1: " + tirada1 + " Dado 2: " + tirada2 + " Suma: " + suma);
         intentos++;
      } while(suma != 7);
        
        // Si la suma es 7 acabo y muestro el resultado: intentos que he necesitado
        
      System.out.println("Has ganado despues de " + intentos + " tiradas!");
   }
}