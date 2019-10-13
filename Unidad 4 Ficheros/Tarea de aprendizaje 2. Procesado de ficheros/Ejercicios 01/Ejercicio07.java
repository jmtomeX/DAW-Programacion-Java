/*
Completa el programa para que lea el fichero productos.txt y diga qué productos cuestan entre 50 y 100 euros.
Tenemos el siguiente fichero, productos.txt. En él se almacena el id del producto, su nombre, su precio, el país de origen y la cantidad en stock:
101,Placa video,120.00,Nacional,115
102,Cable paralelo,30.00,China,25
103,Ficha teléfono,0.50,Tailandia,140
104,CD-R caja por 10,8.00,Estados Unidos,55
108,Escáner 1200 dpi,150.00,Japón,85
109,Impresora láser,750.00,Francia,21
110,Monitor,175.00,Nacional, 110
112,Mouse óptico,60.00,Nacional,180
113,Teclado inalámbrico,75.00,Estados Unidos,145
*/
import java.util.*;
import java.io.*;
public class Ejercicio07 {
   public static void main(String[] args) throws FileNotFoundException {
      Scanner leerFich = new Scanner(new File("productos.txt"));
      System.out.println("Productos entre 50 y 150 euros");
      while(leerFich.hasNextLine()){
         String linea = leerFich.nextLine();
         Scanner leerLinea = new Scanner(linea);
         
         leerLinea.useLocale(Locale.US);
         leerLinea.useDelimiter(",");
         
         int id = leerLinea.nextInt();
         String producto = leerLinea.next();
         double precio = leerLinea.nextDouble();
         
         if(precio >= 50 && precio <= 150){
            System.out.println(id + " " + producto + ": " + precio);
         }
      }
      leerFich.close();
   }
}