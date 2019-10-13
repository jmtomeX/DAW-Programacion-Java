import java.io.*;
public class InforFichero {
   public static void main(String[] args) {
      File fichero = new File ("entrada.txt");
      System.out.println("el método exists() devuelve " + fichero.exists());
      System.out.println("el método canRead() devuelve " + fichero.canRead());
      System.out.println("el método length() devuelve " + fichero.length());
      System.out.println("el método getAbsolutePath() devuelve " + fichero.getAbsolutePath());
   }
}