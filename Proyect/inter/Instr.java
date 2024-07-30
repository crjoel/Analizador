package inter; // Archivo Instr.java

public class Instr extends Nodo {
    
    // Constructor de la clase
    public Instr() { }

    // Instancia nula de Instr, utilizada cuando no hay ninguna instrucción
    public static Instr Null = new Instr();
    
    // Método que se llama con etiquetas de inicio y de finalización
    // Aquí, el método no hace nada, es un método base para ser sobrescrito
    public void gen(int b, int a) {}
    
    // Etiqueta que almacena el lugar después de la instrucción
    int despues = 0; 
    
    // Instancia estática de Instr.Null utilizada para instrucciones de tipo break
    public static Instr Circundante = Instr.Null; 
}
