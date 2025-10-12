package lab4;

import java.util.ArrayList;
import java.util.List;

/**
 * Клас, що представляє слово.
 * Складається зі списку об'єктів {@link Letter}.
 */
public class Word implements SentenceMember {

    private final List<Letter> letters;

    /**
     * Конструктор, що парсить рядок у список літер.
     *
     * @param wordStr Рядок, з якого створюється слово.
     */
    public Word(String wordStr) {
        this.letters = new ArrayList<>();
        for (char c : wordStr.toCharArray()) {
            this.letters.add(new Letter(c));
        }
    }

    /**
     * Повертає довжину слова.
     *
     * @return Кількість літер у слові.
     */
    public int length() {
        return letters.size();
    }

    /**
     * Повертає літеру за вказаним індексом.
     *
     * @param index Індекс літери.
     * @return Об'єкт {@link Letter}.
     */
    public Letter getLetter(int index) {
        if (index >= 0 && index < letters.size()) {
            return letters.get(index);
        }
        throw new IndexOutOfBoundsException("Індекс поза межами слова.");
    }

    /**
     * Перевіряє, чи починається слово з голосної літери.
     *
     * @return {@code true}, якщо перша літера є голосною, інакше {@code false}.
     */
    public boolean startsWithVowel() {
        return !letters.isEmpty() && Letter.isVowel(letters.get(0).getValue());
    }

    /**
     * Повертає рядкове представлення слова.
     *
     * @return Складене слово у вигляді рядка.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Letter letter : letters) {
            sb.append(letter);
        }
        return sb.toString();
    }
}