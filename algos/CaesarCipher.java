package algos;

public class CaesarCipher {
    public static String encrypt(String text, int shift) {
        return processText(text, shift);
    }

    public static String decrypt(String text, int shift) {
        return processText(text, -shift);
    }

    private static String processText(String text, int shift) {
        StringBuilder sb = new StringBuilder();
        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isUpperCase(character) ? 'A' : 'a';
                sb.append((char) (base + (character - base + shift + 26) % 26));
            } else {
                sb.append(character);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String originalText = "Hello, World!";
        int shift = 3;

        String encryptedText = encrypt(originalText, shift);
        System.out.println("Encrypted: " + encryptedText);

        String decryptedText = decrypt(encryptedText, shift);
        System.out.println("Decrypted: " + decryptedText);
    }
}