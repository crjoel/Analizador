package inter; // Archivo While.java

import simbolos.*;

public class While extends Instr {
    
    // Expresión condicional para el bucle while
    Expr expr;
    // Instrucción a ejecutar en cada iteración del bucle
    Instr instr;

    // Constructor vacío
    public While() { 
        expr = null; 
        instr = null; 
    }

    // Inicializa la expresión condicional y la instrucción del bucle
    public void inic(Expr x, Instr s) {
        expr = x; 
        instr = s;
        // Verifica que la expresión sea de tipo booleano
        if (expr.tipo != Tipo.Bool) 
            expr.error("se requiere booleano en while");
    }

    // Genera código intermedio para el bucle while
    public void gen(int b, int a) {
        despues = a; // Guarda la etiqueta 'a', que es el punto de salida del bucle
        // Emite código para saltar a la etiqueta 'a' si la expresión es falsa
        expr.salto(0, a);
        // Genera una nueva etiqueta para el comienzo del bucle
        int etiqueta = nuevaEtiqueta();
        emitirEtiqueta(etiqueta); // Etiqueta para el código del cuerpo del bucle
        // Genera el código para la instrucción del bucle y salta de vuelta a la etiqueta 'b'
        instr.gen(etiqueta, b);
        emitir("goto L" + b); // Salta de vuelta al comienzo del bucle
    }
}
