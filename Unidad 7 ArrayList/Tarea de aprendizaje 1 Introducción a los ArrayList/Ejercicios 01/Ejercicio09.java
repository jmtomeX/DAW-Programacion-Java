/*
Crea el método intercambiar para que reciba un ArrayList de String e intercambie su contenido por parejas:
la primera con la segunda, la tercera con la cuarta... Si la lista tiene un número impar de elementos, 
el último se quedará igual.

Cuando el método funcione, el programa mostrará:

[verde, rosa, negro, rojo]
[rojo, verde, negro]

PISTA: Comprueba cuántos elementos hay que intercambiar antes de empezar a recorrer la lista.
Te dirá cuando debes acabar de recorrerla.
*/

import java.util.*;
public class Ejercicio09 {
   public static void main(String[] args) {
      ArrayList<String> lista = new ArrayList<String>();
      lista.add("rosa");
      lista.add("verde");
      lista.add("rojo");
      lista.add("negro");
      intercambiar(lista);
      System.out.println(lista);
       
      lista.clear();
      lista.add("verde");
      lista.add("rojo");
      lista.add("negro"); 
      lista.add("rojo");
      lista.add("negro");
      intercambiar(lista);
      System.out.println(lista);
   }
    
   /*public static void intercambiar(ArrayList<String> palabras) {
      int tamanhoLista = palabras.size();
      for(int i = 0; i < tamanhoLista; i++) {
         String guardarPalabra = palabras.get(i);
         if(tamanhoLista % 2 == 0) {
            palabras.remove(i);
            palabras.add(i + 1, guardarPalabra);
            i++;
         }else{
            palabras.remove(i);
            palabras.add(i + 1, guardarPalabra);
            i += 2;
         }
      }
   }*/
   ///Método OK
   public static void intercambiar(ArrayList<String> lista) {
      int largo = lista.size();
      if (largo % 2 == 1) {
         largo = largo - 1;
      }
      for (int i = 0; i < largo; i = i + 2) {
         String elemento = lista.get(i);
         lista.set(i, lista.get(i + 1));
         lista.set(i+ 1, elemento);
      }
   }
   
   
}