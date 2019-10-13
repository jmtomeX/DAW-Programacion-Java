/*
Crea el método mostrar(). Se le pasarán:
2 números
Mostrará la suma de esos números como se indica  en el siguiente ejemplo:

mostrar(5.6, 7.4);
mostrar(3.1, 8.3);

5.6 + 7.4 = 13.0
3.1 + 8.3 = 11.4
*/
public class Ejercicio08{
   public static void main(String[] args){
    
      mostrar(5.6, 7.4);
      mostrar(3.1, 8.3);
   }
   public static void mostrar(double num1, double num2){
   
      System.out.print(num1 );
      System.out.println(" + " + num2 +   " = " + (num1 + num2));
   }
}