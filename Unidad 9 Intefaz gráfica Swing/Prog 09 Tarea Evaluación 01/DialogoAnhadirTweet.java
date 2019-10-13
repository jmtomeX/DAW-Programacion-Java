  /**************************************************************************************************************************

  Nombre:  Jose Mari Tome Mejias.
 Fecha :  12/04/2019.
 Módulo:  Programación.
 Tarea:   PROG09 Tarea de evaluación 01. Realiza un programa en Java
  
  Descripción del programa: Clase para crear una ventana JDialog que servirá para añadir un tweet.   
  Enlace auto evaluación: https://drive.google.com/file/d/1Gmgy4Odx7X0CJ19XLj4m0ftr2UVb5dR5/view?usp=sharing                                
                                
**************************************************************************************************************************/


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.regex.*;

public class DialogoAnhadirTweet implements ActionListener  {
    //Atributos
   private JTextField cajaTextoUsuario;
   private JTextField cajaTextoFecha;
   private JTextField cajaTextoMensaje;
   private JDialog dialogo;
   private TweetBD estaTweetBD;
  
   public DialogoAnhadirTweet(TweetBD unaTweetBD, JTextArea areaTexto) {
   
      this.estaTweetBD = unaTweetBD;
      dialogo = new JDialog();
      dialogo.setLayout(new BorderLayout());
      // Centramos la caja de JDialog en el centro
      dialogo.setLocationRelativeTo(null);
      // Creamos una etiqueta y la asigna a la ventana principal   
      dialogo.add(BorderLayout.NORTH, new JLabel("Añadir un Tweet"));
              
      // Creamos un panel para los campos del formulario y lo añadimos a la ventana principal 
      JPanel centro = new JPanel();
      centro.setLayout(new GridLayout(4, 3));
      centro.add(new JLabel("Usuario: "));
      cajaTextoUsuario = new JTextField();
      centro.add(cajaTextoUsuario);
      
      centro.add(new JLabel("Fecha y hora (aaaa-MM-ddThh:mm:ss) "));
      cajaTextoFecha = new JTextField();
      cajaTextoFecha.setInputVerifier(new Verificador()); 
      centro.add(cajaTextoFecha);
   
      centro.add(new JLabel("Mensaje: "));
      cajaTextoMensaje = new JTextField();
      centro.add(cajaTextoMensaje);
   
      dialogo.add(BorderLayout.CENTER, centro);         
   
      // Creamos el botón añadir y lo añadimos a la caja centro 
      JButton botonAnhadir = new JButton("AÑADIR");
      botonAnhadir.addActionListener(this);
        
      centro.add(botonAnhadir);
      
      // Creamos el botón Vaciar y lo añadimos a la ventana principal
      JButton botonAVaciar = new JButton("VACIAR");
      botonAVaciar.addActionListener(this);
        
      centro.add(botonAVaciar);
      
      // Ajustamos la ventana a los componentes y la hacemos visible  
      dialogo.setVisible(true);
      dialogo.pack();
   }

   // Detecta la opción que se ha pulsado y ejecuta la acción correspondiente
   @Override
   public void actionPerformed(ActionEvent evento) {
      JButton boton = (JButton) evento.getSource();
      String textoBoton = boton.getText();     
     
      if(textoBoton.equals("AÑADIR")) {
         String usuarioCaja = cajaTextoUsuario.getText();
         String fechaCaja = cajaTextoFecha.getText();
         String mensajeCaja = cajaTextoMensaje.getText();
        // Si culaquiera de las cajas de texto está vacía dará un mensaje y obligará a introducir el campo.
         if ((usuarioCaja != null) && (usuarioCaja.equals("")) || (fechaCaja != null) && (fechaCaja.equals("")) || (mensajeCaja != null) && (mensajeCaja.equals(""))) {
         // cadena no está vacía
            JOptionPane.showMessageDialog(null, "Rellena todos los campos", "Error!", JOptionPane.ERROR_MESSAGE);
            return;   
         }
      // Añadimos el tweet a la BD
         estaTweetBD.addTweet(usuarioCaja, fechaCaja, mensajeCaja);
         //Cerramos el panel
         dialogo.setVisible(false);
      }
      
      // Al pulsar vaciamos las cajas de texto
      if(textoBoton.equals("VACIAR")) {
      //Vaciamos los JTextField
         cajaTextoUsuario.setText(""); 
         cajaTextoFecha.setText("");
         cajaTextoMensaje.setText("");
      //Esto hace que el cursor se ponga en el campo del usuario
         cajaTextoUsuario.requestFocus(); 
      
      }
   }
   
  // Creamos una subclase de InputVerifier
   private class Verificador extends InputVerifier {
   
      // Sobreescribimos el método verify
      // Comprobamos que el componente es una caja de texto y leemos el texto
      // Si la fecha tiene el formato requerido devuelve true
      // Si se ha producido una excepción abre una ventana de error y devuelve false
      @Override
      public boolean verify(JComponent componente) {
         if (componente instanceof JTextField) {
            JTextField cajaTextoFecha = (JTextField) componente;
            String texto = cajaTextoFecha.getText();
            // 2019-12-12T22:15:12
            // Comprobamos la fecha que sea del formato correcto mediante una expresión regular.
            Pattern p = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}$"); 
            Matcher m = p.matcher(texto);
            if (m.matches()) {
               return true;
            }
            // Si el patrón no coincide devolvemos una caja de texto con el patron que ha de reibir la caja
            JOptionPane.showMessageDialog(cajaTextoFecha, "Introduce una fecha valida (aaaa-MM-ddThh:mm:ss)");  
         }
         return false;
      }
   }
   
}