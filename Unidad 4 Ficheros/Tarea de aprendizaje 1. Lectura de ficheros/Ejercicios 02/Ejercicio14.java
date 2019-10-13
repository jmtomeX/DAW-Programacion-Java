/*
Crea el siguiente programa para que lea el fichero "numeros.dat" que contiene números enteros.
Sumará todos los números y dirá si el total es negativo o positivo:

Por ejemplo si el fichero es:

-23 -45 22 14 78

El resultado sera:

La suma total es positiva: 46
*/
import java.util.*;
import java.io.*;

public class Ejercicio14 {
   public static void main(String[] args) throws FileNotFoundException {
      Scanner leerFichero = new Scanner(new File("numeros.txt"));
      int suma = 0;
      while(leerFichero.hasNextLine()){
         if(leerFichero.hasNextInt()){
            int numero = leerFichero.nextInt();
            suma += numero;
         }
      }
      String resultado = "";
      if(suma >= 0 ){
         resultado = "positiva";
      }else{
         resultado = "negativa";
      }
   
      System.out.println("La suma total es " + resultado + ": " + suma);
   }
}