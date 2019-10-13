/*
Añade el código necesario para que la ventana que se muestra sea interactiva:
Cuando se pulse el botón, recogerá el radio introducido, calculará el área y lo mostrará 
en la etiqueta "Area del circulo" de la siguiente manera:
*/
import java.awt.*;         // Componentes de dibujo
import javax.swing.*;      // Componentes de una interfaz gráfica
import java.awt.event.*;   // Eventos

public class ClaseGuiEventos10 {

   // Se puede incluir el main en la clase
   public static void main(String[] args) {
   
      ClaseGuiEventos10 gui = new ClaseGuiEventos10();
   }

   // Atributos
   private JFrame ventana;
   private JButton boton;
   private JLabel etiquetaArea;
   private JTextField cajaRadio;

   // Constructor
   public ClaseGuiEventos10() {
   
      // Crea y configura la ventana principal
      ventana = new JFrame();   
      ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ventana.setLocation(400, 300);
      ventana.setSize(300, 200);
      ventana.setTitle("EJERCICIO");
      ventana.setLayout(new FlowLayout());
   
      // Crea y configura los componentes
      ventana.add(new JLabel("RADIO"));
      cajaRadio = new JTextField(10);
      ventana.add(cajaRadio);
      boton = new JButton();
      boton.setText("AREA");
      ventana.add(boton);     
      etiquetaArea = new JLabel("Area del círculo");
      ventana.add(etiquetaArea);
      
      // REGISTRAR UN OBJETO DE LA CLASE OYENTE EN EL BOTON
      Oyente pulsarBoton = new Oyente();
      boton.addActionListener(pulsarBoton);
   
      
      // Al final. Cuando se haya creado todo se visualiza
      ventana.setVisible(true);
   }
   
   // CREAR LA CLASE OYENTE
   
   private class Oyente implements ActionListener {
   
      @Override
      public void actionPerformed(ActionEvent event) {
         double radioCirculo = Double.parseDouble(cajaRadio.getText());
         double area = Math.PI * (radioCirculo * radioCirculo);
         area = Math.round(area);
         etiquetaArea.setText(String.format("Area: %.1f", area));
      }
   }
}