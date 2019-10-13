// Programa con ejemplos de uso de parametros con métodos

public class Parametros { 
   public static void main(String[] args) { 
      linea(13);
      linea(7);
      linea(35);        
      caja(10, 5); 
      caja(5, 6);
      eligeEnsalada("Cesar");
      eligeEnsalada("Mixta");
   } 

   public static void linea(int estrellas) { 
      for (int i = 1; i <= estrellas; i++) { 
         System.out.print("*"); 
      }
      System.out.println(); 
   }
    
   public static void caja(int ancho, int alto) {
      // Primera linea
      linea(ancho);
      
      // Cuerpo
      for (int linea = 1; linea <= alto - 2; linea++) {
         System.out.print("*");
         for (int espacio = 1; espacio <= ancho - 2; espacio++) {
            System.out.print(" ");
         }
         System.out.println("*");
      }
      
      // Ultima linea
      linea(ancho);
   }
   
   public static void eligeEnsalada(String tipo) {
      System.out.println("Ensalda " + tipo + ". Buena elección");
   }
}