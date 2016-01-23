import ar.com.avantrip.operations.OperacionMatematica;
import org.junit.Assert;
import org.junit.Test;

public class OperacionesTest {

    @Test
    /**
     * Suma basica
     */
    public void suma() {
        OperacionMatematica o = new OperacionMatematica();
        o.comenzar(2).mas(2);
        Double result = 4d;
        Assert.assertEquals(result, o.igual());
    }

    @Test
    /**
     * Resta basica
     */
    public void resta() {
        OperacionMatematica o = new OperacionMatematica();
        o.comenzar(2).menos(2);
        Double result = 0d;
        Assert.assertEquals(result, o.igual());
    }

    @Test
    /**
     * Multiplicacion basica
     */
    public void por() {
        OperacionMatematica o = new OperacionMatematica();
        o.comenzar(2).por(2);
        Double result = 4d;
        Assert.assertEquals(result, o.igual());
    }

    @Test
    /**
     * Division basica
     */
    public void dividido() {
        OperacionMatematica o = new OperacionMatematica();
        o.comenzar(2).dividido(2);
        Double result = 1d;
        Assert.assertEquals(result, o.igual());
    }

    @Test(expected=IllegalArgumentException.class)
    /**
     * Division por cero Exception
     */
    public void divididoPorCero() {
        OperacionMatematica o = new OperacionMatematica();
        o.comenzar(2).dividido(0);
    }

    @Test
    /**
     * Suma de 2 OperacionMatematica
     */
    public void sumaAnidada() {
        OperacionMatematica o = new OperacionMatematica();
        o.comenzar(2);

        OperacionMatematica o1 = new OperacionMatematica();
        o1.comenzar(2);

        o.mas(o1);

        Double result = 4d;
        Assert.assertEquals(result, o.igual());
    }

    @Test
    /**
     * * Resta de 2 OperacionMatematica
     */
    public void restaAnidada() {
        OperacionMatematica o = new OperacionMatematica();
        o.comenzar(2);

        OperacionMatematica o1 = new OperacionMatematica();
        o1.comenzar(2);

        o.menos(o1);

        Double result = 0d;
        Assert.assertEquals(result, o.igual());
    }

    @Test
    /**
     * * Multiplicacion de 2 OperacionMatematica
     */
    public void porAnidada() {
        OperacionMatematica o = new OperacionMatematica();
        o.comenzar(2);

        OperacionMatematica o1 = new OperacionMatematica();
        o1.comenzar(2);

        o.por(o1);

        Double result = 4d;
        Assert.assertEquals(result, o.igual());
    }

    @Test
    /**
     * * Division de 2 OperacionMatematica
     */
    public void divididoAnidada() {
        OperacionMatematica o = new OperacionMatematica();
        o.comenzar(2);

        OperacionMatematica o1 = new OperacionMatematica();
        o1.comenzar(2);

        o.dividido(o1);

        Double result = 1d;
        Assert.assertEquals(result, o.igual());
    }

    @Test
    /**
     * Calculo sugerido en el encunciado del ejercicio
     */
    public void calculoSugerido() {
        OperacionMatematica o = new OperacionMatematica();
        o.comenzar(5).por(3d).mas(2d).dividido(8d);

        Double result = 15.25d;
        Assert.assertEquals(result, o.igual());
    }

    @Test
    /**
     * Mismo ejercicio que el anterior, pero usando resta
     */
    public void calculoSugeridoResta() {
        OperacionMatematica o = new OperacionMatematica();
        o.comenzar(5).por(3d).menos(2d).dividido(8d);

        Double result = 14.75d;
        Assert.assertEquals(result, o.igual());
    }

    @Test
    /**
     * OperacionMatematica en formato de texto
     */
    public void probarCalculoToString() {
        OperacionMatematica o = new OperacionMatematica();
        o.comenzar(5).por(3).mas(2).dividido(8);

        String result = "5 * 3 + 2 / 8";
        Assert.assertEquals(result, o.toString());
    }

    @Test
    /**
     * OperacionMatematica en formato de texto con resta
     */
    public void probarCalculoToStringResta() {
        OperacionMatematica o = new OperacionMatematica();
        o.comenzar(5).por(3).menos(2).dividido(8);

        String result = "5 * 3 - 2 / 8";
        Assert.assertEquals(result, o.toString());
    }

    @Test
    /**
     * Calculo grande de prueba
     */
    public void calculoGrande() {
        OperacionMatematica o = new OperacionMatematica();
        o.comenzar(3).por(2).mas(5).por(1).menos(6).menos(3).mas(7).menos(8).mas(30).dividido(3);
        Double result = 11d;
        Assert.assertEquals(result, o.igual());
    }
}
