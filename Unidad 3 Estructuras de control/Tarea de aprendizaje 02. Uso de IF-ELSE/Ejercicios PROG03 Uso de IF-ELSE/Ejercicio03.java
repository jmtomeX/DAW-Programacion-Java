/*
Reescribe el siguiente programa para que esté mejor estructurado y así evitar redundancias:
import java.util.*;

public class Programa {
    public static void main(String[] args) {
        Scanner leerTeclado = new Scanner(System.in);
        int total = 300;
        System.out.print("Introduce el numero de hijos: ");
        int hijos = leerTeclado.nextInt();
        if (hijos >= 3) {
            System.out.print("Introduce gasto realizado: ");
            int gasto = leerTeclado.nextInt();
            int descuento = 10;
            System.out.println("Se te va aplicar un descuento del " + descuento + "%");
            double gastoReal = gasto - (double) gasto * descuento / 100;
            System.out.println("Vas a pagar " + gastoReal);
            total += gastoReal;
        } else {
            System.out.print("Introduce gasto realizado: ");
            int gasto = leerTeclado.nextInt();
            System.out.println("No te corresponde el descuento");
            System.out.println("Vas a pagar " + gasto);
            total += gasto;
        }
      
    }
}
*/

import java.util.*;
public class Ejercicio03 {
   public static void main(String[] args) {
      Scanner leerTeclado = new Scanner(System.in);
      int total = 300;
      System.out.print("Introduce el numero de hijos: ");
      int hijos = leerTeclado.nextInt();
      System.out.print("Introduce gasto realizado: ");
      int gasto = leerTeclado.nextInt();
      double gastoReal = 0;
      if (hijos >= 3) {
         int descuento = 10;
         System.out.println("Se te va aplicar un descuento del " + descuento + "%");
         gastoReal = gasto - (double) gasto * descuento / 100;
      } else {
         System.out.println("No te corresponde el descuento");
         gastoReal = gasto;
      }
      System.out.println("Vas a pagar " + gastoReal);
      total += gastoReal;
    
   }
}