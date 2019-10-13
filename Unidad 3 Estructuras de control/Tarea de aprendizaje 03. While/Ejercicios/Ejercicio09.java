/*
Ordena el método deletrear() para que a partir de una palabra, cree otra en mayúsculas en la que se eliminen todas las "A"s.
Por ejemplo: 
String resultado = deletrear("salida");
System.out.println(resultado);
SLID
*/
class Ejercicio09{
   public static void main(String[] args){
      String resultado = deletrear("slida");
      System.out.println(resultado);
   }
   public static String deletrear(String cadena){
      String nuevaCadena = "";
      cadena = cadena.toUpperCase();
      
      for(int i = 0; i < cadena.length(); i++) {
        
         if(cadena.charAt(i) != 'A'){
            nuevaCadena += cadena.charAt(i);   
            System.out.println(cadena.charAt(cadena.length()-1));
         }
      }
      if(cadena.charAt(cadena.length()-1) != 'A') {
         nuevaCadena += cadena.charAt(cadena.length()-1); 
        
      }
      return nuevaCadena;
   }
   
}