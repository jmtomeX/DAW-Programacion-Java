/*
Corrige el siguiente método para que reciba una cadena de caracteres como parámetro
y devuelva un array de 26 elementos que lleve la cuenta de cuantas veces se repite cada letra:

int[] contadorLetras = metodo("Hola que tal");
System.out.println(Arrays.toString(contadorLetras));

[2, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 2, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0]
 [2, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 2, 0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0]

int[] contadorLetras = metodo("abcdefghijklmnopqrstuvwxyz");
System.out.println(Arrays.toString(contadorLetras));

[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]
*/
import java.util.*;
public class Ejercicio06{
   public static void main(String[] args){
   
      int[] contadorLetras = metodo("Hola que tal");
      System.out.println(Arrays.toString(contadorLetras));
   
      int[] contadorLetras2 = metodo("abcdefghijklmnopqrstuvwxyz");
      System.out.println(Arrays.toString(contadorLetras2));
   }
   public static int[] metodo(String cadena) {
      int[] contador = new int[26];
      char[] abecedario = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
      for (int i = 0; i < cadena.length(); i++) {
         char caracter = cadena.toLowerCase().charAt(i);
         if (caracter != ' ') {
            for(int j = 0; j < abecedario.length; j++){
               if(cadena.toLowerCase().charAt(i) == abecedario[j]){
                  contador[j]++;
               }
            }
           
         }
      }
      return contador;
   }
}