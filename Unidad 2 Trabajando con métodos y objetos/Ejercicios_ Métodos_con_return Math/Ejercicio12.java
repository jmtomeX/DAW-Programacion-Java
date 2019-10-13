/*
Crea el método saludo(). Se le pasará el nombre de una persona y devolverá un saludo incluyendo ese nombre.
Por ejemplo:
System.out.println(saludo("Kepa"));

Kaixo Kepa. Bienvenido al curso.
*/
public class Ejercicio12{
   public static void main(String[] args){
      System.out.println(saludo("Kepa"));
   }
   public static String saludo(String nombre) {
      
      return "Kaixo " +  nombre  + ". Bienvenido al curso." ;
   }
}