package inter; // Archivo EstElem.java

import analizadorLexico.*; 
import simbolos.*;

public class EstElem extends Instr {

    // Identificador del arreglo
    public Id arreglo;
    // Expresión que indica el índice del arreglo
    public Expr indice;
    // Expresión que proporciona el valor a asignar
    public Expr expr;

    // Constructor que inicializa el arreglo, el índice y la expresión
    public EstElem(Acceso x, Expr y) {
        arreglo = x.arreglo; 
        indice = x.indice; 
        expr = y;
        // Verifica que el tipo del elemento del arreglo y el tipo del valor sean compatibles
        if (comprobar(x.tipo, expr.tipo) == null) 
            error("error de tipo");
    }

    // Método para comprobar si los tipos son compatibles para la asignación
    public Tipo comprobar(Tipo p1, Tipo p2) {
        // Verifica que ninguno de los tipos sea un arreglo
        if (p1 instanceof Arreglo || p2 instanceof Arreglo) 
            return null;
        // Verifica si los tipos son iguales
        else if (p1 == p2) 
            return p2;
        // Verifica si ambos tipos son numéricos
        else if (Tipo.numerico(p1) && Tipo.numerico(p2)) 
            return p2;
        // Si los tipos no son compatibles, retorna null
        else 
            return null;
    }

    // Genera el código intermedio para la asignación de un valor a un elemento del arreglo
    public void gen(int b, int a) {
        String s1 = indice.reducir().toString(); // Reduce la expresión del índice y convierte a cadena
        String s2 = expr.reducir().toString(); // Reduce la expresión del valor y convierte a cadena
        // Emite el código de la asignación
        emitir(arreglo.toString() + " [ " + s1 + " ] = " + s2);
    }
}
