public class Ejercicio06{
   public static void main(String[] args){
      String cadena;
         
         // FALTA CODIGO   
      cadena "la granja de la abuela";
      //cadena = new String( "la granja de la abuela");
         
      System.out.println(metodo(cadena, "a", "A"));
   }
      
   public static String metodo(String texto, String letra1, String letra2) {
      return texto.replace(letra1, letra2);
   }
}
   
