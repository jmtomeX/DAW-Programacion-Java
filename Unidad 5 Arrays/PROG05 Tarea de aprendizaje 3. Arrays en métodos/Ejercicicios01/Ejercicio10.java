/*
Escribe el código para el método alargar. Recibirá como parámetro un array y devolverá otro con el doble de elementos.
Para ello, cada elemento del primer array se corresponderá con 2 números en el segundo array. 
Si el número original es par, los 2 números nuevos será iguales a la mitad de ese valor.
Si el número es impar, el primer número será una unidad mayor.

Por ejemplo:

int[] a1 = {1, 2, 3, 4};
int[] a2 = alargar(a1);
System.out.println(Arrays.toString(a2));

[1, 0, 1, 1, 2, 1, 2, 2]
int[] a1 = {11, 20, 8, 43};
             [6, 5, 10, 10, 4, 4, 22, 21]
*/
import java.util.*;
public class Ejercicio10 {
   public static void main(String[] args) { 
      int[] a1 =  {1, 2, 3, 4};
      int[] a2 = alargar(a1);
      System.out.println(Arrays.toString(a2));
   }
   public static int[] alargar(int[] lista) {
      int[] listaNueva = new int[lista.length * 2 ];
      int cont = 0;
      for(int i = 0; i < lista.length; i++){
         if(lista[i] % 2 == 0){
            listaNueva[cont] = lista[i] / 2;
            cont += 1;
            listaNueva[cont] = lista[i] / 2;
            cont += 1;
         }else{
            listaNueva[cont] = lista[i] /2 + 1 ;
            cont += 1;
            listaNueva[cont] = listaNueva[cont - 1] - 1;
            cont += 1;
         }
      } 
      return listaNueva;
   }
}