/*
   Analiza la información de distintos ADNs almacenados en un fichero
   Los resultados los guarda en otro fichero y los muestra por consola
*/

import java.util.*;     // Para el objeto Scanner
import java.io.*;       // Para trabajar con ficheros

public class ADN_V2_SOLUCION {

   // Constantes
   public static final int MIN_NUM_CODON = 5;
   public static final int PORCENTAJE_CG = 30;
   public static final int NUM_NUCLEOTIDOS = 4;
   public static final int NUCLEOTIDOS_POR_CODON = 3;
   
   // Array constante con las masas para poder realizar los cálculos con un bucle
   public static final double[] MASAS = {135.128, 111.103, 151.128, 125.107};
   
   // String constante para identificar el índice de cada nucleótido con indexOf
   public static final String LETRAS = "ACGT";
   
   // Método principal
   public static void main(String[] args) {
      Scanner leerTeclado = new Scanner(System.in);
      
      presentacion();

      Scanner leerFichero = null;
      PrintStream escribirFichero = null;
      try {
         // Abre fichero para leer. Supone que todo va bien
         leerFichero = new Scanner(creaFichero(leerTeclado));
         
         // Abre fichero para escribir. Supone que todo va bien
         escribirFichero = new PrintStream(creaFichero(leerTeclado));     
               
         // Lee el fichero, lo procesa y escribe los resultado en el fichero y por consola
         while(leerFichero.hasNextLine()) {    
            String titulo = leerFichero.nextLine();
            String linea = leerFichero.nextLine();
            procesaNucleotidos(linea, titulo, escribirFichero);
         }
      } catch (Exception e) {
         System.out.println("Se ha producido un error: " + e.getMessage());
      }
      
      // Cierra los ficheros
      if (leerFichero != null) {
         leerFichero.close();
      }
      if (escribirFichero != null) {
         escribirFichero.close();
      }

   }
   
   // Muestra información sobre lo que hace el programa
   public static void presentacion() {
      System.out.println("Este programa genera información sobre");
      System.out.println("secuencias de nucleótidos de ADN contenidas en un fichero");
      System.out.println("También indicará si pueden codificar proteinas o no");
      System.out.println("Todos los resultados se guardarán en un fichero");
      System.out.println();
   }
   
   //Pide el nombre del fichero y crea el objeto File 
   public static File creaFichero(Scanner consola) {
      System.out.print("Introduce el nombre del fichero: ");
      String nombre = consola.nextLine();
      return new File(nombre);
   }
   
   // Procesa la línea con la información de la secuencia de nucleótidos
   public static void procesaNucleotidos(String linea, String titulo, PrintStream escribirFichero) {     
      linea = linea.toUpperCase();
      
      // Recorremos la linea y miramos cada carácter para contar los nucleótidos y calcular la masa total
      int[] contNucleotidos = new int[NUM_NUCLEOTIDOS];
      double masaTotal = contarNucleotido(contNucleotidos, linea);
      
      // Calcula el porcentaje de masa de cada nucleotido respecto del total
      double[] masaNucleotidos = calculaMasas(masaTotal, contNucleotidos);
       
      // Separa los codones
      String[] codones = separaCodones(linea);
      
      // Comprueba si es una proteina o no
      String esProteina = detectaProteina(codones, masaNucleotidos);
      
      // Muestra los resultados
      escribirFichero(escribirFichero, titulo, linea, contNucleotidos, masaNucleotidos, masaTotal,
               codones, esProteina);
      escribirFichero(System.out, titulo, linea, contNucleotidos, masaNucleotidos, masaTotal,
               codones, esProteina);
   }
   
   /*
      Cuenta cuántos nucleótidos de cada tipo hay y la masa total de la secuencia
   */
   public static double contarNucleotido(int[] contNucleotidos, String linea) {
      double masa = 0;
      for(int i = 0; i < linea.length(); i++) {
         char letra = linea.charAt(i);
         if (letra == '-') {     // "basura"
            masa += 100;
         } else {                // Nucleótidos
            int indice = LETRAS.indexOf(letra);
            contNucleotidos[indice]++;
            masa += MASAS[indice];
         }
      }
      
      return masa;
   }
   
   /*
      Cálcula el porcentaje de masa de cada nucleotido 
   */
   public static double[] calculaMasas(double masaTotal, int[] contNucleotidos) {
      double[] masaNucleo = new double[NUM_NUCLEOTIDOS];
      for(int i = 0; i < contNucleotidos.length; i++) {
         double masa = contNucleotidos[i] * MASAS[i] / masaTotal * 100;
         masaNucleo[i] = Math.round(masa * 10) / 10.0;
      }
      return masaNucleo;
   }
   
   /*
      Separa la secuencia en grupos de NUCLEOTIDOS_POR_CODON (3)
      para generar los codones
   */
   public static String[] separaCodones(String linea) {
      // Elimina los guiones de la secuencia
      linea = linea.replace("-", "");
      
      // Crea el array para los codones
      String[] codones = new String[linea.length() / NUCLEOTIDOS_POR_CODON];
      
      // Lo recorre para ir guardando las sucadenas de NUCLEOTIDOS_POR_CODON caracteres
      // Actualiza la línea y se queda solo con el resto de caracteres
      for(int i = 0; i < codones.length; i++) {
         codones[i] = linea.substring(0, NUCLEOTIDOS_POR_CODON);
         linea = linea.substring(NUCLEOTIDOS_POR_CODON);
      }
      return codones;
   }

   /*
      Comprueba si la secuencia de codones es una proteina o no
      - Comienza por un codon válido (ATG) 
      - Termina con un codon válido (TAA, TAG o TGA) 
      - Contiene al menos MIN_NUM_CODON (5) codones 
      - El porcentaje de masa de la citosina (C) y la guanina (G) es al menos del PORCENTAJE_CG (30%)
      Si no se cumple alguna de las condiciones devuelve false. Si se cumplen todas true.
   */
   public static String detectaProteina(String[] codones, double[] masaNucleotidos) {
      if (!codones[0].equals("ATG")) {
         return "NO";
      }
      
      String ultimoCodon = codones[codones.length - 1];
      if (!ultimoCodon.equals("TAA") && !ultimoCodon.equals("TAG") && !ultimoCodon.equals("TGA")) {
         return "NO";
      }
      
      if (codones.length < MIN_NUM_CODON) {
         return "NO";
      }
      
      double masaCG = masaNucleotidos[LETRAS.indexOf('C')] + masaNucleotidos[LETRAS.indexOf('G')];
      if (masaCG < PORCENTAJE_CG) {
         return "NO";
      }
      
      return "SI";
   }

   /*
      Escribe los resultados en un PrintStream
      Puedes ser un fichero o la consola
   */
   public static void escribirFichero(PrintStream escribirFichero, String titulo, String lineaOriginal,
            int[] contNucleotidos, double[]pesoNucleotidos, double masa, String[] codones, String esProteina) {
      escribirFichero.println("Descripción: " + titulo);
      escribirFichero.println("Nucleótidos: " + lineaOriginal);
      escribirFichero.println("Contadores: " + Arrays.toString(contNucleotidos));
      escribirFichero.printf("Masa (%%): %s de %.1f\n", Arrays.toString(pesoNucleotidos), masa);
      escribirFichero.println("Lista Codones: " + Arrays.toString(codones));
      escribirFichero.println("Es proteina: " + esProteina);
      escribirFichero.println();

   }
}