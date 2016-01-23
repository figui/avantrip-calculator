package ar.com.avantrip.operations;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa a toda la operacion matematica entera
 */
public class OperacionMatematica implements Calculable {

    private List<Termino> terminos;

    public OperacionMatematica() {
        this.terminos = new ArrayList<Termino>();
    }

    /**
     * Implemetacion de Calculable
     * @return
     */
    @Override
    public Double resolver(Double parcial) {
        for(Termino termino : terminos) {
            parcial = termino.resolver(parcial);
        }
        return parcial;
    }



    /**
     * Metodo de suma, arroja IllegalArgumentException si la operacion no comenzó con el metodo "comenzar()"
     * @param n
     * @return
     */
    public OperacionMatematica mas(Number n) {
        if(terminos.isEmpty()) { throw new IllegalArgumentException("Las operaciones matematicas deben empezar con el metodo \"comenzar()\""); }
        Termino t = new TerminoSuma();
        OperacionTermino o = new OperacionTermino(n);
        t.getOperaciones().add(o);
        terminos.add(t);
        return this;
    }

    /**
     * Metodo de suma para anidar OperacionesMatematicas
     * @param o
     * @return
     */
    public OperacionMatematica mas(OperacionMatematica o) {
        mas(o.igual());
        return this;
    }

    /**
     * * Metodo de resta, arroja IllegalArgumentException si la operacion no comenzó con el metodo "comenzar()"
     * @param n
     * @return
     */
    public OperacionMatematica menos(Number n){
        if(terminos.isEmpty()) { throw new IllegalArgumentException("Las operaciones matematicas deben empezar con el metodo \"comenzar()\""); }
        Termino t = new TerminoResta();
        OperacionTermino o = new OperacionTermino(n);
        t.getOperaciones().add(o);
        terminos.add(t);
        return this;
    }

    /**
     * Metodo de resta para anidar OperacionesMatematicas
     * @param o
     * @return
     */
    public OperacionMatematica menos(OperacionMatematica o) {
        menos(o.igual());
        return this;
    }

    /**
     * * Metodo de division, arroja IllegalArgumentException si el parametro n es igual a 0"
     * @param d
     * @return
     */
    public OperacionMatematica dividido(Number d) {
        if(d.doubleValue() == 0) { throw new IllegalArgumentException("No se puede hacer divisiones por 0"); }
        OperacionTermino o = new OperacionTerminoDivision(d);
        terminos.get(terminos.size() - 1).getOperaciones().add(o);
        return this;
    }

    /**
     * Metodo de division para anidar OperacionesMatematicas
     * @param o
     * @return
     */
    public OperacionMatematica dividido(OperacionMatematica o) {
        dividido(o.igual());
        return this;
    }

    /**
     * Metodo de multiplicacion
     * @param d
     * @return
     */
    public OperacionMatematica por(Number d) {
        OperacionTermino o = new OperacionTerminoMultiplicacion(d);
        terminos.get(terminos.size() - 1).getOperaciones().add(o);
        return this;
    }

    /**
     * Metodo de multiplicacion para anidar OperacionesMatematicas
     * @param o
     * @return
     */
    public OperacionMatematica por(OperacionMatematica o) {
        por(o.igual());
        return this;
    }

    /**
     * Metodo para comenzar una operacion matematica, si anteriormente se realizo una cuenta, el metodo limpia la operacion anterior y comienza de nuevo
     * @param d
     * @return
     */
    public OperacionMatematica comenzar(Number d) {
        // limpio los terminos por si anteriormente se hizo una cuenta
        if(!terminos.isEmpty()) { terminos.clear(); }
        Termino t = new Termino();
        OperacionTermino o = new OperacionTermino(d);
        t.getOperaciones().add(o);
        terminos.add(t);
        return this;
    }

    public Number igual() {
        return resolver(0d);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for(Termino termino : terminos) {
            sb.append(termino.toString());
        }
        return sb.toString();
    }
}
