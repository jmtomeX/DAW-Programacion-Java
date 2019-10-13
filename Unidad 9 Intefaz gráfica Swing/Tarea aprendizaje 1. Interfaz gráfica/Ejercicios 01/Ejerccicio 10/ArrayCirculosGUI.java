/*
Escribe el código del constructor de una interfaz gráfica para que la ventana que se muestre sea 
la siguiente:

Ten en cuenta que:

    La ventana principal tendrá un tamaño de 400 x 150, utiliza BorderLayout y  cuando se cierra 
    el programa acaba.
    Se crea un JPanel con FlowLayout para organizar la etiqueta y el JComboBox en la zona centro.
    El botón se identificará como "EDITAR" y se ubicará en la zona sur.

 Podéis consultar cómo se crea y configura un JComboBox en los apuntes
*/

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.io.*;

public class ArrayCirculosGUI {

   // Programa principal
   public static void main(String[] args) throws FileNotFoundException {
   
      Scanner leerFichero = new Scanner(new File("circulos.txt"));
      int num = leerFichero.nextInt();
      Circulo[] listaCirculos = new Circulo[num];
      for (int i = 0; i < num; i++) {
         double radio = leerFichero.nextDouble();
         String color = leerFichero.next();       
         listaCirculos[i] = new Circulo(radio, color);
      }
      
      ArrayCirculosGUI gui = new ArrayCirculosGUI(listaCirculos);
   }
   
   // Atributos
   JComboBox<Circulo> circulos;
   JFrame ventana;
   
   public ArrayCirculosGUI(Circulo[] lista) {
   
      // Crea y configura la ventana principal
      ventana = new JFrame("ELEGIR CIRCULO");
         
      ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ventana.setLayout(new BorderLayout());
      ventana.setSize(400, 150); 
      
      // Crea y configura la etiqueta y el JComboBox para el color.
      JPanel centro = new JPanel();
      centro.setLayout(new FlowLayout());
      JLabel etiqueta = new JLabel("Circulo:"); 
      centro.add(etiqueta);
      
      circulos = new JComboBox<Circulo>(lista);
      centro.add(circulos);
      
      
      ventana.add(centro, BorderLayout.CENTER);
      // Crea y configura los botones
      JButton boton = new JButton("EDITAR");
      ventana.add(boton, BorderLayout.SOUTH);
      
      // Al final. Cuando se haya creado todo se visualiza
      ventana.setVisible(true);
   }
}