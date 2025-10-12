package lab4;

/**
 * Клас, що представляє розділовий знак у реченні.
 */
public class Punctuation implements SentenceMember {

    private final char value;

    /**
     * Конструктор для створення об'єкта розділового знаку.
     *
     * @param value Символ розділового знаку.
     */
    public Punctuation(char value) {
        this.value = value;
    }

    /**
     * Повертає рядкове представлення розділового знаку.
     *
     * @return Рядок, що містить символ.
     */
    @Override
    public String toString() {
        return String.valueOf(value);
    }
}