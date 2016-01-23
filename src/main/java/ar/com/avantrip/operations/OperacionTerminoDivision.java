package ar.com.avantrip.operations;

/**
 * Created by Snakepit on 23/1/2016.
 */
public class OperacionTerminoDivision extends OperacionTermino {

    public OperacionTerminoDivision(Number valor) {
        super(valor);
    }

    @Override
    public Double resolver(Double parcial) {
        return parcial / getValor();
    }

    @Override
    public String toString() {
        return " / " + super.toString();
    }
}
