import java.util.*;
public class CosaMain {
   public static void main(String[] args) {
      ArrayList<Cosa> elementos = new ArrayList<Cosa>();
      elementos.add(new MesaJardin());
      elementos.add(new Cosa());
      elementos.add(1, new Mueble());
      elementos.add(new Mesa());
   
      for (Cosa unElemento : elementos) {
         unElemento.metodo1();
         System.out.println(unElemento);
         unElemento.metodo2();
      }
   }
}