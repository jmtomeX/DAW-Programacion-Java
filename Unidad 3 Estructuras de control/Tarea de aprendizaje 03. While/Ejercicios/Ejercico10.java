/*
Crea un programa que calcule la media de las calificaciones introducidas. El programa pedirá valores hasta que se introduzca
un número menor que 0. Si el primer número introducido es negativo no mostrará nada.
Haz que el programa sea robusto frente a valores incorrectos. Es decir, no leerá el dato hasta comprobar
 que el valor introducido es realmente un número real. Para ello crea el método leerDouble().
Por ejemplo:
Introduce calificacion: 
-10
Introduce calificacion: 
6,75
Introduce calificacion: 
abc
Valor no valido. Introduce calificacion:
7,25
Introduce calificacion: 
-5
Media: 7.0
*/
import java.util.*;
public class Ejercico10 {
   public static void main(String[] args) {
      Scanner teclado = new Scanner(System.in);
      calculoCalificaciones(teclado);
   }
   public static String calculoCalificaciones(Scanner teclado){
      double numero = 0.0;
      double media = 0.0;
      int cont = 0;
      double suma = 0.0;
      String resultado = "";
      do{
         System.out.println("Introduce calificacion:");
         while(teclado.hasNextDouble() != true){
            System.out.print("Dato no valido. Introduce calificacion:");
            teclado.next();
         }
         numero = teclado.nextDouble();
         if(numero >=0){
            cont++;
            suma = suma + numero;
         }
      }while(numero >= 0);
      media = numero / cont;
      if(cont > 1 && numero >= 0){
         resultado = "Media: " + suma;
      }
     
      return resultado;   
   }
}

