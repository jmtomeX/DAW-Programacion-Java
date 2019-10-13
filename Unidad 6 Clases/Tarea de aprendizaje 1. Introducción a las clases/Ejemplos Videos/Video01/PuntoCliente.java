/*
   Programa cliente que utiliza la clase Punto definida en el fichero Punto.java
   Se debe compilar primero el fichero Punto.java y generar Punto.class
   para que el programa funcione
*/
public class PuntoCliente {
   public static void main(String[] args) {
   
      // Punto 1
      Punto p1 = new Punto();
      p1.x = 2;
      p1.y = 6;
      
      // Punto 2
      Punto p2 = new Punto();
      p2.x = 4;
      p2.y = 9;
            
      // Se ejecutan los métodos de la clase Punto y
      // se muestran los resultados obtenidos
      System.out.printf("Distancia del punto 1 al origen (0, 0): %.2f\n", p1.distanciaOrigen());
      System.out.printf("Distancia del punto 2 al origen (0, 0): %.2f\n", p2.distanciaOrigen());
      System.out.printf("Distancia entre los 2 puntos: %.2f\n", p1.distanciaPuntos(p2));
      System.out.println();
      
      p1.moverPunto(5, -7);
      System.out.printf("Distancia del punto 1 al origen (0, 0): %.2f\n", p1.distanciaOrigen());
      System.out.printf("Distancia del punto 2 al origen (0, 0): %.2f\n", p2.distanciaOrigen());
      System.out.printf("Distancia entre los 2 puntos: %.2f\n", p1.distanciaPuntos(p2));
      System.out.println();
   }
}