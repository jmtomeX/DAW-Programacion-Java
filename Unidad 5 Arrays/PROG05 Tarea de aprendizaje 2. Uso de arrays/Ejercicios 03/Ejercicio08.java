/*
Corrige el siguiente programa para que diga dónde van a hacer la mayoría del alumnado sus exámenes,
en "Araba", "Bizkaia" o "Gipuzkoa".
Los datos están guardados en un arrays. El 1 indica que el alumno o alumna hará el examen en "Araba",
el 2 que lo hará en "Bizkaia" y el 3 que lo hará en "Gipuzkoa".
*/
import java.util.*;
import java.io.*;
public class Ejercicio08 {
   public static final String[] TERRITORIO = {"Araba", "Gipuzkoa", "Bizkaia"};
   
   public static void main(String[] args) {      
      int[] array1 = {1, 2, 3, 2, 2, 3, 2, 3, 1, 2};
      int[] array2 = new int[3];
      
      for (int i = 0; i < array1.length; i++) {
         int num = array1[i];
         array2[num - 1]++;        
      }
      System.out.println(Arrays.toString(array2));
      
      int num = array2[0];
      int indice = 0 ;
      for (int i = 0; i < array2.length ; i++) {
         if (array2[i] > num) {
            num = array2[i];
            indice = i;
         }
      }
      System.out.println("La mayoria de los alumnos van a hacer el examen en " + TERRITORIO[indice]);
   }
}