/*
Crea un programa que pida 5 números por teclado y realice su producto sólo si son menores que 10.

Por ejemplo:
Introduce numero 1: 2
Introduce numero 2: 4
Introduce numero 3: 12
Introduce numero 4: 3
Introduce numero 4: 11
El resultado es 24

24 es igual a 2 x 4 x 3
*/


import java.util.*;

public class Ejercicio07 {
   public static void main(String[] args) {
      Scanner teclado = new Scanner(System.in);
      int producto = 1;
      for(int i = 1; i <= 5; i++){
         System.out.print("Introduce numero " + i + ": ");
         int numero = teclado.nextInt();
         if(numero < 10){
            producto *= numero;
         }
        
      }
      
      System.out.print("\nEl resultado es " + producto);
   }
}