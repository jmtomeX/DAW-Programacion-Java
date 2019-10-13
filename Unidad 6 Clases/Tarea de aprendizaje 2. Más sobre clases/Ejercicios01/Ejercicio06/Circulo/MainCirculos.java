import java.util.*;
public class MainCirculos{
   public static void main(String[] args) {   
      Scanner leerDatos = new Scanner(System.in);
      ArrayCirculos nuevaLista = new ArrayCirculos(5.5, "rojo", 3);
      System.out.println(nuevaLista);
      System.out.println("verde: " + nuevaLista.contarColor("verde"));
      System.out.println("rojo: " + nuevaLista.contarColor("rojo"));
      modificar(nuevaLista, leerDatos);
      modificar(nuevaLista, leerDatos);
      System.out.println(nuevaLista);
      //System.out.println(nuevaLista.colorMayor());
      System.out.println(nuevaLista.colorMayorMod());
   
   }
   /*Completa el método modificar para que reciba un array de Circulos y un Scanner 
   para leer por teclado, pida el Circulo que se quiere cambiar así como los nuevos 
   valores y los modifique.*/
   public static  void  modificar(ArrayCirculos lista, Scanner leerDatos) {
      System.out.print("Circulo a cambiar: ");
      int num = leerDatos.nextInt();
      System.out.print("Nuevo radio: ");
      double radio = leerDatos.nextDouble();
      System.out.print("Nuevo color: ");
      String color = leerDatos.next();
      lista.setCirculo( num , radio,  color);
      System.out.println("El circulo " + num + " se ha cambiado");
   }
}