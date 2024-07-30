package inter; // Archivo Acceso.java

import analizadorLexico.*; 
import simbolos.*;

public class Acceso extends Op {

    public Id arreglo;  // Identificador del arreglo
    public Expr indice; // Expresión que indica el índice

    // Constructor para inicializar el acceso al arreglo
    public Acceso(Id a, Expr i, Tipo p) { 
        super(new Palabra("[]", Etiqueta.INDEX), p); // Inicializa el tipo de operación como acceso a arreglo
        arreglo = a; 
        indice = i;
    }

    // Genera el código intermedio para el acceso al arreglo
    @Override
    public Expr gen() { 
        // Genera un nuevo acceso con el índice reducido
        return new Acceso(arreglo, indice.reducir(), tipo); 
    }

    // Emite el código para saltos condicionales, si es necesario
    @Override
    public void salto(int t, int f) { 
        // Emite los saltos condicionales basados en el acceso reducido
        emitirsaltos(reducir().toString(), t, f); 
    }

    // Representa el acceso al arreglo como una cadena de texto
    @Override
    public String toString() {
        return arreglo.toString() + " [ " + indice.toString() + " ]"; 
    }
}
