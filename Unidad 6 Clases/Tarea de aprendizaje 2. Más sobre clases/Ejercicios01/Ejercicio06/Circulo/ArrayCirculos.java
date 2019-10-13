public class ArrayCirculos {
   // Atributos
   Circulo[] lista;
   
   // Constructor
   public ArrayCirculos(double radio, String color, int num) {
      lista = new Circulo[num];
      for (int i = 0; i < lista.length; i++) {
      
         // Crear un nuevo objeto de la clase Circulo
         Circulo nuevoCirculo = new Circulo(radio, color);
         
         // Lo asigna al elemento actual del array
         lista[i] = nuevoCirculo;
      }
   }
   
   // Metodos
   public void setCirculo(int num, double radio, String color) {
      lista[num - 1].setColor(color);
      lista[num - 1].setRadio(radio);   
   }
   
   public String toString() {
      String formato = "";
      for (int i = 0; i < lista.length; i++) {      
         formato += (i + 1) + ": " + lista[i] + "\n";                  
      }
      return formato;
   }
   
   // METODO QUE HAY QUE CORREGIR
   public  int contarColor(String color) {
      int cont = 0;
      for (int i = 0; i < lista.length; i++) {
         if (lista[i].getColor().equals(color)) {
            cont++;
         }
      }
      return cont;
   }   
   
   public String colorMayor(){
      String colorMayor = "";
      double circuloMayor = lista[1].getRadio();
      for(int i = 0; i < lista.length;i++){
         circuloMayor = Math.max(circuloMayor, lista[i].getRadio());
      
         if(circuloMayor == lista[i].getRadio()){
            colorMayor = lista[i].getColor();
         }
      }
      return colorMayor;
   }
   //Corrige el método colorMayor para que identifique el Circulo de mayor área y devuelva su color. 
   //Si hay varios Circulos de igual tamaño se devolverá el color del primero en el array.
   public  String colorMayorMod() {
      double mayor = 0.0;
      String color = "";
      for (int i = 0; i < lista.length; i++) {
         double area = lista[i].calculaArea();
         if (area > mayor) {
            mayor = area;
            color = lista[i].getColor();
         }
      }
      return color;
   }
}