import java.util.Scanner;
public class Suma {
   public static void main(String[] args) {
      Scanner teclado = new Scanner(System.in);
      System.out.println("Introduce un número ") ;
      int numero = teclado.nextInt();
      int suma = sumaHasta(numero);
      System.out.println("Resultado: " + suma);
   }
   public static int sumaHasta(int max){
      int suma = 0;
      int multi = 1;
      String cadena ="";
      for(int i = 1; i < max; i++){
         suma = suma + i;
         multi = multi * i;
         cadena += i;
      }
      System.out.println("Resultado Multi: " + multi);
      System.out.println("Cadena : " + cadena);
      return suma;
   }
}