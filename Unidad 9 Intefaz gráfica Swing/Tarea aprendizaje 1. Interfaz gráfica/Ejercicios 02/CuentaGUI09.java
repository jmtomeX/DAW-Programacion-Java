/*
Escribe el código de una interfaz gráfica para que la ventana que se muestre sea la siguiente:

Ten en cuenta que:

    La ventana principal se ajusta al tamaño de sus componentes, su título es "OPERACIONES",
    utiliza el GridLayout y  cuando se cierra el programa acaba.
    Las etiquetas se crean a partir de un ArrayList de String.
    Las cajas de texto se guardan en un ArrayList de JTextField

*/

// Importamos las librerias necesarias
import java.awt.*;
import javax.swing.*;
import java.util.*;

public class CuentaGUI09 {

   // Programa principal
   public static void main(String[] args) {
       
      ArrayList<String> opciones = new ArrayList<String>();
      opciones.add("Titular: ");
      opciones.add("Número: ");
      opciones.add("Saldo: ");
      
      CuentaGUI09 gui = new CuentaGUI09(opciones);
   }
   
   // Atributos
   ArrayList<JTextField> cajasTexto;

   // Constructor
   public CuentaGUI09(ArrayList<String> etiquetas) {
   
      // Crea y configura la ventana principal
      JFrame ventana = new JFrame();
      ventana.setTitle("OPERACIONES");
      ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ventana.setLayout(new GridLayout(4, 2));
      
      // Crea y configura las etiquetas y las cajas de texto. Los títulos se obtienen del ArrayList
      // Las cajas de texto se guardan en el ArrayList de cajasTexto 
      cajasTexto = new ArrayList<JTextField>();
      for (int i = 0; i < etiquetas.size(); i++) {
         JLabel etiqueta = new JLabel(etiquetas.get(i));
         JTextField cajaTexto = new JTextField(10);
         ventana.add(etiqueta);
         ventana.add(cajaTexto);
      }
      
      
      // Crea y configura los botones
      ventana.add(new JButton("INGRESAR"));
      ventana.add(new JButton("RETIRAR"));
   
      // Al final. Cuando se haya creado todo se visualiza
      ventana.pack();
      ventana.setVisible(true);
   }
}