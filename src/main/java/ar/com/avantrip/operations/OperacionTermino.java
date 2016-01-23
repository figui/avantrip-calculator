package ar.com.avantrip.operations;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Representa a las operaciones dentro de un termino (generalmente son divisiones y multiplicaciones)
 */
public class OperacionTermino extends Termino{

    private int tipo;
    private double valor;

    public OperacionTermino(int tipo, double valor) {
        super(tipo);
        this.tipo = tipo;
        this.valor = valor;
    }

    public Double resolver() {
        return valor;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        DecimalFormat format = new DecimalFormat("0.#");
        if(tipo == Calculable.PRIMER_OPERACION) {
            return format.format(valor).concat(" ");
        } else if(tipo == Calculable.MULTIPLICADO) {
            return "* ".concat(format.format(valor));
        } else {
            return "/ ".concat(format.format(valor));
        }

    }
}
