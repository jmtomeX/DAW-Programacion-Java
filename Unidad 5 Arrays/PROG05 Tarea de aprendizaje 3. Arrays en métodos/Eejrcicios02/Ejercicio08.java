/*
Corrige el siguiente método para que reciba un array y un número como parámetros 
y devuelva el elemento del array con tantos numeros superiores a él como el número pasado.

Por ejemplo:

int[] a = {14, 1, 22, 17, 36, 7, -43, 5};
System.out.println(metodo(a, 0));

36 (No tiene ningún número mayor)

int[] a = {14, 1, 22, 17, 36, 7, -43, 5};
System.out.println(metodo(a, 2));

17 (el 36 y el 22 son mayores que él)
*/
import java.util.*;
public class Ejercicio08 {
   public static void main(String[] args) { 
      int[] a = {14, 1, 22, 17, 36, 7, -43, 5};
      metodo(a, 1);
   } 
   public static void metodo(int[] lista, int num) {
      Arrays.sort(lista);  
      int[] listaMayor = new int[lista.length];
      int contador = 0;        
      for(int i = 0; i < lista.length; i++){
         if(lista[i] > num){
            listaMayor[contador] = lista[i];
            contador++; 
         }
      }
      if(listaMayor.length > contador){
         listaMayor = Arrays.copyOf(listaMayor, contador);
      }
      if(contador == 0){
         System.out.println(num + " (No tiene ningún número mayor)" );
      }else if(contador > 0){
         System.out.print(num + " (el " + listaMayor[0]);
         for(int i = 1; i < contador - 2; i++){
            if(i == 1){
               System.out.print(", ");
            }
            System.out.print( "el " + listaMayor[i] + ", ");
         }
         if(contador > 2 ){
            System.out.println("el " +  listaMayor[listaMayor.length - 2] + " y el " + listaMayor[listaMayor.length - 1] + " son mayores que él)");
         }else{
            System.out.println(" y el " + listaMayor[listaMayor.length - 1] + " son mayores que él)");
         }  
      }
   }
}