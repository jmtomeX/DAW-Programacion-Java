/*
Corrige el código que se plantea para que la ventana que se muestra sea interactiva:

Cuando se pulse cualquier tecla se mostrará en el área de texto la tecla que se ha pulsado.
Además, si se pulsa "1" se mostrará un JOptionPane.showMessageDialog:

Si se pulsa "K" se mostrará un JOptionPane.showInputDialog:

Si se pulsa "Ctrl" se mostrará un JOptionPane.showConfirmDialog:

Se usará la interfaz KeyListener. Solo habrá que desarrollar el método keyPressed.
*/

import javax.swing.* ;
import java.awt.event.* ;
import java.awt.*;

// Definimos la clase EscuchaTeclas como subclase de JFrame
// Implementa la interfaz KeyListener
public class EscuchaTeclas extends JFrame implements KeyListener {

    // Crear la interfaz gráfica y establece sus propidades
   public static void main(String[] args) {
      EscuchaTeclas ventana = new EscuchaTeclas();
      ventana.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      ventana.setTitle("Ejercicio 08");
      ventana.setSize(360, 120);
      ventana.setVisible(true);      
   }

    // Atributos
   private JTextArea areaTexto;

    // Constructor de la clase
   public EscuchaTeclas () {
    
        // Crear objeto JTextArea
      areaTexto = new JTextArea();
      areaTexto.setText( "Pulsa cualquier tecla del teclado...\n\n" );
      areaTexto.setEnabled( false );
        
        // Creamos un Scroll para la caja de texto
        // El objeto principal es el JScrollPane y se le pasa el JTextArea
      JScrollPane scrollPane = new JScrollPane(areaTexto);
   
        // Añadir al JFrame el JScrollPane. Con eso también se añade el JTextArea
        // Necesitamos el método getContentPane() para obtener el contenedor del JFrame donde se añaden los componentes
      this.getContentPane().add(scrollPane);
   
        // Registrar el oyente en el JFrame
      this.addKeyListener(this);
   
   }

    // Implementar la clase oyente que implemente el interface KeyListener.
    // Hay que desarrollar todos sus métodos.
    
    // Cuando se pulsa cualquier tecla, obtenemos el código de tecla y a partir de él su texto identificativo
    // Lo mostramos en el JTextArea.
    // Si pulsamos "1" mostramos JOptionPane.showMessageDialog
    // Si pulsamos "K" mostramos JOptionPane.showInputDialog
    // Si pulsamos "Ctrl" mostramos JOptionPane.showConfirmDialog
   public void keyPressed(KeyEvent evento) {
      int codigoTecla = evento.getKeyCode();
      String textoTecla = evento.getKeyText(codigoTecla);
      areaTexto.setText(textoTecla + "\n");
      switch (textoTecla) {
         case "1":
            JOptionPane.showMessageDialog(null, "Has pulsado el 1");
            break;
         case "K":
            JOptionPane.showInputDialog(null, "Has pulsado la tecla K");
            break;
         case "Ctrl":
            JOptionPane.showConfirmDialog(null, "Has pulsado la tecla CTRL");
            break;
      }
   }

    // Definimos lo que hacer cuando se libera cualquier tecla
   public void keyReleased(KeyEvent evento) {
   }

    // manejar evento de pulsación de una tecla de acción
   public void keyTyped( KeyEvent evento ) {
   }
}