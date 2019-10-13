/******************************************************************************************************************

  Nombre:   XXX
  Fecha:    XX/XX/2019
  Modulo:   Programación.
  UD:       UD7 ArrayList.
  Tarea:    Tarea Evaluación. Realiza un programa en Java.
  
  Descripción del programa:   Definición de la clase TweetBD
                              Gestionará la descripción y todos los tweets almacenados
                                
*******************************************************************************************************************/

import java.util.*;

public class TweetBD {

   // Atributos   
   private String descripcion;
   private ArrayList<Tweet> tweets;
     
   /* Constructor: inicializa los atributos descripción y tweets
      Parámetros: 
         String descripción: Descripción de los tweets que va a almacenar
   */
   public TweetBD(String descripcion) {
      this.descripcion = descripcion;
      this.tweets = new ArrayList<Tweet>();
   }

   /* Constructor: inicializa los atributos descripción y tweets.
      Carga los tweets leídos de un Scanner conectado a un fichero.
      Parámetros: 
         String descripción: Descripción de los tweets que va a almacenar
         Scanner leerFichero: Scanner conectado a un fichero
   */   
   public TweetBD(String descripcion, Scanner leerFichero) {
      //Sería lo mismo que la llamada al constructor TweetBD(descripcion)
      this(descripcion);
      while (leerFichero.hasNextLine()) {
         String linea = leerFichero.nextLine();
         Scanner leerLinea = new Scanner(linea);
         while (leerLinea.hasNext()) {
            String usuario = leerLinea.next();
            String fechaHora = leerLinea.next();
            String tweet = leerLinea.nextLine();
            //Eleimnina el espacio en blanco al empezar en (1).
            tweet = tweet.substring(1);
            addTweet(usuario, fechaHora, tweet);
         }
      }
   }
   
   /* Método toString
      Formatea un TweetBD de la siguiente manera:
         DESCRIPCION
         1.	usuario          	fecha                         	tweet
         2.	usuario          	fecha                         	tweet
         3.	usuario          	fecha                         	tweet 
      ...
      Utiliza el método toString de la clase Tweet y el bucle for-each
   */
   public String toString() {
      
      String formato = descripcion.toUpperCase();
      
      int cont = 1;
      for (Tweet unTweet : tweets) {
         formato += "\n" + cont + ".\t" + unTweet.toString();
         cont++;
      }
      formato += "\n";
      return formato;
   }
   
   // Métodos get y set
   // Devuelve el número de tweet del ArrayList tweets
   public int getNumeroTweets() {
      return tweets.size();
   }

   // Devuelve el Tweet con el índice indicado
   // Se realizará una copia antes de devolver el objeto para protegerlo de accesos externos
   // Parámetros:
   //       int i: índice del tweet
   // Return: 
   //       Copia del Tweet buscado
   public Tweet getTweet(int i) {
      Tweet buscado = tweets.get(i);
      Tweet copia = new Tweet(buscado);
      return copia;
   }

   // Añade un Tweet al ArrayList a partir de los datos indicados
   // Parámetros:
   //    String usuario: nombre del usuario que ha escrito el tweet
   //    String fechaHora: fecha del tweet con formato yyyy-MM-ddThh:mm:ss
   //    String tweet: contenido del tweet
   // No devuelve nada 
   public void addTweet(String usuario, String fechaHora, String tweet) {
      Tweet nuevoTweet = new Tweet(usuario, fechaHora, tweet);
      tweets.add(nuevoTweet);
   }

   // Añade una copia de Tweet indicado al ArrayList
   // Parámetros:
   //    Tweet unTweet: Tweet original. Se debe copiar antes de añadirlo
   // No devuelve nada    
   public void addTweet(Tweet unTweet) {
      Tweet copia = new Tweet(unTweet);
      tweets.add(copia);
   }

   // Busca y devuelve una copia del tweet más reciente de la BBDD.
   // Si no hay ningún tweet devolverá null
   // Return: copia de Tweet más reciente del ArrayList
   public Tweet TweetMasReciente() {
      if (getNumeroTweets() == 0) {
         return null;
      }
      
      Tweet masReciente = tweets.get(0);
      for (int i = 1; i < tweets.size(); i++) {
         Tweet esteTweet = tweets.get(i);
         if (esteTweet.esMasReciente(masReciente)) {
            masReciente = esteTweet;
         }
      }
      return new Tweet(masReciente);      // Devolvemos una copia
   }

   // Borra todos los tweets del usuario indicado
   // Devolverá el número de tweets borrados
   // Parámetros:
   // String usuario: usuario cuyos tweets hay que borrar
   // Return: número de tweets borrados  
   public int borrarTweets(String usuario) {
      int cont = 0;
      Iterator<Tweet> it = tweets.iterator();   
      while (it.hasNext()) {
         Tweet unTweet = it.next();
         String unUsuario = unTweet.getUsuario();
         if (unUsuario.equals(usuario)) {
            it.remove();
            cont++;
         }
      }
      return cont;  
   }

   // Crea y devuelve un TweetBD con todos los tweet anteriores (más antiguos) al tweet dado
   // La descripción será "Tweets escritos antes de + tweet"
   // Parámetros:
   // Tweet esteTweet: Tweet cuya fecha hay que mirar para obtener los que son más antiguos
   // Return: un objeto TweetBD con el resultado obtenido  
   public TweetBD tweetsAnteriores(Tweet esteTweet) {
      TweetBD nuevaBD = new TweetBD("Tweets escritos antes de este tweet: " + esteTweet);
           
      for (Tweet unTweet : tweets) {
         if (esteTweet.esMasReciente(unTweet)) {
            nuevaBD.addTweet(unTweet);
         }
      }
      return nuevaBD;    
   }

   // Crea y devuelve un TweetBD con todos los tweet que contienen el texto dado
   // La descripción será "Tweets que contienen la palabra + palabra"
   // Parámetros:
   // String palabra: Palabra a buscar en el texto del tweet. Puede ser parte de una palabra
   // Return: un objeto TweetBD con el resultado obtenido 
   public TweetBD buscarTweets(String palabra) {
      TweetBD nuevaBD = new TweetBD("Tweets que contienen la palabra " + palabra);
      for (Tweet unTweet : tweets) {
         String texto = unTweet.getTweet();
         if (texto.contains(palabra)) {
            nuevaBD.addTweet(unTweet);
         }
      }
      return nuevaBD; 
   }   
}