/*
Escribe el código para el método precioJusto. Recibirá como parámetro un array de números y un número.
Devolverá el número del array más cercano al dado sin sobrepasarlo:

int[] nums1 = {120, 400, 170, 250};
int resultado = precioJusto(nums1, 180);
System.out.println("Resultado: " + resultado);
Resultado: 170

int[] nums1 = {120, 400, 170, 250};
int resultado = precioJusto(nums1, 160);
System.out.println("Resultado: " + resultado);
Resultado: 120
*/
public class Ejercicio10 {
   public static void main(String[] args) {    
      int[] nums1 = {120, 150,161, 400, 170, 250};
      int resultado = precioJusto(nums1, 1000);
      System.out.println("Resultado: " + resultado);
   }
   public static int precioJusto(int[] listaPrecios, int precio) {
      int result = -1;
      int min = -1;
      for (int i = 0; i < listaPrecios.length; i++) {
         if (listaPrecios[i] <= precio) {
            int dif = precio - listaPrecios[i];
            if (result == -1 || dif < min) {
               result = listaPrecios[i];
               min = dif;
            }
         }
      }
      return result;
   }
   
}

