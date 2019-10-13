import java.awt.*;
import javax.swing.*;

public class ContenedoresGridLayout {
   public static void main(String[] args) {
      JFrame ventana = new JFrame();
      ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ventana.setSize(new Dimension(300, 120));
      ventana.setTitle("LAYOUT TIPO GRID");
   
      // 2 rows, 3 columns
      ventana.setLayout(new GridLayout(2, 3));
      for (int i = 6; i >= 1; i--) {
         JButton boton = new JButton();
         boton.setText("BOTON " + i);
         ventana.add(boton);
      }
      ventana.setVisible(true);
   }
}