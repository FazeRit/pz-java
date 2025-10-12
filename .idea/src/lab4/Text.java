package lab4;

import java.util.ArrayList;
import java.util.List;

/**
 * Клас, що представляє повний текст.
 * Складається зі списку речень ({@link Sentence}).
 */
public class Text {

    private final List<Sentence> sentences;

    /**
     * Конструктор, що приймає сирий текст, обробляє його і парсить на речення.
     *
     * @param rawText Вхідний текст у вигляді рядка.
     */
    public Text(String rawText) {
        this.sentences = new ArrayList<>();
        // 1. Замінити послідовність табуляцій та пробілів одним пробілом.
        String processedText = rawText.trim().replaceAll("[\\t ]+", " ");

        // 2. Розбити текст на речення (за розділовими знаками .!?)
        String[] sentenceStrings = processedText.split("(?<=[.!?])\\s*");

        // 3. Створити об'єкти Sentence для кожного рядка
        for (String sentenceStr : sentenceStrings) {
            if (!sentenceStr.isBlank()) {
                this.sentences.add(new Sentence(sentenceStr));
            }
        }
    }

    /**
     * Збирає всі слова з усього тексту в один список.
     *
     * @return Список усіх об'єктів {@link Word} у тексті.
     */
    public List<Word> getAllWords() {
        List<Word> allWords = new ArrayList<>();
        for (Sentence sentence : sentences) {
            for (SentenceMember member : sentence.getMembers()) {
                if (member instanceof Word) {
                    allWords.add((Word) member);
                }
            }
        }
        return allWords;
    }

    /**
     * Повертає рядкове представлення всього тексту.
     *
     * @return Повний текст, зібраний з речень.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sentences.size(); i++) {
            sb.append(sentences.get(i));
            if (i < sentences.size() - 1) {
                sb.append(" "); // Додаємо пробіл між реченнями
            }
        }
        return sb.toString();
    }
}