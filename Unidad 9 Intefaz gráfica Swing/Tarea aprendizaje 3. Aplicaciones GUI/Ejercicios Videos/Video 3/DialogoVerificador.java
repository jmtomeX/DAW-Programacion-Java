import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class DialogoVerificador implements ActionListener {
   
   //Atributos
   JTextField cajaTexto;
   
   public DialogoVerificador() {
      
      // Creamos y configuramos un JDialog
      JDialog dialogo = new JDialog();
      dialogo.setLayout(new FlowLayout());

      // Creamos el formulario y lo añadimos a la ventana principal
      dialogo.add(new JLabel("Elige un registro: "));
      cajaTexto = new JTextField(15);
      Verificador verificadorInt = new Verificador();
      cajaTexto.setInputVerifier(verificadorInt);  
      dialogo.add(cajaTexto);

      // Creamos el botón y lo añadimos a la ventan principal
      JButton boton = new JButton("MOSTRAR");
      boton.addActionListener(this);
      dialogo.add(boton);
      
      // Ajustamos la ventana a los componentes y la hacemos visible
      dialogo.pack();
      dialogo.setVisible(true);
   }
   
   // Detecta la opción que se ha pulsado y ejecuta la acción correspondiente
   public void actionPerformed(ActionEvent evento) {
      String texto = cajaTexto.getText();
      JOptionPane.showMessageDialog(null, "Has escrito: " + texto);
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
            String texto = cajaTexto.getText();
            try {
               Integer.parseInt(texto);
               return true;
            } catch (Exception e) {
               JOptionPane.showMessageDialog(cajaTexto, "Introduce un número entero");
               return false;
            }
         }
         return false;
      }
   }
}