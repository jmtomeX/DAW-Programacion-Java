// Programa que utiliza booleanos como return de un método

import java.util.*;

public class BooleanIMC {
   public static void main(String[] args) {
      if(buenIMC(21)) {
         System.out.println("IMC correcto. Sigue así.");
      } else {
         System.out.println("IMC fuera de rango. Consulta a tu médico.");
      }
   }
   
   // Comprueba si el IMC es correcto.
   //
   // double imc - el valor del IMC
   // return true si es correcto false en caso contrario
   public static boolean buenIMC(double imc) {
      return imc >= 18.5 && imc < 25;
   }
}