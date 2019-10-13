import java.util.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class EjemploMenus08 implements ActionListener {

   // Se puede incluir el main en la clase
   public static void main(String[] args) {
      EjemploMenus08 gui = new EjemploMenus08();
   }

   // Atributos
   private JTextArea areaTexto;

   // Constructor
   public EjemploMenus08() {
   
      // Crea y configura la ventana principal
      JFrame ventana = new JFrame();   
      ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ventana.setSize(450, 260);
      ventana.setTitle("Ejemplo de menús");
   
      // Crea la barra de menús. Se añade con setJMenuBar
      JMenuBar menus = crearMenuBar();
      ventana.setJMenuBar(menus);
      
      // Crea la caja de texto y la añade a la ventana principal
      areaTexto = new JTextArea();
      ventana.add(areaTexto);
      
      // Al final. Cuando se haya creado todo se visualiza
      ventana.setVisible(true);
   }
   
   private JMenuBar crearMenuBar() {
   
      // Para crear menús primero debemos crear una barra de menús (JMenuBar)
      JMenuBar barraMenu = new JMenuBar();
      
      // Creamos un menú y lo añadimos a la barra de menús
      JMenu menu1 = new JMenu("INICIO");
      barraMenu.add(menu1);
      
      //Creamos un menú y lo añadimos como submenú. Las opciones las leemos de un array.
      JMenu subMenu = new JMenu("FICHEROS");
      String[] opciones = {"Abrir", "Cerrar"};
      for (int i = 0; i < opciones.length; i++) {
         String opcion = opciones[i];
         JMenuItem opcionMenu = new JMenuItem(opcion);
         subMenu.add(opcionMenu);
         opcionMenu.addActionListener(this);
      }
      menu1.add(subMenu);
      
      // Añadimos un separador
      menu1.addSeparator();
      
      // Creamos 2 opciones para el menú y las añadimos
      // Registramos la clase oyente en cada opción
      JMenuItem opcionMenu1 = new JMenuItem("Cambiar color");
      menu1.add(opcionMenu1);
      opcionMenu1.addActionListener(this);
      JMenuItem opcionMenu2 = new JMenuItem("Cambiar tamaño");
      menu1.add(opcionMenu2);
      opcionMenu2.addActionListener(this);
   
      // Creamos otro menú. Las opciones las leemos del ficheros opciones.txt
      JMenu menu2 = new JMenu("MENU 2");      
      Scanner leerFichero = null;
      try {
         leerFichero = new Scanner(new File("opciones.txt"));
         leerFichero.useDelimiter(";");
         while (leerFichero.hasNext()) {
            String opcion = leerFichero.next();
            JMenuItem opcionMenu = new JMenuItem(opcion);
            menu2.add(opcionMenu);
            opcionMenu.addActionListener(this);
         }
      } catch (Exception excepcion) {
         JOptionPane.showMessageDialog(null, "Se ha producido un error al leer el fichero");
      }
      
      if (leerFichero != null) {
         leerFichero.close();
      }
      barraMenu.add(menu2);
      
      return barraMenu;
   }

   // Implementamos la interfaz ActionListener
   @Override
   public void actionPerformed(ActionEvent evento) {
   
      // Identificamos la opción pulsada y la mostramos en la caja de texto
      // JMenuItem opcion = (JMenuItem) evento.getSource();
      String textoOpcion = ((JMenuItem) evento.getSource()).getText();
      String texto = "Se ha elegido la opcion: " + textoOpcion;
      areaTexto.append(texto + "\n");
      
      if (textoOpcion.equals("Opción 1")) {
         JOptionPane.showMessageDialog(null, "Has pulsado la opción 1 del menu 1");
         return;
      }
      
      if(textoOpcion.equals("Abrir")) {
         Dialogo08 nuevaVentana = new Dialogo08();
         return;
      }
   }
}