/*
Ordena el código del método para que reciba un array como parámetro 
y devuelva otro array que contenga únicamente los números pares del anterior:
*/
   
import java.util.*;
public class Ejercicio08 {
   public static void main(String[] args) { 
      int[] numeros = {1, 2, 3, 4, 5, 43, 34, 66, 12, 15};
      System.out.println(Arrays.toString(metodo(numeros)));
   }
   public static int[] metodo(int[] lista){
      int cont = 0;
      int[] nuevo = new int[lista.length];
      for(int i = 0;i < lista.length; i++){
         if(lista[i] % 2 == 0){
            nuevo[cont] = lista[i];
            cont++;
         }
      }
      if(nuevo.length > cont){
         return Arrays.copyOf(nuevo, cont); 
      }
      return nuevo;
   }
}