 /***********************************************************************************************

 Nombre:  Jose Mari Tome Mejias.
 Fecha :  01/03/2018.
 Módulo:  Programación.
 Tarea:   PROG07 Tarea de evaluación 01. Realiza un programa en Java
 
 Descripción del programa:Esta tarea se centra en el en el manejo de ArrayLists y en el desarrollo
 y uso de nuestras propias clases. Para ello, se crearán y utilizarán las clases Tweet y TweetBD y
 se puede utilizar el fichero tweet.txt para hacer pruebas. La estructura de las clases está
 definida en los archivos Tweet.java y TweetBD.java.

    En concreto, el programa leerá del fichero tweet.txt una serie de tweets y mostrará por consola
    el número total de tweets que contiene y el tweet más reciente. Además, proporcionará un menú
    que permitirá trabajar con esos tweets hasta que se ea salir.
 
     
 Enlace aoutoevaluación: 
     
*************************************************************************************************/ 
import java.util.*;
import java.io.*;
import java.util.regex.*;

public class TweetDBMain {
//opciones del menú
   public static final int SALIR = 0;
   public static final int ANHADIR_TWEET = 1 ;
   public static final int BORRAR_TWEETS = 2;
   public static final int MOSTRAR_TWEETS = 3;
   public static final int TWEETS_ANTERIORES = 4;
   public static final int TWEETS_DE_UNTEMA = 5;
   
   public static void main(String[] args) throws FileNotFoundException {
      Scanner leerTeclado = new Scanner(System.in);
      File fichero = new File("GuardarDatos.txt");
      PrintStream escribirFichero = null;
      try {
         escribirFichero = new PrintStream(fichero);
      } catch (Exception e) {
         System.out.println("Se ha producido la excepción: " + e);
      }
      intro();//Muestra la introducción
      TweetBD unTweetBD = null;
      Scanner ficheroEntrada = null;
      try{//Leemos el fichero de entrada
         ficheroEntrada = new Scanner(new File("tweets.txt"));
         unTweetBD = new TweetBD("Tweets del fichero", ficheroEntrada);
      } catch (FileNotFoundException e) {
         System.out.println("ERROR");
      }
      if (ficheroEntrada != null) {
         ficheroEntrada.close();
      }
      //mostramos el número de tweets del fichero
      int size = unTweetBD.getNumeroTweets();
      System.out.println("Se han leído " + size + " tweets \n");
      //mostramos el último tweet
      System.out.println("El tweet más reciente es:\n" + unTweetBD.tweetMasReciente() + "\n");
      //Mostramos el menu con las opciones para elegir
      int opcion = menuElegir(leerTeclado);
      while(opcion != SALIR) {
         switch (opcion) {
            case ANHADIR_TWEET:
               anhadirTweet(leerTeclado, unTweetBD);
               escribirFichero.print(unTweetBD.toString() + "\n");
               break;
            case BORRAR_TWEETS:
               escribirFichero.print(unTweetBD.toString() + "\n\n");
               borrarTweetsUsuario(leerTeclado, unTweetBD);
               escribirFichero.print(unTweetBD.toString() + "\n");
               break;
            case MOSTRAR_TWEETS:
               System.out.println(unTweetBD.toString() + "\n");
               break;
            case TWEETS_ANTERIORES:
               escribirFichero.print(unTweetBD.toString() + "\n"); 
               tweetAnteriorATweet(leerTeclado, unTweetBD, escribirFichero);    
               break;
            case TWEETS_DE_UNTEMA:
               escribirFichero.print(unTweetBD.toString() + "\n"); 
               buscarTweetsPalabra(leerTeclado, unTweetBD, escribirFichero); 
               break;
            default:
               System.out.println("Opción incorrecta");
               break;
         }
         opcion = menuElegir(leerTeclado);
      }  
      System.out.print("Fin del programa");
   }
   //********************************* MÉTODOS **************************************//
   //Método que muestra la introduccion  USER_c271e4ac	07 de marzo de 2010 (15:34:14
   public static  void intro() {
      System.out.println("Este programa permite trabajar con una lista de tweets");
      System.out.println("Utiliza las clase Tweet y TweetBD");
      System.out.println("Lee tweets del fichero tweets.txt");
      System.out.println("Mediante un menú permite elegir diferentes opciones");
      System.out.println("Cuando se elige finalizar, muestra \"Fin del programa\"\n");
   }
    //Método que muestra el menú y devulve un int con la opción
   public static int  menuElegir(Scanner teclado){
      System.out.println("******** MENU *******");
      System.out.println("1. Añadir un tweet");
      System.out.println("2. Borrar tweets");
      System.out.println("3. Mostrar tweets");
      System.out.println("4. Tweets anteriores");
      System.out.println("5. Tweets de un tema");
      System.out.println("Elige tu opción (0 para acabar): ");
      int opcion = teclado.nextInt();
      return opcion;
   }
   
