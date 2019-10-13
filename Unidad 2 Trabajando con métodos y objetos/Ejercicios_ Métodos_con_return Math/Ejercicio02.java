/*
Crea el método calcular(). Se le pasará el lado de un cuadrado y devolverá el valor de su área. Recuerda que el área de un cuadrado es igual a lado * lado.
Por ejemplo:
System.out.println("Area: " + calcular(7.0));
Area: 49.0
*/
public class Ejercicio02{
   public static void main(String[] args){
      int area = calcular(6);
      System.out.println("El area del cuadrado es: " + area);
   }
   
   public static int calcular(int lado){
      int area = lado* lado;
      return area;
   }
}