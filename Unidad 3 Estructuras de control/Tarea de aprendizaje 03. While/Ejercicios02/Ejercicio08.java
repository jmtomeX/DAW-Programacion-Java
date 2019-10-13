/*
Completa el método deletrear() para que a partir de una palabra, cree otra en la que las letras estén en minúsculas y separadas por barras.
Por ejemplo:

System.out.println(deletrear("PALABRA"));
/p/a/l/a/b/r/a/
*/

public class Ejercicio08 {
   public static void main(String[] args) {
      System.out.println(deletrear("palabra"));
   }
   public static String deletrear(String cadena) {
      cadena = cadena.toUpperCase();
      String nuevaCadena = "";
      System.out.print(cadena.charAt(0));
      for(int  i = 1; i < cadena.length() ; i++) {
         nuevaCadena += "/" + cadena.charAt(i) ;
      }
      return nuevaCadena;
   } 
}
     
     
     
     /*
      public static String deletrear(String cadena) {
      cadena = cadena.toLowerCase();
      System.out.print("/");
      String nuevaCadena= "";
      int cont = 0;
      for(int i = 0; i < cadena.length(); i++) {
         cont++;
         nuevaCadena += cadena.charAt(i) + "/";
         if(cont == cadena.length()){
            System.out.print(nuevaCadena);
         }
      }
      
      return nuevaCadena;
   }

     */
