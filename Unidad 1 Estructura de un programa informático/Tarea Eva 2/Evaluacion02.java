/*
            ||
            ||
         __/||\__
      __/:::||:::\__
   __/::::::||::::::\__
__/:::::::::||:::::::::\__
|""""""""""""""""""""""""|
\_/\/\/\/\/\/\/\/\/\/\/\_/
  \_/\/\/\/\/\/\/\/\/\_/
    \_/\/\/\/\/\/\/\_/
      \_/\/\/\/\/\_/
            ||
            ||
            ||
            ||
         |%%||%%|
         |%%||%%|
         |%%||%%|
         |%%||%%|
         |%%||%%|
         |%%||%%|
         |%%||%%|
         |%%||%%|
         |%%||%%|
         |%%||%%|
         |%%||%%|
         |%%||%%|
         |%%||%%|
         |%%||%%|
         |%%||%%|
         |%%||%%|
         __/||\__
      __/:::||:::\__
   __/::::::||::::::\__
__/:::::::::||:::::::::\__
|""""""""""""""""""""""""|
*/

/*Para ello, nuestra primera tarea va a ser definir esas piezas e indicar
un nombre para los métodos con los que las vamos a llevar a cabo.
 No importa si todavía no tenemos muy claro cómo vamos a realizar 
luego esas piezas.*/

public class Evaluacion02 {
   public static  final int ALTO = 4;
   public static void main(String[] args) {
     
      copaReversa();
   }
    ///Métodos
    
    //Mostrar la parte central vertical  de la copa --> ||
   public static void centroVertical(){ 
    
   }
    
    //Mostrar la parte superior de la copa --> __/:::::::::||:::::::::\__
   public static void copaInversa(){
    
   }
    
    //Mostrar la parte central horizontal  de la copa --> |""""""""""""""""""""""""|
   public static void centroHorizontal(){
    
   }
    
    //Mostrar la parte inferior de la copa --> \_/\/\/\/\/\/\/\/\/\/\/\_/
   public static void copaReversa(){
      int linea = 0;
      for(linea = 1; linea <= ALTO; linea++){
         for(int espacio = 0; espacio <= 2*linea - 2; espacio++){
            System.out.print(" ");
         }
         System.out.print("\\_");
         for(int i =1; i <= -2 * linea + 13; i++){
            System.out.print("/");
            System.out.print("\\");
         }
      
         System.out.println("_/");
      } 
      System.out.println();
   }
    //Mostrar la parte del mango de la copa --> |%%||%%|
   public static void zonaMango(){
    
   }   
}