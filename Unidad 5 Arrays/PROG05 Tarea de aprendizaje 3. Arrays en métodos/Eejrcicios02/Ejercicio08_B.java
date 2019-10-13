
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

public class Ejercicio08_B {
   public static void main(String[] args) { 
      int[] a = {14, 1, 22, 17, 36, 7, -43, 5};
      metodo(a,5 );
   } 

   public static int metodo(int[] lista, int num) {
      java.util.Arrays.sort(lista);          
      System.out.println(java.util.Arrays.toString(lista));
      int fin = lista.length - 1;
      return lista[fin - num];
   }
}