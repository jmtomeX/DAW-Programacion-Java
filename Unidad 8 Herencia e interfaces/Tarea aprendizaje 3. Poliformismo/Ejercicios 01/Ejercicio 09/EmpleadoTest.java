import java.util.*;
import java.io.*;

public class EmpleadoTest {
   public static void main(String[] args) {
      
      Empleado ana1 = new Empleado("Ana Salas", "111111A");
      Empleado xabi = new Empleado("Xabier Arana", "222222B");
      Empleado ana2 = new Empleado("Ana Salas", "111111A");
      if (!ana1.equals(xabi)) System.out.println("DIFERENTES");
      if (ana1.equals(ana2)) System.out.println("IGUALES");
   }
}