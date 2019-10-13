import java.util.*;
public class Ejercicio06{
   public static void main(String[] args) {
      ArrayList<Integer> listaNumeros = new ArrayList<Integer>(Arrays.asList(12, 0, 2, 12, -2, 5, 56, 78));
      System.out.println(listaNumeros);
   
      eliminarDivisible(listaNumeros,3);
      System.out.println(listaNumeros);
   }
   public static void eliminarDivisible(ArrayList<Integer> numeros, int divisor) {
      Iterator<Integer> iterador = numeros.iterator();
      while(iterador.hasNext()) {
         int numero = iterador.next();
         if(numero % divisor == 0) {
            iterador.remove();
         }
      }
   }
      
}