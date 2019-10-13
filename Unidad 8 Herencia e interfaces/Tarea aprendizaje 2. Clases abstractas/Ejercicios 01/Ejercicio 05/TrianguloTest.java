import java.util.*;

public class TrianguloTest {
   public static void main(String[] args) {
      Triangulo[] arrayTriangulo = {new Triangulo("A321", 4, 3), new Triangulo("C321", 5, 2), new Triangulo("A123", 2, 5), new Triangulo("B123", 3, 4)};
      
      System.out.println(Arrays.toString(arrayTriangulo));
      Arrays.sort(arrayTriangulo);
      System.out.println(Arrays.toString(arrayTriangulo));
   }
}