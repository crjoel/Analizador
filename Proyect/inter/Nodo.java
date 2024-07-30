package inter; // Archivo Nodo.java

import analizadorLexico.*;

public class Nodo {
    int linealex = 0; // Línea actual en el análisis
    static int etiquetas = 0; // Contador estático para etiquetas

    Nodo() {
        linealex = AnalizadorLexico.linea; // Inicializa la línea del nodo
    }

    void error(String s) {
        throw new Error("Cerca de la línea " + linealex + ": " + s); // Usa linealex en lugar de lineales
    }

    public int nuevaEtiqueta() {
        return ++etiquetas; // Incrementa y devuelve una nueva etiqueta
    }

    public void emitirEtiqueta(int i) {
        System.out.print("L" + i + ":"); // Imprime una etiqueta
    }

    public void emitir(String s) {
        System.out.println("\t" + s); // Imprime una línea de código
    }
}
