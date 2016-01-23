package ar.com.avantrip.operations;

/**
 * Created by Snakepit on 22/1/2016.
 */
public interface Calculable {

    int SUMA = 0;
    int RESTA = 1;
    int MULTIPLICADO = 2;
    int DIVIDIDO = 3;
    int PRIMER_TERMINO = 4;
    int PRIMER_OPERACION = 5;

    Double resolver(Double parcial);
}
