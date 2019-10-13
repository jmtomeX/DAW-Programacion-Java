/*
Escribe el método problema() para que muestre lo siguiente por consola:

         -----1-----
         ----333----
         ---55555---
         --7777777--
         -999999999-
*/

public class Aprendizaje07_01For {
   public static void main(String[] args) {
     
      bloque();      
   }
   
        ///Método
   public static void bloque() {
   //creamos las líneas
      int numero = 1;
      for(int linea = 1; linea <=5; linea++){
      
      //añadimos los guinones
         for(int j = 1; j < -linea + 7; j++){
            System.out.print("-");
         }
      
      //añadimos los números
         for(int i = 1; i <= numero; i++){
            System.out.print(numero);
           
         }
         numero = numero +2;
      //añadimos los guiones
         for(int j = 1; j < -linea + 7; j++){
            System.out.print("-");
         }
      
         System.out.println();
      }
   }
   
}