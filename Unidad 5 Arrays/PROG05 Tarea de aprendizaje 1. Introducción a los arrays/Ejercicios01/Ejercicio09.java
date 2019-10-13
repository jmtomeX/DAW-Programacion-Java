/*
Crea el método buscarMenor para que reciba un array de datos double y devuelva el número menor del array:

double[] array = {9.7, 3.6, 1.8, 8.2, 5.5};
buscarMenor(array);
Devolverá 1.8
*/

public class Ejercicio09 {
   public static void main(String[] args) {
      double[] array = {9.7, 3.6, 1.8, 8.2, 5.5};    
      System.out.println(buscarMenor(array));
   }
   public static double buscarMenor(double array[]){
      double result = array[0] ;
      for(int i = 0; i <= array.length - 1; i++ ){
         if(result > array[i]){
            result = array[i];
         }
      }
      return result;
   }

}
