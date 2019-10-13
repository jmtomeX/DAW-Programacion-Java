/*
Reescribe el siguiente metodo para mejorar el código y reducir el número de líneas de código.

El método devuelve true cuando la 2 letra y la penúltima son iguales, false en caso contrario.

public static boolean comienzoFin(String cadena) {
    if (cadena.charAt(1) == cadena.charAt(cadena.length() - 2)) {
        return true;
    } else {
        return false;
    }
}
*/
public class Ejercicio01 {
   public static void main(String[] args) {
      System.out.println(comienzoFin("esss"));
   }
   public static boolean comienzoFin(String cadena) {
      return cadena.charAt(1) == cadena.charAt(cadena.length() - 2);
   
   }
}