/*
Corrige el código que se plantea para que la ventana que se muestra sea interactiva:

Cuando se pulse el botón "BUSCAR" identificará el color elegido y buscará el primer circulo de ese 
color en un array. Mostrará el radio de ese circulo. En este caso, será 6.00:

 Se usará la clase Circulo y al constructor de la interfaz gráfica se le pasará el array de Circulos donde realizar la busqueda.
*/
// Importamos las librerias necesarias
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CirculoGUI08 implements ActionListener {

   // Programa principal
   public static void main(String[] args) {
      
      // Creamos un array con 4 Circulos cada uno de un color
      Circulo[] circulos = new Circulo[4];
      for (int i = 0; i < 4; i++) {
         Circulo otroCirculo = new Circulo((i + 1) * 2, colores[i]);
         circulos[i] = otroCirculo;
      }
      
      CirculoGUI08 gui = new CirculoGUI08(circulos);
   }
   
   // Atributos
   public static String[] colores = {"Blanco", "Negro", "azul", "Verde"};
   private JLabel radio;
   private JComboBox<String> color;
   private Circulo[] circulos;

   // Constructor
   public CirculoGUI08(Circulo[] arrayCirculos) {
   
      // Guardamos el array de circulos en el atributo circulos para poder trabajar con él en la clase
      circulos = arrayCirculos;
   
      // Crea y configura la ventana principal
      JFrame ventana = new JFrame();
      ventana.setTitle("ELEGIR CIRCULO");
      ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ventana.setSize(400, 150);
      ventana.setLayout(new BorderLayout());
     
      // Crea y configura las etiquetas y el JComboBox para el color.
      JPanel arriba = new JPanel(new FlowLayout());
      radio = new JLabel("Radio: ");
      arriba.add(radio);
      arriba.add(new JLabel("Color: "));
      color = new JComboBox<String>(colores);
      arriba.add(color);
      ventana.add(arriba, BorderLayout.CENTER);
        
      // Crea y configura los botones
      JButton boton = new JButton("BUSCAR");
      ventana.add(boton, BorderLayout.SOUTH);
      
      // Registrar el oyente en el botón
      boton.addActionListener(this);
   
      // Al final. Cuando se haya creado todo se visualiza
      ventana.setVisible(true);
   }
   
   
   // Implementamos la interfaz ActionListener para el botón. Sobreescribimos el método actionPerformed
   // Cuando se pulse el boton buscará el primer círculo de ese color y mostrará su radio
   @Override
   public void actionPerformed(ActionEvent evento) {
   
      String colorElegido = (String) color.getSelectedItem();
   
      for (Circulo unCirculo : circulos) {
         String unColor = unCirculo.getColor();
         if (colorElegido.equals(unColor)) {
            double unRadio = unCirculo.getRadio();
            radio.setText(String.format("Radio: %.2f", unRadio));
            return;
         }
      }
   }
}