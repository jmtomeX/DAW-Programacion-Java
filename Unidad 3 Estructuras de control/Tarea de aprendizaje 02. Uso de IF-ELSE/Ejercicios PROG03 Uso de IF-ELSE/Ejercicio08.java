/*
Completa el programa para que pida 4 números por teclado y diga cuántos han sido positivos.

Por ejemplo:

Introduce numero 1: 2
Introduce numero 2: 4
Introduce numero 3: -5
Introduce numero 4: 3
El resultado es 3

porque 2, 4 y 3 son positivos.
*/
import java.util.*;

public class Ejercicio08 {
   public static void main(String[] args) {
      Scanner leerTeclado = new Scanner(System.in);
      int positivos = contarPositivos(leerTeclado);
      System.out.print("el resultado es " + positivos + ".");         
   }
   
   public static int contarPositivos(Scanner teclado){
      int contador = 0;
      for(int i = 1; i <= 4; i++){
         System.out.println("Introduce numero " + i +":");
         int numero = teclado.nextInt();
         if(numero > 0){
            contador++ ;
         }
      }
      return contador;
   }
}