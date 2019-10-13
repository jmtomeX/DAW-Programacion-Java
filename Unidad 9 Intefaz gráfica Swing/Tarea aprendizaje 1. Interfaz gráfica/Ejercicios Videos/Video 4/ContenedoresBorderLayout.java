import java.awt.*;
import javax.swing.*;

public class ContenedoresBorderLayout {
   public static void main(String[] args) {
      JFrame ventana = new JFrame();
      ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ventana.setTitle("LAYOUT DE TIPO BORDER");
   
      ventana.setLayout(new BorderLayout());
      ventana.add(new JButton("NORTE"), BorderLayout.SOUTH);
      ventana.add(new JButton("SUR"), BorderLayout.NORTH);
      ventana.add(new JButton("OESTE"), BorderLayout.WEST);
      ventana.add(new JButton("ESTE"), BorderLayout.EAST);
      ventana.add(      new JButton("CENTRO"), BorderLayout.CENTER);
      
      ventana.pack();
      ventana.setVisible(true);
   }
}