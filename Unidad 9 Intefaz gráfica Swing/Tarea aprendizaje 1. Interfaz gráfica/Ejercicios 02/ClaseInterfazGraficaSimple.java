/*
Modifica el código que se plantea para que la ventana que se muestre sea la siguiente:

Ten en cuenta que:

    La ventana principal utiliza el BorderLayout.
    Se crea un JPanel con FlowLayout para juntar la etiqueta Celsius y la caja de texto en la zona
    norte de la ventana principal.
    El botón estará en la zona sur y la etiqueta "Temperatura en grados..." en la zona centro.

*/

import java.awt.*;         // Componentes de dibujo
import javax.swing.*;      // Componentes de una interfaz gráfica

public class ClaseInterfazGraficaSimple {

   // Se puede incluir el main en la clase
   public static void main(String[] args) {
      ClaseInterfazGraficaSimple gui = new ClaseInterfazGraficaSimple();
   }

   // Atributos
   private JFrame ventana;
   private JButton boton;
   private JLabel resultado;
   private JTextField cajaCelsius;

   // Constructor
   public ClaseInterfazGraficaSimple() {
   
      // Crea y configura la ventana principal
      ventana = new JFrame();
      ventana.setTitle("EJERCICIO");
      ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ventana.setLocation(400, 300);
      ventana.setSize(400, 200);
      ventana.setLayout(new BorderLayout());
   
      // Crea y configura los componentes
      JPanel principal = new JPanel();
      principal.setLayout(new FlowLayout());
      principal.add(new JLabel("Celsius"));
      cajaCelsius = new JTextField(10);
      principal.add(cajaCelsius);
      
      ventana.add(principal, BorderLayout.NORTH);
      
      boton = new JButton();
      boton.setText("CONVERTIR");
      ventana.add(boton, BorderLayout.SOUTH);
      resultado = new JLabel("Temperatura en grados Fahrenheit");
      ventana.add(resultado, BorderLayout.CENTER);
      
      // Al final. Cuando se haya creado todo se visualiza
      ventana.setVisible(true);
   }   
}