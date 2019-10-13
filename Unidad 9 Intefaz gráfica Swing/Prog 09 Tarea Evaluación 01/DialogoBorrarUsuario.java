  /**************************************************************************************************************************
  
 Nombre:  Jose Mari Tome Mejias.
 Fecha :  12/04/2019.
 Módulo:  Programación.
 Tarea:   PROG09 Tarea de evaluación 01. Realiza un programa en Java
  
  Descripción del programa: Clase para crear una ventana JDialog que servirá para borrar un usuario seleccionado.  
   
  Enlace auto evaluación: https://drive.google.com/file/d/1Gmgy4Odx7X0CJ19XLj4m0ftr2UVb5dR5/view?usp=sharing                                
                                
**************************************************************************************************************************/


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class DialogoBorrarUsuario implements ActionListener {
  //Atributos
   private JTextField cajaTexto;
   private JDialog dialogo;
   private TweetBD estaTweetBD;
  
   public DialogoBorrarUsuario(TweetBD unaTweetBD, JTextArea areaTexto) {
      this.estaTweetBD = unaTweetBD;
      dialogo = new JDialog();
      dialogo.setLayout(new BorderLayout());
      // Centramos la caja de JDialog en el centro
      dialogo.setLocationRelativeTo(null);
      // Creamos una etiqueta y la asigna a la ventana principal   
      dialogo.add(BorderLayout.NORTH, new JLabel("Borrar todos los tweets de un usuario"));
   
      JPanel centro = new JPanel();
   // Creamos el formulario y lo añadimos a la ventan principal
      centro.setLayout(new GridLayout(1, 2));
      centro.add(new JLabel("Usuario: "));
      cajaTexto = new JTextField();
      centro.add(cajaTexto);
      dialogo.add(BorderLayout.CENTER, centro);
            
      // Creamos el botón borrar y lo añadimos a la ventana principal
      JButton botonBorrar = new JButton("BORRAR");
      botonBorrar.addActionListener(this);
        
      dialogo.add(botonBorrar, BorderLayout.SOUTH);
      // Ajustamos la ventana a los componentes y la hacemos visible
      dialogo.setVisible(true);
      dialogo.pack();
   }

 // Implementamos la interfaz ActionListener
   @Override
   public void actionPerformed(ActionEvent evento) {
   // Identificamos la opción pulsada
      JButton botonBorrar = (JButton) evento.getSource();
      String textoBoton = botonBorrar.getText();
      String usuarioCaja = cajaTexto.getText();
    
      if(textoBoton.equals("BORRAR")) {
      // Mostramos un JOptionPane solo las opciones de Si y No.
      // Pedirá una confirmación mostrando un mensaje
         Object[] options = { "SI", "NO" };
         int opcion = JOptionPane.showOptionDialog(null, "Realmente quieres borrar los tweets de " + usuarioCaja, "AVISO",
               JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
      
      // Si seleccionamos usará el método borrarTweets de la clase TweetBD 
      // Mostrará un mensaje con los mensajes borrados y cerrará la ventana
         if (opcion == JOptionPane.YES_OPTION) {
            int tweetsBorrados = estaTweetBD.borrarTweets(usuarioCaja);
            JOptionPane.showMessageDialog(null, "Se han borrado " + tweetsBorrados + " mensajes","" ,JOptionPane.YES_NO_OPTION);
            dialogo.setVisible(false);
         } else { 
         // Si no mostrará un mensaje y cerrará la ventana
            JOptionPane.showMessageDialog(null,"Borrado de mensajes cancelado");
            dialogo.setVisible(false);
         }
      }
   }
}