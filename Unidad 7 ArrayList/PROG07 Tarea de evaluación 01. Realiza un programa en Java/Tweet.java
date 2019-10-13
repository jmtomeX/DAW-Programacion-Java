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

// Clase Tweet
import java.text.ParseException;
import java.text.SimpleDateFormat; 
import java.util.Date;
public class Tweet{
 // Atributos
   private String usuario;
   private Date fecha;
   private String tweet; 
   private String fechaStr;
         
   // Constructores: convierte el String de la fecha a un objeto Date
   public Tweet(String usuario, String fechaHora, String tweet)  {
      this.usuario = usuario;
   //2010-03-03T14:19:51
      try {
         SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
         fecha = formatoFecha.parse(fechaHora);
      } catch (ParseException e){
         System.out.println("El formato de la fecha es incorrecto, fecha esperada (yyyy-MM-dd HH:mm:ss): " + e.getMessage());
      
      }  
      this.tweet = tweet;
   }
      
   public Tweet(Tweet otroTweet) {
      usuario = otroTweet.usuario;
      fecha = otroTweet.fecha;
      tweet =otroTweet.tweet;
   }
    
   //************************ MÉTODOS ****************************//
   public String getUsuario() {
      return usuario;
   }
   
   public Date getFecha() {
      return fecha;
   }
   
   public String getTweet() {
      return tweet;
   }
   
// Te puede ayudar usar el método format de la clase String y la clase SimpleDateFormat
   // Formatea un tweet de la siguiente manera
   // Usuario: hueco de 13 caracteres, alineado a la izquierda
   // Tabulador
   // Fecha: con el siguiente formato "dd 'de' MMMM 'de' yyyy (HH:mm:ss)"
   // Tabulador
   // Tweet
   // USER_a75657c2  	03 de marzo de 2010 (00:02:54)	@USER_13e8a102 They reached a "compromise"
   public String toString() {
      String salidaDatos = String.format("%-13s\t%s\t%s", usuario, fechaFormateada(), tweet);
      
      return salidaDatos;
   }
  
   // Compara la la fecha del Tweet con la de otro,devuleve un boolean y recibe un Objeto de la clase Tweet.
   // Devuelve true si es más reciente y false en caso contrario
   public boolean esMasReciente(Tweet otro) {
      if(fecha.before(otro.fecha)){
         return true;
      }
      return false;
      
   }
   //Método para formatear la fecha, recibe una fecha tipo Date y devuelve un String con la fecha
   //Solo se usa dentro de la clase tweet.
   private String fechaFormateada() {
      SimpleDateFormat formatoFecha = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy (HH:mm:ss)");
      String fechaFormt = formatoFecha.format(fecha);
      return fechaFormt;
     
   }  
}