/*
Escribe un programa que pregunte el número de productos que se han comprado.
A continuación, por cada producto preguntará su precio.
Por último, mostrará el precio total y el precio medio por producto.
Por ejemplo:

Cuantos productos: 3
Producto 1: 23,3
Producto 2: 7,3
Producto 3: 2,1
El total de la compra son: 32.7 euros.
El precio medio por producto es: 10.9 euros.

IMPORTANTE: si se quieren leer datos desde el teclado tanto en el main como en un método, se deberá crear
el objeto de la clase Scanner en el main y luego pasarlo como parámetro al método.
*/
import java.util.*;
public class Ejercicio11{
   public static void main(String[] args){
      productos(new Scanner(System.in));
   }
   public static void productos(Scanner teclado){
      int i = 0;
      double precioTotal = 0;
      System.out.println("Cuantos productos:");
      int numeroProductos = teclado.nextInt();
      for( i = 1; i <= numeroProductos; i++){
         System.out.println("Producto " + i +  ":" );
         double precio = teclado.nextDouble();
         precioTotal += precio;
      }
      System.out.println("El total de la compra son: " + precioTotal + " euros");
      System.out.println("El precio medio por producto es: " + precioTotal / numeroProductos + " euros");
      
   }
}