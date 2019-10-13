/*Pregunta 4
Escribe el método problema() para que muestre lo siguiente por consola:

|v      v|
| v    v |
|  v  v  |
|   vv   |
*/

public class Aprendizaje07_03For {
   public static void main(String[] args) {
      problema();
   }
   
   public static void problema(){
      for(int linea = 1; linea <=4; linea++){
      //añadimos las pipetas
         System.out.print("|");
       //añadimos los espacios en blanco
         for(int i = 1; i <= linea-1; i++){
            System.out.print(" ");
         }
      //añadimos las v
         System.out.print("v");
      //añadimos los espacios en blanco
         for(int i = 1; i<=  -2 * linea  + 8; i++){
            System.out.print(" ");
         }
      //añadimos las v
         System.out.print("v");
       //añadimos los espacios en blanco
         for(int i = 1; i <= linea-1; i++){
            System.out.print(" ");
         } 
      //añadimos las pipetas
         System.out.print("|");
         System.out.println();
      }
   }
   
}