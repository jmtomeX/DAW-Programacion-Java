import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class SetLastModified {
   public static void main(String[] args) throws  FileNotFoundException, NullPointerException{ 
   
      File fichero = new File("entrada.txt");
      long ms = System.currentTimeMillis();
      boolean cambio = fichero.setLastModified(ms);
   
      if (cambio)
         System.out.println("Se ha cambiado la hora del sistema satisfactoriamente");
      else
         System.out.println("NO se ha podido cambiar la hora");
      System.out.println(ms);
      File[] ficheros = fichero.listFiles();
      for (int x=0;x<ficheros.length;x++){
         System.out.println(ficheros[x].getName());
      }
   }
}