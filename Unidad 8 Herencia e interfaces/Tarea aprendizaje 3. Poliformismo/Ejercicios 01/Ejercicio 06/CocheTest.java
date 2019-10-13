/*
Corríge la siguiente versión para que implemente correctamente el método equals y cuando se ejecute el siguiente código identifique los coches
de la misma marca y modelo como iguales sin tener en cuenta el año:
*/

import java.util.*;
import java.io.*;

public class CocheTest {
   public static void main(String[] args) {
      
      Coche coche1 = new Coche("Fiat", "Panda", 2010);
      Coche coche2 = new Coche("Opel", "Meriva", 2010);
      Coche coche3 = new Coche("Fiat", "Panda", 2015);
      if (!coche1.equals(coche2)) System.out.println("DIFERENTES");
      if (coche1.equals(coche3)) System.out.println("IGUALES");
   }
}