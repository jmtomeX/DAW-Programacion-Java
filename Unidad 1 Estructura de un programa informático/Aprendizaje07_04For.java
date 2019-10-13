//Modifica el siguiente programa para que la constante MAX controle el tamaño del cuadrado:

public class Aprendizaje07_04For {  
   public static final int MAX = 5; 
   public static void main(String[] args) {
     
      for (int i = 0; i < MAX; i++) {
         for (int j = 0; j < MAX; j++) {
            System.out.print("+");
         }
         System.out.println();
      }
   }
}