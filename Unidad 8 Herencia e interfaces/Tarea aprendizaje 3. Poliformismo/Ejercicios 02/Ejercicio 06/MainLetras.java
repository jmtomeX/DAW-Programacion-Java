import java.util.*;
public class MainLetras {
   public static void main(String[] args) {
   
      ArrayList<A> elementos = new ArrayList<A>();
      elementos.add(new A());
      elementos.add(new B());
      elementos.add(0, new C());
      elementos.add(2, new D());
   
      for (A unElemento : elementos) {
         System.out.println(unElemento);
         unElemento.metodo1();
         unElemento.metodo2();
         System.out.println();
      }
   }
}