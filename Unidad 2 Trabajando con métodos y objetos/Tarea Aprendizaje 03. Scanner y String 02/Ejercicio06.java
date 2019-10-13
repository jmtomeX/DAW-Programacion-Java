/*
Suponiendo los siguientes valores:
*/


public class Ejercicio06{
   public static void main(String[] args){
      String cadena1 = "Caperucita Roja";
      String cadena2 = "El Gato con Botas";
      System.out.println(cadena1.length());
      System.out.println(cadena2.toUpperCase());
      System.out.println(cadena1.toLowerCase());
      System.out.println(cadena1.charAt(5));
      System.out.println(cadena2.charAt(10));
      System.out.println(cadena2.indexOf("a"));
      System.out.println(cadena1.indexOf("a"));
      System.out.println(cadena1.substring(6));
      System.out.println(cadena2.substring(3,7));
      System.out.println(cadena2.replace("Botas", "Zapatillas"));
      System.out.println(cadena2.replace(" ", "-"));
      System.out.println(cadena1.length()  - cadena2.length());
      System.out.println(cadena1.toUpperCase().indexOf("O"));
      System.out.println(cadena2.substring(0,7).toLowerCase());
      
   }
}
