public class Ejercicio05{
   public static final int MAX = 5;

   public static void metodo() {
      int num = 0;
      for (int cont = MAX; cont >= 1; cont--) {
         num += (cont * cont);
      }
      System.out.println("El resultado es: " + num);
   }

   public static void main(String[] args) {
      metodo();
   }
}