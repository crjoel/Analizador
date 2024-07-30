package inter; // Archivo If.java

import simbolos.*;

public class If extends Instr {
    
    // Expresión condicional del if
    Expr expr;
    // Instrucción que se ejecuta si la condición es verdadera
    Instr instr;

    // Constructor de la clase If
    public If(Expr x, Instr s) {
        expr = x; 
        instr = s;
        // Verifica que la expresión sea de tipo booleano
        if (expr.tipo != Tipo.Bool) 
            expr.error("se requiere booleano en if");
    }

    // Método para generar código intermedio para la instrucción if
    public void gen(int b, int a) {
        // Genera una nueva etiqueta para el código de la instrucción
        int etiqueta = nuevaEtiqueta();
        // Emite el código para saltar a la etiqueta 'a' si la expresión es falsa
        expr.salto(0, a);
        // Emite la etiqueta para el código de la instrucción que se ejecuta si la expresión es verdadera
        emitirEtiqueta(etiqueta);
        // Genera el código para la instrucción a ejecutar si la condición es verdadera
        instr.gen(etiqueta, a);
    }
}
