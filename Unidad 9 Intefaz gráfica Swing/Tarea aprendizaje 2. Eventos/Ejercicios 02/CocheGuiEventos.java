/*
Añade el código necesario para que la ventana que se muestra sea interactiva:

Cuando se pulse el botón, se recogerán los datos introducidos y se creará un objeto de la 
clase Coche con esos datos:

 Finalmente, se mostrará el contenido del ArrayList para comprobar que se ha añadido correctamente:
 Recuerda que los ArrayList disponen del método toString().
*/
// Importamos las librerias necesarias
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CocheGuiEventos {

   // Programa principal
   public static void main(String[] args) {
   
      // Crea el ArrayList de datos sobre los que vamos a trabajar
      ArrayList<Coche> listaCoches = new ArrayList<Coche>();
      listaCoches.add(new Coche("Opel", "Meriva", 2013));
      listaCoches.add(new Coche("Honda", "Civic", 2016));
      listaCoches.add(new Coche("Renault", "Clio", 2014));
      listaCoches.add(new Coche("Ford", "Fiesta", 2012));
      
      // Creamos la interfaz gráfica y le pasamos los datos
      CocheGuiEventos gui = new CocheGuiEventos(listaCoches);
   }
   
   // Atributos
   JTextField cajaMarca;
   JTextField cajaModelo;
   JTextField cajaYear;
   ArrayList<Coche> coches;         // Datos con los que vamos a trabajar

   // Constructor
   public CocheGuiEventos(ArrayList<Coche> coches) {
   
      // Guardamos el ArrayList de Coches recibido en el atributo coches
      this.coches = coches;
   
      // Crea y configura la ventana principal
      JFrame ventana = new JFrame();
      ventana.setTitle("AÑADIR COCHE");
      ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ventana.setSize(300, 150);
      ventana.setLayout(new BorderLayout());
   
      // Crea y configura la etiqueta de la zona norte
      JLabel titulo = new JLabel("Vas añadir un nuevo coche");
      ventana.add(titulo, BorderLayout.NORTH);
      
      // Crea y configura la zona centro.
      // Crea las etiquetas y las cajas de texto y las añade al marco secundario
      // El marco secundario lo añade a la zona centro
      JPanel centro = new JPanel(new GridLayout(3, 2));
      centro.add(new JLabel("Marca: "));
      cajaMarca = new JTextField(10);
      centro.add(cajaMarca);
      centro.add(new JLabel("Modelo: "));
      cajaModelo = new JTextField(10);
      centro.add(cajaModelo);
      centro.add(new JLabel("Año: "));
      cajaYear = new JTextField(10);
      centro.add(cajaYear);
      ventana.add(centro, BorderLayout.CENTER);
      
      // Crea y configura el botón de la zona sur
      JButton botonCrear = new JButton("CREAR");
      ventana.add(botonCrear, BorderLayout.SOUTH);
      
      // CREAR OYENTES Y REGISTRARLOS
      OyenteCrear oyente = new OyenteCrear();
      botonCrear.addActionListener(oyente);
   
   
      // Al final. Cuando se haya creado todo se visualiza
      ventana.setVisible(true);
   }
   
   // CREAR OYENTE ActionListener PARA EL BOTON CREAR
   private class OyenteCrear implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent evento) {
         String marcaCoche = cajaMarca.getText();
         String modeloCoche = cajaModelo.getText();
         String anhoCoche = cajaYear.getText();
         int anhoC = Integer.parseInt(anhoCoche);
         coches.add(new Coche(marcaCoche, modeloCoche, anhoC)); 
         JOptionPane.showMessageDialog(null, coches.toString());
         
      }
   } 
}