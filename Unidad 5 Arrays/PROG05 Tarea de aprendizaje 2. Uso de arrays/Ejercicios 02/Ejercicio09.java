/*Escribe el código para el método capicua. Recibirá como parámetro un array de números
y devolverá true si el array es capicúa y false en caso contrario.:

int[] nums1 = {12, 4, 7, 25};
boolean resultado = capicua(nums);
System.out.println("Resultado: " + resultado);
Resultado: false

int[] nums1 = {2, 4, 7, 4 ,2};
boolean resultado = capicua(nums);
System.out.println("Resultado: " + resultado);
Resultado: true
*/

public class Ejercicio09 {
   public static void main(String[] args) {
      int[] nums = {2, 4, 4 , 4 , 2};
      boolean resultado = capicua(nums);
      System.out.println("Resultado: " + resultado);
   }
   public static boolean capicua(int[] nums) {
      for (int i = 0; i < nums.length / 2; i++) {
         if (nums[i] != nums[nums.length - 1 - i] ) {
            return false;
         }
      }
      return true;
   }
}