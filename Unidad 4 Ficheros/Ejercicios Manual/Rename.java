import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Rename {
   public static void main(String[] args) throws  FileNotFoundException{ 
      PrintStream escribirFichero = new PrintStream(new File("lineas02.txt"));
      Date fechaActual = new java.util.Date(); //Fecha actual del sistema     
      File f = null;
      File f1 = null;
      boolean bool = false;
      
      try {  
      
         // crear nuevos objetos de archivo
         f = new File("edades.txt");
         f1 = new File("testABC.txt");
         //para establecerle la fecha actual al fichero que se le pasa como parámetro
         //new File("lineas02.txt").setLastModified(new Date().getTime());
         //f1.delete();
         /*while(fichero.hasNextLine()){
            String linea = fichero.nextLine();
            System.out.print(linea);
         }*/
         // renrenombrar archivo
         bool = f.renameTo(f1);
         
         // imprimir
         System.out.print("Archivo renombrado? " +  bool + "\n" + fechaActual);
         escribirFichero.print(fechaActual);
        
      
      } catch(Exception e) {
         // si ocurre algún error
         e.printStackTrace();
      }
   }
   
}