// Programa que utiliza booleanos como return de un método

import java.util.*;

public class BooleanDigitos {
   public static void main(String[] args) {
      if(tieneDigito(12034, 0)) {
         System.out.println("Tiene el dígito");
      } else {
         System.out.println("No lo tiene.");
      }
   }
   
   // Comprueba si uno de los dígitos del número es el indicado.
   //
   // int num - número
   // int digito - dígito que hay que buscar
   // return true si el dígito existe false en caso contrario
   public static boolean tieneDigito(int num, int digito) {
      // Recorre todos los dígitos
      int siguienteDigito;
      while(num > 0) {
         siguienteDigito = num % 10;   // Obtiene el último dígito
         if(siguienteDigito == digito) {
            return true;
         }
         //System.out.println("Número: " + num + " Dígito: " + siguienteDigito);
         num = num / 10;   // Elimina el último dígito para seguir buscando
      }
      return false;
   }
}