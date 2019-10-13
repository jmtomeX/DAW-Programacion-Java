// Este programa muestra como utilizar return con IF
import java.util.*;

public class IMC {
   public static void main(String[] args) {
      System.out.println("Este program clasifica a una persona segun su Indice de Masa Corporal.");
      System.out.println("Según tu IMC tu situación es: " + clasificaIMC(60, 1.70));
      System.out.println("Según tu IMC tu situaciónn es: " + clasificaIMC(80, 1.80));
      System.out.println("Según tu IMC tu situación es: " + clasificaIMC(80, 1.60));
      System.out.println("Según tu IMC tu situación es: " + clasificaIMC(45, 1.70));
   }
   
   // A partir del peso y la altura obtiene el Indice de Masa Corporal
   // Y devuelve una cadena de caracteres indicando el estado correspondiente
   public static String clasificaIMC(double peso, double altura) {
      double indice = peso / Math.pow(altura, 2);
      // Clasificar según IMC
      if(indice < 18.5) {                       // bajo peso: < 18.50
         return "bajo peso";
      } else if (indice >= 18.5 && indice < 25) {      // normal: 18,5 - 24,99
         return "normal";
      } else if (indice >= 25 && indice < 30) {        // sobrepeso: >= 25,00
         return "sobrepeso";
      }                       // obesidad: >= 30,00
      return "obesidad";
   }
}