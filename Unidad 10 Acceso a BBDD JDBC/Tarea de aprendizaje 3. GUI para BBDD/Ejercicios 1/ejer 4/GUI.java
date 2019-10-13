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
         // Guardamos el ArrayList en un array y lo cargamos en el desplegable
      try {
         ArrayList<Empleado> lista = miBBDD.getEmpleados();
         Empleado[] arrayEmpleados = new Empleado[lista.size()];
         lista.toArray(arrayEmpleados);
         empleados = new JComboBox<Empleado>(arrayEmpleados);
      } catch (Exception excepcion) {
         JOptionPane.showMessageDialog(ventana, "Error con la BBDD: " + excepcion.getMessage());
      }
   
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
    Desarrolla el método actionPerformed dentro de la clase GUI para que en el desplegable se
    carguen todos los empleados y empleadas de la BBDD con el fomato nombre(código).
    Además, cuando elijamos un empleado o una empleada, se mostrarán su nombre, código y número
    de cuenta como se muestra en la imagen:
    
    Se comprobará que ninguna de las 2 cajas de texto están vacías y que el código introducido
    se corresponde con un número entero (puedes usar un verificador si quieres).  

       Si todo va bién se informará de que la operación se realizado con éxito:
            
       Si el registro no se puede borrar también se indicará:
     
       Por último, si hay algún problema con la BBDD se informará de ello:
   */
   @Override
   public void actionPerformed(ActionEvent evento) {
   
      Object objetoPulsado = evento.getSource();
      if(objetoPulsado instanceof JComboBox) {
         Empleado empleadoSeleccionado = (Empleado) empleados.getSelectedItem();
         areaTexto.setText(empleadoSeleccionado + "\n");
         areaTexto.append("Cuenta: " + empleadoSeleccionado.getCuenta() + "\n");
         return;
      }
   }
}
