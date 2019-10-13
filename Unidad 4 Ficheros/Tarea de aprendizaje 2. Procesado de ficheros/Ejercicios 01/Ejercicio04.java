/*
Tenemos el siguiente fichero, lineas.txt:

Kaixo        34 45,78    zer

moduz zaude gaur?
100  90  ...  0

BUKAERA :)

Escribe lo que mostraría en consola el siguiente código:

Scanner sarrera = new Scanner(new File("lineas.txt"));
int cont = 0;
while (sarrera.hasNext()) {
    System.out.println("Leido: " + sarrera.next());
    cont++;
}
System.out.println("Total: " + cont);
*/

import java.io.*;
import java.util.*;

public class Ejercicio04 {
   public static void main(String[] args) throws FileNotFoundException{
      Scanner sarrera = new Scanner(new File("lineas.txt"));
      int cont = 0;
      while (sarrera.hasNext()) {
         System.out.println("Leido: " + sarrera.next());
         cont++;
      }
      System.out.println("Total: " + cont);
   }
}