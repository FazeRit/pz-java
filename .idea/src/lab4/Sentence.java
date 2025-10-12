package lab4;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Клас, що представляє речення.
 * Складається зі списку слів ({@link Word}) та розділових знаків ({@link Punctuation}).
 */
public class Sentence {

    private final List<SentenceMember> members;

    /**
     * Конструктор, що парсить рядок у список слів та розділових знаків.
     * Використовує регулярний вираз для розділення.
     *
     * @param sentenceStr Рядок, що містить повне речення.
     */
    public Sentence(String sentenceStr) {
        this.members = new ArrayList<>();
        // Регулярний вираз, що знаходить слова та розділові знаки
        Pattern pattern = Pattern.compile("\\w+|[\\p{Punct}]");
        Matcher matcher = pattern.matcher(sentenceStr);

        while (matcher.find()) {
            String part = matcher.group();
            if (part.matches("\\w+")) { // Якщо частина є словом
                members.add(new Word(part));
            } else { // Інакше це розділовий знак
                members.add(new Punctuation(part.charAt(0)));
            }
        }
    }

    /**
     * Повертає список усіх членів речення.
     *
     * @return Список об'єктів, що реалізують {@link SentenceMember}.
     */
    public List<SentenceMember> getMembers() {
        return new ArrayList<>(members); // Повертаємо копію для інкапсуляції
    }

    /**
     * Повертає рядкове представлення речення.
     *
     * @return Повне речення, зібране з його частин.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < members.size(); i++) {
            sb.append(members.get(i));
            // Додаємо пробіл після слова, якщо далі не йде розділовий знак
            if (members.get(i) instanceof Word && (i + 1) < members.size() &&
                    members.get(i + 1) instanceof Word) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}