//Estudia el siguiente método y elige las opciones correctas:

public class Ejercicio06 {
   public static void main(String[] args) {
      System.out.println("Hay " + factores(51) + " números");
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