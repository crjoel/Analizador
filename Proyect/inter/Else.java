package inter; // Archivo Else.java

import simbolos.*;

public class Else extends Instr {
    
    // Expresión condicional para la instrucción if-else
    Expr expr;
    // Instrucción a ejecutar si la condición es verdadera
    Instr instr1;
    // Instrucción a ejecutar si la condición es falsa
    Instr instr2;

    // Constructor de la clase Else
    public Else(Expr x, Instr s1, Instr s2) {
        expr = x; 
        instr1 = s1; 
        instr2 = s2;
        // Verifica que la expresión sea de tipo booleano
        if (expr.tipo != Tipo.Bool) 
            expr.error("se requiere booleano en if");
    }

    // Método para generar código intermedio para la instrucción else
    public void gen(int b, int a) {
        // Genera una etiqueta para la instrucción cuando la expresión es verdadera
        int etiqueta1 = nuevaEtiqueta();
        // Genera una etiqueta para la instrucción cuando la expresión es falsa
        int etiqueta2 = nuevaEtiqueta();
        
        // Si la expresión es falsa, salta a la etiqueta2
        expr.salto(0, etiqueta2);
        // Si la expresión es verdadera, ejecuta la instrucción instr1 y luego salta a la etiqueta 'a'
        emitirEtiqueta(etiqueta1); 
        instr1.gen(etiqueta1, a); 
        emitir("goto L" + a);
        // Etiqueta para el bloque else, que se ejecuta si la expresión es falsa
        emitirEtiqueta(etiqueta2); 
        instr2.gen(etiqueta2, a);
    }
}
