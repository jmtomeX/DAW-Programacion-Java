/*
Escribe el código para un programa que pida 5 codigos con el siguiente formato:

3 letras mayúsculas
2 dígitos
1 letra mayúscula
Por ejemplo: FSP56B

Si el dato introducido cumple con el formato, lo almacenará en un ArrayList de cadenas de caracteres.

Finalmente muestra el contenido de la lista. Si los códigos introducidos son: ABC12D, PSW12d, ArL23B, GLA81M y 12ADR2


Prueba a utilizar un bucle for-each.

*/

import java.util.regex.*;     // Para poder usar patrones  
import java.util.*;
public class Ejercicio10 {
   public static void main(String[] args) {
      Scanner teclado = new Scanner(System.in);
      int contOK = 0;
      ArrayList<String> codigosOK = new ArrayList<String>();
      String codigo = "";
      Pattern formatoString = Pattern.compile("[A-Z]{3}[0-9]{2}[A-Z]{1}");
      Matcher comparaFormato ;
      while(contOK != 5) { 
         do {
            System.out.println("Escribe un código que contenga 3 letras mayúsculas, 2 dígitos, 1 letra mayúscula");
            codigo = teclado.next();
            comparaFormato = formatoString.matcher(codigo);
         }while(!comparaFormato.matches());
         codigosOK.add(codigo);
         contOK++;   
      }
      System.out.print(codigosOK);  
   }
      
}
