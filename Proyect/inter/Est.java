package inter; // Archivo Est.java

import analizadorLexico.*; 
import simbolos.*;

public class Est extends Instr {

    // Identificador de la variable a la que se le asignará un valor
    public Id id;
    // Expresión que proporciona el valor a asignar
    public Expr expr;

    // Constructor que inicializa el identificador y la expresión
    public Est(Id i, Expr x) {
        id = i; 
        expr = x;
        // Verifica que el tipo de la variable y el tipo de la expresión sean compatibles
        if (comprobar(id.tipo, expr.tipo) == null) 
            error("error de tipo");
    }

    // Método para comprobar si los tipos de la variable y la expresión son compatibles
    public Tipo comprobar(Tipo p1, Tipo p2) {
        // Si ambos tipos son numéricos, se permite la asignación
        if (Tipo.numerico(p1) && Tipo.numerico(p2)) 
            return p2;
        // Si ambos tipos son booleanos, se permite la asignación
        else if (p1 == Tipo.Bool && p2 == Tipo.Bool) 
            return p2;
        // Si los tipos no son compatibles, retorna null
        else 
            return null;
    }

    // Genera el código intermedio para la asignación
    public void gen(int b, int a) {
        // Emite el código de la asignación
        emitir(id.toString() + " = " + expr.gen().toString());
    }
}
