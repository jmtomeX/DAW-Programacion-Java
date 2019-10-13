import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/**
  * Java SimpleDateFormat - convert a Java String to a Date
  *
  * Uses a String pattern to define the expected date format.
  *
  */
public class SimpleDateFormatStringToDate {
   public static void main(String[] args) {
      // (1) create a SimpleDateFormat object with the desired format.
      // this is the format/pattern we're expecting to receive.
               // Crear una instancia de la clase Date
      // El objeto guardará la fecha y hora actual
      Date fechaActual = new Date(); 
            
      // Mostrar la fecha con formato predeterminado
      System.out.println(fechaActual);
   // Definimos diferentes formatos con la Clase SimpleDateFormat      
      SimpleDateFormat formato1 = new SimpleDateFormat("hh:mm:ss a");
      SimpleDateFormat formato2 = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy. hh:mm:ss zzz");
      SimpleDateFormat formato3 = new SimpleDateFormat("EEEE MM dd yyyy");
      
      // Aplicamos esos formatos a una fecha        
      System.out.println("Formato 1: " + formato1.format(fechaActual));
      System.out.println("Formato 2: " + formato2.format(fechaActual));
      System.out.println("Formato 3: " + formato3.format(fechaActual) + "\n");
      
     /*******************************************************************/
      //Comparar 2 fechas
      SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-mm-yyyy");
      Date fecha = new Date();
      System.out.println("Fecha actual: " + formatoFecha.format(fecha)); 
      try {
         Date fecha1 = formatoFecha.parse("20-08-2017");  
         System.out.println("Fecha introducida: " + formatoFecha.format(fecha1));
         int comparacion = fecha1.compareTo(fecha);
         if (comparacion > 0) {  
            System.out.println("La fecha introducida ocurre después de la fecha actual"); 
         } else if (comparacion < 0) {  
            System.out.println("La fecha introducida ocurre antes de la fecha actual"); 
         } else {  
            System.out.println("Ambas fechas son iguales"); 
         }
      } catch (ParseException e) {
         System.out.println("El formato de la fecha es incorrecto");
      }
      System.out.println();
      /******************************************************************/
      
      String expectedPattern = "MM/dd/yyyy";
      SimpleDateFormat formatter = new SimpleDateFormat(expectedPattern);
      try {
         // (2) give the formatter a String that matches the SimpleDateFormat pattern
         String userInput = "09/22/2009";
         Date date = formatter.parse(userInput);
      
         // (3) prints out "Tue Sep 22 00:00:00 EDT 2009"
         System.out.println(date);
      } catch (ParseException e){
         // execution will come here if the String that is given
         // does not match the expected format.
         e.printStackTrace();
      }
   
      
   }
}