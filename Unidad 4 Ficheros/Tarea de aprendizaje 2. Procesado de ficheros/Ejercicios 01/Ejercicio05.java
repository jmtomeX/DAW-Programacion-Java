/*
Tenemos el siguiente fichero, lineas.txt:

En un lugar
      de la Mancha, 

    de cuyo nombre

  no quiero acordarme,

Escribe lo que mostraría en consola el siguiente código:

Scanner sarrera = new Scanner(new File("lineas.txt"));
while (sarrera.hasNext()) {
    System.out.println("Leido: " + sarrera.next());
}
*/


import java.io.*;
import java.util.*;

public class Ejercicio05 {
   public static void main(String[] args) throws FileNotFoundException{
      Scanner sarrera = new Scanner(new File("lineas05.txt"));
      while (sarrera.hasNext()) {
         System.out.println("Leido: " + sarrera.next());
      }
   
   }
}