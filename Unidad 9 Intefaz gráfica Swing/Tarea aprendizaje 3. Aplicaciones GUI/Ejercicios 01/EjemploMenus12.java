import java.util.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class EjemploMenus12 implements ActionListener {

   // Se puede incluir el main en la clase
   public static void main(String[] args) throws FileNotFoundException {
      
      // Conectamos con el fichero banco.txt y creamos una instancia de Banco con todos sus datos
      Scanner leerFichero = new Scanner(new File("banco.txt"));
      leerFichero.useLocale(Locale.ENGLISH);
      Banco miBanco = new Banco("BBVA", leerFichero);
      leerFichero.close();
         
      EjemploMenus12 gui = new EjemploMenus12(miBanco);
   }

   // Atributos
   private JTextArea areaTexto;
   private Banco esteBanco;

   // Constructor
   public EjemploMenus12(Banco unBanco) {
   
      // Inicializamos el atributo esteBanco con el Banco indicado
      // Guardamos los datos sobre los que queremos trabajar en una variable de clase
      // para poder trabajar sobre ella desde cualquier método de la clase
      this.esteBanco = unBanco;

   
      // Crea y configura la ventana principal
      JFrame ventana = new JFrame();   
      ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ventana.setSize(450, 260);
      ventana.setTitle("Ejemplo de menús");
   
      // Crea la barra de menús. Se añade con setJMenuBar
      JMenuBar menus = crearMenuBar();
      ventana.setJMenuBar(menus);
      
      // Crea la caja de texto y la añade a la ventana principal
      areaTexto = new JTextArea(esteBanco.toString());
      ventana.add(areaTexto);
      
      // Al final. Cuando se haya creado todo se visualiza
      ventana.setVisible(true);
   }
   
   private JMenuBar crearMenuBar() {

      // Para crear menús primero debemos crear una barra de menús (JMenuBar)
      JMenuBar barraMenu = new JMenuBar();
      
      // Creamos un menú y lo añadimos a la barra de menús
      JMenu menu1 = new JMenu("MENU 1");
      barraMenu.add(menu1);
      
      // Creamos 2 opciones para el menú y las añadimos
      // Registramos la clase oyente en cada opción
      JMenuItem opcionMenu1 = new JMenuItem("Opción 1");
      menu1.add(opcionMenu1);
      opcionMenu1.addActionListener(this);
      JMenuItem opcionMenu2 = new JMenuItem("Opción 2");
      menu1.add(opcionMenu2);
      opcionMenu2.addActionListener(this);
      
      // Añadimos un separador
      menu1.addSeparator();
        
      //Creamos un menú y lo añadimos como submenú. Las opciones las leemos de un array.
      JMenu subMenu = new JMenu("SUBMENU");
      String[] opciones = {"Opción 1 del submenú", "Opción 2 del submenú"};
      for (int i = 0; i < opciones.length; i++) {
         String opcion = opciones[i];
         JMenuItem opcionMenu = new JMenuItem(opcion);
         subMenu.add(opcionMenu);
         opcionMenu.addActionListener(this);
      }
      menu1.add(subMenu);

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
      JMenuItem opcion = (JMenuItem) evento.getSource();
      String textoOpcion = opcion.getText();
      
      if (textoOpcion.equals("Opción 1")) {
         Dialogo12 unDialogo = new Dialogo12(esteBanco);;
         return;
      }
   }
}