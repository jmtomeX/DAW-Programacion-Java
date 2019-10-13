import java.awt.*;
import javax.swing.*;

public class IndiceMasaCorporalGUI {

   // Se puede incluir el main en la clase
   public static void main(String[] args) {
      IndiceMasaCorporalGUI Gui = new IndiceMasaCorporalGUI();
   }

   // Atributos: los componentes del interfaz gráfico que queremos manejar
   private JFrame ventana;
   private JTextField campoAltura;
   private JTextField campoPeso;
   private JLabel etiquetaIMC;
   
   // Constructor del interfaz gráfico
   public IndiceMasaCorporalGUI() {
   
      // Ventana principal de tipo BorderLayout
      ventana = new JFrame("IMC");
      ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ventana.setLayout(new BorderLayout());
   
      // Crea un marco secundario de tipo rejilla para agrupar los 4 primeros componentes
      JPanel norte = new JPanel(new GridLayout(2, 2));
      norte.add(new JLabel("Altura: "));
      campoAltura = new JTextField(5);
      norte.add(campoAltura);
      norte.add(new JLabel("Peso: "));
      campoPeso = new JTextField(5);
      norte.add(campoPeso);
      
      // Asignamos el marco secundario a la ventana principal
      ventana.add(norte, BorderLayout.NORTH);
      
      // Creamos la etiquetaIMC y la asignamos a la ventana principal
      etiquetaIMC = new JLabel("Escribe tu peso y altura");
      ventana.add(etiquetaIMC, BorderLayout.CENTER);
      
      // Creamos el botón y lo asignamos a la ventana principal
      JButton botonCalcular = new JButton("Calcular");
      ventana.add(botonCalcular, BorderLayout.SOUTH);
      
      // Ajustamos la ventan a los componentes y la hacemos visible
      ventana.pack();
      ventana.setVisible(true);
   }
}