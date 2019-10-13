/*
Crea un programa que genere multiplicaciones. Generará los 2 números que se van a multiplicar,
el primero entre 1 y 100 y el segundo entre 1 y 10, pedirá el resultado al usuario y dirá si es correcto o no.
El programa continuará hasta que el usuario quiera acabar.

Utiliza la semilla 20 para que el programa sea autocorregible.
Por ejemplo:

Multiplicar (S/N)? S
15 x 2 = 40
Resultado incorrecto
Multiplicar (S/N)? S
21 x 3 = 63
Resultado correcto
Multiplicar (S/N)? N
*/
import java.util.*;
public class Ejercicio10 {
   public static void main(String[] args) {
      Scanner teclado = new Scanner(System.in);
      Random r = new Random();
      String respuesta;
      int cont = 1;
      do{
         //pedimos si quiere multiplicar
         respuesta = respuestaUsuario(teclado);
         if(respuesta.equals("S")){
            int num1 = r.nextInt(100) + 1;
            int num2 = r.nextInt(10) + 1;
            System.out.print(num1 + " x " + num2 + " = ");
            int resultadoUsuario = comprobarEnteros(teclado);
            //comprobamos la multiplicación introducida por el usuario
            int resultadoMaquina = num1 * num2;
            if(resultadoUsuario == resultadoMaquina) {
               System.out.println("Resultado correcto");
            }else {
               System.out.println("Resultado incorrecto");
            } 
         }else{
            break;
         } 
      }while(respuesta.equals("S"));
   }
   public static int comprobarEnteros(Scanner teclado){
      while(!teclado.hasNextInt()){
         teclado.next();
         System.out.println("Ingrese un número entero.");
      }
      int resultadoUsuario = teclado.nextInt();
      return resultadoUsuario;
   }
   public static String respuestaUsuario(Scanner teclado){
      System.out.print("Multiplicar (S/N)? ");
      String respuesta = teclado.next();
      respuesta = respuesta.toUpperCase(); 
      return respuesta;
   }  
}