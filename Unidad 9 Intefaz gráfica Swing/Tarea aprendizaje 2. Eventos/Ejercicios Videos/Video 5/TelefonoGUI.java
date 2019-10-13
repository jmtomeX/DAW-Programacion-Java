import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class TelefonoGUI implements ActionListener {
   public static void main(String[] args) {
      TelefonoGUI gui = new TelefonoGUI();
   }
   
   //Atributos
   JFrame ventana;
   JPanel centro;
   JButton[] teclado;
   JTextField numero;
   JButton marcar;
   
   public TelefonoGUI() {
      ventana = new JFrame();
      ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ventana.setTitle("TELEFONO");
   
      ventana.setLayout(new BorderLayout());
      
      teclado = new JButton[12];
      centro = new JPanel(new GridLayout(4, 3));
      int i = 0;
      for ( ; i < 9; i++) {
         addBoton(i, "" + (i + 1));
      }
      addBoton(i++, "*");
      addBoton(i++, "0");
      addBoton(i++, "#");
      ventana.add(centro, BorderLayout.CENTER);
   
      JPanel sur = new JPanel(new FlowLayout());
      sur.add(new JLabel("Número a marcar: "));
      numero = new JTextField(10);
      sur.add(numero);
      marcar = new JButton("MARCAR");
      sur.add(marcar);
      marcar.addActionListener(this);
      ventana.add(sur, BorderLayout.SOUTH);
      
      ventana.pack();
      ventana.setVisible(true);
   }
    
   private void addBoton(int indice, String texto) {
      teclado[indice] = new JButton(texto);
      centro.add(teclado[indice]);
      teclado[indice].addActionListener(this);
   }
   
   @Override
   public void actionPerformed(ActionEvent event) {
      JButton boton = (JButton) event.getSource();
      String pulsado = boton.getText();
      
      if (!pulsado.equals("MARCAR")) {
         String textoActual = numero.getText();
         numero.setText(textoActual + pulsado);
         //numero.seText(numero.getText() + pulsado); ES lo mismo que las 2 líneas anteriores.
      } else {
         JOptionPane.showMessageDialog(null, "Marcar el número: " + numero.getText());
      }
   }
}