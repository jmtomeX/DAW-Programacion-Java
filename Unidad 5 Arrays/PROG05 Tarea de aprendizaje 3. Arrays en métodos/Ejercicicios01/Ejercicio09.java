/*
Escribe el código para el método dividirLetras. Recibirá como parámetro un String de letras,
dividira esas letras en grupos de 6, los guardará en un array de String  y lo devolverá.
Se supone que la cadena de caracteres siempre es múltiplo de 6:
   Por ejemplo:
   
   String[] a = dividirLetras("Hola que tal estas");
   System.out.println(Arrays.toString(a));
   ["Hola q", "ue tal", " estas"]
*/

import java.util.*;
public class Ejercicio09 {
   public static void main(String[] args) { 
      String[] a = dividirLetras("Hola que tal estas");
      System.out.println(Arrays.toString(a));
   }
   public static String[] dividirLetras(String cadena){
      String[] letrasDivididas = new String[cadena.length() / 6];
      int tamannoMin = 0;
      int tamannoMax = 0;
      for(int i = 0; i < cadena.length() / 6; i++){
         tamannoMax += 6;
         letrasDivididas[i] = cadena.substring(tamannoMin,tamannoMax);
         tamannoMin += 6;
      }
      return letrasDivididas;
   }
}