import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class Dialogo09 implements ActionListener {
   
   //Atributos
   JTextField cajaTexto;
   
   public Dialogo09() {
      
      // Creamos y configuramos un JDialog
      JDialog dialogo = new JDialog();
      dialogo.setLayout(new FlowLayout());
      
      
      // Creamos el formulario y lo añadimos a la ventana principal
      dialogo.add(new JLabel("Elige el fichero: "));
      cajaTexto = new JTextField(15);
      dialogo.add(cajaTexto);
      cajaTexto.setInputVerifier(new Verificador());
      
      // Creamos el botón y lo añadimos a la ventana principal
      JButton boton = new JButton("ABRIR");
      boton.addActionListener(this);
      dialogo.add(boton);
      
      // Ajustamos la ventana a los componentes y la hacemos visible
      dialogo.pack();
      dialogo.setVisible(true);
   }
   
   // Detecta la opción que se ha pulsado y ejecuta la acción correspondiente
   @Override
   public void actionPerformed(ActionEvent evento) {
      JOptionPane.showMessageDialog(null, "Vas a abrir un fichero");
   }

   
   // Creamos una subclase de InputVerifier
   private class Verificador extends InputVerifier {
   
      // Sobreescribimos el método verify
      // Comprobamos que el componente es una caja de texto y leemos el texto
      // Si se puede convertir en entero, si paseInt no genera excepción, se devuelve true
      // Si se ha producido una excepción abre una ventana de error y devuelve false
      @Override
      public boolean verify(JComponent componente) {
         if (componente instanceof JTextField) {
            JTextField cajaTexto = (JTextField) componente;
            String nombreFich = cajaTexto.getText();
            File fichero = new File(nombreFich);
            if (fichero.canRead()) {
               return true;
            }
            JOptionPane.showMessageDialog(cajaTexto, "Hay algún problema con ese fichero");
            return false;
         }
         return false;
      }
   }
}