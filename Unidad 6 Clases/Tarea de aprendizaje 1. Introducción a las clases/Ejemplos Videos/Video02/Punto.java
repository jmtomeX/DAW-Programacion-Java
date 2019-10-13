/*
   Definición de la clase Punto
*/
public class Punto {

   // Atributos, estado o variables miembro
   // Se declaran a nivel de clase y se puede trabajar con ellas
   // desde cualquier método de la clase sin pasarlos como parámetros
   private int x;
   private int y;

   // Comportamiento, interfaz o métodos miembro
   // Se declaran public para ser accesibles desde fuera de la clase
   // Se elimina el modificador static
   // Trabajan con los atributos directamente
   
   // Método consultor para el atributo x
   // Devuelve el valor de la coordenada x
   public int getX() {
      return x;
   }

   // Método consultor para el atributo y  
   public int getY() {
      return y;
   }

   // Método modificador para los atributos x e y
   // Modifica el valor de x e y a partir de los valores pasados como parámetros
   // Utiliza la palabra reservada this (este objeto) para distinguir
   // las variables miembro x e y de los parámetros x e y    
   public void setCoordenadas(int x, int y) {
      this.x = x;
      this.y = y;
   }
   
   // Método para formatear los datos del punto para mostrarlos por consola
   // Existe por defecto y lo reescribimos para que se adapte a nuestras necesidades
   public String toString() {
      return "(" + x + ", " + y + ")";
   }

   // Calcula la distancia desde el origen (0, 0) a las coordenadas del punto
   // Podemos crear el punto (0, 0) y después llamar al método distanciaPuntos
   // Se reutiliza el código y es más fácil de mantener
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
      x += dx;
      y += dy;
   }
}