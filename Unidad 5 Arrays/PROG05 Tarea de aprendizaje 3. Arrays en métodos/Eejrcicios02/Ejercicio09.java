/*
Escribe el código para el método convertirArray. Recibirá como parámetro un String
y devolverá un array de caracteres con el contenido del String:

Por ejemplo:

char[] a = convertirArray("Hola");
System.out.println(Arrays.toString(a));

['H', 'o', 'l', 'a']
*/
import java.util.*;
public class Ejercicio09 {
   public static void main(String[] args) { 
      char[] a = convertirArray("Hola");
      System.out.println(Arrays.toString(a));
   }
   public static char[] convertirArray(String palabras){
      char[] letras = new char[palabras.length()];
      for(int i = 0; i < palabras.length(); i++){
         char letra = palabras.charAt(i);
         letras[i] = letra;
      }
      return letras;
   }
}