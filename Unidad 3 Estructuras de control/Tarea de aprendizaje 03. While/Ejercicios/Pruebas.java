public class Pruebas{
   public static void main(String[] args){
      String cadena = "HORRIBLE"; 
      String nuevaCadena= "";
      for(int i = 0; i < cadena.length(); i++) {
         if(cadena.charAt(cadena.length()-1) != 'A') {
            nuevaCadena += cadena.charAt(cadena.lenght()-1);
         }
      }
      System.outprintln(nuevaCadena);
   }
}