import java.io.*;
public class ConcesionarioMain {
   public static void main(String[] args) throws FileNotFoundException{
      try{
         Concesionario unConcesionario = new Concesionario("Mas Motor", "concesionario.txt");
         System.out.println(unConcesionario);
      } catch (FileNotFoundException e) {
         System.out.println("ERROR");
      }
   }

}