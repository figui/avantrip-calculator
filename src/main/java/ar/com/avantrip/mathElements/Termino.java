package ar.com.avantrip.mathElements;


import java.util.ArrayList;
import java.util.List;

/**
 * Representa a un Termino dentro de una operacion matematica, la relacion es de 1 OperacionMatematica, muchos Terminos
 */
public class Termino implements Calculable {

    private int tipo;
    private List<OperacionTermino> operaciones;

    public Termino(int tipo) {
        this.operaciones = new ArrayList<OperacionTermino>();
        this.tipo = tipo;
    }

    public Double resolver() {
        double result = 0d;
        for(OperacionTermino operacion : operaciones) {
            if(operacion.getTipo() == Calculable.PRIMER_OPERACION) {
                result += operacion.resolver();
            } else if(operacion.getTipo() == Calculable.DIVIDIDO) {
                result /= operacion.resolver();
            } else if(operacion.getTipo() == Calculable.MULTIPLICADO) {
                result *= operacion.resolver();
            }
        }
        return result;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public List<OperacionTermino> getOperaciones() {
        return operaciones;
    }

    public void setOperaciones(List<OperacionTermino> operaciones) {
        this.operaciones = operaciones;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for(OperacionTermino operacion : operaciones) {
            sb.append(operacion.toString());
        }
        if(tipo == Calculable.PRIMER_TERMINO) {
            return sb.toString().concat(" ");
        } else if(tipo == Calculable.SUMA) {
            return "+ ".concat(sb.toString());
        } else {
            return "- ".concat(sb.toString());
        }
    }
}

