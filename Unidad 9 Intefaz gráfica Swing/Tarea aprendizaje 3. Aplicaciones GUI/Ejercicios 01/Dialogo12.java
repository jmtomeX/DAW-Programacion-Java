import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Dialogo12 implements ActionListener {
   
   //Atributos
   private JTextField cajaNumero;
   private JTextField cajaSaldo;
   private JTextField cajaTitular;
   private Banco esteBanco;
   
   public Dialogo12(Banco unBanco) {
   
      // Inicializamos
      this.esteBanco = unBanco;
         
      // Creamos y configuramos un JDialog
      JDialog dialogo = new JDialog();
      dialogo.setLayout(new GridLayout(4, 2));
   
      // Creamos el formulario y lo añadimos a la ventana principal
      dialogo.add(new JLabel("Número: "));
      cajaNumero = new JTextField(15); 
      dialogo.add(cajaNumero);
      
      dialogo.add(new JLabel("Saldo: "));
      cajaSaldo = new JTextField(15); 
      dialogo.add(cajaSaldo);
      cajaSaldo.setInputVerifier(new VerificadorDouble());
      
      dialogo.add(new JLabel("Titular: "));
      cajaTitular = new JTextField(15); 
      dialogo.add(cajaTitular);
   
      // Creamos el botón y lo añadimos a la ventan principal
      JButton boton = new JButton("AÑADIR");
      boton.addActionListener(this);
      dialogo.add(boton);
      JButton reset = new JButton("RESET");
      dialogo.add(reset);
      
      // Ajustamos la ventana a los componentes y la hacemos visible
      dialogo.pack();
      dialogo.setVisible(true);
   }
   
   // Detecta la opción que se ha pulsado y ejecuta la acción correspondiente
   // JOptionPane.showConfirmDialog JOptionPane.YES_OPTION
   public void actionPerformed(ActionEvent evento) {
      String numeroTexto = cajaNumero.getText();
      int numero = Integer.parseInt(numeroTexto);
      String saldoTexto = cajaSaldo.getText();
      double saldo = Double.parseDouble(saldoTexto);
      String titular = cajaTitular.getText();
      if (!esteBanco.cuentaExiste(numero)) {
         // Añadir la cuenta
         esteBanco.addCuenta(numero, saldo, titular);
         JOptionPane.showMessageDialog(null, esteBanco.toString());
         return;
      }
      JOptionPane.showMessageDialog(null, "Esa cuenta ya existe");
   }
   
   // Creamos una subclase de InputVerifier
   // Si se puede convertir en double, si parseDouble no genera excepción, se devuelve true
   // Si se ha producido una excepción abre una ventana de error y devuelve false
   private class VerificadorDouble extends InputVerifier {
      @Override
      public boolean verify(JComponent componente) {
         if (componente instanceof JTextField) {
            JTextField cajaTexto = (JTextField) componente;
            String texto = cajaTexto.getText();
            try {
               Double.parseDouble(texto);
               return true;
            } catch (Exception e) {
               JOptionPane.showMessageDialog(cajaTexto, "Introduce un número");
               return false;
            }
         }
         return false;
      }
   }
}