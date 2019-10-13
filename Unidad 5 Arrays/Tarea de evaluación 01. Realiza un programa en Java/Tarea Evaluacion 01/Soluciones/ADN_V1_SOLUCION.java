/*
   Analiza la información de distintos ADNs almacenados en un fichero
   Los resultados los guarda en otro fichero y los muestra por consola
*/

import java.util.*;     // Para el objeto Scanner
import java.io.*;       // Para trabajar con ficheros

public class ADN_V1_SOLUCION {

   // Constantes
   public static final int MIN_NUM_CODON = 5;
   public static final int PORCENTAJE_CG = 30;
   public static final int NUM_NUCLEOTIDOS = 4;
   public static final int NUCLEOTIDOS_POR_CODON = 3;
   
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
            String titulo = leerFichero.nextLine();    // Lee la descripción
            String linea = leerFichero.nextLine();     // Lee la secuencia de nucleótidos
            procesaNucleotidos(linea, titulo, escribirFichero);
         }
      } catch (Exception e) {
         System.out.println("Se ha producido el error: " + e.getMessage());
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
      int basura = contarNucleotido(contNucleotidos, linea);
      
      // Calcula el porcentaje de masa de cada nucleotido respecto del total
      double[] masaNucleotidos = new double[NUM_NUCLEOTIDOS];
      double masaTotal = calculaMasas(basura, contNucleotidos, masaNucleotidos);
       
      // Separa los codones
      String[] codones = separaCodones(linea);
      
      // Comprueba si es una proteina o no
      String esProteina = "NO";
      if (detectaProteina(codones, masaNucleotidos)){
         esProteina = "SI";
      }
      
      // Muestra los resultados
      escribirFichero(escribirFichero, titulo, linea, contNucleotidos, masaNucleotidos, masaTotal,
               codones, esProteina);
      escribirFichero(System.out, titulo, linea, contNucleotidos, masaNucleotidos, masaTotal,
               codones, esProteina);
   }
   
   /*
      Cuenta cuántos nucleótidos de cada tipo hay y cuanta "basura" en la secuencia
   */
   public static int contarNucleotido(int[] nucleotidos, String linea) {
      int basura = 0;
      for(int i = 0; i < linea.length(); i++) {
         char letra = linea.charAt(i);
         switch (letra) {
            case 'A':
               nucleotidos[0]++;
               break;
            case 'C':
               nucleotidos[1]++;
               break;
            case 'G':
               nucleotidos[2]++;
               break;
            case 'T':
               nucleotidos[3]++;
               break;
            case '-':
               basura++;
               break;
         }    
      }
      return basura;   
   }
   
   /*
      Cálcula la masa total y el porcentaje de masa de cada nucleotido 
   */
   public static double calculaMasas(int basura, int[] nucleotidos, double[] masa) {
      masa[0] = nucleotidos[0] * 135.128;
      masa[1] = nucleotidos[1] * 111.103;
      masa[2] = nucleotidos[2] * 151.128;
      masa[3] = nucleotidos[3] * 125.107;
      
      //For que suma todos los valores de la variable para sacar el total masa
      //y despues del for anado la el total de basura.
      double masaTotal = basura * 100;
      for(int i = 0; i < masa.length; i++) {
         masaTotal += masa[i];   
      }
      
      //for para convertir en porcentaje todos los valores de el array masa y
      //redondear el numero a 1 decimal
      for(int i = 0; i < masa.length; i++) {
         masa[i] = masa[i] * 100 / masaTotal;
         masa[i] = Math.round(masa[i] * 10) / 10.0;      
      }
      return masaTotal;
   }
   
   /*
      Separa la secuencia en grupos de NUCLEOTIDOS_POR_CODON (3)
      para generar los codones
   */
   public static String[] separaCodones(String secuencia) {
      // Elimina los guiones de la secuencia
      secuencia = secuencia.replace("-", "");
      
      // Crea el array para los codones
      int numCodones = secuencia.length() / NUCLEOTIDOS_POR_CODON;
      String[] codones = new String[numCodones];
      
      // Lo recorre para ir guardando las sucadenas de NUCLEOTIDOS_POR_CODON caracteres
      // Actualiza la línea y se queda solo con el resto de caracteres
      int codon = 0;
      for(int i = 0; i < secuencia.length(); i = i + NUCLEOTIDOS_POR_CODON) {
         codones[codon] = secuencia.substring(i, i + NUCLEOTIDOS_POR_CODON);
         codon++;
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
   public static boolean detectaProteina(String[] codones, double[] masaNucleotidos) {
      if (!codones[0].equals("ATG")) {
         return false;
      }
      
      String ultimoCodon = codones[codones.length - 1];
      if (!ultimoCodon.equals("TAA") && !ultimoCodon.equals("TAG") && !ultimoCodon.equals("TGA")) {
         return false;
      }
      
      if (codones.length < MIN_NUM_CODON) {
         return false;
      }
      
      double masaCG = masaNucleotidos[1] + masaNucleotidos[2];
      if (masaCG < PORCENTAJE_CG) {
         return false;
      }
      
      return true;
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