package inter; // Archivo Break.java

public class Break extends Instr {
    
    // Referencia a la instrucción circundante (bucle) que se debe interrumpir
    Instr instr;

    // Constructor de la clase Break
    public Break() {
        // Verifica si hay una instrucción circundante válida
        if (Instr.Circundante == null) 
            error("break no encerrada");
        // Inicializa la instrucción circundante
        instr = Instr.Circundante;
    }

    // Genera el código intermedio para la instrucción break
    public void gen(int b, int a) {
        // Emite una instrucción para saltar a la etiqueta de salida del bucle
        emitir("goto L" + instr.despues);
    }
}
