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
/*
Clase Tweet: Los tweets más reciente son los que se han escrito después del indicado, no antes.
Clase TweetBD: En el método tweetMasReciente mejor copiar con new solo el Tweet que se devuelve con el return. 
Además, podrías haber usado esMasReciente. En el método toString se debería añadir también la descripción del TweetBD.
Clase MainTweet: Normalmente se suele escribir en el fichero al final antes de salir del programa y después de haber
hecho todas las modificaciones.
*/

// Clase TweetBD
// Atributos 
import java.util.*;
import java.io.*;

public class TweetBD {  
   private String descripcion;
   private ArrayList<Tweet> tweets;
      
    // Constructores
   public TweetBD(String descripcion) {
      this.descripcion = descripcion;
      tweets = new ArrayList<Tweet>();
   }
    
   public TweetBD(String descripcion, Scanner leerFichero) throws FileNotFoundException {
      this.descripcion = descripcion;
      tweets = new ArrayList<Tweet>();
      while(leerFichero.hasNextLine()){
         String linea = leerFichero.nextLine();
         Scanner leerLinea = new Scanner(linea);
         
         String usuario = leerLinea.next();
         String fechaHora =  leerLinea.next();
         String tweet =  leerLinea.nextLine();
         Tweet unTweet = new Tweet(usuario, fechaHora, tweet);
         tweets.add(unTweet);        
      }
   }
   
   //******************* MÉTODOS************************//
   //Devuelve el número de elementos del Arraylist tweets
   public int getNumeroTweets() {
      return tweets.size();
   }
     
    // Añade un tweet con los datos indicados al ArrayList tweets
   public void addTweet(String usuario, String fechaHora, String tweet) {
      Tweet unTweet = new Tweet(usuario, fechaHora, tweet);
      tweets.add(unTweet);
   }
    
    //Añade un Tweet     
   public void addTweet(Tweet unTweet) {
      Tweet copiaTweet = new Tweet(unTweet);
      tweets.add(unTweet);
   }
    
    // Busca y devuelve el tweet más reciente de la BBDD
    // Si no hay ningún tweet devolverá null
   public Tweet tweetMasReciente() {
      Date masReciente = new Date();
      masReciente = tweets.get(0).getFecha();
      Tweet masRecienteTweet = null;
      for(int i = 1; i < getNumeroTweets() - 1; i++) {
         if(masReciente.before(tweets.get(i).getFecha())) {
            masReciente = tweets.get(i).getFecha();
            masRecienteTweet = new Tweet(tweets.get(i));
         }
      }
      return masRecienteTweet;
   }
     
    /* Formatea un TweetBD de la siguiente manera:
       DESCRIPCION
       1.	usuario          	fecha                         	tweet
       2.	usuario          	fecha                         	tweet
       3.	usuario          	fecha                         	tweet 
       ...
    */  
   public String toString() {
      String salidaDatos = "";
      int i = 1;
      for(Tweet unTweet : tweets) {
         salidaDatos += i + ".\t" + unTweet.toString() + "\n";
         i++;
      }
    
      return salidaDatos;
   }
    
    // Borra todos los tweets del usuario indicado
    // Devolverá el número de tweets borrados, recibe un usuario String y devulve un int
   public int borrarTweets(String usuario) {
      Iterator<Tweet> it = tweets.iterator();
      int tweetsBorrados = 0;
      while(it.hasNext()) {
         Tweet tweet = it.next();
         if(tweet.getUsuario().equals(usuario)) {
            it.remove();
            tweetsBorrados++;
         }
      }
      
      return tweetsBorrados;
   }
    
    // Devuelve el Tweet con el Índice indicado
   public Tweet getTweet(int i) {
      Tweet copiaTweet = new Tweet(tweets.get(i));
      return copiaTweet;
   }
    
    // Crea y devuelve un TweetBD con todos los tweet anteriores al tweet dado
    // La descripción será "Tweets escritos antes de + tweet"
    //Rcibe un objeto Tweet y devuelve un objeto TweetBD
   public TweetBD tweetsAnteriores(Tweet esteTweet) {
      TweetBD tweetBDAnterior = new TweetBD("TWEETS ESCRITOS ANTES DE: "  + esteTweet + "\n");
      //TweetBDAnterior.addTweet(getTweet(numTweet));     
      for(Tweet miraTweet: tweets){
         if(miraTweet.esMasReciente(esteTweet)) {
            Tweet copiaTweet = new Tweet(miraTweet);
            tweetBDAnterior.addTweet(copiaTweet);  
         }   
      } 
      System.out.print(tweetBDAnterior.descripcion);//imprimimos la descripción
      
      return tweetBDAnterior;
   }

    // Crea y devuelve un TweetBD con todos los tweet que contienen el texto dado
    // La descripción será "Tweets que contienen la palabra + palabra"
    //Rcibe una palabra a buscar String y devuelve un objeto TweetBD
   public TweetBD buscarTweets(String palabra) {
      TweetBD tweetBusqueda = new TweetBD("TWEETS QUE CONTIENEN LA PALABRA "+ palabra.toUpperCase() + "\n");
      int i = 0;
      for(Tweet miraTweet: tweets) {
         if(tweets.get(i).getTweet().contains(palabra)) {//compruba si esta la palabra.
            Tweet copiaTweet = new Tweet(miraTweet);
            tweetBusqueda.addTweet(copiaTweet);  
         }  
         i++; 
      } 
      System.out.print(tweetBusqueda.descripcion);//imprimimos la descripción
     
      return tweetBusqueda;
   } 
}
