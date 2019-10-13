/*
   Definición de la clase Punto
*/
public class Punto {

   // Atributos, estado o variables miembro
   // Se declaran a nivel de clase y se puede trabajar con ellas
   // desde cualquier método de la clase sin pasarlos como parámetros
   private int x;
   private int y;

   // Constructores: métodos especiales que permiten instanciar una clase mediante new
   // No devuelven ningún tipo de dato y se llaman como la clase
   // Gracias a la sobrecarga de métodos puede haber más de uno
   // se diferenciarán únicamente por el número y tipo de los parámetros
   public Punto(int x, int y) {
      setCoordenadas(x, y);
   }
   
   public Punto() {
      setCoordenadas(0, 0);
   }
   
   public Punto(Punto otroPunto) {
      setCoordenadas(otroPunto.getX(), otroPunto.getY());
   }

   // Métodos consultores (get) y modificadores (set)
   public int getX() {
      return x;
   }
   
   public int getY() {
      return y;
   }
   
   public void setCoordenadas(int x, int y) {
      this.x = x;
      this.y = y;
   }
   
   // Método toString
   public String toString() {
      return "(" + x + ", " + y + ")";
   }

   // Calcula la distancia desde el origen (0, 0) a las coordenadas del punto
   public double distanciaOrigen() {
      Punto origen = new Punto();
      return distanciaPuntos(origen);
   }

   // Calcula la distancia entre el punto p2 y las coordenadas del punto  
   public double distanciaPuntos(Punto p2) {
      return Math.sqrt(Math.pow(x - p2.x, 2) + Math.pow(y - p2.y, 2));
   }

   // Mueve la coordenada x del punto una distancia dx y la coordenada y otra dy  
   public void moverPunto(int dx, int dy) {
      setCoordenadas(x + dx, y + dy);
   }
}
