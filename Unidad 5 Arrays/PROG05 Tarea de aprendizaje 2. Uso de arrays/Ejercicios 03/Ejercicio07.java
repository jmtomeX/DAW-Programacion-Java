import java.util.*;
import java.io.*;
public class Ejercicio07 {
   public static void main(String[] args) {      
      double[] array1 = {4.7, 5.6, 1.7, 7.3, 12.9};
      if(ordenado(array1)){
         System.out.println("El array está ordenado");
      } else {
         System.out.println("El array está desordenado");
      }
   }
   public static boolean ordenado(double[] arrayDoubles){
      for(int i = 1; i <arrayDoubles.length; i++){
         if(arrayDoubles[i] < arrayDoubles[i - 1]){
            return false;
         }
      }
      return true;
   }
   
}