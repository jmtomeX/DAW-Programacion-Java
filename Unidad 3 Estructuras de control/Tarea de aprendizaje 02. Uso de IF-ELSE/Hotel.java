// Este programa muestra como evitar redundancias en estructuras IF
import java.util.*;

public class Hotel {
   public static void main(String[] args) {
      System.out.println("Este programa calcula el precio total a pagar en el hotel.");
      Scanner leerTeclado = new Scanner(System.in);
      double total = totalEstancia(leerTeclado);
      System.out.println("El precio total a pagar es de " + total + " euros");  
   }
   
   // Obtiene el total a pagar en funcion del tipo de cliente
   // Normal: 70 euros la noche
   // Mayores de 60 años: 65 euros la noche
   // clientes habituales: 60 euros la noche
   public static int totalEstancia(Scanner leerTeclado) {
      System.out.print("Tipo de cliente (Normal, Senior, Habitual): ");
      String cliente = leerTeclado.next().toLowerCase();
      
      System.out.print("Numero de habitaciones: ");
      int habitaciones = leerTeclado.nextInt();
      System.out.print("Numero de dias: ");
      int dias = leerTeclado.nextInt();
      
      int precio = 70;
      
      if (cliente.equals("senior")) {
         precio = 65;
      } else if (cliente.equals("habitual")) {
         precio = 60;
      }
      
      int total = habitaciones * dias * precio;
      return total;
   }
}