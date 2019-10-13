/******************************************************************************************************************

  Nombre:   XXX
  Fecha:    XX/XX/2019
  Modulo:   Programación.
  UD:       UD9 Interfaces gráficas (Swing).
  Tarea:    Tarea Evaluación. Realiza un programa en Java.
  
  Define la clase DialogoAnterioresCombo para crear la ventana secundaria necesaria para 
  mostrar todos los tweets anteriores al seleccionado
                                
*******************************************************************************************************************/
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class DialogoAnterioresCombo implements ActionListener {
   
   //Atributos
   private JDialog dialogo;
   private TweetBD unTweetBD;
   private JTextArea cajaTexto;
   private JComboBox<Tweet> desplegable;
   
   // Constructor de la clase: creamos y configuramos un JDialog
   public DialogoAnterioresCombo(TweetBD unTweetBD, JTextArea cajaTexto) {
      
      this.unTweetBD = unTweetBD;
      this.cajaTexto = cajaTexto;
      
      dialogo = new JDialog();
      dialogo.setLayout(new BorderLayout());
      
      // Creamos una etiqueta y la asigna a la ventana principal   
      dialogo.add(BorderLayout.NORTH, new JLabel("Mostrar todos los tweets más antiguos al elegido"));
      
      // Creamos un contenedor para organizar los componentes de la zona centro
      JPanel centro = new JPanel();
      
      centro.setLayout(new GridLayout(1, 2));
      centro.add(new JLabel("Elige un tweet: "));
      
      // Lista desplegable con los Tweets de la lista
      Tweet[] datos = unTweetBD.getArrayTweets();
		desplegable = new JComboBox<Tweet>(datos);
      centro.add(desplegable);
      
      dialogo.add(BorderLayout.CENTER, centro);
      
      // Creamos el botón y lo añadimos a la ventan principal
      JButton boton = new JButton("BUSCAR");
      boton.addActionListener(this);
      dialogo.add(BorderLayout.SOUTH, boton);
      
      // Ajustamos la ventana a los componentes y la hacemos visible
      dialogo.pack();
      dialogo.setVisible(true);
   }
   
   // Identificamos el tweet que se ha elegido y obtenemos y mostramos todos los tweets anteriores
   public void actionPerformed(ActionEvent evento) {
      Tweet unTweet = (Tweet) desplegable.getSelectedItem();
      TweetBD resultados = unTweetBD.tweetsAnteriores(unTweet);
      cajaTexto.setText(resultados.toString());
   }
}