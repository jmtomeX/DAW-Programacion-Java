import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class ListFiles {
   public static void main(String[] args) throws NullPointerException{ 
      try{
         File fichero = new File("entrada.txt");
         File f = null;
         File[] ficheros = f.listFiles();
         for (int x = 0; x < ficheros.length; x++){
            System.out.println(ficheros[x].getName());
         }
      } catch(Exception e) {
         // si ocurre algún error
         e.printStackTrace();
      }
   }
}