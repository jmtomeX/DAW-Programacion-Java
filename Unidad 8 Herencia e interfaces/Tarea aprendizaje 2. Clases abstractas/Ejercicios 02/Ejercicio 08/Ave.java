public abstract class Ave {
    protected char sexo;
    protected int edad;
    
    Ave(char sexo, int edad){
        this.sexo = sexo;
        this.edad = edad;
    }
    
    public String toString(){
        return "Sexo: " + sexo + " Edad: " + edad;
    }
   
   public String trinar() {
      return "Piopio";
   }
}