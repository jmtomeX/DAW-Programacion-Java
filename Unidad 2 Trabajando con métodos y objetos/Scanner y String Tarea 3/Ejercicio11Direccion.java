/*
Crea el método procesaDireccion().
Se le pasará un objeto de tipo Scanner para leer por teclado la calle, el municipio y la provincia del usuario.
A continuación, creará un texto con el siguiente formato: Calle <calle introducida>, <municipio introducido>(<provincia introducida>) y lo devolverá al programa principal.
Utiliza nextLine() para leer la línea entera y no solo una palabra.

Por ejemplo:

System.out.println(procesaDireccion(new Scanner(System.in)));

Introduce una calle: 
Álava 41 interior
Introduce una municipio: 
Vitoria-Gasteiz
Introduce una provincia: 
Alava
Calle Álava 41 interior, Vitoria-Gasteiz(Alava)
*/
import java.util.*;

public class Ejercicio11Direccion {
   public static void main(String[] args) {
      //Scanner teclado = new Scanner(System.in);
      //String resultado = procesarDireccion(teclado);
      //System.out.println(resultado);
     
      System.out.println(procesarDireccion(new Scanner(System.in)));
   }
   public static String procesarDireccion(Scanner teclado){
      //Pedimos los datos
      System.out.println("Introduce una calle:");
      String nombreCalle = teclado.nextLine();
      System.out.println("Introduce una municipio:");
      String nombreMunicipio = teclado.nextLine();
      System.out.println("Introduce una provincia:");
      String nombreProvincia = teclado.nextLine();
      return nombreCalle + ", " + 
         nombreMunicipio  + "(" +  nombreProvincia + ")";
   }
     
}