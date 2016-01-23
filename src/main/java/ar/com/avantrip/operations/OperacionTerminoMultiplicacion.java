package ar.com.avantrip.operations;

/**
 * Created by Snakepit on 23/1/2016.
 */
public class OperacionTerminoMultiplicacion extends OperacionTermino {

    public OperacionTerminoMultiplicacion(Number valor) {
        super(valor);
    }

    @Override
    public Double resolver(Double parcial) {
        return parcial * getValor();
    }

    @Override
    public String toString() {
        return " * " + super.toString();
    }


}
