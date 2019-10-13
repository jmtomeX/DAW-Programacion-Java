/*
Completa el programa con el método cuantos() al que se le pasarán un objeto de tipo Scanner conectado a un fichero y una edad.
Leerá el fichero y devolverá el número de personas con edad mayor a la indicada y mostrará sus nombres. Si todas son menores devolverá -1.
El fichero sigue el siguiente formato:
Marta 25 Nerea 30 Miren 27 Aitor 41 Javier 36

El resultado de las siguientes llamadas debería ser:

resultado = cuantos(leerFich, 30);
mostrará:
    Aitor: 41
    Javier: 36
devolverá 2

resultado = cuantos(leerFich, 45);
devolverá -1
Mostrará: No hay nadie mayor de 45
*/
import java.util.*;
import java.io.*;

public class Ejercicio09 {
   public static void main(String[] args) throws FileNotFoundException {
      Scanner leerFich = new Scanner(new File("edades.txt"));
      Scanner leerTeclado = new Scanner(System.in);
      
      System.out.print("Edad: ");
      int edadMinima = leerTeclado.nextInt();
      
      int total = cuantos(leerFich, edadMinima);
      
      if (total == -1) {
         System.out.println("No hay nadie mayor de " + edadMinima);
      }
      leerFich.close();
   }
   public static int cuantos(Scanner texto, int edad){
      int cont = 0;
      while(texto.hasNext()){
         String nombre = texto.next();
         int edadClinte = texto.nextInt();
      
         if(edadClinte > edad){
            System.out.println(nombre + ":" + edadClinte);
            cont++;
         }
         else if(cont == 0){
            cont = -1;
         }
      }
     
      return cont;
   }
}