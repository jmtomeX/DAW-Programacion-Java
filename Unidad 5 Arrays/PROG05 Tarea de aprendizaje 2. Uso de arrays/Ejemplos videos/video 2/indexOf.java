public class indexOf {   
   public static void main(String args[]) {        
   
      String str_Sample = "Este es el índice del ejemplo";   
   
      // Carácter en la posición      
      System.out.println("Índice de caracteres 'x':" + str_Sample.indexOf('x'));       
   
      // Carácter en la posición después del valor de índice dado    
      System.out.println("Índice de caracteres 'después del índice 3:" + str_Sample.indexOf('s', 3));   
   
      // Dar posición de índice para la subcadena dada      
      System.out.println("Índice de subcadena 'es':" + str_Sample.indexOf("es"));     
   
      // Dar posición de índice para la subcadena dada y comenzar el índice     
      System.out.println("Index of substring 'es' form index:" + str_Sample.indexOf("es", 5));   
   }
}