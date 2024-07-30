package simbolos; // Archivo Ent.java

import java.util.*;
import analizadorLexico.*;
import inter.*;

public class Ent {
    private Hashtable<Token, Id> tabla; // Especificar el tipo genérico
    protected Ent ant;

    public Ent(Ent n) {
        tabla = new Hashtable<>();
        ant = n;
    }

    public void put(Token w, Id i) {
        tabla.put(w, i);
    }

    public Id get(Token w) {
        for (Ent e = this; e != null; e = e.ant) { // Corregir 'Env' a 'Ent'
            Id encontro = e.tabla.get(w); // Cast a Id no necesario si el Hashtable tiene tipos genéricos
            if (encontro != null) return encontro;
        }
        return null;
    }
}
