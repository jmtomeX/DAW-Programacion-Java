import java.io.*;
import java.util.*;
public class Delimiter {
   public static void main(String[] args) {
   
      Scanner leer = new Scanner("Ana García/Mujer/18");
      leer.useDelimiter("/");
      System.out.println("Separador: " + leer.delimiter());
      while(leer.hasNext()){
         System.out.println(leer.next());
      }
   
   }
}