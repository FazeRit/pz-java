package lab4;

/**
 * Клас, що представляє окрему літеру.
 * Зберігає символ та надає базові операції над ним.
 */
public class Letter {

    /**
     * Символ, який зберігає ця літера.
     */
    private final char value;

    /**
     * Рядок, що містить усі голосні літери для перевірки.
     * Включає українські та англійські голосні.
     */
    private static final String VOWELS = "aeiouyаеиіоуюєї";

    /**
     * Конструктор для створення об'єкта літери.
     *
     * @param value Символ, що буде збережено.
     */
    public Letter(char value) {
        this.value = value;
    }

    /**
     * Повертає збережений символ.
     *
     * @return Символ літери.
     */
    public char getValue() {
        return value;
    }

    /**
     * Перетворює літеру у верхній регістр.
     *
     * @return Новий об'єкт {@code Letter} у верхньому регістрі.
     */
    public Letter toUpperCase() {
        return new Letter(Character.toUpperCase(this.value));
    }

    /**
     * Перетворює літеру у нижній регістр.
     *
     * @return Новий об'єкт {@code Letter} у нижньому регістрі.
     */
    public Letter toLowerCase() {
        return new Letter(Character.toLowerCase(this.value));
    }

    /**
     * Статичний метод для перевірки, чи є символ голосною літерою.
     * Перевірка нечутлива до регістру.
     *
     * @param c Символ для перевірки.
     * @return {@code true}, якщо символ є голосною, інакше {@code false}.
     */
    public static boolean isVowel(char c) {
        return VOWELS.indexOf(Character.toLowerCase(c)) != -1;
    }

    /**
     * Повертає рядкове представлення літери.
     *
     * @return Рядок, що складається з одного символу літери.
     */
    @Override
    public String toString() {
        return String.valueOf(value);
    }
}