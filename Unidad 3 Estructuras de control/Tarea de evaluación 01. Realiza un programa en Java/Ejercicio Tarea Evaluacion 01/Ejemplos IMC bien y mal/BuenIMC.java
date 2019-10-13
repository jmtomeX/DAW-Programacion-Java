// Este program obtiene el IMC para 2 personas.
// Esta version incluye distintos metodos bien diseñados
// que proporciona estructura y evitan la redundancia.

import java.util.*;

public class BuenIMC {
   public static void main(String[] args) {
      presentacion();
      Scanner leerTeclado = new Scanner(System.in);
      double imc1 = getIMC(leerTeclado);
      double imc2 = getIMC(leerTeclado);
      muestraResultados(imc1, imc2);
   }

   // Presenta el program al usuario
   public static void presentacion() {
      System.out.println("Este programa lee la altura y el peso de");
      System.out.println("una persona y calcula su IMC");
      System.out.println("su Indice de Masa Corporal.");
      System.out.println();
   }

   // Utiliza el objeto Scanner para pedir la altura y el peso,
   // y devuelve el IMC
   public static double getIMC(Scanner leerTeclado) {
      System.out.println("Introduce los datos de la siguiente persona:");
      System.out.print("altura en metros ");
      double altura = leerTeclado.nextDouble();
      System.out.print("peso en kilogramos ");
      double peso = leerTeclado.nextDouble();
      double imc = calculaIMC(altura, peso);
      System.out.println();
      return imc;
   }

   // Calcula el IMC a partir del peso en kilos y la altura en metros
   public static double calculaIMC(double altura, double peso) {
      return peso / (altura * altura);
   }

   // Muestra los resultados obtenidos para cada persona
   public static void muestraResultados(double imc1, double imc2) {
      System.out.println("Persona #1 indice de masa corporal = " + round1(imc1));
      reportStatus(imc1);
      System.out.println("Persona #2 indice de masa corporal = " + round1(imc2));
      reportStatus(imc2);
   }

   // Muestra el estado de una persona segun su IMC
   public static void reportStatus(double imc) {
      if (imc < 18.5) {
         System.out.println("bajo peso");
      } else if (imc < 25) {
         System.out.println("normal");
      } else if (imc < 30) {
         System.out.println("sobrepeso");
      } else { // imc >= 30
         System.out.println("obeso");
      }
   }

   // devuelve el resultado de redondear el numero a un decimal
   public static double round1(double n) {
      return Math.round(n * 10.0) / 10.0;
   }
}