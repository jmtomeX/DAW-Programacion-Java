//Indica cuántas veces se repite el siguiente bucle while:
//Se ejecuta 5 veces.
public class Ejercicio01 {
   public static void main(String[] args) {
      String palabra= "a";
      while (palabra.length() < 10) {
         palabra = "b" + palabra + "b";
         System.out.println(palabra);
      }
   }
}
