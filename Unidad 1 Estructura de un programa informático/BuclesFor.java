// Este programa incluye diferentes�todos que demuestran
//   distintos usos de los bucles for.
public class BuclesFor {
   public static void main(String[] args) {
     
      for (int i = 1; i <= 10; i++) {
         System.out.println("Otra línea...");
      }
      System.out.println();
   
      contar();
      cuadradoDeNum();
      cuentaAtras();
      cuentaAtras2();
      DibujarCuadrado();
      DibujarCuadradoBucleAnidado();
      piramide();
    
   }
   
   //Métodos
   ///////////////////////////////
   // Cuenta del 1 al 10.
   //   Fijate en c cómo funciona la variable.
   public static void contar() {
      for (int i = 1; i <= 10; i++) {
         System.out.println("Vamos " + i);
      }
      System.out.println();   
   }
   
   // Muestra los cuadrados de los n�meros del 1 al 10. Uno por l�nea
   public static void cuadradoDeNum() {
      for (int i = 1; i <= 10; i++) {
         int cuadrado = i *i;
         System.out.println(i + " al cuadrado = " + (cuadrado));
      } 
      System.out.println();   
   }
   
   // Muestra la cuenta atrás desde 10 a 1, seguido por "Hemos llegado al final"
   //   Cada n�mero se mostrará en una l�nea diferente.
      public static void cuentaAtras() {
      for (int i = 10; i >= 1; i--) {
        
         System.out.println(i);
      } 
      System.out.println("Hemos llegado al final");   
      System.out.println();   
   }
   
     
   // Muestra la cuenta atr�s desde 10 a 1, seguido por "Hemos llegado al final"
   //   Todos los n�meros se muestran en la misma l�nea.
   
      public static void cuentaAtras2() {
      for (int i = 10; i >= 1; i--) {
        
         System.out.print(i + " ");
      } 
      System.out.println("\nHemos llegado al final");   
      System.out.println();   
   }
     
   // Muestra un cuadrado de 10 x 5 asteriscos.
    public static void DibujarCuadrado(){
       for (int linea=1; linea <=10; linea++){
          System.out.println("*****");
       }
       System.out.println();
    }
    
      
   // Muestra un cuadrado de 10 x 5 asteriscos.
   //   Esta vez utilizando bucles for anidados.
      public static void DibujarCuadradoBucleAnidado(){
       for (int j=1; j <=5; j++){
          for (int i =1; i<=10; i++){
            System.out.print("*");
          }
            System.out.println();
       }
         System.out.println();
    }
     
   // Dibuja una pirámide de 5 filas de asteriscos
   public static void piramide(){
      for (int i = 1; i <= 10; i++){
         for (int j = 1; j <= i; j++){
            System.out.print("*");
         }
         
         System.out.println();
         
      }
   }
   
 }