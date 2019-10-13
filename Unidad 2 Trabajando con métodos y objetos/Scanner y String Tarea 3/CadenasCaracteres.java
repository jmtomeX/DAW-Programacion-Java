import java.util.*;

// Programa que muestra el uso de la clase String

public class CadenasCaracteres {
   public static void main(String[] args) {
   // Lee una palabra por teclado
      Scanner teclado = new Scanner(System.in);
      System.out.print("Escribe una palabra: ");
      String palabra = teclado.next();
      
      // Convierte la palabra a mayúscula
      palabra = palabra.toUpperCase();
      
      // Muestra la palabra, el número de letras y la primera letra
      System.out.println(palabra + " tiene " + palabra.length() + 
          " letras y empieza por la letra " + palabra.substring(0, 1));
      
      // Recorre las letra de una palabra, guarda la siguiente letra en una nueva cadena
      String mensajeCifrado = "";
      for (int i = 0; i < palabra.length(); i++) {
         mensajeCifrado += (char) (palabra.charAt(i) + 1);
      }
      System.out.println("Mensaje cifrado: " + mensajeCifrado);
      
      String mensajeDesCifrado = "";
      for (int i = 0; i < palabra.length(); i++) {
         mensajeDesCifrado += (char) (mensajeCifrado.charAt(i) - 1);
      }
      System.out.println("Mensaje Descifrado: " + mensajeDesCifrado);
      
   }
}