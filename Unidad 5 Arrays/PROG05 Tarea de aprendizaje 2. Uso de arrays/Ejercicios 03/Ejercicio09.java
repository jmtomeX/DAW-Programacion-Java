/*
Escribe el código para el método repetido. Recibirá como parámetro un array de números y un número.
Devolverá true si el número está en el array y false en caso contrario.:

int[] nums1 = {12, 4, 7, 25};
boolean resultado = repetido(nums, 7);
System.out.println("Resultado: " + resultado);

Resultado: true

int[] nums1 = {12, 4, 7, 25};
boolean resultado = repetido(nums, 15);
System.out.println("Resultado: " + resultado);

Resultado: false
*/
import java.util.*;

public class Ejercicio09 {
   public static void main(String[] args){
      Scanner leer = new Scanner(System.in);
      int[] nums1 = new int[5];
        
      for(int i = 0; i < nums1.length; i++) {
         System.out.print("Introduce un numero: ");
         int numero = leer.nextInt();
            
         while (repetido(nums1, numero)) {
            System.out.print("Ese numero esta repetido. Introduce otro: ");
            numero = leer.nextInt();
         }
         nums1[i] = numero;
      }
      System.out.println("Resultado: " + Arrays.toString(nums1));
   }
   public static boolean repetido(int[] numeros, int numero){
      for(int i = 0; i < numeros.length; i++){
         if(numeros[i] == numero){
            return true;
         }
      }
      return false;
   } 

}