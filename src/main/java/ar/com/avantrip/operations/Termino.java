package ar.com.avantrip.operations;


import java.util.ArrayList;
import java.util.List;

/**
 * Representa a un Termino dentro de una operacion matematica, la relacion es de 1 OperacionMatematica, muchos Terminos
 */
public class Termino extends OperacionMatematica {

    private List<OperacionTermino> operaciones;

    public Termino() {
        this.operaciones = new ArrayList<OperacionTermino>();
    }

    @Override
    public Double resolver(Double parcial) {
        for(OperacionTermino operacion : operaciones) {
            parcial = operacion.resolver(parcial);
        }
        return parcial;
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
        return sb.toString();
    }
}

