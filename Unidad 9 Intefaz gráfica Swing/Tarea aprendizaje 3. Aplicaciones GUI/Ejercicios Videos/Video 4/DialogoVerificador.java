import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class DialogoVerificador implements ActionListener {
   
   //Atributos
   private JTextField cajaTexto;
   private Banco esteBanco;
   private JTextArea areaTexto;
   
   public DialogoVerificador(Banco unBanco, JTextArea areaTexto) {
   
      // Inicializamos
      this.esteBanco = unBanco;
      this.areaTexto = areaTexto;
         
      // Creamos y configuramos un JDialog
      JDialog dialogo = new JDialog();
      dialogo.setLayout(new FlowLayout());

      // Creamos el formulario y lo añadimos a la ventana principal
      dialogo.add(new JLabel("Elige una cuuenta: "));
      cajaTexto = new JTextField(15);
      cajaTexto.setInputVerifier(new Verificador());  
      dialogo.add(cajaTexto);

      // Creamos el botón y lo añadimos a la ventan principal
      JButton boton = new JButton("BORRAR");
      boton.addActionListener(this);
      dialogo.add(boton);
      
      // Ajustamos la ventana a los componentes y la hacemos visible
      dialogo.pack();
      dialogo.setVisible(true);
   }
   
   // Detecta la opción que se ha pulsado y ejecuta la acción correspondiente
   // JOptionPane.showConfirmDialog JOptionPane.YES_OPTION
   public void actionPerformed(ActionEvent evento) {
      String texto = cajaTexto.getText();
      int numero = Integer.parseInt(texto);
      if (esteBanco.cuentaExiste(numero)) {
         // Borrar la cuenta
         int respuesta = JOptionPane.showConfirmDialog(null, "Borrar la cuanta: " + numero);
         if (respuesta == JOptionPane.YES_OPTION) {
            esteBanco.bajaCuenta(numero);
            //JOptionPane.showMessageDialog(null, esteBanco.toString());
            areaTexto.setText(esteBanco.toString());
            return;
         }
      }
      JOptionPane.showMessageDialog(null, "Esa cuenta no existe");
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