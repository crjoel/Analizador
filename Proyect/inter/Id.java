package inter; // Archivo Id.java

import analizadorLexico.*;
import simbolos.*;

public class Id extends Expr {
    public int desplazamiento; // Dirección relativa en memoria

    // Constructor de la clase Id
    public Id(Palabra id, Tipo p, int b) {
        super(id, p); // Llama al constructor de Expr con el token y tipo
        desplazamiento = b; // Asigna el desplazamiento
    }
}
