// Este programa muestra ejemplos de uso de estructuras IF
import java.util.*;

public class EjemplosIf {
   public static void main(String[] args) {
      Scanner leerTeclado = new Scanner(System.in);
      //System.out.println("Resultado: " + contarMultiplos5(leerTeclado));
      System.out.println("Número de 'A's: " + contarA("Hola"));
      System.out.println(contarMultiplos5(leerTeclado));
   }
   
   // Pide 5 números y cuenta los que son multiplos de 5 
   public static int contarMultiplos5(Scanner consola) {
      int cont = 0;
      for(int i = 1; i <= 5; i++) {
         System.out.print("Introduce número " + i + ": ");
         int num = consola.nextInt();
         if(num % 5 == 0) {
            cont++;
         }
      }
      return cont;      
   }
   
   // Recibe una palabra y cuenta cuantas 'A's y 'a'-s tiene 
   public static int contarA(String palabra) {
      int cont = 0;
      palabra = palabra.toUpperCase();
      for(int i = 0; i < palabra.length(); i++) {
         if(palabra.charAt(i) == 'A') {
            cont++;
         }
      }
      return cont;      
   }
}