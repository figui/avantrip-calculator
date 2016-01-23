import ar.com.avantrip.mathElements.OperacionMatematica;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Snakepit on 22/1/2016.
 */
public class OperacionesTests {

    @Test
    public void suma() {
        OperacionMatematica o = new OperacionMatematica();
        o.comenzar(2).mas(2);
        Double result = 4d;
        Assert.assertEquals(result, o.igual());
    }

    @Test
    public void resta() {
        OperacionMatematica o = new OperacionMatematica();
        o.comenzar(2).menos(2);
        Double result = 0d;
        Assert.assertEquals(result, o.igual());
    }

    @Test
    public void por() {
        OperacionMatematica o = new OperacionMatematica();
        o.comenzar(2).por(2);
        Double result = 4d;
        Assert.assertEquals(result, o.igual());
    }

    @Test
    public void dividido() {
        OperacionMatematica o = new OperacionMatematica();
        o.comenzar(2).dividido(2);
        Double result = 1d;
        Assert.assertEquals(result, o.igual());
    }

    @Test(expected=IllegalArgumentException.class)
    public void divididoPorCero() {
        OperacionMatematica o = new OperacionMatematica();
        o.comenzar(2).dividido(0);
    }

    @Test
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
    public void calculoSugerido() {
        OperacionMatematica o = new OperacionMatematica();
        o.comenzar(5).por(3).mas(2).dividido(8);

        Double result = 15.25d;
        Assert.assertEquals(result, o.igual());
    }

    @Test
    public void probarCalculoToString() {
        OperacionMatematica o = new OperacionMatematica();
        o.comenzar(5).por(3).mas(2).dividido(8);

        String result = "5 * 3 + 2 / 8";
        Assert.assertEquals(result, o.toString());
    }
}
