/*
Corrige el programa para que cree un objeto de la clase ArrayCirculos,
modifique su valores por otros introducidos por teclado y nos diga cuantos Circulos
son de color azul y que color tiene el Circulo mayor de la siguiente manera:

      Numero de Circulos que va a tener: 2
      CIRCULO 1: 
      Color: azul
      Radio: 5,5
      CIRCULO 2: 
      Color: rojo
      Radio: 2,2
      1: Circulo azul de radio 5.5
      2: Circulo rojo de radio 2.2
      Azul: 1
      Circulo mayor: azul
*/
import java.util.*;

import java.util.*;

public class Ejercicio08 {
   public static void main(String[] args) {
      Scanner teclado = new Scanner(System.in);
      System.out.print("Numero de Circulos que va a tener: ");
      int num = teclado.nextInt();
      ArrayCirculos lista = new ArrayCirculos(0, "", num);
      for (int i = 1; i <= num; i++) {
         System.out.println("CIRCULO " + i + ": ");
         System.out.print("Color: ");
         String color = teclado.next();
         System.out.print("Radio: ");
         double radio = teclado.nextDouble();
         lista.setCirculo(i, radio, color);
      }
      System.out.print(lista);
      System.out.println("Azul: " + lista.contarColor("azul"));
      System.out.println("Circulo mayor: " + lista.colorMayor());
   }
}