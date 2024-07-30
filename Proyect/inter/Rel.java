package inter; // Archivo Rel.java

import analizadorLexico.*; 
import simbolos.*;

public class Rel extends Logica {

    // Constructor para operaciones relacionales
    public Rel(Token tok, Expr x1, Expr x2) {
        super(tok, x1, x2); // Llama al constructor de Logica con las dos expresiones
    }

    // Comprueba si los tipos de las expresiones son compatibles para la operación relacional
    @Override
    public Tipo comprobar(Tipo p1, Tipo p2) {
        // Las comparaciones entre arreglos no están permitidas
        if (p1 instanceof Arreglo || p2 instanceof Arreglo) return null;
        // Los tipos deben ser iguales para una comparación
        else if (p1 == p2) return Tipo.Bool;
        else return null;
    }

    // Genera el código intermedio para la operación relacional
    @Override
    public void salto(int t, int f) {
        Expr a = expr1.reducir(); // Reduce expr1 a código intermedio
        Expr b = expr2.reducir(); // Reduce expr2 a código intermedio
        String prueba = a.toString() + " " + op.toString() + " " + b.toString(); // Crea la expresión de prueba
        emitirsaltos(prueba, t, f); // Emite los saltos condicionales
    }
}
