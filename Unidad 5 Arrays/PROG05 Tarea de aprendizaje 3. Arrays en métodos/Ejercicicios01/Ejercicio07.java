/*
Ordena el código del método para que recorra un array y devuelva el número de elementos mayores 
o iguales que num1 y menores o iguales que num2:
*/
public class Ejercicio07 {
   public static void main(String[] args) { 
      int[] numeros = {1, 2, 3, 4, 5, 43, 34, 66, 12, 15};
      System.out.println(metodo(numeros, 3, 45));
   }
   public static int metodo(int[] lista, int num1, int num2){
      int cont = 0;
      for(int i = 0; i < lista.length; i++){
         if(lista[i] >= num1 && lista[i] <= num2){
            cont++;
         }
      }
      return cont;
   }
}