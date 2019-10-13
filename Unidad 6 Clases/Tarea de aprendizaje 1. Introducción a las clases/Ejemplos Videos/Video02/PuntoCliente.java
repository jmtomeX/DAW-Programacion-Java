/*
   Programa cliente que utiliza la clase Punto definida en el fichero Punto.java
   Se debe compilar primero el fichero Punto.java y generar Punto.class
   para que el programa funcione
*/
public class PuntoCliente {
   public static void main(String[] args) {
      // Punto 1
      Punto p1 = new Punto();
      p1.setCoordenadas(2, 6);
      System.out.printf("Punto 1: (%d, %d)\n", p1.getX(), p1.getY());
      
      // Método toString existe por defecto
      // Imprime el nombre del objeto y su dirección en memoria
      // Se puede sobreescribir para adaptarlo a nuestras necesidades
      // Si no se indica método, se invoca toString
      System.out.println("Punto 1: " + p1.toString());
      System.out.println("Punto 1: " + p1);
      
      // Punto 2
      Punto p2 = new Punto();
      p2.setCoordenadas(4, 9);
      System.out.printf("Punto 2: (%d, %d)\n", p2.getX(), p2.getY());
      System.out.println("Punto 2: " + p2);
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