/******************************************************************************************************************

  Nombre:   XXX
  Fecha:    XX/XX/2019
  Modulo:   Programación.
  UD:       UD7 ArrayList.
  Tarea:    Tarea Evaluación. Realiza un programa en Java.
  
  Descripción del programa:   Definición de la clase Tweet
                              Gestionará el usuario, la fecha y el contenido de un tweet
                                
*******************************************************************************************************************/

// Librerías para manejar objetos de la clase Date
import java.text.*;
import java.util.*;

// Definición de la clase Tweet
public class Tweet {

   // Atributos
    private String usuario;
    private Date fecha;
    private String tweet; 
    
   /* 
      Constructor: crea la Un Tweet.
      Parámetros: 
         String usuario: nombre del usuario que ha escrito el tweet
         Date fechaHora: fecha del tweet
         String tweet: contenido del tweet
   */
   public Tweet(String usuario, Date fechaHora, String tweet) {
      this.usuario = usuario;
      this.fecha = fechaHora;
      this.tweet = tweet;
   }
   
   // toString
   // Es necesario utilizar la clase SimpleDateFormat para convertir la fecha Date a un String
   // En este caso el formato será dd de MMMM d' yyyy (HH:mm:ss)
   // Se usará el método format
   public String toString() {
      SimpleDateFormat formatoFecha = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy (HH:mm:ss)");
      String fechaString = formatoFecha.format(fecha);
      return String.format("%-18s%-35s%s", usuario, fechaString, tweet);
   }
   
   // Constructor copia
   // Para usar el otro constructor mediante this(), habría que convertir la fecha Date a String
   public Tweet(Tweet otroTweet) {
      this(otroTweet.usuario, otroTweet.fecha, otroTweet.tweet);
   }
   
   // Métodos get y set
   // Devuelve el usuario del Tweet
   public String getUsuario() {
      return usuario;
   }
   
   // Devuelve la fecha del Tweet
   public Date getFecha() {
      return fecha;
   }
   
   // Devuelve el contenido del Tweet
   public String getTweet() {
      return tweet;
   }
     
   // Compara el atributo fecha con la fecha del Tweet otro 
   // Utilizamos el método compareTo
   public boolean esMasReciente(Tweet otro) {
      Date otraFecha = otro.fecha;
      int compararFechas = fecha.compareTo(otraFecha);
      return compararFechas > 0;
   }
}