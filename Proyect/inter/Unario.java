package inter; // Archivo Unario.java

import analizadorLexico.*; 
import simbolos.*;

public class Unario extends Op {
    public Expr expr; // Expresión que se opera unariamente

    // Constructor de la clase Unario
    public Unario(Token tok, Expr x) {
        super(tok, null); // Llama al constructor de Op con el token para la operación unaria
        expr = x;
        tipo = Tipo.max(Tipo.Int, expr.tipo); // Determina el tipo resultante de la operación
        if (tipo == null) {
            error("Error de tipo"); // Maneja errores si el tipo es incompatible
        }
    }

    // Genera una nueva expresión unaria reducida
    @Override
    public Expr gen() {
        return new Unario(op, expr.reducir()); // Reduce la expresión y crea una nueva instancia de Unario
    }

    // Representa la operación unaria como una cadena
    @Override
    public String toString() {
        return op.toString() + " " + expr.toString(); // Devuelve la expresión en forma de cadena
    }
}
