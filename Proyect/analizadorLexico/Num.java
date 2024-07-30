package analizadorLexico; // Archivo Num.java

public class Num extends Token {
    public final int valor;

    public Num(int v) {
        super(Etiqueta.NUM); // Inicializa el token con la etiqueta NUM
        valor = v;
    }

    @Override
    public String toString() {
        return "" + valor; // Devuelve el valor del número como una cadena
    }
}
