  /**************************************************************************************************************************

  Nombre:  Jose Mari Tome Mejias.
 Fecha :  12/04/2019.
 Módulo:  Programación.
 Tarea:   PROG09 Tarea de evaluación 01. Realiza un programa en Java
  
  Descripción del programa: Clase para crear una ventana JDialog que servirá para mostrar los tweets más antiguos
                            a partir de un tweet seleccionado de un JComboBox.   
                             
                                
**************************************************************************************************************************/


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class DialogoTweetsAntiguos implements ActionListener {
  //Atributos
   private JTextField cajaTexto;
   private JDialog dialogo;
   private JTextArea areaTexto;
   private TweetBD estaTweetBD;
   
   // 
   private Dimension pantalla;
   private Dimension dimensioVentana;
  
   public DialogoTweetsAntiguos(TweetBD unaTweetBD, JTextArea areaTexto) {
      this.estaTweetBD = unaTweetBD;
      this.areaTexto = areaTexto;
      
   // Instanciamos un nuevo JDialog
      dialogo = new JDialog();
      dialogo.setLayout(new BorderLayout());
      
      // Centramos la ventana principal en el centro de la pantalla 
      // Se obtienen las dimensiones en pixels de la pantalla.
      pantalla = Toolkit.getDefaultToolkit().getScreenSize();
      // Se obtienen las dimensiones en pixels de la ventana.
      dimensioVentana = dialogo.getSize();
      // Un calculo para situar la ventana en el centro de la pantalla.
      // Usa el método comprobarBD para ver si hay tweets y dependiendo de ello la colocará.
      dialogo.setLocation(comprobarBD(estaTweetBD,  pantalla,  dimensioVentana), (pantalla.height - dimensioVentana.height) / 2);
   
   // Creamos una etiqueta y la asigna a la ventana principal  
      dialogo.add(BorderLayout.NORTH, new JLabel("Mostrar todos los tweets más antiguos al elegido"));
   
   // Creamos el formulario y lo añadimos a la ventana principal
      JPanel centro = new JPanel();
      centro.setLayout(new GridLayout(1, 2));
      centro.add(new JLabel("Elige un tweet: "));
      
   // Creamos un JComboBox creando un array de tweets
      JComboBox<Tweet> tweets = new JComboBox<Tweet>(estaTweetBD.getArrayTweets());
      
   // Registramos la clase oyente para JComboBox
      tweets.addActionListener(this);
              
      centro.add(tweets);
      dialogo.add(centro);
      
   // Ajustamos la ventana a los componentes y la hacemos visible
      dialogo.setVisible(true);
      dialogo.pack();
   }

 // Detecta la línea del JComboBox que se ha pulsado y  se lo pasa como parámetro al método
 // tweetsAnteriores() de la clase TweetBD
   public void actionPerformed(ActionEvent evento) {
      JComboBox cb = (JComboBox)evento.getSource();
      Tweet tweetSeleccionado = (Tweet)cb.getSelectedItem();
      areaTexto.append("\n" + estaTweetBD.tweetsAnteriores(tweetSeleccionado).toString());
      
   // Cuando se finaliza se cierra la ventana     
      dialogo.setVisible(false);
   }
   
   // Método para colocar la pantalla JDialog dependiendo de si hay tweets o no
   // Si hay tweets la llevará a la parte izquierda de la pantalla si no la mostrará en el centro
   public int comprobarBD (TweetBD unaTweetBD, Dimension pantalla, Dimension dimensioVentana) {
      int devolverCentrado = 0;
      if(unaTweetBD.getNumeroTweets() == 0) {
         devolverCentrado = (pantalla.width - dimensioVentana.width) / 2;
      }
      return devolverCentrado;
   }
      
}