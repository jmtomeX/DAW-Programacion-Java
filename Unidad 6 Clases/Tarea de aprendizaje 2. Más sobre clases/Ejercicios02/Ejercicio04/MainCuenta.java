import java.util.*;
public  class MainCuenta{
   public static void main(String[] args){
   
      Cuenta miCuenta = new Cuenta(0, 0.0, "");
      Cuenta[] listaCuentas = new Cuenta[5];
      for (int i = 0; i < listaCuentas.length; i++) {
         listaCuentas[i] = new Cuenta(0, 0.0, "");
      }
      System.out.println(miCuenta.toString());
      System.out.println(Arrays.toString(listaCuentas));
      //Obtener el saldo del 2º elemento del array 	
      System.out.println(listaCuentas[1].getSaldo());
         //Modificar el saldo del último elemento del array para que valga 55.55 	
      listaCuentas[4].setSaldo(55.55);
         //Modificar el titular del objeto miCuenta para que valga "Alicia Garai" 	
      miCuenta.setTitular("Alicia Garai");
         //Ingresa 100 euros en la penultima cuenta de listaCuentas
      listaCuentas[3].ingresar(100.0);
      System.out.println(miCuenta.toString());
      System.out.println(Arrays.toString(listaCuentas));
      // System.out.println());
   }
}