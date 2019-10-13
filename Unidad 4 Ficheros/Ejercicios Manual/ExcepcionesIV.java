
import java.io.*;
import java.util.*;
public class ExcepcionesIV {
   public static void main(String[] args) {
      Scanner teclado = new Scanner(System.in);
      boolean leido = false;
      do {
         System.out.print("Nombre del fichero: ");
         String nombre = teclado.next();
         File fichero = new File(nombre);
         Scanner leerFichero = null;
         try {
            leerFichero = new Scanner(fichero);
            procesar(leerFichero);
            leido = true;
         } catch (FileNotFoundException excepcion) { 
            System.out.println("Error al abrir el fichero");
         } catch (Exception excepcion) { 
            System.out.println("Otro error");
         } finally {
            if(leerFichero != null) {
               leerFichero.close();
            }
         }
      } while(!leido);
      System.out.println("Final del programa");
   }
   public static void procesar(Scanner entrada) {
      while (entrada.hasNext()) {
         String nombre = entrada.next();
         double suma = 0.0;
         int cont = 0;
         while (entrada.hasNextDouble()) {
            suma += entrada.nextDouble();
            cont++;
         }
         System.out.println("Nota media de " + nombre + " = " + suma / cont);
      }
   }
}