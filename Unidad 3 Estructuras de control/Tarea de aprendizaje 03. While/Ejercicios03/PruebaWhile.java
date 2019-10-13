import java.util.Scanner; 
public class PruebaWhile{ 
   public static void main(String[] args) { 
      // Declare the object and initialize with 
      // predefined standard input object 
      Scanner sc = new Scanner(System.in); 
      String respuesta = "";
      do{
         respuestaUsuario(sc);
         System.out.print(respuesta);
      }while(!respuesta.equals("S"));
   }

   public static String respuestaUsuario(Scanner teclado){
      System.out.print("Multiplicar (S/N)? ");
      String respuesta = teclado.next();
      respuesta = respuesta.toUpperCase(); 
      return respuesta;
   }
}