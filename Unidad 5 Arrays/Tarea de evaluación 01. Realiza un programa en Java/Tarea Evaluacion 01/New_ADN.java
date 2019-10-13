/***********************************************************************************************

 Nombre:  Jose Mari Tome Mejias.
 Fecha :  //2019.
 Módulo:  Programación.
 Tarea:   PROG05 Tarea de evaluación 01. Realiza un programa en Java
 
 Descripción del programa:Esta tarea se centra en el manejo de arrays, ficheros y cadenas de caracteres y necesitará 2 ficheros de texto, dna.txt y ecoli.txt,
 que se deberán guardar en la misma carpeta en la que guardamos el programa.
    En concreto el programa leerá ficheros que contienen secuencias de nucleótidos y generará información útil sobre ellos, simulando el trabajo de los biólogos computacionales.
    Los nucleótidos son los elementos que forman el ADN y pueden ser de cuatro tipos diferentes: adenina (A), timina (T), citosina (C) y guanina (G).
    El ADN adopta una forma de doble hélice en la que una A siempre se enfrenta a una T y una C a una G.        

 Enlace aoutoevaluación: 
     
*************************************************************************************************/ 
import java.util.*;
import java.io.*;
public class New_ADN {
//Número mínimo de codones de una proteina 
   public static final int CODONESMIN = 5;
 //Porcentaje de masa de Citosina y Guananina juntas
   public static final int PORCENTAJECG = 30; 
 //Número de tipos de nucleótidos
   public static final int TIPOSNUCLEOTIDOS = 4;
 //Número de nucleótidos por codon
   public static final int NUCLEOTIDOSXCODON = 3;
     //Valores de las masas unitarias
      //  [0] A = 135.128; // ADENINA
      //  [1] C = 111.103; // CITOSINA
      //  [2] G = 151.128; // GUNANINA
      //  [3] T = 125.107; // TIMINA
      //  [4] B = 100.0; //BASURA -
   public static final double[] valoresNucleotidos = {135.128, 111.103, 151.128, 125.107, 100.0};
   public static void main(String[] args) throws FileNotFoundException{
      Scanner teclado = new Scanner(System.in);
   
      introduccion();
   //Gestiona cualquier excepción que ocurra mientras se lee el fichero.
      Scanner leerFichero = null;
      try{  //Si el fichero no se abre correctamente se producirá una excepción.
         leerFichero = abrirFicheroEntrada(teclado);
         int contadorLinea = 0;
         while(leerFichero.hasNextLine()){
            contadorLinea++;
            String linea = leerFichero.nextLine();
            Scanner leerLinea = new Scanner(linea);
           
           //comprobamos que es la  línea par que es la última de cada grupo en el archivo.
            if(contadorLinea % 2 == 0){
               System.out.print("Nucleótidos: ");
            }else{//es la primera línea de cada grupo de datos.
               System.out.print("Descripción: ");
            }              
         //mientras que tenga para leer palabras las leerá  
            while(leerLinea.hasNext()) {
               String palabra = leerLinea.next();
               if(contadorLinea % 2 == 0){
               
                  System.out.print(palabra.toUpperCase() + " ");
                 
               }else{
                  System.out.print(palabra.toLowerCase()+ " ");
                  
               }
            }  
            System.out.println();
         } 
      
      } catch (Exception e) {
         System.out.println(e.getMessage());//Muestra que excepción ha ocurrido
      }
      //Cierra el fichero si la conexión se ha realizado
      if(leerFichero != null) {
         leerFichero.close();
      }   
      
   
   }
  /*************** MÉTODOS **************************/
   public static void introduccion(){
      System.out.println("Este programa genera información sobre\nsecuencias de nucleótidos de ADN contenidas en un fichero");
      System.out.println("También indicará si pueden codificar proteinas o no\nTodos los resultados se guardarán en un fichero");
      System.out.println();
   } 
        //Abrir el fichero de entrada.
   public static Scanner abrirFicheroEntrada (Scanner teclado) throws FileNotFoundException {
      System.out.println("Introduce el nombre del fichero: ");
      String nombre = teclado.nextLine();
   //Comprobamos que el fichero se pueda leer si no pedirá otro.
      File ficheroEntrada = new File(nombre);
      while(!ficheroEntrada.canRead()){
         System.out.println("Fichero no encontrado.");
         System.out.print("Nombre del fichero: ");
         nombre = teclado.nextLine();
         ficheroEntrada = new File(nombre);
      }
      //Abre le fichero y lo devuelve
      return new Scanner(ficheroEntrada);
   }
   
}