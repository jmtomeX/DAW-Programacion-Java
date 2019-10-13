import java.util.*;

public class Ejercicio01 {
   public static void main(String[] args) {
      Scanner leerTeclado = new Scanner(System.in);
      System.out.print("Introduce un numero: ");
      int numero = leerTeclado.nextInt();      
      System.out.println("El ultimo digito del numero es " + ultimoDigito(numero));
   }
   
   public static int ultimoDigito(int num) {
      return Math.abs(num % 10);
   }
}