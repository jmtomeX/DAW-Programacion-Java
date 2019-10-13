//Ejercicio 11
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Dialogo11 implements ActionListener { 
// Atributos 
   private JTextField cajaNumero;
   private JTextField cajaSaldo;
   private JTextField cajaTitular;
   private Banco esteBanco;

// Constructor
   public Dialogo11(Banco unBanco) {
   // Creamos y configuramos un dialogo
      this.esteBanco = unBanco;
   
      JDialog dialogo = new JDialog();
      dialogo.setLayout(new BorderLayout());
      dialogo.setSize(450, 260);
      
      JPanel centro = new JPanel(new GridLayout(3,2));
   
      centro.add(new JLabel("Número"));
      cajaNumero = new JTextField(30);
      centro.add(cajaNumero);
   
      centro.add(new JLabel("Saldo"));
      cajaSaldo = new JTextField(30);
      centro.add(cajaSaldo);
   
      centro.add(new JLabel("Titular"));
      cajaTitular = new JTextField(30);
      centro.add(cajaTitular);
      
      dialogo.add(BorderLayout.NORTH,centro);
      
   // Creamos los botones y los añadimos a la ventana principal
      JPanel botonesPanel = new JPanel();
      botonesPanel.setLayout(new GridLayout(1,2));
      
      JButton botonAnhadir = new JButton("AÑADIR");
      botonAnhadir.addActionListener(this);
      botonesPanel.add(botonAnhadir);
      
      JButton botonReset = new JButton("RESET");
      botonReset.addActionListener(this);
      botonesPanel.add(BorderLayout.SOUTH, botonReset);
      
      dialogo.add(botonesPanel);   
      
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
}