/*
 El resultado será:

Javier Salas (111111JJ) Ventas: 60000,00 Comision: 40,00
24000.0
*/
public class EmpleadoComisionMain {

   public static void main(String[] args) {
   
      EmpleadoComision javier = new EmpleadoComision("Javier Salas", "111111JJ", 60000, 40);
      System.out.println(javier);
      System.out.println(javier.salario());
   }
}