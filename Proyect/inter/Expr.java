package inter; // Archivo Expr.java

import analizadorLexico.*;
import simbolos.*;

public class Expr extends Nodo {
    public Token op; // Token asociado con la expresión
    public Tipo tipo; // Tipo de la expresión

    // Constructor de la clase Expr
    Expr(Token tok, Tipo p) {
        op = tok;
        tipo = p;
    }

    // Método que genera una expresión
    public Expr gen() {
        return this;
    }

    // Método para reducir la expresión, por defecto no hace nada
    public Expr reducir() {
        return this;
    }

    // Método para manejar saltos condicionales en el código generado
    public void salto(int t, int f) {
        emitirsaltos(toString(), t, f);
    }

    // Método auxiliar para emitir instrucciones de salto
    public void emitirsaltos(String prueba, int t, int f) {
        if (t != 0 && f != 0) {
            emitir("if " + prueba + " goto L" + t);
            emitir("goto L" + f);
        } else if (t != 0) {
            emitir("if " + prueba + " goto L" + t);
        } else if (f != 0) {
            emitir("iffalse " + prueba + " goto L" + f);
        } else {
            // No se emite nada si ambos t y f son cero
        }
    }

    // Método para convertir el token en una cadena
    @Override
    public String toString() {
        return op.toString();
    }
}
