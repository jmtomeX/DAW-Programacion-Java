/*
Crea un método que muestre los factores de un número y devuelva el número total de factores,
sabiendo que un factor será un valor por el que es divisible el número.
Por ejemplo:
System.out.println("Total: " + factores(15));
1 - 3 - 5 - 15
Total: 4

System.out.println("Total: " + factores(24));
1 - 2 - 3 - 4 - 6 - 8 - 12 - 24
Total: 7
*/
public class Ejercicio10 {
   public static void main(String[] args) {
      System.out.println("Total: " + factores(24));
      System.out.println("Total: " + factores(15));

   }
   public static int factores(int num) {
      System.out.print(1);
      int cont = 1;
      for(int i = 2; i <= num; i++) {
         if(num % i == 0) {
            System.out.print(" - " + i);
            cont++;
         }
      }
      System.out.println();
      return cont;
   }
}