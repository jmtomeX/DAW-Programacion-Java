//Deberás incluir un comentario al principio con información básica (Nombre, fecha, módulo, UD, Tarea) y la descripción del programa.
 /*
 Enlace documento
 -->> https://drive.google.com/open?id=1Xi3kTOXZL381qgkUkQWTw8f-L5-SvR0L
 Jose Mari Tome Mejias.
 10/10/2018.
 Programación.
 Und 1. Tarea Evaluación 03. Realiza un programa en Java.
 */
 
/* Dibuja la siguiente figura

     /**\
    //**\\
   ///**\\\
  ////**\\\\
 /////**\\\\\
+=*=*=*=*=*=*+
|../\..../\..|
|./\/\../\/\.|
|/\/\/\/\/\/\|
|\/\/\/\/\/\/|
|.\/\/..\/\/.|
|..\/....\/..|
+=*=*=*=*=*=*+
|\/\/\/\/\/\/|
|.\/\/..\/\/.|
|..\/....\/..|
|../\..../\..|
|./\/\../\/\.|
|/\/\/\/\/\/\|
+=*=*=*=*=*=*+
     /**\
    //**\\
   ///**\\\
  ////**\\\\
 /////**\\\\\
 
 */
public class Cohete{
   public static  final int ALTURA_LINEAS = 3; //Constante nº filas. Se añadiran +2 al for de la punta y la cola.
   public static int linea = 0; //Añadimos la variable línea para poder usarla en todos los métodos.
   public static void main(String[] args){
      System.out.println("Dibuja la siguiente figura\n");
      flechaCohete();
      franjaCohete();
      cuerpoReverso();
      cuerpoInverso();
      franjaCohete();
      cuerpoInverso();
      cuerpoReverso();
      franjaCohete();
      flechaCohete();  
   } 
   
   //Metodos
   public static void franjaCohete(){
      System.out.print("+");
      for(int i =0; i < 6; i++){
         System.out.print("=*");
      }
      System.out.println("+");
   }
   public static void flechaCohete(){ //
   
   /*Generamos  el número de lineas.
   Se añaden +2 al for de la punta y la cola porque tiene dos líneas más que los demás.*/
      for( linea = 1; linea <= (ALTURA_LINEAS + 2) ; linea++){   
         for(int espacio = 1; espacio <= -1 * linea +6; espacio++){//Se añaden espacios en blanco decrecientes  5 4 3 2 1
            System.out.print(" ");
         }
         for(int i = 1; i <= linea; i++){//Se añaden / en incremento 1 2 3 4 5
            System.out.print("/");
         }
         System.out.print("**");
         for(int j = 1; j<= linea ; j++){//Se añaden \ en incremento 1 2 3 4 5
            System.out.print("\\");
         }
         System.out.println();
      }
      linea = 0;// para que no se vaya acumulando la reiniciamos, aunque en los métodos se pone a 1.
   }
   public static void cuerpoReverso(){ 
       //Generamos el número de lineas.
      for(linea =1; linea <= ALTURA_LINEAS; linea++){
         System.out.print("|");
         puntoReverso();
         trianguloReverso();
         for(int i = 1; i <= -2 * linea + 6; i++){//Imprimos los puntos centrales decrecientes 4 2 0
            System.out.print(".");
         }
         trianguloReverso();
         puntoReverso();
         System.out.println("|");
      }
      linea = 0;// para que no se vaya acumulando la reiniciamos, aunque en los métodos se pone a 1.
   }
  //Métodos para el cuerpoReveerso
   public static void trianguloReverso(){
      for(int j = 1; j <= linea; j++){//Imprimimos "/\" creciente 1 2 3
         System.out.print("/\\"); 
      }
   }
  
   public static void puntoReverso(){
      for(int i = 1; i <= -linea + 3; i++){//Imprimimos "." decreciente 3 2 1
         System.out.print(".");
      }
   }
    //FIN Métodos para el cuerpoReveerso
    
   public static void cuerpoInverso(){ 
    //Generamos  el número de lineas.
      for(linea = 1; linea <= ALTURA_LINEAS; linea++){
         System.out.print("|");
         puntoInverso(); 
         trianguloInverso();
         for(int i = 1; i <= 2 * linea -2; i++){//Imprimos los puntos centrales crecientes  0 2 4
            System.out.print(".");
         }
         trianguloInverso();
         puntoInverso(); 
         System.out.println("|");
      }
   }
      //Métodos para el cuerpoInverso
   public static void trianguloInverso(){
      for(int i = 1; i <= - linea + 4; i++){//Imprimimos "\/" decreciente 3 2 1
         System.out.print("\\/");
      }
   } 
   public static void puntoInverso(){
      for(int j = 1; j <= linea - 1; j++){//Imprimimos "." creciente 1 2 3
         System.out.print(".");
      }    
   }
   //FIN Métodos para el cuerpoInverso
}

