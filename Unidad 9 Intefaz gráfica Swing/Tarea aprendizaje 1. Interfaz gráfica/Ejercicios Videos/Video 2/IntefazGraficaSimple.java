// Programa para demostrar la creación de una interfaz gráfica sencilla
// Siempre necesitaremos un JFrame para crear la ventana principal
// Dentro ubicaremos los componentes que vamos a usar: cajas de texto, botones, menús desplegables...

import java.awt.*;      // Se necesita pra utilizar componentes de dibujo como Color, Point, Dimension...
import javax.swing.*;

public class IntefazGraficaSimple {

   public static void main(String[] args) {
   
      // Ejemplo mínimo de frame
      // Siempre se crea oculta. Hay que hacerla visible para que el usuario o usuaria acceda a ella
      JFrame ventana1 = new JFrame();
      ventana1.setVisible(true);
      
   
      // 2º ejemplo: Atributos y métodos de Frame
      JFrame ventana = new JFrame();
      
      ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ventana.setLocation(300, 200);
      ventana.setSize(150, 100);
      ventana.setTitle("UNA VENTANA");
      
      // 3. paso: añadir componentes mediante el método public void add(Component comp)
      // Primero se crean y se configuran. Luego se añaden a la ventana.
      // 2 botones. Los 2 ocupan todo el tamaño del frame y se colocan uno encima del otro
      JButton boton1 = new JButton();
      boton1.setText("BOTON 1");
      boton1.setBackground(Color.GREEN);
      ventana.add(boton1);
           
      JButton boton2 = new JButton();
      boton2.setText("BOTON 2");
      boton2.setBackground(Color.RED);
      ventana.add(boton2);
      
      // Se cambia la forma de disponer los elementos
      // Los elementos se colocan de izquierda a derecha
      ventana.setLayout(new FlowLayout());
      
      // La ventana se adapta a los elementos que contiene
      // Es una alternativa a asignarle el tamaño setSize()
      ventana.pack();
      
      // Al final. Cuando se haya creado todo se visualiza
      ventana.setVisible(true);
   }
}