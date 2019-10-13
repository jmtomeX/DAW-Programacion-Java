/*
Escribe un programa que pida una palabra y dibuje un cuadrado como en el ejemplo:

Introduce tu palabra: 
KAIXO
K K K K K 
A A A A A 
I I I I I 
X X X X X 
O O O O O 
*/
import java.util.*;
public class Ejercicio13 {
   public static void main(String[] args) {
      Scanner teclado = new Scanner(System.in); 
      System.out.println("Introduce tu palabra:");
      String palabra = teclado.nextLine();
      for(int i = 0; i < palabra.length(); i++){
         for(int j = 0; j < palabra.length(); j++){
            System.out.print(palabra.toUpperCase().charAt(i) + " ");
         }
         System.out.println();
      }
   }
}