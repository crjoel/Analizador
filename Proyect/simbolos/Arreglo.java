package simbolos; // Archivo Arreglo.java

import analizadorLexico.*;

public class Arreglo extends Tipo {
    public Tipo de; // Tipo de los elementos del arreglo
    public int tamanio = 1; // Número de elementos en el arreglo

    public Arreglo(int tm, Tipo p) {
        super("[]", Etiqueta.INDEX, tm * p.anchura); // Llama al constructor de Tipo con el nombre del tipo de arreglo, etiqueta INDEX y el tamaño total en bytes
        tamanio = tm; // Asigna el tamaño del arreglo
        de = p; // Asigna el tipo de los elementos del arreglo
    }

    @Override
    public String toString() {
        return "[" + tamanio + "] " + de.toString(); // Devuelve una representación en cadena del arreglo
    }
}
