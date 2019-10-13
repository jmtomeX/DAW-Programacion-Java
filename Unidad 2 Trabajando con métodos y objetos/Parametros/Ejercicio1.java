/*
Corrige el programa para que muestre lo siguiente por consola:
x = 10.01 y = 8.0
x = 10.01 y = 867.5309
El valor es: 867.5309
z = 5
*/
public class Ejercicio1 {
   public static void main(String[] args) {
      double num = 867.5309;
      double x = 10.01, y = 8.0;
      int z = 5;
      mostrar( x, y);
      mostrar(x, y = num);
      System.out.println("El valor es: " + num);
      System.out.println("z = " + z);
   }

   public static void mostrar(double x,  double y) {
      System.out.println("x = " +  x + " y = " + y);
    
   }
}