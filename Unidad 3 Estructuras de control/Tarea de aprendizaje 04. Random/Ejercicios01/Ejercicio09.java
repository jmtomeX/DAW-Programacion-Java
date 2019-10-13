/*
Crea un método que dibuje un triángulo de una letra al azar entre 'a' y 'z'.
Por ejemplo:
cuadrosAleatorios();
h
h-h
h-h-h
h-h-h-h

cuadrosAleatorios();
o
o-o
o-o-o
o-o-o-o
*/

import java.util.*;
public class Ejercicio09 {
   public static void main(String[] args) {
        // Utilizamos la semilla 20 para que los numeros sean los mismos y se pueda autocorregir
      Random r = new Random(20);
      cuadrosAleatorios(r);
      cuadrosAleatorios(r);
   }
    // CREA EL METODO AQUI
   public static void cuadrosAleatorios(Random r) {
      char letra = (char) ('a' + r.nextInt(26));
   
      for(int linea = 1; linea <= 4; linea++) {            
         for(int i = 0; i < linea - 1; i++){
            System.out.print(letra + "-");
         }
         System.out.println(letra);
      }
   }
}