import java.util.*;
public class ComparadorBase implements Comparator<Triangulo> {
   public int compare(Triangulo triangulo1, Triangulo triangulo2) {
      double base1 = triangulo1.getBase();
      double base2 = triangulo2.getBase();
      if(base1 > base2) {
         return -1;
      }
      if(base1 == base2) {
         return triangulo1.getId().compareTo(triangulo2.getId());
      }
      return 1;
   }
}