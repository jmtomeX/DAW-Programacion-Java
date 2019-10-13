// Este program lee las notas de diferentes alumnos y alumnas de un fichero de texto
// y calcula y muestra la nota media de cada uno
/*
43 Marta 7,5 8 10 8 8,5
   57 Nerea 6,5 5,5 7 6 5,75
   22 Miren 8 8 8
   101 Aitor 6,5 8 9,25 8
   87 Javier 2,5 3
*/


import java.io.*;
import java.util.*;

public class MediaAlumnaLineas {

   // Lee línea a línea el fichero y llama al método procesarLinea por cada una de ellas
   public static void main(String[] args) throws FileNotFoundException {
   
      // Conecta con el fichero alumnosID.txt
      Scanner leerFichero = new Scanner(new File("alumnosId.txt"));
      
      // Mientras haya otra línea más por leer, la lee y la procesa
      while (leerFichero.hasNextLine()) {
         String linea = leerFichero.nextLine();
         procesarLinea(linea);
      }
      
      // Cierra la conexión
      leerFichero.close();
   }

   // Procesa la cadena proporcionada (ID, name, and hours worked)
   // String texto: línea de texto que hay que procesar
   public static void procesarLinea(String texto) {
   
      // Crea un objeto de tipo Scanner a partir de una cadena de texto
      Scanner linea = new Scanner(texto);
      
      // Lee el id del alumno o alumna
      int id = linea.nextInt();
      // Lee el nombre del alumno o alumna
      String nombre = linea.next();   
      // Lee las calificaciones, las cuenta y las suma
      double suma = 0;
      int cont = 0;
      while(linea.hasNextDouble()){
         double num = linea.nextDouble();
         suma += num;
         cont++;
      }
      
      
      // Visualiza los datos del alumno o alumna y su nota media
      System.out.println("Nota media de " + nombre + " (id#" + id + ") = " + suma / cont);
   
   }
}