/*
   Programa que trabaja con puntos sin utilizar clases
   Programación procedimental - estructurada
*/
public class Puntos {

   public static void main(String[] args) {
      // Punto 1
      int x1 = 2;
      int y1 = 6;
      
      // Punto 2
      int x2 = 4;
      int y2 = 9;
      
      System.out.printf("Distancia del punto 1 al origen (0, 0): %.2f\n", distanciaOrigen(x1, y1));
      System.out.printf("Distancia del punto 2 al origen (0, 0): %.2f\n", distanciaOrigen(x2, y2));
      System.out.printf("Distancia entre los 2 puntos: %.2f\n", distanciaPuntos(x1, y1, x2, y2));
      System.out.println();
   }
   
   public static double distanciaOrigen(int x, int y) {
      return Math.sqrt(x * x + y * y);
   }
   
   public static double distanciaPuntos(int x1, int y1, int x2, int y2) {
      return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
   }
}