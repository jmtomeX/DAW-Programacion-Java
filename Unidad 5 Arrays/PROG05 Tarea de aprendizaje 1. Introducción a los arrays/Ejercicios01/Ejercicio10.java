/*
Escribe el código para el método menor. Recibirá como parámetros un número entero y un array,
comparará el valor con todos los elementos en el array y devolverá true si todos son menores
y false en caso contrario:
int[] array = {4, 12, 7, 25, 7};
menor(7, array);

Devolverá false (solo el 4 es menor)

int[] array = {4, 12, 7, 25, 7};
menor(38, array);

Devolverá true (todos los números del array son menores que 38)
*/
public class Ejercicio10 {
   public static void main(String[] args) {
      int[] array = {4, 12, 7, 25, 7};
      System.out.println(menor(10, array));
      System.out.println(array.length);
   }
   public static boolean menor(int numero, int array[]){
      int cont = 0;
      for(int i = 0; i <= array.length -1 ; i++){
         if(numero > array[i]) {
            cont++;
         }
         
      }
      return (cont == (array.length));
   }
}