public class Ejercicio10{
   public static void main(String[] args){
      String cadena1 = "La Vuelta al Mundo en 80 Días";
      String cadena2 = "20000 Leguas de Viaje Submarino";
      System.out.println( "cadena1 --> La Vuelta al Mundo en 80 Días\ncadena2 --> 20000 Leguas de Viaje Submarino");
      System.out.println();
      System.out.println("cadena1.length()" +  cadena1.length()); 	
   
      System.out.println("cadena1.substring(6)" + cadena1.substring(6));	
   
      System.out.println("cadena2.toUpperCase()" + cadena2.toUpperCase());
   
      System.out.println("cadena2.substring(13,27) " + cadena2.substring(13,27) );	
   
      System.out.println("cadena1.toLowerCase()" + cadena1.toLowerCase());
   
      System.out.println("cadena2.replace(Leguas', 'Millas')" + cadena2.replace("Leguas", "Millas") );	
   
      System.out.println("cadena1.charAt(5)" + cadena1.charAt(5));	
   
      System.out.println("cadena1.replace(\"a\", \"e\")" + 	cadena1.replace("a", "e") );	
   
      System.out.println("cadena2.charAt(10)" + cadena2.charAt(10));	
   
      System.out.println("cadena2.substring(cadena2.indexOf('S'))" + cadena2.substring(cadena2.indexOf("S")) );	
   
      System.out.println("cadena2.indexOf(\"V\")" + cadena2.indexOf("V"));	
   
      System.out.println("cadena2.toUpperCase().indexOf('U')" + 	cadena2.toUpperCase().indexOf('U') 	);
   
      System.out.println("cadena1.indexOf(\"V\")" + cadena1.indexOf('V'));
   
      System.out.println("cadena1.substring(0,9).toLowerCase()" + cadena1.substring(0,9).toLowerCase());
      
   }
}