package inter; // Archivo Not.java

import analizadorLexico.*; 
import simbolos.*;

public class Not extends Logica {

    // Constructor para la operación NOT
    public Not(Token tok, Expr x2) {
        super(tok, x2, x2); // Inicializa la operación NOT con la misma expresión para expr1 y expr2
    }

    // Genera el código intermedio para la operación NOT
    @Override
    public void salto(int t, int f) {
        expr2.salto(f, t); // Invierte las etiquetas de verdadero y falso de expr2
    }

    @Override
    public String toString() {
        return op.toString() + " " + expr2.toString(); // Representa la expresión NOT como una cadena
    }
}
