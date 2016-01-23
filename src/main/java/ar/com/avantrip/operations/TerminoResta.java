package ar.com.avantrip.operations;

/**
 * Created by Snakepit on 23/1/2016.
 */
public class TerminoResta extends Termino {
    public TerminoResta() {
        super();
    }

    @Override
    public Double resolver(Double parcial) {
        Double result = 0d;
        for(OperacionTermino operaciones : getOperaciones()) {
            result = operaciones.resolver(result);
        }
        return parcial - result;
    }

    @Override
    public String toString() {
        return " - " + super.toString();
    }
}