   //Método para añadir un nuevo tweet, recibe un Scanner para leer por teclado y un objeto TweetDB
   public static void anhadirTweet(Scanner teclado, TweetBD unTweetBD) {
      //Comprueba que el usuario tenga 8 carácteres
      Pattern formatoUsuario = Pattern.compile(".{8}");
      Matcher comparaFormato;
      String usuario = "";
     //Si el usuario no es valido la pedirá otra vez
      do {
         System.out.println(" Usuario: ");
         usuario = teclado.next();
         comparaFormato  = formatoUsuario.matcher(usuario);
         if(!comparaFormato.matches()) {
            System.out.println("El usuario es inválido, tipo esperado 8 carácateres.");
         }
      }while (!comparaFormato.matches());
      usuario = "USER_" + usuario;
      
      //Comparamos la fecha y la hora para que sea valida (\\d == a [0-9])
      Pattern formatoFecha = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");
      Pattern formatoHora = Pattern.compile("\\d{2}:\\d{2}:\\d{2}");
      String fechaStr;
      String hora;
      //Si la fecha no es valida la pedirá otra vez
      do {
         System.out.println("Introduce una fecha  (aaaa-mm-dd): ");
         fechaStr = teclado.next();
         comparaFormato = formatoFecha.matcher(fechaStr);
         if(!comparaFormato.matches()) {
            System.out.println("La fecha es inválida");
         }
      } while (!comparaFormato.matches());
     //Si la hora no es valida la pedirá otra vez
     do {
         System.out.println("Introduce una  hora (hh:mm:ss): ");
         hora = teclado.next();
         comparaFormato = formatoHora.matcher(hora);
         if(!comparaFormato.matches()) {
            System.out.println("La hora es inválida");
         }
      } while(!comparaFormato.matches());
      //Pedimos el tweet
      System.out.println(" Mensaje: ");
      teclado.nextLine();
      String mensaje = teclado.nextLine();
      String fechaHora = fechaStr + "T" + hora;
     //Añadimos el tweet
      Tweet unTweet = new Tweet(usuario, fechaHora, mensaje);
      unTweetBD.addTweet(unTweet);  
      System.out.print("El tweet se ha añadido\n");
   }
   
   //Método para borrar los tweets de los usuarios, recibe un Scanner para leer por teclado y un 
   //objeto de la clase TweetBD.
   public static void borrarTweetsUsuario(Scanner teclado,  TweetBD unTweetBD) {
      System.out.print("Elige un usuario: "); //USER_989b85bb
      String usuario = teclado.next();
      System.out.print("Borrar todos los tweets del usuario " +  usuario + " (S/N) ");
      String respuesta = teclado.next();
      while(!respuesta.equalsIgnoreCase("S") && !respuesta.equalsIgnoreCase("N")) {
         System.out.print("Borrar todos los tweets del usuario " +  usuario + " (S/N) ");
         respuesta = teclado.next();
      }
      int tweetBorrados = 0;
      if(respuesta.equalsIgnoreCase("S")) {
         tweetBorrados = unTweetBD.borrarTweets(usuario);
         System.out.println("Se han borrado " + tweetBorrados +" mensajes\n" );
      }
   }
   
   //Método que recoge el número de tweet para imprimir los anteriores al tweet elegido, recibe un Scanner para leer por teclado y un 
   //objeto de la clase TweetBD.
   public static void tweetAnteriorATweet(Scanner teclado, TweetBD unTweetBD, PrintStream escribirFichero) {
      System.out.print("Elige el número de un tweet: ");
      int numTweet = teclado.nextInt();
      System.out.println(unTweetBD.tweetsAnteriores(unTweetBD.getTweet(numTweet - 1)));
      escribirFichero.print("TWEETS ESCRITOS ANTES DE: "  + unTweetBD.getTweet(numTweet - 1) + "\n");
      escribirFichero.print("\n" + unTweetBD.tweetsAnteriores(unTweetBD.getTweet(numTweet - 1)));
   }
   
   //Método que recoge una palabra y da una base con la palabra, recibe un Scanner para leer por teclado y un 
   //objeto de la clase TweetBD.
   public static void buscarTweetsPalabra(Scanner teclado, TweetBD unTweetBD,  PrintStream escribirFichero) {
      System.out.print("Eligela palabra a buscar: ");
      String palabra = teclado.next();
      System.out.println(unTweetBD.buscarTweets(palabra));
      escribirFichero.print("\nTWEETS QUE CONTIENEN LA PALABRA "+ palabra.toUpperCase() + "\n");
      escribirFichero.print(unTweetBD.buscarTweets(palabra));
   }
}