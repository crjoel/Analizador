package inter; // Archivo Op.java

import analizadorLexico.*; // Corregido para incluir el asterisco para importaciones de todas las clases
import simbolos.*;

public class Op extends Expr {
    
    // Constructor de la clase Op
    public Op(Token tok, Tipo p) {
        super(tok, p); // Inicializa la clase base Expr con el token y tipo
    }

    // Método para reducir la expresión
    @Override
    public Expr reducir() {
        Expr x = gen(); // Genera la expresión base
        Temp t = new Temp(tipo); // Crea un nuevo objeto Temp para almacenar el resultado
        emitir(t.toString() + " = " + x.toString()); // Emite el código para la operación
        return t; // Devuelve el resultado como una nueva expresión
    }
}
