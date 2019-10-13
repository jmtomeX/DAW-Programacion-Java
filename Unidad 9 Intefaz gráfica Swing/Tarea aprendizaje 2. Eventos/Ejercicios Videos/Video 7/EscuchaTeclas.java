/*
 * Ejemplo de manejo de eventos de teclado
 */
import javax.swing.* ;
import java.awt.event.* ;

// Definimos la clase EscuchaTeclas como subclase de JFrame
// Implementa la interfaz KeyListener
public class EscuchaTeclas extends JFrame implements KeyListener {

    // Crear la interfaz gráfica y establece sus propidades
   public static void main(String[] args) {
      EscuchaTeclas ventana = new EscuchaTeclas();
      ventana.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      ventana.setTitle("Eventos de teclado");
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

    // Implementar la clase oyente que implemente el interface KeyListener
    
    // Definimos lo que hacer cuando se pulsa cualquier tecla
   public void keyPressed(KeyEvent evento) {
      int codigoTecla = evento.getKeyCode();                  // Obtenemos el código de la tecla
      String textoTecla = evento.getKeyText(codigoTecla);     // Obtenemos el texto que representa esa tecla
      String linea = "Se oprimió tecla: " + textoTecla + "\n";
       //linea = areaTexto.getText() + linea + "\n";
      areaTexto.append(linea);
   }

    // Definimos lo que hacer cuando se libera cualquier tecla
   public void keyReleased(KeyEvent evento) {
      String linea = "Se soltó tecla: " + evento.getKeyText(evento.getKeyCode());
      linea = areaTexto.getText() + linea + "\n\n";
      areaTexto.setText(linea);
   }

    // manejar evento de pulsación de una tecla de acción
   public void keyTyped( KeyEvent evento ) {
      char charTecla = evento.getKeyChar();                   // Obtenemos el carácter asociado con la tecla pulsada.
      String linea = "Se escribió tecla: " + charTecla;
      linea = areaTexto.getText() + linea + "\n";
      areaTexto.setText(linea);
   }
}