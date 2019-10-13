public class Ejercicio07 {
   public static void main(String[] args) {
      double[] notas = {4.7, 7.3, 5.9, 9.6, 6.5};
      int[] seguimiento = new int [3];
        
      for (int i = 0; i < notas.length; i++) {
         if (notas[i] <= 5) {
            seguimiento[0]++;
         } else if (notas[i] > 9) {
            seguimiento[1]++;
         } else {
            seguimiento[2]++;
         }
      }
      System.out.println("Rendimiento excelente " + seguimiento[2]);
      System.out.println("Rendimiento bueno " + seguimiento[1]);
   }
}