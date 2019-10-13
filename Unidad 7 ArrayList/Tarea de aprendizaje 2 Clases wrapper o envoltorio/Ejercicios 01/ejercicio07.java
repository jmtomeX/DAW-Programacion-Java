/*
Corrige el método minPrimero para que obtenga el valor menor del ArrayList pasado como parámetros y 
lo inserte al comienzo de la lista. El resultado del programa será:

Lista inicial: [3, -5, 18, 10]
Lista final: [-5, 3, 18, 10]
*/
import java.util.*;
public class ejercicio07 {
   public static void main(String[] args) {
      ArrayList<Integer> lista = new ArrayList<Integer>();
      lista.add(3);
      lista.add(-5);
      lista.add(18);
      lista.add(10);
      
      System.out.println("Lista inicial: " + lista);
      minPrimero(lista);
      System.out.println("Lista final: " + lista);
   }
   
   public static void minPrimero(ArrayList<Integer> lista) {
      int min = lista.get(0);
      int indice = 0;
      for (int i = 1; i < lista.size(); i++) {
         int num = lista.get(i);
         if (num < min) {
            min = num;
            indice = i;
         }
      }
      lista.remove(indice);
      lista.add(0, min);   
   }
}