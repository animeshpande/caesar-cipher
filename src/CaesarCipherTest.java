import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CaesarCipherTest {
    private CaesarCipher caesarCipher;
    private static final String DECODED_STRING = "Hello world!";
    private static final String ENCODED_STRING = "Wtaad ldgas!";
    private static final int KEY = 15;

    @BeforeMethod
    public void setUp() {
        caesarCipher = new CaesarCipher(KEY);
    }

    @Test
    public void testEncode() {
        String output = caesarCipher.encode(DECODED_STRING);
        assertEquals(output, ENCODED_STRING);
    }

    @Test
    public void testDecode() {
        String output = caesarCipher.decode(ENCODED_STRING);
        assertEquals(output, DECODED_STRING);
    }

    @Test
    public void testGetKey() {
        assertEquals(caesarCipher.getKey(), KEY);
    }

    @Test
    public void testSetKey() {
        final int key = 5;
        caesarCipher.setKey(key);
        assertEquals(caesarCipher.getKey(), key);
    }
}
