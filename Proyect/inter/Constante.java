package inter; // Archivo Constante.java

import analizadorLexico.*; 
import simbolos.*;

public class Constante extends Expr {
    // Constructor para constantes generales
    public Constante(Token tok, Tipo p) {
        super(tok, p); // Llama al constructor de Expr con el token y el tipo
    }

    // Constructor para constantes enteras
    public Constante(int i) {
        super(new Num(i), Tipo.Int); // Crea un token Num y lo pasa al constructor de Expr con tipo Int
    }

    // Constantes booleanas predefinidas
    public static final Constante
        True = new Constante(Palabra.True, Tipo.Bool),
        False = new Constante(Palabra.False, Tipo.Bool);

    // Maneja los saltos en el código generado
    @Override
    public void salto(int t, int f) {
        if (this == True && t != 0) {
            emitir("goto L" + t); // Salta a la etiqueta t si la constante es True
        } else if (this == False && f != 0) {
            emitir("goto L" + f); // Salta a la etiqueta f si la constante es False
        }
    }
}
