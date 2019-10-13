/*
Crea el método redondearDecimales(). Se le pasarán el número a redondear y devolverá el valor redondeado a 2 decimales. Utiliza el método Math.round().
Por ejemplo:
System.out.println("Valor redondeado: " + redondearDecimales(4.6789));
Valor redondeado: 4.68
*/
public class Ejercicio04{
   public static void main(String[] args){
      System.out.println("Valor redondeado: " + redondearDecimales(334.3423423423));
   }
   public static double redondearDecimales(double numeroReal){
      numeroReal = (double) Math.round(numeroReal * 100)/100;
      return numeroReal;
   }
}