package inter; // Archivo Sec.java

public class Sec extends Instr {

    // Primer instrucción en la secuencia
    Instr instr1; 
    // Segunda instrucción en la secuencia
    Instr instr2;

    // Constructor que inicializa ambas instrucciones
    public Sec(Instr s1, Instr s2) { 
        instr1 = s1; 
        instr2 = s2; 
    }

    // Genera el código intermedio para las dos instrucciones en secuencia
    public void gen(int b, int a) {
        // Si la primera instrucción es null, solo genera la segunda instrucción
        if (instr1 == Instr.Null) 
            instr2.gen(b, a);
        // Si la segunda instrucción es null, solo genera la primera instrucción
        else if (instr2 == Instr.Null) 
            instr1.gen(b, a);
        else {
            // Genera una etiqueta para la transición entre las dos instrucciones
            int etiqueta = nuevaEtiqueta();
            // Genera la primera instrucción
            instr1.gen(b, etiqueta);
            // Emite la etiqueta que indica el punto de transición
            emitirEtiqueta(etiqueta);
            // Genera la segunda instrucción
            instr2.gen(etiqueta, a);
        }
    }
}
