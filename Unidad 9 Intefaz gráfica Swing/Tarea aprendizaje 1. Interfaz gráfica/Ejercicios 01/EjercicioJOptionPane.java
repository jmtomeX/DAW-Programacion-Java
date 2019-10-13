import javax.swing.*;

public class EjercicioJOptionPane {
   public static void main(String[] args) {
      int repuesta = JOptionPane.showConfirmDialog(null,"¿Quieres acabar?");
      while(repuesta != JOptionPane.YES_OPTION) {
         String texto = JOptionPane.showInputDialog(null, "Escribe un texto: ");
         int letras = texto.length();
         JOptionPane.showMessageDialog(null, "El texto introducido tiene "+ letras + " letras");
         repuesta = JOptionPane.showConfirmDialog(null,"¿Quieres acabar?");
      
      }
      JOptionPane.showMessageDialog(null, "Fin del programa");
   }
}