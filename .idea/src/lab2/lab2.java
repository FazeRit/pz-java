package lab2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Лабораторна робота №2: Робота з рядками в Java (Варіант 7).
 * Виконує сортування слів введеного тексту, що починаються з голосних літер, за другою літерою (C17=7)
 * з використанням типу даних String (C3=1).
 */
public class StringLab {

    /**
     * Головний метод, який є точкою входу в програму.
     *
     * @param args Аргументи командного рядка (не використовуються в цій програмі).
     */
    public static void main(String[] args) {
        try {
            // Створення сканера для введення тексту
            Scanner scanner = new Scanner(System.in);

            // Введення тексту користувачем
            System.out.println("Будь ласка, введіть текст:");
            String text = scanner.nextLine();

            // Перевірка на null або порожній текст
            if (text == null || text.trim().isEmpty()) {
                throw new IllegalArgumentException("Текст не може бути null або порожнім.");
            }

            // Розбиття тексту на слова
            String[] words = text.toLowerCase().split("[\\p{Punct}\\s]+");

            // Фільтрація слів, що починаються з голосних
            String[] vowelWords = Arrays.stream(words)
                    .filter(word -> word.length() > 1 && isVowel(word.charAt(0)))
                    .toArray(String[]::new);

            // Сортування за другою літерою
            Arrays.sort(vowelWords, new Comparator<String>() {
                @Override
                public int compare(String w1, String w2) {
                    if (w1.length() < 2 || w2.length() < 2) return 0;
                    return Character.compare(w1.charAt(1), w2.charAt(1));
                }
            });

            // Виведення результату
            System.out.println("Слова, що починаються з голосних, відсортовані за другою літерою:");
            for (String word : vowelWords) {
                System.out.println(word);
            }

            // Закриття сканера
            scanner.close();

        } catch (IllegalArgumentException e) {
            System.err.println("Помилка: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Непередбачена помилка: " + e.getMessage());
        }
    }

    /**
     * Перевіряє, чи є символ голосною літерою.
     *
     * @param c Символ для перевірки
     * @return true, якщо символ є голосною, false інакше
     */
    private static boolean isVowel(char c) {
        return "aeiouyаеиіоуюєї".indexOf(Character.toLowerCase(c)) != -1;
    }
}