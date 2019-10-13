/*
Crea la clase ComparadorArea para que implemente correctamente la interfaz Comparator y cuando se ejecute el siguiente código el
array se ordene según el área de los tríangulos, de menor a mayor y si el área es igual en función de la base también de menor a mayor:


 El resultado será:

[Triangulo(A321): 4.0 x 3.0, Triangulo(C321): 5.0 x 2.0, Triangulo(A123): 2.0 x 5.0, Triangulo(B123): 3.0 x 4.0]
[Triangulo(A123): 2.0 x 5.0, Triangulo(C321): 5.0 x 2.0, Triangulo(B123): 3.0 x 4.0, Triangulo(A321): 4.0 x 3.0]
*/

import java.util.*;

public class TrianguloTest {
   public static void main(String[] args) {
      Triangulo[] arrayTriangulo = {new Triangulo("A321", 4, 3), new Triangulo("C321", 5, 2), new Triangulo("A123", 2, 5), new Triangulo("B123", 3, 4)};
      
      System.out.println(Arrays.toString(arrayTriangulo));
      Arrays.sort(arrayTriangulo, new ComparadorArea());
      System.out.println(Arrays.toString(arrayTriangulo));
   }
}

class ComparadorArea implements Comparator<Triangulo> {

   @Override
   public int compare(Triangulo unTriangulo, Triangulo otroTriangulo) {
      int devuelve = 0;
      if(unTriangulo.getArea() < otroTriangulo.getArea()){
         devuelve = -1;
      }else if(unTriangulo.getArea() > otroTriangulo.getArea()) {
         devuelve = 1;
      } else if(unTriangulo.getArea() == otroTriangulo.getArea())  {
         if(unTriangulo.getBase() < otroTriangulo.getBase()) {
            devuelve = -1;
         }else if(unTriangulo.getBase() > otroTriangulo.getBase()) {
            devuelve = 1;
         }else{
            devuelve = 0;
         }
      }
      return devuelve;
   }
}