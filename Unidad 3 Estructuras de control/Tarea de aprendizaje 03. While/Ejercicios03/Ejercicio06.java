//Estudia el siguiente método y elige las opciones correctas:
public class Ejercicio06 {
   public static void main(String[] args) {
      System.out.println(metodo(12324));
   }
   public static int metodo(int num) {
      int menor = num % 10;
      num = num / 10;
      int mayor = num;
      while (num > 0) {
         menor = Math.min(mayor, num % 10);
         num = num / 10;
      }
      return menor;
   }
}