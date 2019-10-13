/******************************************************************************************************************

  Nombre:   XXX
  Fecha:    XX/XX/2019
  Modulo:   Programación.
  UD:       UD9 Interfaces gráficas (Swing).
  Tarea:    Tarea Evaluación. Realiza un programa en Java.
  
  Define la clase DialogoBorrar para crear la ventana secundaria necesaria para borrar los tweets de un usuario
                                
*******************************************************************************************************************/
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class DialogoBorrar implements ActionListener {
   
   //Atributos
   private JDialog dialogo;
   private JTextField usuario;
   private TweetBD unTweetBD;
   
   // Constructor de la clase: creamos y configuramos un JDialog
   public DialogoBorrar(TweetBD unTweetBD) {
   
      this.unTweetBD = unTweetBD;
      
      dialogo = new JDialog();
      dialogo.setLayout(new BorderLayout());
      
      // Creamos una etiqueta y la asigna a la zona norte de la ventana principal   
      dialogo.add(BorderLayout.NORTH, new JLabel("Borrar todos los tweets de un usuario"));
      
      // Creamos un contenedor para organizar los componentes de la zona centro
      JPanel centro = new JPanel();
      centro.setLayout(new GridLayout(1, 2));
      
      centro.add(new JLabel("Usuario: "));
      usuario = new JTextField();
      centro.add(usuario);
      
      dialogo.add(BorderLayout.CENTER, centro);
      
      // Creamos el botón y lo añadimos a la ventan principal
      JButton boton = new JButton("BORRAR");
      boton.addActionListener(this);
      dialogo.add(BorderLayout.SOUTH, boton);
      
      // Ajustamos la ventana a los componentes y la hacemos visible
      dialogo.pack();
      dialogo.setVisible(true);
   }
   
   // Cuando se pulsa el botón pregunta si realmente se quieren borrar los tweets
   // y después se muestra cuántos se han borrado
   public void actionPerformed(ActionEvent evento) {
   
      String usuarioTexto = usuario.getText();
      int opcion = JOptionPane.showConfirmDialog(null,"¿Realmente quieres borrar los tweets de " + usuarioTexto 
                  + "?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
      
      if (opcion == JOptionPane.YES_OPTION) {
         int total = unTweetBD.borrarTweets(usuarioTexto);
         JOptionPane.showMessageDialog(dialogo, "Se han borrado " + total + " mensajes");
      }
   }
}