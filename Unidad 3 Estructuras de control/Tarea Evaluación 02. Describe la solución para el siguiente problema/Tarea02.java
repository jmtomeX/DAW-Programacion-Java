/*
El programa elegirá al azar un valor y el usuario o usuaria introducirá el suyo. El programa dirá quién ha ganado.
El juego se repetirá hasta que el usuario decida acabar.
Al final, se visualizará cuántas partidas se han jugado, cuántas ha ganado el ordenador y cuántas el usuario o usuaria.
*/

import java.util.*;
public class Tarea02 {
   public static final int PIEDRA = 0;
   public static final int PAPEL = 1;
   public static final int TIJERA = 2;
   public static final int EMPATE = 0;
   public static final int ORDENADOR_PIERDE = 1;
   public static final int ORDENADOR_GANA = -1;
   public static void main(String[] args){
      Scanner teclado = new Scanner(System.in);
      Random r = new Random();
      jugarPiedraPapelTijera(teclado, r);
   //Lo que se pide en esta pregunta es escribir el código que realizaría lo siguiente:
   // Introducir por teclado una de las 3 opciones: Piedra, Papel y Tijera
   // Comprobar quién ha ganado: el usuario o usuaria o el ordenador y mostrarlo por pantalla
   }
   public static int jugarPiedraPapelTijera(Scanner teclado, Random r){
      String jugar = "si";
      jugar = jugar.toLowerCase();
      int usuarioEleccion = 0;
      int contUsuario = 0;
      int contMaquina = 0;
      while(jugar.equals("si")){
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
        //preguntar si desea continuar jugando
         System.out.print("¿Quiéres continuar con el juego?");
         jugar = teclado.next();
         jugar = jugar.toLowerCase();
         System.out.println();
      }//while
      //mostramos la puntuación de los jugadores
      System.out.println("El usuario ha sacado " + contUsuario + " punto y la máquina " + contMaquina + " punto");
      //Mostramos quién ha ganado el juego
      int resultado; 
      if(contMaquina < contUsuario) {
         resultado = ORDENADOR_PIERDE;
      }else if(contUsuario < contMaquina) {
         resultado =  ORDENADOR_GANA;
      }else if(contUsuario == contMaquina) {
         resultado= EMPATE;
      }
      return resultado;
   }
    // Utilizar la clase Random para generar una de las 3 opciones al azar
   public static int maquinaGenera(Random r) {
      int tirada = r.nextInt(3);
      System.out.println("La máquina saco " + tirada);
      return tirada;
   }
   
   /*public static void ganadorEs(){
    if(contUsuario > contMaquina) {
            System.out.println("Ha ganado el usuario.");
      }else if(contUsuario < contMaquina) {
         System.out.println("Ha ganado la máquina.");
      }else if(contUsuario == contMaquina) {
         System.out.println("Ha habido un empate.");
   }*/
}