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
         String fechaHora: fecha del tweet con formato yyyy-MM-ddThh:mm:ss
         String tweet: contenido del tweet
      Es necesario utilizar la clase SimpleDateFormat convertir la fecha a un objeto Date
      Se define el formato y se convierte usando el método parse.
      Se debe gestionar la excepción ParseException
   */
   public Tweet(String usuario, String fechaHora, String tweet) {
      this.usuario = usuario;
      this.tweet = tweet;
      
      SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
      try {
          Date fechaDate = formatoFecha.parse(fechaHora);  
          this.fecha = fechaDate;
      } catch (ParseException e) {
          System.out.println("El formato de la fecha es incorrecto");
      }
   }
   
   // toString
   // Es necesario utilizar la clase SimpleDateFormat para convertir la fecha Date a un String
   // En este caso el formato será dd de MMMM d' yyyy (HH:mm:ss)
   // Se usará el método format
   public String toString() {
      SimpleDateFormat formatoFecha = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy (HH:mm:ss)");
      String fechaString = formatoFecha.format(fecha);
      return String.format("%-13s\t%s\t%s", usuario, fechaString, tweet);
   }
   
   // Constructor copia
   // Para usar el otro constructor mediante this(), habría que convertir la fecha Date a String
   public Tweet(Tweet otroTweet) {
      this.usuario = otroTweet.usuario;
      this.fecha = otroTweet.fecha;
      this.tweet = otroTweet.tweet;
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