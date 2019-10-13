/*José Mari Tomé, 24.09.2018, Programación, 1, Tarea Evaluación 01. Realiza un programa en Java (30%)
Enlace al documento
https://drive.google.com/file/d/1nTYtGxG8kpycXwM0MdzsSnnzCR7EhtAa/view?usp=sharing*/
public class AkerraIkusiDugu {//Creamos la Clase
  public static void main(String[] args) {
     //Mostramos por pantalla el primer parrafo
      noRepeat1();//Usamos el método noRepeat1
            
      //Mostramos por pantalla el segundo parrafo
      noRepeat2();//Usamos el método noRepeat2
      
      //Mostramos por pantalla el tercer parrafo
      noRepeat3();//Usamos el método noRepeat3
         
      //Mostramos por pantalla el cuarto parrafo
      noRepeat4();//Usamos el método noRepeat4
  }
   
   //Métodos
   //Métodos de parrafos que no se repiten
      public static void noRepeat1(){
         System.out.println("Akerra ikusi dugu baratzean jaten.\nMakila ikusi dugu aker hori jotzen.");//Creamos un método que imprima las primeras líneas sin repetir del primer parrafo
         makilak();//Usamos el método makilak
      }
      
       public static void noRepeat2(){
         System.out.println("Sua ikusi dugu makila erretzen.\nUra ikusi dugu sua amatatzen.");//Creamos un método que imprima las primeras líneas sin repetir del segundo parrafo
         metod1();//Usamos el método urak
         makilak();//Usamos el método makilak
      }
      
       public static void noRepeat3(){
         System.out.println("Idia ikusi dugu ur hori edaten.\nSoka ikusi dugu idi hori lotzen.");//Creamos un método que imprima las primeras líneas sin repetir del tercer parrafo
         metod2();//USamos el método sokak 
         makilak();//Usamos el método makilak
      }
      
       public static void noRepeat4(){
         System.out.println("Sagua ikusi dugu soka hori eteten.\nKatua ikusi dugu sagua harrapatzen.\nKatuak sagua, saguak soka,");//Creamos un método que imprima las primeras líneas sin repetir del cuarto parrafo
         metod2();//USamos el método sokak
         makilak();//Usamos el método makilak
      }  
      
      //Métodos de parrafos que se repiten
      public static void metod1(){
         System.out.println("Urak sua, suak makilak,");
      }
      
      public static void metod2(){
         System.out.println("Sokak idia, idiak ura,");
          metod1();
         
      }
      
     public static void makilak(){
        System.out.println("Makilak akerra, akerrak artoa,\nakerra ken.\nBaratzetik akerra ken,\nken, ken, ken, ken.");
        System.out.println();
      }
    
}