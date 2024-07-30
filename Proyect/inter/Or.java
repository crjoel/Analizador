package inter; // Archivo Or.java

import analizadorLexico.*; 
import simbolos.*;

public class Or extends Logica {

    // Constructor para la operación OR
    public Or(Token tok, Expr x1, Expr x2) {
        super(tok, x1, x2); // Llama al constructor de la clase base Logica
    }

    // Genera el código intermedio para la operación OR
    @Override
    public void salto(int t, int f) {
        int etiqueta = t != 0 ? t : nuevaEtiqueta(); // Usa la etiqueta de verdadero (t) si está disponible, o crea una nueva
        expr1.salto(etiqueta, 0); // Si expr1 es verdadero, salta a la etiqueta de verdadero
        expr2.salto(t, f); // Evalúa expr2; si expr2 es verdadero, salta a la etiqueta de verdadero, si es falso, salta a la etiqueta de falso
        if (t == 0) emitirEtiqueta(etiqueta); // Emite la etiqueta de verdadero si no se ha proporcionado
    }
}
