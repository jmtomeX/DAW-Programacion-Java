/*José Mari Tomé, 24.09.2018, Programación, 1, Tarea Evaluación 01. Realiza un programa en Java (30%)
Enlace al documento
https://drive.google.com/file/d/1nTYtGxG8kpycXwM0MdzsSnnzCR7EhtAa/view?usp=sharing*/
public class Programa {//Creamos la Clase
  public static void main(String[] args) {
     //Mostramos por pantalla el primer parrafo
      System.out.println("Akerra ikusi dugu baratzean jaten.\nMakila ikusi dugu aker hori jotzen.");//Imprimimos las primeras líneas sin repetir
      makilak();//Usamos el método makilak
      
      //Mostramos por pantalla el segundo parrafo
      System.out.println("Sua ikusi dugu makila erretzen.\nUra ikusi dugu sua amatatzen.");//Imprimimos las primeras líneas sin repetir
      metod1();//Usamos el método urak
      makilak();//Usamos el método makilak
      
      //Mostramos por pantalla el tercer parrafo
      System.out.println("Idia ikusi dugu ur hori edaten.\nSoka ikusi dugu idi hori lotzen.");//Imprimimos las primeras líneas sin repetir
      metod2();//USamos el método sokak 
      makilak();//Usamos el método makilak
      
      //Mostramos por pantalla el cuarto parrafo
      System.out.println("Sagua ikusi dugu soka hori eteten.\nKatua ikusi dugu sagua harrapatzen.\nKatuak sagua, saguak soka,");//Imprimimos las primeras líneas sin repetir
      metod2();//USamos el método sokak
      makilak();//Usamos el método makilak
  }
   
   //Metodos
        
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
