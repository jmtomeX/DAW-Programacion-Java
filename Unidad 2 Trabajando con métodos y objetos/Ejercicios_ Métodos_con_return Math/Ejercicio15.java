/*
Crea el método calculo().
Se le pasará el número de horas trabajadas y el precio por hora. Devolverá el precio de la avería que será igual al precio total más 50.
Por ejemplo:

System.out.println("El precio de la salida es: " + calculo(1.5, 50));

El precio de la salida es: 125.0
*/

public class Ejercicio15 {
   public static void main(String[] args) {
      System.out.println("El precio de la salida es: " + calculo(5, 5));
      System.out.println("El precio de la salida es: " + calculo(2.5, 45.5));
   }
   public static double calculo(double horas, double precioHora){
      final double SALIDA = 50;
      double total = (horas * precioHora) + SALIDA;
      return total; 
   } 
}