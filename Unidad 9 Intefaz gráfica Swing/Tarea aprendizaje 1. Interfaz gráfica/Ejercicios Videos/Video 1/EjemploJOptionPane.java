// Cuadros de dialogo JOptionPane
// Son la forma más sencilla de crear ventanas gráficas en Java 
// Necesitan el paquete javax.swing
// Se pueden considerar como un equivalente gráfico simple del System.out.println y del Scanner 
// Existen 3 tipos: showMessageDialog, showInputDialog y showConfirmDialog

import javax.swing.*;

public class EjemploJOptionPane {

   public static void main(String[] args) {
   
      // Método JOptionPane.showMessageDialog(): Permite mostrar mensajes
      // Equivalente gráfico a println
      JOptionPane.showMessageDialog(null, "Hola, Mundo!");
      
      // Método JOptionPane.showInputDialog(): Permite leer datos
      // Caja de texto: equivalente gráfico de Scanner
      // Devuelve el dato introducido siempre como un String: equivamente a nextLine
      // Necesitaremos Integer.parseInt() o Double.parseDouble() para convertir el dato
      // Si no introducimos nada y damos a aceptar devolverá un String vacío
      // Si pulsamos cancelar devolverá null
      String nombre = JOptionPane.showInputDialog(null, "¿Cómo te llamas?");
      JOptionPane.showMessageDialog(null, "Buenos días, " + nombre);
      String edadTexto = JOptionPane.showInputDialog(null, "¿Cuántos años tienes?");
      int edad = Integer.parseInt(edadTexto);
      JOptionPane.showMessageDialog(null, "Edad: " + edad);
      
      // Método JOptionPane.showConfirmDialog()
      // Pregunta con 3 opciones: 
      //    JOptionPane.YES_OPTION: Si
      //    JOptionPane.NO_OPTION: No
      //    JOptionPane.CANCEL_OPTION: Cancelar
      int opcion = JOptionPane.showConfirmDialog(null,"¿Te gustan las galletas, " + nombre + "?");
      
      // Si responde Si
      if (opcion == JOptionPane.YES_OPTION) {
         JOptionPane.showMessageDialog(null, "¡Por supuesto! ¿A quién no?");
      } else {
         // Si responde no o pulsa Cancelar
         JOptionPane.showMessageDialog(null,"Lo siento pero no estamos de acuerdo.");
      }
   }
}