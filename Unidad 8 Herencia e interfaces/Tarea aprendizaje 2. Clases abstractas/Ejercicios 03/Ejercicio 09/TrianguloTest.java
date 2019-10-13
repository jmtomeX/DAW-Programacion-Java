import java.util.*;

public class TrianguloTest {
   public static void main(String[] args) {
      Triangulo[] arrayTriangulo = {new Triangulo("A321", 4, 3), new Triangulo("C321", 5, 2), new Triangulo("A123", 2, 5), new Triangulo("B123", 3, 4)};
      
      System.out.println(Arrays.toString(arrayTriangulo));
      Arrays.sort(arrayTriangulo, new ComparadorArea());
      System.out.println(Arrays.toString(arrayTriangulo));
   }
}
/*
 El resultado será:

[Triangulo(A321): 4.0 x 3.0, Triangulo(C321): 5.0 x 2.0, Triangulo(A123): 2.0 x 5.0, Triangulo(B123): 3.0 x 4.0]
[Triangulo(A123): 2.0 x 5.0, Triangulo(C321): 5.0 x 2.0, Triangulo(B123): 3.0 x 4.0, Triangulo(A321): 4.0 x 3.0]
*/