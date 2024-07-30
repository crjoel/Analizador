package analizadorLexico; // Archivo Token.java

public class Token {
    public final int etiqueta;

    public Token(int t) {
        etiqueta = t;
    }

    @Override
    public String toString() {
        return "" + (char)etiqueta; // Devuelve el carácter correspondiente a la etiqueta
    }
}
