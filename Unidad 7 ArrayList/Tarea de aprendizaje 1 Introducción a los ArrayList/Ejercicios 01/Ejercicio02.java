import java.util.*;
public class Ejercicio02{
   public static void main(String[] args) {
      ArrayList<String> lista = new ArrayList<String>(Arrays.asList("ROJO", "BLANCO", "AZUL", "NEGRO"));
     
      System.out.println( lista.size());	
   
      System.out.println(lista.indexOf("AZUL"));	
   
      System.out.println(lista.indexOf("azul")); 	
   
      System.out.println(lista.get(1));
      
      System.out.println(lista.isEmpty());
   
      System.out.println(lista.get(lista.size()-1));
      
      System.out.println(lista);
   }
}
