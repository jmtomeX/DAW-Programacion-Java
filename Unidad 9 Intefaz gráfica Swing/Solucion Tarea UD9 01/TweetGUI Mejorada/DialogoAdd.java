/******************************************************************************************************************

  Nombre:   XXX
  Fecha:    XX/XX/2019
  Modulo:   Programación.
  UD:       UD9 Interfaces gráficas (Swing).
  Tarea:    Tarea Evaluación. Realiza un programa en Java.
  
  Define la clase DialogoAdd para crear la ventana secundaria necesaria para añadir un tweet
                                
*******************************************************************************************************************/
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.regex.*;     // Para poder usar patrones

public class DialogoAdd implements ActionListener {
   
   // Atributos
   private JDialog dialogo;
   private JTextField usuario;
   private JTextField fecha;
   private JTextField mensaje;
   private TweetBD unTweetBD;
   
   // Constructor de la clase: Creamos y configuramos un JDialog
   public DialogoAdd(TweetBD unTweetBD) {   
         
      this.unTweetBD = unTweetBD;

      dialogo = new JDialog();
      dialogo.setLayout(new BorderLayout());
      
      // Creamos una etiqueta y la asigna a la zona norte de la ventana principal   
      dialogo.add(BorderLayout.NORTH, new JLabel("Añadir un Tweet"));
      
      // Creamos y organizamos todos los componentes de la zona centro
      JPanel centro = crearCentro();
      dialogo.add(BorderLayout.CENTER, centro);
      
      // Creamos el botón y lo añadimos a la zona sur de la ventana principal
      JButton boton = new JButton("AÑADIR");
      boton.addActionListener(this);
      dialogo.add(BorderLayout.SOUTH, boton);
      
      // MEJORAS para los botones
      boton.setForeground(new Color(29, 161, 242));
      
      // MEJORAS en los JDialog
      this.dialogo.setModal(true);        // Bloqueamos la pantalla principal
      this.dialogo.getRootPane().setDefaultButton(boton);    // Pulsar ENTER será equicvalente a pulsar el botón 
      
      // Ajustamos el diálogo a los componentes y la hacemos visible
      dialogo.pack();
      dialogo.setVisible(true);
   }
   
   // Creamos un contenedor para organizar los componentes de la zona centro
   // Será un formulario para pedir los datos de un tweet
   // Lo devolvemos para añadirlo a la ventana principal
   private JPanel crearCentro() {

      JPanel centro = new JPanel();
      centro.setLayout(new GridLayout(3, 2));
      
      centro.add(new JLabel("Usuario: "));
      usuario = new JTextField();
      centro.add(usuario);
      
      centro.add(new JLabel("Fecha y hora (aaaa-MM-ddThh:mm:ss): "));
      fecha = new JTextField();
      fecha.setInputVerifier(new Verificador());      // Para controlar que la fecha cumple con el formato exigido
      centro.add(fecha);
      
      centro.add(new JLabel("Mensaje: "));
      mensaje = new JTextField();
      centro.add(mensaje);
      
      return centro;
   }
   
   // Se comprueba que se han introducido todos los datos del tweet
   // y se añade al objeto TweetBD
   public void actionPerformed(ActionEvent evento) {
   
      String usuarioTexto = usuario.getText();
      String fechaTexto = fecha.getText();
      String mensajeTexto = mensaje.getText();
      
      if (usuarioTexto.equals("") || fechaTexto.equals("") || mensajeTexto.equals("")) {
         JOptionPane.showMessageDialog(null, "Falta algún dato");
      } else {
         unTweetBD.addTweet(usuarioTexto, fechaTexto, mensajeTexto);
         JOptionPane.showMessageDialog(null, "El tweet se ha añadido");
         dialogo.dispose();
      }
   }
   
   // Creamos un InputVerifier para comprobar que el formato de la fecha es válido
   private class Verificador extends InputVerifier {
   
      @Override   
      public boolean verify(JComponent entrada) {
      
         JTextField fecha = (JTextField) entrada;
         String fechaTexto = fecha.getText();
         
         // Aqui verificamos si cadena es correcta y devolvemos
         Pattern formatoFecha = Pattern.compile("[0-9]{4}-\\d{2}-\\d{2}T[0-9]{2}:\\d{2}:\\d{2}");
         Matcher comparaFormato = formatoFecha.matcher(fechaTexto);
         if (!comparaFormato.matches()) {
            JOptionPane.showMessageDialog(null, "El formato de la fecha no es correcto");
            return false;
         }
         return true;
      }
   }
}