//Login sencillo en base a una contraseña

import java.util.*;

public class Login {
   public static void main(String[] args) {
      Scanner leerTeclado = new Scanner(System.in);     
      System.out.print("Introduce password: ");
      String entrada = leerTeclado.next();
      String password = "=PROG2018";
      if (entrada.equals(password)) {
         System.out.println("Adelante!");
      } else {
         System.out.println("Intentalo otra vez");
      //Variable Objeto String
         String cad = "hola";
         System.out.println(cad.startsWith("ho"));
         System.out.println( cad.startsWith("ho"));
         System.out.println(cad.endsWith("l"));
         System.out.println(cad.equalsIgnoreCase("HOLA"));
        
         System.out.println(cad.charAt(0) == 't');
         
         
      }
   
   }
}