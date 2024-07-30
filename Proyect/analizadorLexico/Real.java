package analizadorLexico; // Archivo Real.java

public class Real extends Token {
    public final float valor;

    public Real(float v) {
        super(Etiqueta.REAL); // Inicializa la etiqueta con la constante REAL
        valor = v;
    }

    @Override
    public String toString() {
        return "" + valor; // Devuelve el valor como una cadena
    }
}
