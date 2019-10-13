import java.awt.*;
import javax.swing.*;

public class ContenedoresFlowLayout {
   public static void main(String[] args) {
      JFrame ventana = new JFrame();
      ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ventana.setSize(320, 75);
      ventana.setTitle("LAYOUT TIPO FLOW-LAYOUT");
   
      ventana.setLayout(new FlowLayout());
      ventana.add(new JLabel("Código Postal: "));
      ventana.add(new JTextField(5));
      ventana.add(new JButton("Enviar"));
   
      ventana.setVisible(true);
   }
}