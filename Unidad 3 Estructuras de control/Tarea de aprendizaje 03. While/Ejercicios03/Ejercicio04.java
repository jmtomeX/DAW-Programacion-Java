/*
Convierte el bucle FOR del siguiente programa en un bucle WHILE.
 Conserva el nombre de todas las variables e indexa correctamente el código.
 public class Programa {
    public static void main(String[] args) {
        // Convertir For en While
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 5; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
*/
public class Ejercicio04 {
   public static void main(String[] args) {
      int i = 1;
      while(i <= 4) {
         int j = 1;
         while(j <= 5) {
            System.out.print("*");
            j++;
         }
         System.out.println();
         i++;
      }
   }
}