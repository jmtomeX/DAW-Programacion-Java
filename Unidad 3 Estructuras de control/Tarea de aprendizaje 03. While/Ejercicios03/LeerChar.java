import java.util.Scanner; 
public class LeerChar{ 
   public static void main(String[] args) { 
      // Declare the object and initialize with 
      // predefined standard input object 
      Scanner sc = new Scanner(System.in); 
   
      // Character input 
      System.out.print("Ingresa un caracter: ");
      char c = sc.next().charAt(0); 
   
      // Print the read value 
      System.out.println("c = "+c); 
   } 
}
