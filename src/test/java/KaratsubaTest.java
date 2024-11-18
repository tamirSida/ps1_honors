import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.math.BigInteger;

public class KaratsubaTest {

    @Test
    public void testKaratsubaMultNormalCase() {
        BigInteger a = new BigInteger("123456789");
        BigInteger b = new BigInteger("987654321");
        BigInteger expected = a.multiply(b);
        BigInteger result = karatsuba.karatsuba_mult(a, b);
        assertEquals(expected, result);
    }

    @Test
    public void testKaratsubaMultSmallNumbers() {
        BigInteger a = new BigInteger("12");
        BigInteger b = new BigInteger("34");
        BigInteger expected = a.multiply(b);
        BigInteger result = karatsuba.karatsuba_mult(a, b);
        assertEquals(expected, result);
    }

    @Test
    public void testKaratsubaMultLargeNumbers() {
        BigInteger a = new BigInteger("123456789012345678901234567890");
        BigInteger b = new BigInteger("987654321098765432109876543210");
        BigInteger expected = a.multiply(b);
        BigInteger result = karatsuba.karatsuba_mult(a, b);
        assertEquals(expected, result);
    }
}