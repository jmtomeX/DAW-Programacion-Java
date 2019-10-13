/*
Escribe el método problema() para que muestre lo siguiente por consola:

|  ^^  |
| ^  ^ |
|^    ^|
*/
public class Ejercicio06 {
   public static void main(String[] args) {
     
      for (int linea = 1; linea <= 3; linea++) {
         System.out.print("|");
         for(int i = 1; i <= (-1 * linea) + 3; i++){
            System.out.print(" ");
         }
         System.out.print("^");
         for(int i = 1; i <= (2 *linea) - 2; i++){
            System.out.print(" ");
         }
         
         System.out.print("^");
         for(int i = 1; i <= (-1 * linea) + 3; i++){
            System.out.print(" ");
         }
         System.out.println("|");
      }
   }
}