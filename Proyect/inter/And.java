package inter; // Archivo And.java

import analizadorLexico.*; 
import simbolos.*;

public class And extends Logica {

    // Constructor para la operación AND
    public And(Token tok, Expr x1, Expr x2) {
        super(tok, x1, x2); // Llama al constructor de la clase base Logica
    }

    // Genera el código intermedio para la operación AND
    @Override
    public void salto(int t, int f) {
        int etiqueta = f != 0 ? f : nuevaEtiqueta(); // Usa la etiqueta de falso (f) si está disponible, o crea una nueva
        expr1.salto(0, etiqueta); // Si expr1 es falso, salta a la etiqueta de falso
        expr2.salto(t, f); // Evalúa expr2; si expr2 es verdadero, salta a la etiqueta de verdadero, si es falso, salta a la etiqueta de falso
        if (f == 0) emitirEtiqueta(etiqueta); // Emite la etiqueta de falso si no se ha proporcionado
    }
}
