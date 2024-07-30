package inter; // Archivo Arit.java

import analizadorLexico.*; 
import simbolos.*;

public class Arit extends Op {
    public Expr expr1, expr2; // Expresiones involucradas en la operación aritmética

    // Constructor de la clase Arit
    public Arit(Token tok, Expr x1, Expr x2) {
        super(tok, null); // Llama al constructor de Op con el token, tipo es inicializado después
        expr1 = x1;
        expr2 = x2;
        tipo = Tipo.max(expr1.tipo, expr2.tipo); // Determina el tipo resultante de la operación
        if (tipo == null) {
            error("Error de tipo"); // Maneja errores si los tipos son incompatibles
        }
    }

    // Genera una nueva expresión aritmética reducida
    @Override
    public Expr gen() {
        return new Arit(op, expr1.reducir(), expr2.reducir()); // Reduce las expresiones y crea una nueva instancia de Arit
    }

    // Representa la operación aritmética como una cadena
    @Override
    public String toString() {
        return expr1.toString() + " " + op.toString() + " " + expr2.toString(); // Devuelve la expresión en forma de cadena
    }
}
