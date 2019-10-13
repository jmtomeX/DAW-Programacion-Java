import java.util.*;
public class EjemploEliminarDeArreglo {
   public boolean eliminar(int[] arreglo, int elemento) {
      boolean resultado = false;
      for (int i = 0; i < arreglo.length; i++) {
         if (arreglo[i] == elemento) {
            for (int j = i; j < arreglo.length - 1; j++) {
               arreglo[j] = arreglo[j+1];
            }
            arreglo[arreglo.length - 1] = 0;
            resultado = true;
         }
      }
      return resultado;
   }

   public void ejemploEliminar(int[] arreglo, int numero) {
      //mencionaste no usar librerías externas de Java para
      //eliminar el elemento, pero no mencionaste
      //si no debían usarse para otras funciones como
      //mostrar su contenido
      System.out.println(Arrays.toString(arreglo));
      if (eliminar(arreglo, numero)) {
         System.out.println(
            String.format(
                "Se eliminó %d. Ahora el arreglo es: %s",
                numero, Arrays.toString(arreglo)));
      } else {
         System.out.println("El arreglo sigue intacto.");
      }
   }

   public static void main(String[] args) {
      //arreglo definido de manera estática
      int[] arreglo = { 1, 2, 3, 4, 5 };
        //el mismo caso de antes pero asignamos los valores del arreglo desde un for
      int[] otroArreglo = new int[5];
      EjemploEliminarDeArreglo ejemplo = new EjemploEliminarDeArreglo();
      System.out.println(Arrays.toString(otroArreglo));
      //eliminando los números 3, 10 y 4 del arreglo
      ejemplo.ejemploEliminar(arreglo, 3);
      ejemplo.ejemploEliminar(arreglo, 10);
      ejemplo.ejemploEliminar(arreglo, 4);
   
    
      //solo a modo de demostración, imprimimos el contenido del arreglo
      //será algo como [0, 0, 0, 0, 0]
      //porque eso es un arreglo de enteros vacío en Java
      System.out.println(Arrays.toString(otroArreglo));
      //ahora, le asignamos elementos
      for (int i = 1; i <=5; i++) {
         otroArreglo[i-1] = i;
      }
      //y lo volvemos a mostrar en la consola
      //ahora luce [1, 2, 3, 4, 5] como lucía `arreglo`
      //antes que le eliminaran sus datos
      System.out.println(Arrays.toString(otroArreglo));
   }
}