package ar.com.avantrip.operations;

/**
 * Created by Snakepit on 23/1/2016.
 */
public class TerminoSuma extends Termino {

    public TerminoSuma() {
        super();
    }

    @Override
    public Double resolver(Double parcial) {
        Double result = 0d;
        for(OperacionTermino operacion : getOperaciones()) {
            result = operacion.resolver(result);
        }
        return parcial + result;
    }

    @Override
    public String toString() {
        return " + " + super.toString();
    }
}
