/*
Añade el código necesario para que la ventana que se muestra sea interactiva:

Cuando se pulse el botón, se recogerán los datos introducidos, se creará un objeto
de la clase Coche con esos datos y el año 2010 y se buscarán todos los coches que sean
de la misma marca y modelo utilizando el método equals de la clase Coche:
*/

// Importamos las librerias necesarias
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CocheGuiEventos10 {

   // Programa principal
   public static void main(String[] args) {
   
      // Crea el ArrayList de datos sobre los que vamos a trabajar
      ArrayList<Coche> listaCoches = new ArrayList<Coche>();
      listaCoches.add(new Coche("Opel", "Meriva", 2013));
      listaCoches.add(new Coche("Ford", "Fiesta", 2015));
      listaCoches.add(new Coche("Honda", "Civic", 2016));
      listaCoches.add(new Coche("Renault", "Clio", 2014));
      listaCoches.add(new Coche("Ford", "Fiesta", 2012));
      
      // Creamos la interfaz gráfica y le pasamos los datos
      CocheGuiEventos10 gui = new CocheGuiEventos10(listaCoches);
   }
   
   // Atributos
   JTextField cajaMarca;
   JTextField cajaModelo;
   ArrayList<Coche> coches;         // Datos con los que vamos a trabajar

   // Constructor
   public CocheGuiEventos10(ArrayList<Coche> coches) {
   
      // Guardamos el ArrayList de Coches recibido en el atributo coches
      this.coches = coches;
   
      // Crea y configura la ventana principal
      JFrame ventana = new JFrame();
      ventana.setTitle("AÑADIR COCHE");
      ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ventana.setLayout(new BorderLayout());
   
      // Crea y configura la etiqueta de la zona norte
      JLabel titulo = new JLabel("Vas a buscar un coche");
      ventana.add(titulo, BorderLayout.NORTH);
      
      // Crea y configura la zona centro.
      // Crea las etiquetas y las cajas de texto y las añade al marco secundario
      // El marco secundario lo añade a la zona centro
      JPanel centro = new JPanel(new GridLayout(2, 2));
      centro.add(new JLabel("Marca: "));
      cajaMarca = new JTextField(10);
      centro.add(cajaMarca);
      centro.add(new JLabel("Modelo: "));
      cajaModelo = new JTextField(10);
      centro.add(cajaModelo);
      ventana.add(centro, BorderLayout.CENTER);
      
      // Crea y configura el botón de la zona sur
      JButton botonBuscar = new JButton("BUSCAR");
      ventana.add(botonBuscar, BorderLayout.SOUTH);
      
      // CREAR OYENTES Y REGISTRARLOS
      OyenteBuscar buscar = new OyenteBuscar();
      botonBuscar.addActionListener(buscar);
   
   
      // Al final. Cuando se haya creado todo se visualiza
      ventana.pack();
      ventana.setVisible(true);
   }
   
   // CREAR OYENTE ActionListener PARA EL BOTON CREAR
   private class OyenteBuscar implements ActionListener {
      public void actionPerformed(ActionEvent evento) {
         String marcaCoche = cajaMarca.getText();
         String modeloCoche = cajaModelo.getText();
         Coche unCoche = new Coche(marcaCoche, modeloCoche, 2010); 
         String resultado = "";
         for(Coche otroCoche : coches) {
            if(unCoche.equals(otroCoche)) {
               resultado += otroCoche.toString()  + "\n";
            }
         }
         JOptionPane.showMessageDialog(null, resultado); 
      }
   } 
}