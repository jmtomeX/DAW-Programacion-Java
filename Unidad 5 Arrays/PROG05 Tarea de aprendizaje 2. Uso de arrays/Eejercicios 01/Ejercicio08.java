/*
Corrige el siguiente programa para que cuente cuántos alumnos y alumnas no han superado el curso(< 5), 
cuántos han tenido un rendimiento excelente (>= 9) y cuántos un rendimiento bueno (>= 5 y < 9).

Para ello, se utilizará el array seguimiento.

*/
public class Ejercicio08 {
   public static void main(String[] args) {
      double[] notas = {4.7, 7.3, 5.9, 9.6, 6.5};
      int[] seguimiento = new int [3];
        
      for (int i = 0; i <= notas.length - 1 ; i++) {
         if (notas[i] < 5) {
            seguimiento[0]++;
            System.out.println(notas[i]);
         } else if (notas[i] <= 9) {
            seguimiento[1]++;
            System.out.println(notas[i]);
         } else {
            seguimiento[2]++;
            System.out.println(notas[i]);
         }
      }
      System.out.println("Rendimiento excelente " + seguimiento[2]);
      System.out.println("Rendimiento bueno " + seguimiento[1]);
      System.out.println("No han superado el curso " + seguimiento[0]);
   }
}