/*Conocemos las siguientes ventanas JOptionPane:

JOptionPane.showMessageDialog(null, "Texto a mostrar");
String respuesta = JOptionPane.showInputDialog(null, "Pregunta a realizar");
int respuesta = JOptionPane.showConfirmDialog(null,"Pregunta con respuesta SI o NO");

1. Primero pedirá una temperatura en grados Celsius. El dato que se introduzca podrá ser un número decimal.

2. A continuación, mostrará la misma temperatura convertida a grados fahrenheit. La fórmula que se utilizará será:
   fahrenheit = celsius * 9 / 5 + 32.

3. Por último, se preguntará si se quiere realizar otra conversión. Se repetirá todo el proceso una y otra vez
    mientras se pulse "Si".

 

IMPORTANTE: Con JOptionPane, cuando se introduzcan números decimales siempre hay que hacerlo con '.'.
En caso contrario, se producirá una excepción.

*/
import javax.swing.*;

public class EjercicioJOptionPane08 {
   public static void main(String[] args) {
      int respuesta = -1;
      do {
         String celsiusTexto = JOptionPane.showInputDialog(null, "Introduce una temperatura en grados Celsius");
         double celsius = Double.parseDouble(celsiusTexto);
         double fahrenheit = celsius * 9 / 5 + 32;
         JOptionPane.showMessageDialog(null, "Tenperatura en grados Farenhait: " + String.format("%.2f", fahrenheit));
         respuesta = JOptionPane.showConfirmDialog(null,"¿Quieres realizar otra conversión?");
      } while(respuesta == JOptionPane.YES_OPTION);
   }
}