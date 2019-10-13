/*
   Analiza la información de distintos ADNs almacenados en un fichero
   Los resultados los guarda en otro fichero y los muestra por consola
*/

import java.util.*;     // Para el objeto Scanner
import java.io.*;       // Para trabajar con ficheros

public class ADN_V3_SOLUCION {

   // Constantes
   public static final int MIN_NUM_CODON = 5;
   public static final int PORCENTAJE_CG = 30;
   public static final int NUM_NUCLEOTIDOS = 4;
   public static final int NUCLEOTIDOS_POR_CODON = 3;

   // Array constante con las masas para poder realizar los cálculos con un bucle
   public static final double[] MASAS = {135.128, 111.103, 151.128, 125.107, 100};
   
   // String constante para identificar el índice de cada nucleótido con indexOf
   public static final String LETRAS = "ACGT-";
 
   // Método principal
   // Contiene el núcleo del programa. Abre los ficheros, proceso los datos y cierra los ficheros
   public static void main(String[] args) {
      Scanner leerTeclado = new Scanner(System.in);
      
      presentacion();

      Scanner leerFichero = null;
      PrintStream escribirFichero = null;
      try {
         // Abre fichero para leer
         File ficheroEntrada = abrirFichLectura(leerTeclado);
         leerFichero = new Scanner(ficheroEntrada);
         
         // Abre fichero para escribir
         escribirFichero = abrirFichSalida(leerTeclado, ficheroEntrada);     
               
         // Lee el fichero, lo procesa y escribe los resultado en el fichero y por consola
         while(leerFichero.hasNextLine()) {    
            String descripcion = leerFichero.nextLine();
            // Comprueba si la 2 línea existe
            if (leerFichero.hasNextLine()) {
               String linea = leerFichero.nextLine();
               procesaNucleotidos(linea, descripcion, escribirFichero);
            }
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
   // Parámetros: Scanner consola para leer datos por teclado.
   // Return: Objeto File obtenido a partir del nombre introducido
   public static File creaFichero(Scanner consola) {
      System.out.print("Introduce el nombre del fichero: ");
      String nombre = consola.nextLine();
      return new File(nombre);
   }

   // Obtiene un fichero válido a partir del nombre introducido por teclado.
   // Parámetros: Scanner teclado.
   // Return: File fichero válido.
   public static File abrirFichLectura(Scanner teclado) {
       File fichero = creaFichero(teclado);
       while (!fichero.exists() || !fichero.canRead()) {
         System.out.println("Fichero no válido. Inténtalo otra vez.");
         fichero = creaFichero(teclado);
      }
      return fichero;
   }

   // Obtiene el fichero de salida a partir del nombre introducido por teclado.
   // Comprueba que el fichero para la salida sea diferente del fichero de entrada.
   // Parámetros: Scanner teclado, File ficheroEntrada.
   // Return: PrintStream con la conexión al fichero válido para la salida.
   public static PrintStream abrirFichSalida(Scanner teclado, File ficheroEntrada) throws FileNotFoundException {
      File fichero = creaFichero(teclado);
      while (fichero.equals(ficheroEntrada)) {
         System.out.println("El fichero de salida no puede ser el mismo que el de entrada.");
         System.out.println("Inténtalo otra vez.");
         fichero = creaFichero(teclado);
      }

      return new PrintStream(fichero);
   }
   
   // Procesa la línea con la información de la secuencia de nucleótidos
   // La muestra por pantalla y la guarda en el fichero
   // Parámetros:
   //    String linea: secuencia de nucleóstidos a procesar
   //    String titulo: descripción de la secuencia
   //    PrintStream escribirFichero: conexión al fichero de salida
   // Return: no se devuelve nada
   public static void procesaNucleotidos(String secuencia, String titulo, PrintStream escribirFichero) {     
      secuencia = secuencia.toUpperCase();
      
      // Recorremos la linea y miramos cada carácter para contar los nucleótidos y calcular la masa total
      
      int[] contadorConGuiones = contarTipos(secuencia);

      // Calcula el porcentaje de masa de cada nucleotido respecto del total
      double[] masaNucleotidos = new double[NUM_NUCLEOTIDOS];
      double masaTotal = calcularMasa(contadorConGuiones, masaNucleotidos);
       
      // Separa los codones
      String[] codones = separaCodones(secuencia);
      
      // Comprueba si es una proteina o no
      boolean esProteina = detectaProteina(codones, masaNucleotidos);
      
      // Muestra los resultados
      // Hace una copia de array de contadores con "basura" sin ella.
      int[] contadorNucleotidos = Arrays.copyOf(contadorConGuiones, 4);
      escribirFichero(escribirFichero, titulo, secuencia, contadorNucleotidos, masaNucleotidos, masaTotal,
               codones, esProteina);
      escribirFichero(System.out, titulo, secuencia, contadorNucleotidos, masaNucleotidos, masaTotal,
               codones, esProteina);
   }
   
   // Método que cuenta cuántos nucleótidos hay de cada tipo en una secuencia. 
   // Parámetros:
   //    String linea: la secuencia de nucleótidos.
   // Devuelve un array con las cantidades de cada nucleótido. 
   public static int[] contarTipos(String linea) {
      int[] contador = new int[NUM_NUCLEOTIDOS + 1];
      for (int i = 0; i < linea.length(); i++) {
         char caracter = linea.charAt(i);
         contador[LETRAS.indexOf(caracter)]++;                      
      }     
      return contador;  
   }
   
   // Método que calcula la masa total y los porcentajes de masa de cada uno de los tipos de nucleótidos
   // Parámetros:
   //    el array de contadores de tipos, incluidos el 'basura'; el String correspondiente a la secuencia de nucleótidos
   //y el array de porcentajes de masas. NO devuelve nada.
   public static double calcularMasa(int[] contadorConGuiones, double[] porcentajes) { 
           
      double masaTotal = 0;
      for (int i = 0; i < contadorConGuiones.length; i++) {
         masaTotal += contadorConGuiones[i] * MASAS[i];                
      } 
      
      for (int i = 0; i < NUM_NUCLEOTIDOS; i++) {
         double masa = contadorConGuiones[i] * MASAS[i] * 100 / masaTotal;
         porcentajes[i] = (double) Math.round(masa * 10) / 10;
      }
      
      return masaTotal;
   }
      
   /*
      Separa la secuencia en grupos de NUCLEOTIDOS_POR_CODON (3)
      para generar los codones
      Parámetros:
         String linea: secuencia de nucleóstidos a procesar
      Return: devuelve un array de String con los codones obtenidos
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
      Si no se cumple alguna de las condiciones devuelve "NO". Si se cumplen todas "SI".
      Parámetros:
         String[] codones: array con los codones de la secuencia
         double[] masaNucleotidos: array con los porcentajes de masa de cada nucléotido
      Return: devuelve un String que devuelve "NO" si no se cumple alguna de las condiciones.
      "SI" en caso contrario.
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
      
      double masaCG = masaNucleotidos[LETRAS.indexOf('C')] + masaNucleotidos[LETRAS.indexOf('G')];
      if (masaCG < PORCENTAJE_CG) {
         return false;
      }
      
      return true;
   }

   /*
      Escribe los resultados en un PrintStream. Puede ser un fichero o la consola
      Parámetros:
         PrintStream escribirFichero: destino donde se escribirán los resultados
         String titulo: descripción de la secuencia
         String linea: secuencia que se ha precesado
         int[] contNucleotidos: array con la cantidad de nucléotido de cada tipo
         double[]pesoNucleotidos: array con los porcentajes de masa de cada nucléotido
         double masa: Masa total de la secuencia
         String[] codones: array con los codones de la secuencia
         String esProteina: cadena que valdrá "SI" si es una proteína, "NO" en caso contrario
      Return: No devuelve nada.
   */
   public static void escribirFichero(PrintStream escribirFichero, String titulo, String linea,
            int[] contNucleotidos, double[]pesoNucleotidos, double masa, String[] codones, boolean esProteina) {
      escribirFichero.println("Descripción: " + titulo);
      escribirFichero.println("Nucleótidos: " + linea);
      escribirFichero.println("Contadores: " + Arrays.toString(contNucleotidos));
      escribirFichero.printf("Masa (%%): %s de %.1f\n", Arrays.toString(pesoNucleotidos), masa);
      escribirFichero.println("Lista Codones: " + Arrays.toString(codones));
      escribirFichero.print("Es proteina: ");
      if (esProteina) {
         escribirFichero.println("SI");
      } else {
         escribirFichero.println("NO");
      }
      escribirFichero.println();

   }
}