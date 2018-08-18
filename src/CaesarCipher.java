public class CaesarCipher {
    private static final int LOWEST_UPPER_CASE_ASCII = (int) 'A';
    private static final int HIGHEST_UPPER_CASE_ASCII = (int) 'Z';
    private static final int LOWEST_LOWER_CASE_ASCII = (int) 'a';
    private static final int HIGHEST_LOWER_CASE_ASCII = (int) 'z';
    private int key;

    CaesarCipher(int key) {
        setKey(key);
    }

    public String encode(String toEncode) {
        StringBuilder encodedString = new StringBuilder();
        for (char c : toEncode.toCharArray()) {
            encodedString.append(isAlphabet(c) ? encodeChar(c) : c);
        }
        return encodedString.toString();
    }

    public String decode(String toDecode) {
        StringBuilder decodedString = new StringBuilder();
        for (char c : toDecode.toCharArray()) {
            decodedString.append(isAlphabet(c) ? decodeChar(c) : c);
        }
        return decodedString.toString();
    }

    private char encodeChar(char c) {
        int ascii = (int) c + key;
        if (Character.isUpperCase(c)) {
            ascii = ascii > HIGHEST_UPPER_CASE_ASCII ? (ascii % (HIGHEST_UPPER_CASE_ASCII + 1)) + LOWEST_UPPER_CASE_ASCII : ascii;
        } else {
            ascii = ascii > HIGHEST_LOWER_CASE_ASCII ? (ascii % (HIGHEST_LOWER_CASE_ASCII + 1)) + LOWEST_LOWER_CASE_ASCII : ascii;
        }
        return (char) ascii;
    }

    private char decodeChar(char c) {
        int ascii = (int) c - key;
        if (Character.isUpperCase(c)) {
            ascii = ascii < LOWEST_UPPER_CASE_ASCII ? HIGHEST_UPPER_CASE_ASCII - (LOWEST_UPPER_CASE_ASCII - ascii - 1) : ascii;
        } else {
            ascii = ascii < LOWEST_LOWER_CASE_ASCII ? HIGHEST_LOWER_CASE_ASCII - (LOWEST_LOWER_CASE_ASCII - ascii - 1) : ascii;
        }
        return (char) ascii;
    }

    private boolean isAlphabet(char c) {
        int ascii = (int) c;
        return ascii >= LOWEST_UPPER_CASE_ASCII && ascii <= HIGHEST_UPPER_CASE_ASCII ||
                ascii >= LOWEST_LOWER_CASE_ASCII && ascii <= HIGHEST_LOWER_CASE_ASCII;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        if (key > 0 && key < 26) {
            this.key = key;
        } else {
            throw new IndexOutOfBoundsException("Key should be between 1 and 25");
        }
    }
}