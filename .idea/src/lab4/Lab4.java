package lab4;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Головний клас для запуску програми.
 * Виконує основну логіку лабораторної роботи №2 з використанням створеної
 * об'єктної моделі тексту.
 * Завдання: відсортувати слова, що починаються з голосних, за другою літерою.
 */
public class Lab4 {

    /**
     * Точка входу в програму.
     *
     * @param args Аргументи командного рядка (не використовуються).
     */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // 1. Введення тексту користувачем
            System.out.println("Будь ласка, введіть текст:");
            String inputText = scanner.nextLine();

            if (inputText == null || inputText.isBlank()) {
                throw new IllegalArgumentException("Текст не може бути порожнім.");
            }

            // 2. Створення об'єкта Text з введеного рядка
            // У конструкторі Text відбувається вся необхідна обробка та парсинг
            Text text = new Text(inputText);

            // 3. Отримання всіх слів з тексту
            List<Word> allWords = text.getAllWords();

            // 4. Фільтрація слів за умовою (починаються з голосної, довжина > 1)
            //    та сортування за другою літерою
            List<Word> sortedVowelWords = allWords.stream()
                    .filter(word -> word.length() > 1 && word.startsWithVowel())
                    .sorted(Comparator.comparing(word -> word.getLetter(1).toLowerCase().getValue()))
                    .collect(Collectors.toList());

            // 5. Виведення результату
            System.out.println("\nСлова, що починаються з голосних, відсортовані за другою літерою:");
            if (sortedVowelWords.isEmpty()) {
                System.out.println("Такі слова не знайдено.");
            } else {
                sortedVowelWords.forEach(System.out::println);
            }

        } catch (IllegalArgumentException e) {
            System.err.println("Помилка вводу: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Виникла непередбачувана помилка: " + e.getMessage());
            e.printStackTrace();
        }
    }
}