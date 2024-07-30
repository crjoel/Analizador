package inter; // Archivo Logica.java

import analizadorLexico.*; 
import simbolos.*;

public class Logica extends Expr {
    public Expr expr1, expr2;

    // Constructor para operaciones lógicas
    public Logica(Token tok, Expr x1, Expr x2) {
        super(tok, null); // Llama al constructor de Expr con el token, tipo se inicializa como null
        expr1 = x1;
        expr2 = x2;
        tipo = comprobar(expr1.tipo, expr2.tipo); // Comprueba el tipo de las expresiones
        if (tipo == null) {
            error("Error de tipo"); // Maneja errores si el tipo es incompatible
        }
    }

    // Método para comprobar si los tipos de las expresiones son booleanos
    public Tipo comprobar(Tipo p1, Tipo p2) {
        if (p1 == Tipo.Bool && p2 == Tipo.Bool) return Tipo.Bool; // Los dos tipos deben ser booleanos
        else return null;
    }

    // Genera código intermedio para la operación lógica
    @Override
    public Expr gen() {
        int f = nuevaEtiqueta(); // Etiqueta para falso
        int a = nuevaEtiqueta(); // Etiqueta para continuar
        Temp temp = new Temp(tipo); // Crea una nueva variable temporal para el resultado

        // Genera el código para la operación lógica
        expr1.salto(0, f); // Salta a la etiqueta f si expr1 es falso
        expr2.salto(0, f); // Salta a la etiqueta f si expr2 es falso
        emitir(temp.toString() + " = true"); // Si ambos son verdaderos, temp = true
        emitir("goto L" + a); // Salta a la etiqueta a para continuar
        emitirEtiqueta(f); // Etiqueta para el caso falso
        emitir(temp.toString() + " = false"); // Si alguno es falso, temp = false
        emitirEtiqueta(a); // Etiqueta para continuar

        return temp; // Devuelve la variable temporal
    }

    // Representa la operación lógica como una cadena
    @Override
    public String toString() {
        return expr1.toString() + " " + op.toString() + " " + expr2.toString(); // Devuelve la expresión en forma de cadena
    }
}
