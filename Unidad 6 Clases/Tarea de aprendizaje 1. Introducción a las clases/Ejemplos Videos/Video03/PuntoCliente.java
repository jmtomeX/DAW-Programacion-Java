/*
   Programa cliente que utiliza la clase Punto definida en el fichero Punto.java
   Se debe compilar primero el fichero Punto.java y generar Punto.class
   para que el programa funcione
*/
public class PuntoCliente {
   public static void main(String[] args) {
   
      // Punto 1
      Punto p1 = new Punto(6, 2);
      System.out.printf("Punto 1: (%d, %d)\n", p1.getX(), p1.getY());
      
      p1.setCoordenadas(2, 6);
      System.out.println("Punto 1: " + p1);
      
      // Punto 2
      Punto p2 = new Punto();
      System.out.printf("Punto 2: (%d, %d)\n", p2.getX(), p2.getY());
      
      p2.setCoordenadas(4, 9);
      System.out.println("Punto 2: " + p2);
      System.out.println();
      
      // Punto 3
      Punto p3 = new Punto(p1);
      System.out.printf("Punto 3: (%d, %d)\n", p3.getX(), p3.getY());
      
      p3.moverPunto(-5, 7);
      System.out.println("Punto 3: " + p3);
      System.out.println();
            
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