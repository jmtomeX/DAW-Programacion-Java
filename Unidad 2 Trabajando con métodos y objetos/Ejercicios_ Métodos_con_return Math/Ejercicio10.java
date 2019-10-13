/*
Corrige el programa para que muestre lo siguiente por consola:

La temperatura en grados Celsius es: 37.0
*/
public class Ejercicio10 {
   public static void main(String[] args) {
      double farenheit = 98.6;
      double celsius = 0.0;
      double respuesta = convertir(farenheit, celsius);
      System.out.println("La temperatura en grados Celsius es: " + respuesta);
   }

   public static double convertir(double farenheit, double celsius) {
      celsius = (farenheit - 32) * 5 / 9;
      return celsius;
   }
}