/*
Escribe el método esConsonante() al que se le pasa un carácter y devuelve true si es una vocal y false en caso contrario:
Por ejemplo:
System.out.println(esConsonante('F'));
true
System.out.println(esConsonante('a'));
false
*/
public class Ejercicio10 {
   public static void main(String[] args) {
      System.out.println(esConsonante('F'));
      System.out.println(esConsonante('a'));
      System.out.println(esConsonante('A'));
   }
   public static boolean esConsonante(char caracter) {
      String cadena = Character.toString(caracter);
      cadena = cadena.toLowerCase();
      if(cadena.equals("a") || cadena.equals("e") || cadena.equals("i") || cadena.equals("o") || cadena.equals("u")){
         return false;
      }
      return true;
   }
}
/*
Método isLowerCase para saber si un caracter esta en minuscula
Método isUpperCase para saber si un caracter esta en mayuscula
*/