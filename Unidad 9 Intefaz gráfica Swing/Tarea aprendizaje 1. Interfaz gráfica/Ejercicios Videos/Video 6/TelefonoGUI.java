import java.awt.*;
import javax.swing.*;

public class TelefonoGUI {

   // Programa principal
   public static void main(String[] args) {
      TelefonoGUI gui = new TelefonoGUI();
   }
   
   //Atributos
   private JFrame ventana;
   private JPanel centro;
   private JButton[] teclado;
   private JTextField numero;
   
   // Constructor
   public TelefonoGUI() {
      
      // Ventana principal
      ventana = new JFrame();
      ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ventana.setSize(250, 200);
      ventana.setTitle("TELEFONO");
      ventana.setLayout(new BorderLayout());
      
      // Creamos un marco secundario de tipo rejilla para agrupar todos los botones
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
      
      // Creamos otro marco secundario para el resto de componentes
      JPanel sur = new JPanel(new FlowLayout());
      sur.add(new JLabel("Número a marcar: "));
      numero = new JTextField(10);
      sur.add(numero);
      ventana.add(sur, BorderLayout.SOUTH);
   
      ventana.setVisible(true);
   }
    
   private void addBoton(int indice, String texto) {
      teclado[indice] = new JButton(texto);
      centro.add(teclado[indice]);
   }
}