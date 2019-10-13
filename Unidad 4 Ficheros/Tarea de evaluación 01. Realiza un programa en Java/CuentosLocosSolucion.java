/*
   Juego de los cuentos locos
   Se utiliza consola.nextLine() para leer todas las entradas de texto
   Da problemas si se mezclan next() con nextLine()
   Importante ver dónde se genera la excepción y dónde interesa procesarla (try-catch)
*/
import java.util.*;     // Para el objeto Scanner
import java.io.*;       // Para trabajar con ficheros

public class CuentosLocosSolucion {
   /*
      Método principal
   */
   public static void main(String[] args) throws FileNotFoundException {
      Scanner leerTeclado = new Scanner(System.in);
      
      presentacion();
      
      String seguir = elegirOpcion(leerTeclado);
      while(!seguir.equals("S")) {
         if(seguir.equals("C")) {
            crearCuento(leerTeclado);
         } else if(seguir.equals("V")) {
            verCuento(leerTeclado);
         }
         seguir = elegirOpcion(leerTeclado);
      }
      System.out.print("\nAgur");   
   }
   
   /*
      Presentación
   */
   public static void presentacion() {
      System.out.println("Bienvenidos y bienvenidas al juego de los cuentos locos.");
      System.out.println("El programa te pedirá que introduzcas una serie de palabras");
      System.out.println("que se utilizarán para completar una historia.");
      System.out.println("El resultado se guardará en un fichero.");
      System.out.println("Puedes leer esas historias siempre que quieras.");
   }
   
   /*
      Elegir opcion
   */
   public static String elegirOpcion(Scanner consola) {
      System.out.print("\n******* MENU *******\n(C)rear un \"Mad Lib\"\n(V)er un \"Mad Lib\"\n(S)alir\n");
      System.out.print("Elija su opción: ");
      String opcion = consola.nextLine();
      opcion = opcion.toUpperCase();
      return opcion;
   }
   
   /*
      Crea un cuento loco
   */
   public static void crearCuento(Scanner consola) throws FileNotFoundException {
      System.out.println("\nCrear un cuento: ");    
   
      // Abre el fichero para leer
      Scanner leerFichero = abreFichLeer(consola);
      
      // Abre el fichero para escribir
      PrintStream escribirFichero = abreFichEscribir (consola);
      
      // Mientras quede texto lee el fichero línea a línea
      // luego procesa cada línea
      while (leerFichero.hasNextLine()) {
         String linea = leerFichero.nextLine();
         procesarLinea(consola, escribirFichero, linea);
      }
      System.out.println("El cuento loco ha sido creado");
      System.out.println();
   
      leerFichero.close();
      escribirFichero.close();
   }
   
   /*
      Ver un cuento loco
   */
   public static void verCuento(Scanner consola) {
      System.out.println("\nVer un cuento: ");
      
      // Gestiona cualquier excepción que pueda ocurrir mientras se lee el fichero
      Scanner leerFichero = null;
      try {
         leerFichero = abreFichLeer(consola);
         
         // Si el fichero no se abre correctamente, al leerlo se producirá una excepción
         // También debe ir dentro del try
         while (leerFichero.hasNextLine()) {
            String linea = leerFichero.nextLine();
            System.out.println(linea);
         }
      } catch (Exception e) {
         System.out.println(e.getMessage());    // Muestra qué excepción se ha producido
      }
      
      // Cierra el fichero si la conexión se ha realizado correctamente
      if (leerFichero != null) {
         leerFichero.close();
      }
   }
   
   /*
      Comprueba si la palabra es alguna de las que tiene que completar el usuario
      Empiezan por < y acaban por >
   */
   public static boolean hayHueco(String palabra) {
      return (palabra.startsWith("<") && palabra.endsWith(">"));
   }
   
   /*
      Abre el fichero para leer
      Si no puede pregunta hasta que lo encuentra
   */
   public static Scanner abreFichLeer (Scanner consola) throws FileNotFoundException {      
      // Lee el nombre del fichero
      System.out.print("Nombre del fichero que quieres leer: ");
      String nombre = consola.nextLine();
      
      // Comprueba que el fichero se puede leer si no pide otro nombre
      File fichEntrada = new File(nombre);
      while (!fichEntrada.canRead()) {
         System.out.println("Fichero no encontrado. Inténtalo otra vez");
         System.out.print("Nombre del fichero: ");
         nombre = consola.nextLine();
         fichEntrada = new File(nombre);
      }
      
      // Abre el fichero y lo devuelve
      return new Scanner(fichEntrada);
   }
   
   /*
      Abre el fichero para escribir
      Si no puede lo crea nuevo
   */
   public static PrintStream abreFichEscribir (Scanner consola) throws FileNotFoundException {
      // Lee el nombre del fichero
      System.out.print("Nombre del fichero de salida: ");
      String nombre = consola.nextLine();
      
      // Si no se puede leer crea un fichero con ese nombre
      File fichSalida = new File(nombre);
   
      return new PrintStream(fichSalida);
   }
   
   /*
      Procesa una línea: lee palabra por palabra y si es un hueco (< >)
      pide una palabra al usuario para completarlo
   */
   public static void procesarLinea(Scanner consola, PrintStream escribirFichero, String datos) {
      // Crea un Scanner a partir de una linea del fichero para procesarla más fácil
      Scanner linea = new Scanner(datos);
      
      // Lee las palabras, identifica los huecos y pide palabras para rellenarlos
      while (linea.hasNext()) {
         String palabra = linea.next();
         if(hayHueco(palabra)) {
            palabra = palabra.replace('-', ' ');
            System.out.print(palabra.substring(1,palabra.length() - 1) + ": ");
            palabra = consola.nextLine();
         }
         escribirFichero.print(palabra + " ");  // Escribe cada palabra en el fichero
      }
      escribirFichero.println();
   }
}