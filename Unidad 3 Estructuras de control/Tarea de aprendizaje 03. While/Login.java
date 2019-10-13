// Programa que pide contraseñas hasta que se introduce la correcta.
import java.util.*;

public class Login {
   public static void main(String[] args) {
      Scanner leerTeclado = new Scanner(System.in);
      String clave = "PROG2018";
      String password;
      
      int cont = 0;
      do {
         System.out.print("Introduce password: ");
         password = leerTeclado.nextLine();
         System.out.println("Clave incorrecta");
         cont++;
      } while (cont < 3 && !password.equals(clave));
      
      if(password.equals(clave)) {
         System.out.println("Ya estás dentro");
      } else {
         System.out.println("Intentos agotados");
      }
   }
}