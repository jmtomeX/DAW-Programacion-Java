// Programa para demostrar el manejo de las clases wrapper o envoltorio
// Hay que usar clases especiales (wrapper)
// int      -->   Integer
// double   -->   Double
// char     -->   Character
// boolean  -->   Boolean

import java.util.*;
public class WrapperEjemplos {
   public static void main(String[] args) {
   
      // Crea objetos envoltorio    
      Integer objetoInt = new Integer(34);
      Double objetoDouble = new Double(3.58);
      int z = 61;
      Integer num = new Integer(z);
      Boolean objetoBoolean = new Boolean(false);
      Character objetoCaracter = new Character('a');
      System.out.println(objetoInt + " - " + objetoDouble + " - " + objetoBoolean + " - " + objetoCaracter);
      
      // Convierte el contenido de los objetos a los tipos primitivos.
      int i = objetoInt.intValue();
      objetoInt = 24;
      i = objetoInt * 2;
      System.out.println(i + " - " + objetoInt);
   }
}