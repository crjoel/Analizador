package inter; // Archivo Temp.java

import analizadorLexico.*; 
import simbolos.*;

public class Temp extends Expr {
    static int conteo = 0; // Contador estático para generar números únicos
    int numero = 0; // Número de la variable temporal

    // Constructor de la clase Temp
    public Temp(Tipo p) {
        super(Palabra.temp, p); // Llama al constructor de Expr con el token para la variable temporal y el tipo
        numero = ++conteo; // Asigna un número único a la variable temporal
    }

    // Representa la variable temporal como una cadena
    @Override
    public String toString() {
        return "t" + numero; // Devuelve el nombre de la variable temporal (ej. t1, t2, t3, ...)
    }
}
