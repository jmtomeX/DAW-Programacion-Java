/* 
Crea el método mostrar(). Se le pasará:

  un número

Mostrará un cuadrado en función de ese número como se indica en el siguiente ejemplo:

mostrar(5);
11111
22222
33333
44444
55555
*/


public class Ejercicio02{
   public static void main(String[] args){
      mostrar(10);
   }
   public static void mostrar( int numrept){
      
      for(int i = 1; i <= numrept; i++){
         for(int j = 1; j <= numrept; j++){
            System.out.print(i);
         }
         System.out.println();
      }
   }
}