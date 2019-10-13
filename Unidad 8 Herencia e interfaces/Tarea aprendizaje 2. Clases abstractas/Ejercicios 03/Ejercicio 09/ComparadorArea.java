/*
Crea la clase ComparadorArea para que implemente correctamente la interfaz Comparator y cuando se ejecute el siguiente
código el array se ordene según el área de los tríangulos, de menor a mayor y si el área es igual en función de la base
también de menor a mayor:
*/
import java.util.*;

public class ComparadorArea implements Comparator<Triangulo> {

   public int compare(Triangulo unTriangulo, Triangulo dosTriangulo) {
      double area1 = unTriangulo.getArea();
      double area2 = dosTriangulo.getArea();
      if(area1 == area2) {
         double base1 = unTriangulo.getBase();
         double base2 = dosTriangulo.getBase();
         if(base1 < base2) {
            return -1;
         }
         if(base1 > base2) {
            return 1;
         }
         return 0;
      }
      if(area1 < area2) {
         return -1;
      }
      return 1;
   }
}

