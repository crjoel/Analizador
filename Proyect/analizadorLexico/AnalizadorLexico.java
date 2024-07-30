package analizadorLexico; // Archivo AnalizadorLexico.java

import java.io.*; 
import java.util.*; 
import simbolos.*; // Asegúrate de que el paquete 'simbolos' esté disponible y definido correctamente

public class AnalizadorLexico {
    public static int linea = 1;
    char preanalisis = ' '; // Usar comillas simples para caracteres
    Hashtable<String, Palabra> palabras = new Hashtable<>(); // Especificar el tipo de clave y valor en el Hashtable

    void reservar(Palabra w) {
        palabras.put(w.lexema, w);
    }

    public AnalizadorLexico() {
        reservar(new Palabra("if", Etiqueta.IF));
        reservar(new Palabra("else", Etiqueta.ELSE));
        reservar(new Palabra("while", Etiqueta.WHILE));
        reservar(new Palabra("do", Etiqueta.DO));
        reservar(new Palabra("break", Etiqueta.BREAK));
        reservar(Palabra.True);
        reservar(Palabra.False);
        // Asumo que Tipo es una clase o enum con constantes
        reservar(Tipo.Int);
        reservar(Tipo.Char);
        reservar(Tipo.Bool);
        reservar(Tipo.Float);
    }

    void readch() throws IOException {
        preanalisis = (char) System.in.read(); // Lee el siguiente carácter de la entrada estándar
    }

    boolean readch(char c) throws IOException {
        readch();
        if (preanalisis != c) return false;
        preanalisis = ' ';
        return true;
    }

    public Token explorar() throws IOException {
        // Ignorar espacios en blanco y contar líneas
        for (; ; readch()) {
            if (preanalisis == ' ' || preanalisis == '\t') continue;
            else if (preanalisis == '\n') linea = linea + 1;
            else break;
        }

        // Identificar tokens basados en el carácter actual
        switch (preanalisis) {
            case '&':
                if (readch('&')) return Palabra.and;
                else return new Token('&');
            case '|':
                if (readch('|')) return Palabra.or;
                else return new Token('|');
            case '=':
                if (readch('=')) return Palabra.eq;
                else return new Token('=');
            case '!':
                if (readch('=')) return Palabra.ne;
                else return new Token('!');
            case '<':
                if (readch('=')) return Palabra.le;
                else return new Token('<');
            case '>':
                if (readch('=')) return Palabra.ge;
                else return new Token('>');
        }

        // Procesar números
        if (Character.isDigit(preanalisis)) {
            int v = 0;
            do {
                v = 10 * v + Character.digit(preanalisis, 10);
                readch();
            } while (Character.isDigit(preanalisis));
            
            // Procesar números con punto decimal
            if (preanalisis != '.') return new Num(v);

            float x = v; 
            float d = 10;
            for (;;) {
                readch();
                if (!Character.isDigit(preanalisis)) break;
                x = x + Character.digit(preanalisis, 10) / d;
                d = d * 10;
            }
            return new Real(x);
        }

        // Procesar identificadores y palabras clave
        if (Character.isLetter(preanalisis)) {
            StringBuilder b = new StringBuilder(); // Usa StringBuilder en lugar de StringBuffer para mejor rendimiento en casos simples
            do {
                b.append(preanalisis);
                readch();
            } while (Character.isLetterOrDigit(preanalisis));
            String s = b.toString();
            Palabra w = palabras.get(s);
            if (w != null) return w;
            w = new Palabra(s, Etiqueta.ID);
            palabras.put(s, w);
            return w;
        }

        // Retornar token para caracteres no reconocidos
        Token tok = new Token(preanalisis);
        preanalisis = ' ';
        return tok;
    }
}
