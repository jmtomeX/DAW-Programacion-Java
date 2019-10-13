/*
 * GUI con menú para manejar la BBDD
 * Configura correctamente la IP de la BBDD
 */

import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.text.*;       // Para poder usar DefaultCaret
import java.awt.event.*;
import java.sql.*;

public class GUI implements ActionListener {

   // Método main
   public static void main (String args[]) throws ClassNotFoundException, SQLException {
   
      String driver = "oracle.jdbc.driver.OracleDriver";
      String url = "jdbc:oracle:thin:@localhost:1521:xe ";
      String usuario = "desvan";
      String password = "desvan";
      
      BBDD miBBDD = new BBDD(driver, url, usuario, password);
   
      GUI gui = new GUI(miBBDD);
   }

   // Atributos
   private BBDD miBBDD;
   private JFrame ventana;
   private JComboBox<Empleado> empleados;
   private JTextField cajaDpto;
   private JTextField cajaIdDpto;
   private JTextField cajaLetra;
   private JTextArea areaTexto;
   private JButton borrar;
   private JButton insertar;
   private JButton mostrar;

   // Constructor
   public GUI(BBDD unaBBDD) {
   
      this.miBBDD = unaBBDD;
   
      // Crea y configura la ventana principal
      ventana = new JFrame();   
      ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ventana.setTitle("MENU BBDD");
   
      // Creamos un contenedor para organizar la zona norte de la ventana principal
      JPanel norte = new JPanel(new FlowLayout());
      norte.add(new JLabel("Departamento: "));
      cajaDpto = new JTextField(15);
      norte.add(cajaDpto);
      norte.add(new JLabel("ID: "));
      cajaIdDpto = new JTextField(15);
      norte.add(cajaIdDpto);
      insertar = new JButton("INSERTAR");
      insertar.addActionListener(this);
      norte.add(insertar);
      borrar = new JButton("BORRAR");
      borrar.addActionListener(this);
      norte.add(borrar);
      ventana.add(BorderLayout.NORTH, norte);
           
      // Crea la caja de texto con scroll y la añade a la ventana principal
      // Se desactiva el autoscroll
      areaTexto = new JTextArea(15, 30);
      areaTexto.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
      DefaultCaret caret = (DefaultCaret) areaTexto.getCaret();
      caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
      JScrollPane scroll = new JScrollPane(areaTexto);
      ventana.add(BorderLayout.CENTER, scroll);
      
      // Creamos un contenedor para organizar la zona sur de la ventana principal
      JPanel sur = new JPanel(new FlowLayout());
      empleados = new JComboBox<Empleado>();
      sur.add(empleados);
      
      empleados.addActionListener(this);
      sur.add(new JLabel("Letra: "));
      cajaLetra = new JTextField(5);
      sur.add(cajaLetra);
      mostrar = new JButton("MOSTRAR");
      mostrar.addActionListener(this);
      sur.add(mostrar);
      ventana.add(BorderLayout.SOUTH, sur);
   
      
      // Al final. Cuando se haya creado todo se visualiza
      ventana.pack();
      ventana.setVisible(true);
   }
   
   // Implementamos la interfaz ActionListener
   /*
     Desarrolla el método actionPerformed dentro de la clase GUI para que cuando se pulse
     la opción BORRAR se borre el departamento con el nombre indicado.
   */
   @Override
   public void actionPerformed(ActionEvent evento) {
    // Identificamos y ejecutamos la opción
      // Identificamos la opción pulsada
      Object objetoPulsado = evento.getSource();
      JButton botonPulsado = (JButton) objetoPulsado;
      String textoOpcion = botonPulsado.getText();
      
      if (textoOpcion.equals("BORRAR")) {
      // Obtenemos el nombre del departamento y miramos que tenga datos
         String nombre = cajaDpto.getText();
         if(nombre.isEmpty()) {
            JOptionPane.showMessageDialog(ventana, "El nombre está vacío.");
            return;
         }
         // Ejecutamos la opción
         try {
            if (miBBDD.borrarDepartamento(nombre)) {
               JOptionPane.showMessageDialog(ventana, "Operación realizada con éxito");
            } else {
               JOptionPane.showMessageDialog(ventana, "Problemas con la operación");
            }
         } catch (Exception excepcion) {
            JOptionPane.showMessageDialog(ventana, "Error con la BBDD: " + excepcion.getMessage());
         }
         return;
      }    
   }   
}
