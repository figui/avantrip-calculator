package ar.com.avantrip.mathElements;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa a toda la operacion matematica entera
 */
public class OperacionMatematica implements Calculable {

    private List<Termino> terminos;
    private DecimalFormat format;

    public OperacionMatematica() {
        this.terminos = new ArrayList<Termino>();
        this.format = new DecimalFormat("0.#");
    }

    /**
     * Implemetacion de Calculable
     * @return
     */
    public Double resolver() {
        Double result = 0d;
        for(Termino termino : terminos) {
            if(termino.getTipo() == Termino.PRIMER_TERMINO ||termino.getTipo() == Calculable.SUMA) {
                result += termino.resolver();
            } else if(termino.getTipo() == Calculable.RESTA) {
                result -= termino.resolver();
            }
        }
        return result;
    }

    /**
     * Metodo de suma, arroja IllegalArgumentException si la operacion no comenzó con el metodo "comenzar()"
     * @param n
     * @return
     */
    public OperacionMatematica mas(double n) {
        if(terminos.isEmpty()) { throw new IllegalArgumentException("Las operaciones matematicas deben empezar con el metodo \"comenzar()\""); }
        Termino t = new Termino(Calculable.SUMA);
        OperacionTermino o = new OperacionTermino(Calculable.PRIMER_OPERACION, n);
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
    public OperacionMatematica menos(double n){
        if(terminos.isEmpty()) { throw new IllegalArgumentException("Las operaciones matematicas deben empezar con el metodo \"comenzar()\""); }
        Termino t = new Termino(Calculable.RESTA);
        OperacionTermino o = new OperacionTermino(Calculable.PRIMER_OPERACION, n);
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
    public OperacionMatematica dividido(double d) {
        if(d == 0) { throw new IllegalArgumentException("No se puede hacer divisiones por 0"); }
        OperacionTermino o = new OperacionTermino(Calculable.DIVIDIDO, d);
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
    public OperacionMatematica por(double d) {
        OperacionTermino o = new OperacionTermino(Calculable.MULTIPLICADO, d);
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
    public OperacionMatematica comenzar(double d) {
        if(!terminos.isEmpty()) { terminos.clear(); } // limpio los terminos por si anteriormente se hizo una cuenta
        Termino t = new Termino(Termino.PRIMER_TERMINO);
        OperacionTermino o = new OperacionTermino(Calculable.PRIMER_OPERACION, d);
        t.getOperaciones().add(o);
        terminos.add(t);
        return this;
    }

    public Double igual() {
        return resolver();
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
