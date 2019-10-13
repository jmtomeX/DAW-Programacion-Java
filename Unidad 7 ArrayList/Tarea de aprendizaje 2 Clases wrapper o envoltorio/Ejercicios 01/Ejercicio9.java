/*
Escribe el código para el método contarTiradas. Recibirá como parámetro un ArrayList de enteros entre 0 
y MAX y devolverá un array que cuente cuantas veces se repite cada número.

Cuando el método funcione, el programa mostrará lo siguiente:
[3, 0, 3, 0, 4, 4, 1, 4, 3, 4, 1, 5, 3, 0, 3, 0, 4, 1, 1, 4, 5, 1, 3, 2, 5]
   [4, 5, 1, 6, 6, 3]
*/

import java.util.*;
public class Ejercicio9 {
   public static final int MAX = 6;
   public static void main(String[] args) {
      Random numAzar = new Random(10);
      ArrayList<Integer> lista = new ArrayList<Integer>();
      for (int i = 0; i < 25; i++) {
         int num = numAzar.nextInt(MAX);
         lista.add(num);
      }
      
      System.out.println(lista);
      int[] contador = contarTiradas(lista);
      System.out.println(Arrays.toString(contador));
   }
    
   public static int[]  contarTiradas(ArrayList<Integer> listaNum) {
      int[] tiradas = new int[MAX];
      for (int i = 0; i < listaNum.size(); i++){
         int num = listaNum.get(i);
         tiradas[num]++; 
      }
      
      return tiradas;
   }
    
}