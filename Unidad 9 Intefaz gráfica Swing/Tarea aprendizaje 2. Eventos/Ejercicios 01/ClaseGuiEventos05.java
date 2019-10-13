/*
Ejercicio 05
Corrige el código que se plantea para que la ventana que se muestra sea interactiva:
Una vez introducida una temperatura, cuando se pulse el botón, se convertirá a grados fahrenheit
Se asume que el dato que se introduce es válido. Será un número decimal y se utilizará el punto para indicar los decimales.
*/

// Clase para la interfaz gráfica de nuestro programa

import java.awt.*;         // Componentes de dibujo
import javax.swing.*;      // Componentes de una interfaz gráfica
import java.awt.event.*;   // Eventos

public class ClaseGuiEventos05 {

   // Se puede incluir el main en la clase
   public static void main(String[] args) {
      ClaseGuiEventos05 gui = new ClaseGuiEventos05();
   }

   // Atributos
   private JFrame ventana;
   private JButton boton;
   private JLabel resultado;
   private JTextField cajaCelsius;

   // Constructor
   public ClaseGuiEventos05() {
   
      // Crea y configura la ventana principal
      ventana = new JFrame();   
      ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ventana.setLocation(400, 300);
      ventana.setSize(400, 200);
      ventana.setTitle("EJERCICIO 1");
      ventana.setLayout(new FlowLayout());
   
      // Crea y configura los componentes
      ventana.add(new JLabel("Celsius"));
      cajaCelsius = new JTextField(10);
      ventana.add(cajaCelsius);
      boton = new JButton();
      boton.setText("CONVERTIR");
      
      // REGISTRAR UN OBJETO DE LA CLASE OYENTE EN EL BOTON
      Oyente pulsarBoton = new Oyente();
      boton.addActionListener(pulsarBoton);
      
      ventana.add(boton);
      resultado = new JLabel("Temperatura en grados Fahrenheit");
      ventana.add(resultado);
      
      // Al final. Cuando se haya creado todo se visualiza
      ventana.setVisible(true);
   }
   
   // Crear la clase Oyente
   // Se crea una clase que tiene el comportamiento del interfaz ActionListener
   // Se reescribe el método actionPerformed con el código que queremos que se ejecute cuando se pulse el componente
   
   private class Oyente implements ActionListener {
   // Si ocurre el evento ActionEvent lee la temperatura en grados Celsius de la caja de texto cajaCelsius
      // La convierte a grados Fahrenheit
      // Muestra el valor obtenido en la etiqueta resultado
      @Override
      public void actionPerformed(ActionEvent event) {
         double celsiusTexto = Double.parseDouble(cajaCelsius.getText()); 
         double fahrenheit = celsiusTexto * 9 / 5 + 32;
         resultado.setText("Temperatura en grados Fahrenheit: " + fahrenheit);
      }
   }
}