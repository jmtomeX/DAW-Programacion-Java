/*
Corríge la siguiente versión para que implemente correctamente la interfaz Comparable y cuando se ejecute
el siguiente código el array se ordene según la base de los tríangulos, de mayor a menor:
 El resultado será:

   [Triangulo(A321): 4.0 x 3.0, Triangulo(C321): 5.0 x 2.0, Triangulo(A123): 2.0 x 5.0, Triangulo(B123): 3.0 x 4.0]
   [Triangulo(C321): 5.0 x 2.0, Triangulo(A321): 4.0 x 3.0, Triangulo(B123): 3.0 x 4.0, Triangulo(A123): 2.0 x 5.0]
*/
import java.util.*;

public class Triangulo implements Comparable<Triangulo> {
   private String id;
   private double base;
   private double altura;
   
   public Triangulo(String id, double base, double altura) {
      this.id = id;
      this.base = base;
      this.altura = altura;
   }
   
   public String toString() {
      return "Triangulo(" + id + "): " + base + " x " + altura;
   }
   
   public double getArea() {
      return base * altura;
   }
   
   @Override
    public int compareTo(Triangulo unTriangulo) {
      if (unTriangulo.base < base) {
         return -1;
      }
      if (unTriangulo.base > base) {
         return 1;
      }
      return 0;
   }
}