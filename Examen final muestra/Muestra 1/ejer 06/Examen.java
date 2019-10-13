import java.awt.*;         // Componentes de dibujo
import javax.swing.*;      // Componentes de una interfaz gráfica
import java.awt.event.*;   // Eventos

public class Examen {

   // Se puede incluir el main en la clase
   public static void main(String[] args) {
   
      Examen gui = new Examen();
   }

   // Atributos
   private JFrame ventana;
   private JLabel etiquetaArea;
   private JTextField cajaRadio;

   // Constructor
   public Examen() {
   
      // Crea y configura la ventana principal
      ventana = new JFrame();   
      ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ventana.setLocation(400, 300);
      ventana.setSize(350, 200);
      ventana.setTitle("EJERCICIO");
      ventana.setLayout(new FlowLayout());
   
      // Crea y configura los componentes
      ventana.add(new JLabel("RADIO"));
      cajaRadio = new JTextField(10);
      ventana.add(cajaRadio);
      
      JButton boton = new JButton();
      boton.setText("AREA");
      
   
      
      ventana.add(boton);
      JButton reset = new JButton();
      reset.setText("RESET");
      
   
      
      ventana.add(reset);     
      etiquetaArea = new JLabel("Area del círculo");
      ventana.add(etiquetaArea);
      
      // REGISTRAR UN OBJETO DE LA CLASE OYENTE
      // Le asignamos el oyente al botón AREA
      boton.addActionListener(new Oyente());
      // Le asignamos el oyente al botón RESET
      reset.addActionListener(new Oyente());
      
      // Al final. Cuando se haya creado todo se visualiza
      ventana.setVisible(true);
   }
   
   // CREAR LA CLASE OYENTE
   /*
   Añade el código necesario para que la ventana que se muestra sea interactiva:
      Cuando se pulse el botón "AREA", recogerá el radio introducido, calculará el área y lo 
      mostrará en la etiqueta "Area del circulo" de la siguiente manera:

      Si no se ha introducido ningún número, pedirá introducirlo:
      Cuando se pulse el botón "RESET", se vaciará la caja de texto y en la etiqueta "Area del circulo" se volverá
      a mostrar el texto inicial:
   */
   
   private class Oyente implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent evento) {
         JButton boton = (JButton) evento.getSource();
         if(boton.getText().equals("AREA")) {
            String radioStr =cajaRadio.getText();
            if(radioStr.equals("")) {
               JOptionPane.showMessageDialog(null, "Debes indicar el valor del radio");
               return;
            }
            double radio = Double.parseDouble(radioStr);
            double perimetro =Math.round(2 * Math.PI * radio * radio);
            etiquetaArea.setText("Area " + Double.toString(perimetro));
         }
         if(boton.getText().equals("RESET")) {
            cajaRadio.setText("");
            return;
         }
      }
   }
}