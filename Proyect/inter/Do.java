package inter; // Archivo Do.java

import simbolos.*;

public class Do extends Instr {
    
    // Expresión condicional para el bucle do-while
    Expr expr;
    // Instrucción a ejecutar en cada iteración del bucle
    Instr instr;

    // Constructor vacío
    public Do() { 
        expr = null; 
        instr = null; 
    }

    // Inicializa la instrucción y la expresión condicional
    public void inic(Instr s, Expr x) {
        expr = x; 
        instr = s;
        // Verifica que la expresión sea de tipo booleano
        if (expr.tipo != Tipo.Bool) 
            expr.error("se requiere booleano en do");
    }

    // Genera código intermedio para el bucle do-while
    public void gen(int b, int a) {
        despues = a; // Guarda la etiqueta 'a', que es el punto de salida del bucle
        int etiqueta = nuevaEtiqueta(); // Genera una nueva etiqueta para la condición
        instr.gen(b, etiqueta); // Genera el código para la instrucción del bucle
        emitirEtiqueta(etiqueta); // Emite la etiqueta para la condición del bucle
        expr.salto(b, 0); // Evalúa la condición del bucle; si es verdadera, salta a la etiqueta 'b'
    }
}
