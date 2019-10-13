import java.util.*;
public class MasAltoBajo{
   public static void main(String[] args){
      Scanner teclado = new Scanner(System.in);
      System.out.println("Introduce un numero:");
      int num = teclado.nextInt();
      int mayor = num;
      int menor = num; 
      while(num != 0) {
         System.out.println("El mayor es " + mayor + " y el menor es " +  menor);
         mayor = Math.max(mayor, num);
         menor = Math.min(menor, num);
         System.out.println("Introduce un numero:");
         num = teclado.nextInt();
      }
      System.out.println("El mayor es " + mayor + " y el menor es " +  menor);
   }
}

