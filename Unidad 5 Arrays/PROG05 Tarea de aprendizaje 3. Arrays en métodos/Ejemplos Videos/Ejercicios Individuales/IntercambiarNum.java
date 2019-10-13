import java.util.*;

public class IntercambiarNum {
   public static void main(String[] args) {
   //Intercambia el valor entre 2 variables
      int a = 5;
      int b = 7;
      System.out.println(a + " " + b);
      intercambiar(a, b);
      System.out.println(a + " " + b);
   }
   //Este método intercambia el valor entre 2 variables utilizando una variable intermedia
   // Solo se cambia dentro del método
   // No tiene efecto fuera porque está trabajando con copias de las variables originales. Paso por valor
   public static void intercambiar(int x, int y) {
      int temp = x;
      x = y;
      y = temp;
      System.out.println(x + " " + y);
   }

}