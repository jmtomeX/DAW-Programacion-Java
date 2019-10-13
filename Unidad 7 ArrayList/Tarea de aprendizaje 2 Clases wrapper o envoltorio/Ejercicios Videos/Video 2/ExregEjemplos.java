// Programa para demostrar el manejo de:
//    - el método parseXxx de las clases wrapper o envoltorio
//    - las expresiones regulares o regex

import java.util.*;
import java.util.regex.*;     // Para poder usar patrones

public class ExregEjemplos {
   public static void main(String[] args) {
      
   
      String texto = "Z,B,A,X,M,O,P,U";
      String []partes = texto.split(",");
      Arrays.sort(partes);
      System.out.println(Arrays.toString(partes));
   
   
      // Convierte cadenas de caracteres a tipos primitivos.
      // Se pueden guardar también directamente en objetos wrapper
      int i = Integer.parseInt("123");
      double d = Double.parseDouble("34.89");
      System.out.println(i + " - " + d);
      
      // Leemos un dato y si es un entero se convierte a int mediante parseInt
      // 4 bytes: -2147483648 al 2147483647
      Scanner leerDatos = new Scanner(System.in);
      System.out.println("Introduce un dato: ");
      String dato = leerDatos.next();
      Pattern formatoInt = Pattern.compile("-?[0-9]{1,9}");    // -999999999 al 999999999
      Matcher comparaFormato = formatoInt.matcher(dato);
      if (comparaFormato.matches()) {
         int numero = Integer.parseInt(dato);
         System.out.println(numero + " es un entero");
      } else {
         System.out.println("No lo es");
      }
      
      // Pedimos una fecha hasta que se introduce una válida: 1/3/2018
      Pattern formatoFecha = Pattern.compile("[0-9]{1,2}/\\d{1,2}/\\d{4}");
      do {
         System.out.println("Introduce una fecha (d/m/aaaa): ");
         String fecha = leerDatos.next();
         comparaFormato = formatoFecha.matcher(fecha);
      } while (!comparaFormato.matches());
      System.out.println("La fecha es válida");
   
      // Comprobamos si una fecha es válida y separamos día, mes y año: 01/03/88
      Pattern formatoFecha2 = Pattern.compile("(\\d{2})/(\\d{2})/(\\d{2})");
      String fecha = "01/03/88";
      comparaFormato = formatoFecha2.matcher(fecha);
      if (comparaFormato.matches()) {
         String diaTexto = comparaFormato.group(1);
         String mesTexto = comparaFormato.group(2);
         String yearTexto = comparaFormato.group(3);
         System.out.println(diaTexto + "-" + mesTexto + "-" + yearTexto);
      }         
      
   }
}