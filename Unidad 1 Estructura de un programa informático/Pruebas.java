public class Pruebas {
   public static void main(String[] args) {
   
      //triangulo();
      //completar();
      //problema();
      //problema2();
      //problema3();
      //piramide();
      //agur();
      cuadrado();
      problema4();
   }
   
   //Métodos 
   
   /*Completa el programa escribiendo el código indicado para que muestre lo siguiente por consola:
         Ejemplo 1: 5 + 1 = 6
         Ejemplo 2: 5 + 3 = 8
         Ejemplo 3: 5 + 5 = 10
         Ejemplo 4: 5 + 7 = 12*/
   
   public static void completar() {
      int contador = 1;
      for (int i = 1; i <=7; i= i+2){  
         System.out.print("Ejemplo " + contador + ": 5 + " + i + " = " + (5+i));
         contador++;
         System.out.println();
      }
   }
   
/*Escribe el método problema() para que muestre por pantalla el siguiente resultado:
    1
   2
  3
 4
5
*/   
   public static void  problema(){
      for(int j = 1; j <=5; j++){
         for(int i =5-j; i >= 1; i--){
            System.out.print(" ");
         }
         System.out.println(j);
      }
   }  
 ////////////////////////////////////////////////////
   
   /* 
   *
     ***
    *****
   *******
  *********
 ************/

   public static void piramide() {
      for (int i = 1; i <= 6; i++) {
         for (int j = 0; j < (6 - i); j++){ 
            System.out.print(" ");
         }
         for (int k = 1; k <  i*2 ; k++) {
            System.out.print("*");
         }
         System.out.println();
      }  
   }

////////////////////////////////


   public static void problema2() {
      int numero = 4;
      for (int cont = 1; cont <= numero; cont++) {
         System.out.println(numero);
         numero = numero / 2;
      }
   }


//////////////////////////////////////
   public static void problema3() {
      int total = 25;
      for (int num = 1; num <= (total / 2); num++) {
         total = total - 2 * num;
         System.out.println(total + " " + num);
      }
   }
   
/* Escribe el método problema() para que muestre por pantalla el siguiente resultado:

10 8 6 4 2 0 
Agur*/

   public static void agur(){
      for(int i = 10; i >= 0; i = i-2){
         System.out.print(i + " ");    
      }
      System.out.println("\nAgur");
   }
   
/* Escribe el método problema() para que muestre por pantalla el siguiente resultado. Fíjate que son los cuadrados de los 10 primeros números:

1 4 9 16 25 36 49 64 81 100

Si quieres, puedes buscar otra solución sin usar la multiplicación. Fíjate en la diferencia que hay entre números adyacentes. 
   */
   public static void cuadrado(){
      for(int i = 1; i <= 10; i++){
         System.out.print(i * i + " ");
      }
      System.out.println(); 
   }
  ///////////////////////////////// 
  
  
/*Escribe el programa Problema para que muestre por pantalla el siguiente resultado:

999999999888888887777777666666555554444333221
999999999888888887777777666666555554444333221
999999999888888887777777666666555554444333221
999999999888888887777777666666555554444333221
*/

   public static void problema4() {
   
      for (int i = 0; i < 4; i++) {
         for (int j = 9; j >= 0; j--) {
            for (int k = 0; k < j; k++) {
               System.out.print(j);    
            }
         }
         System.out.println();
      }
   }
   
   
   
   
   

    
}
