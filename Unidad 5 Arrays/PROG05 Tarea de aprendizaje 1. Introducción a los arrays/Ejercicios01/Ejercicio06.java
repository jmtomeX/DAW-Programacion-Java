public class Ejercicio06 {
   public static void main(String[] args) {
   
      int inicio = -5, fin = 37;
      //System.out.println(inicio % 2);
      //System.out.println( (fin % 5) + 1);
      System.out.println((fin - inicio) / 2 + 1);
      if (inicio % 2 == 0) {
         inicio++;
      }
   
      if (fin % 2 == 0) {
         fin--;
      }
   
      int[] nums = new int[(fin - inicio) / 2 + 1];
      System.out.println((fin - inicio) / 2 + 1);
      for (int i = 0; i < nums.length; i++) {
         nums[i] = inicio;
         inicio += 2;
      }
      System.out.println(inicio  + " " + fin );
   }
}