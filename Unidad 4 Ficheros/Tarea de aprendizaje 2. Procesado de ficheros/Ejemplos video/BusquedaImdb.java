// Este programa lee 250 películas de IMDB y busca el texto introducido
// En este caso, por el formato del fichero nos interesa leer líneas completas
// y luego leer esas líneas elemento a elemento para obtener un formato concreto

import java.util.*;
import java.io.*;

public class BusquedaImdb {
   
   public static void main(String[] args) throws FileNotFoundException {
   
      // Conecta con el fichero imdb.txt y con el teclado para leer datos
      Scanner leerFichero = new Scanner(new File("imdb.txt"));
      Scanner leerTeclado = new Scanner(System.in);
      
      presentacion();
      
      // Pregunta por el texto a buscar en el fichero
      System.out.print("¿Qué texto buscamos? ");
      String texto = leerTeclado.nextLine().toLowerCase();
      System.out.println();
      
      // Utiliza el método buscar para saber cuantas películas contienen ese texto
      int cont = buscar(texto, leerFichero);
      System.out.println(cont + " péliculas que incluyen ese texto");
      
      // Cierra la conexión con el fichero
      leerFichero.close();
   }
   
   // Muestra una pequeña explicación del programa.
   public static void presentacion() {
      System.out.println("Programa que busca películas que incluyan en su título");
      System.out.println("el texto introducido por el usuario o usuaria");
      System.out.println();
   }
   
   // Lee un objeto de tipo Scanner conectado a un fichero
   // linea a linea y comprueba si contiene el texto buscado
   // Muestra cada una de esas líneas y devuelve el número de coincidencias.
   //
   // String texto - el texto a buscar
   // Scanner fichero - conexión al fichero que se va a leer
   // return int - Devuelve el número de péliculas que incluyen el texto
   public static int buscar(String texto, Scanner fichero) throws FileNotFoundException {      
      int coincidencias = 0;
      while (fichero.hasNextLine()) {
         String linea = fichero.nextLine();
         if (linea.toLowerCase().contains(texto)) {
            coincidencias++;
            procesarMostrar(linea);
         }
      }
      return coincidencias;
   }
   
   // Visualiza la película con el siguiente formato
   // Título -- Posición #N, Valoración X.X (X opiniones)
   //
   // String pelicula - posición, nº de opiniones, valoración, título 
   public static void procesarMostrar(String pelicula) {
      
      // Crear Scanner a partir de una cadena de caracteres
      Scanner informacion = new Scanner(pelicula);
      informacion.useLocale(Locale.US);
      
      int posicion = informacion.nextInt();
      int opiniones = informacion.nextInt();
      double valoracion = informacion.nextDouble();
      String titulo = "";
     //Este while es como un contador va leyendo palabra por palabra hasta acabar con el título.
      while (informacion.hasNext()) {
         titulo += informacion.next() + " ";
      }
      
      System.out.println(titulo + "-- Posición #" + posicion + ", Valoración " + valoracion + " (" + opiniones + " opiniones)");
   }
}