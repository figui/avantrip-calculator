package ar.com.avantrip.operations;

import java.text.DecimalFormat;

/**
 * Representa a las operaciones dentro de un termino (generalmente son divisiones y multiplicaciones)
 */
public class OperacionTermino extends Termino{

    private Double valor;

    public OperacionTermino(Number valor) {
        this.valor = valor.doubleValue();
    }

    @Override
    public Double resolver(Double parcial) {
        return valor;
    }

    public Double getValor() {
        return valor.doubleValue();
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        DecimalFormat format = new DecimalFormat("0.#");
        return format.format(valor);

    }
}
