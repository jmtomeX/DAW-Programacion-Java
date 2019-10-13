/*
   Definición de la clase Punto
*/
public class Punto {

   // Atributos, estado o variables miembro
   // Se declaran a nivel de clase y se puede trabajar con ellas
   // desde cualquier método de la clase sin pasarlos como parámetros
   public int x;
   public int y;


   // Comportamiento, interfaz o métodos miembro
   // Se declaran public para ser accesibles desde fuera de la clase
   // Se elimina el modificador static
   // Trabajan con los atributos directamente

   // Calcula la distancia desde el origen (0, 0) a las coordenadas del punto
   public double distanciaOrigen() {
      return Math.sqrt(x * x + y * y);
   }
   
   // Calcula la distancia entre el punto p2 y las coordenadas del punto
   public double distanciaPuntos(Punto p2) {
      return Math.sqrt(Math.pow(x - p2.x, 2) + Math.pow(y - p2.y, 2));
   }
   
   // Mueve la coordenada x del punto una distancia dx y la coordenada y otra dy
   public void moverPunto(int dx, int dy) {
      x += dx;
      y += dy;
   }
}