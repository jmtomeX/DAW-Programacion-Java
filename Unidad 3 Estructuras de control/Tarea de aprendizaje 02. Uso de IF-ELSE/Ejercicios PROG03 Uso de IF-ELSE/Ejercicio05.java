/*
Reescribe el siguiente programa para que esté mejor estructurado y así evitar redundancias:

import java.util.*;

public class Programa {
    public static void main(String[] args) {
        Scanner leerTeclado = new Scanner(System.in);
        int contador = 0;
        System.out.print("Introduce tu edad: ");
        int edad = leerTeclado.nextInt();
        if (edad >= 18) {
            contador++;
            System.out.println("Registro finalizado");
        } else {
            System.out.print("Introduce el telefono de tu tutor legal: ");
            String tfnoTutor = leerTeclado.next();
            contador++;
            System.out.println("Registro finalizado");
        }
    }
}
*/

import java.util.*;

public class Ejercicio05 {
   public static void main(String[] args) {
      Scanner leerTeclado = new Scanner(System.in);
      System.out.print("Introduce tu edad: ");
      int edad = leerTeclado.nextInt();
      if (edad < 18) {  
         System.out.print("Introduce el telefono de tu tutor legal: ");
         String tfnoTutor = leerTeclado.next();
      }
      System.out.println("Registro finalizado");
   }
}