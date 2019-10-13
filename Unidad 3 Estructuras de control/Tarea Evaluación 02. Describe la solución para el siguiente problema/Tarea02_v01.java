/*
El programa elegirá al azar un valor y el usuario o usuaria introducirá el suyo. El programa dirá quién ha ganado.
El juego se repetirá hasta que el usuario decida acabar.
Al final, se visualizará cuántas partidas se han jugado, cuántas ha ganado el ordenador y cuántas el usuario o usuaria.
*/

import java.util.*;
public class Tarea02_v01 {
   public static final int PIEDRA = 0;
   public static final int PAPEL = 1;
   public static final int TIJERA = 2;
   public static final int EMPATE = 0;
   public static final int ORDENADOR_PIERDE = 1;
   public static final int ORDENADOR_GANA = -1;
   public static void main(String[] args){
      Scanner teclado = new Scanner(System.in);
      Random r = new Random();
      System.out.println(jugarPiedraPapelTijera(teclado, r));
   //Lo que se pide en esta pregunta es escribir el código que realizaría lo siguiente:
   // Introducir por teclado una de las 3 opciones: Piedra, Papel y Tijera
   // Comprobar quién ha ganado: el usuario o usuaria o el ordenador y mostrarlo por pantalla
   }
   public static int jugarPiedraPapelTijera(Scanner teclado, Random r){
      String jugar = "";
      jugar = jugar.toLowerCase();
      int usuarioEleccion = 0;
      int contUsuario = 0;
      int contMaquina = 0;
      int contadorPartidas = 0;
      while(!jugar.equals("FIN")){
      contadorPartidas++;
       // Introducir por teclado una de las 3 opciones: Piedra, Papel y Tijera
         System.out.println("Introduce una opción:\n Piedra (0)\n Papel  (1)\n Tijera (2) ");
         usuarioEleccion = teclado.nextInt();
         int maquinaEleccion = maquinaGenera(r);
       //Usuario gana -->> La piedra rompe la tijera || El papel envuelve la piedra || La tijera corta el papel 
         if(usuarioEleccion == PIEDRA && maquinaEleccion == TIJERA || usuarioEleccion == PAPEL && maquinaEleccion == PIEDRA || usuarioEleccion == TIJERA && maquinaEleccion == PAPEL ){
            contUsuario++;
         }
         //Usuario gana -->> La piedra rompe la tijera || El papel envuelve la piedra || La tijera corta el papel 
         else if(maquinaEleccion == PIEDRA && usuarioEleccion == TIJERA || maquinaEleccion == PAPEL && usuarioEleccion == PIEDRA || maquinaEleccion == TIJERA && usuarioEleccion == PAPEL ){
            contMaquina++;
         }
        //preguntar si desea continuar jugando, si inserta FIN termina el juego.
         System.out.print("¿Quiéres continuar con el juego, FIN para salir o un caracter para continuar?");
         jugar = teclado.next();
         jugar = jugar.toUpperCase();
         System.out.println();
      }//while
      //Mostramos el total de partidas, seria la suma de las partidas más 1 que es la primera partida.
      int partidasTotales = contMaquina + contUsuario;
      System.out.println("El total de partidas jugadas son " + contadorPartidas); 
      //mostramos la puntuación del ordenador
      String partidaS = " partida";
      if(contMaquina > 1){
         partidaS = " partidas" ;
      }
      System.out.println("El ordenador ha ganado " + contMaquina  + partidaS);
      //Mostramos quién ha ganado el juego
      if(contMaquina < contUsuario) {
         return  ORDENADOR_PIERDE;
      }else if(contUsuario == contMaquina) {
         return  EMPATE;
      }
      return ORDENADOR_GANA;
   }
    // Utilizar la clase Random para generar una de las 3 opciones al azar
   public static int maquinaGenera(Random r) {
      int tirada = r.nextInt(3);
      System.out.println("La máquina saco " + tirada);
      return tirada;
   }
}


   /*public static void ganadorEs(){
    if(contUsuario > contMaquina) {
            System.out.println("Ha ganado el usuario.");
      }else if(contUsuario < contMaquina) {
         System.out.println("Ha ganado la máquina.");
      }else if(contUsuario == contMaquina) {
         System.out.println("Ha habido un empate.");
   }*/

