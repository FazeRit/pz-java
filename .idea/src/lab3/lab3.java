package lab3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Лабораторна робота №3: Робота з класами в Java (Варіант 7, ID=7).
 * Реалізує клас "Меблі" з 5 полями, дозволяє вводити масив об’єктів, сортує його за висотою
 * (за зростанням) і ціною (за спаданням при однаковій висоті), а також знаходить ідентичний об’єкт.
 */
public class FurnitureLab {

    /**
     * Клас, що представляє меблі з 5 полями.
     */
    static class Furniture {
        private final String type;        // Тип меблів
        private final String material;    // Матеріал
        private final double height;      // Висота (м)
        private final double width;       // Ширина (м)
        private final double price;       // Ціна (грн)

        /**
         * Конструктор класу Furniture.
         *
         * @param type Тип меблів
         * @param material Матеріал
         * @param height Висота
         * @param width Ширина
         * @param price Ціна
         */
        public Furniture(String type, String material, double height, double width, double price) {
            this.type = type;
            this.material = material;
            this.height = height;
            this.width = width;
            this.price = price;
        }

        /**
         * Повертає рядкове представлення об’єкта.
         *
         * @return Рядок із даними об’єкта
         */
        @Override
        public String toString() {
            return "Furniture{type='" + type + "', material='" + material + "', height=" + height +
                    ", width=" + width + ", price=" + price + "}";
        }

        /**
         * Перевіряє рівність двох об’єктів Furniture.
         *
         * @param obj Об’єкт для порівняння
         * @return true, якщо об’єкти ідентичні, false інакше
         */
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Furniture other = (Furniture) obj;
            return type.equals(other.type) &&
                    material.equals(other.material) &&
                    Double.compare(height, other.height) == 0 &&
                    Double.compare(width, other.width) == 0 &&
                    Double.compare(price, other.price) == 0;
        }
    }

    /**
     * Головний метод, який є точкою входу в програму.
     *
     * @param args Аргументи командного рядка (не використовуються в цій програмі).
     */
    public static void main(String[] args) {
        try {
            // Створення сканера для введення
            Scanner scanner = new Scanner(System.in);

            // Введення кількості об’єктів
            System.out.print("Введіть кількість об’єктів меблів: ");
            int size = scanner.nextInt();
            scanner.nextLine(); // Очищення буфера

            if (size <= 0) {
                throw new IllegalArgumentException("Кількість об’єктів повинна бути позитивною.");
            }

            // Створення масиву об’єктів Furniture
            Furniture[] furnitureArray = new Furniture[size];

            // Введення даних для кожного об’єкта
            for (int i = 0; i < size; i++) {
                System.out.println("\nВведення об’єкта #" + (i + 1) + ":");
                System.out.print("Тип меблів: ");
                String type = scanner.nextLine();
                System.out.print("Матеріал: ");
                String material = scanner.nextLine();
                System.out.print("Висота (м): ");
                double height = scanner.nextDouble();
                System.out.print("Ширина (м): ");
                double width = scanner.nextDouble();
                System.out.print("Ціна (грн): ");
                double price = scanner.nextDouble();
                scanner.nextLine(); // Очищення буфера

                furnitureArray[i] = new Furniture(type, material, height, width, price);
            }

            // Виведення початкового масиву
            System.out.println("\nПочатковий масив:");
            for (Furniture furniture : furnitureArray) {
                System.out.println(furniture);
            }

            // Сортування за висотою (зростання) і ціною (спадання)
            Arrays.sort(furnitureArray, new Comparator<Furniture>() {
                @Override
                public int compare(Furniture f1, Furniture f2) {
                    int heightCompare = Double.compare(f1.height, f2.height); // Спершу за висотою (зростання)
                    if (heightCompare != 0) return heightCompare;
                    return Double.compare(f2.price, f1.price); // При однаковій висоті — за ціною (спадання)
                }
            });

            // Виведення відсортованого масиву
            System.out.println("\nВідсортований масив (за висотою↑, ціною↓):");
            for (Furniture furniture : furnitureArray) {
                System.out.println(furniture);
            }

            // Введення об’єкта для пошуку
            System.out.println("\nВведення об’єкта для пошуку:");
            System.out.print("Тип меблів: ");
            String searchType = scanner.nextLine();
            System.out.print("Матеріал: ");
            String searchMaterial = scanner.nextLine();
            System.out.print("Висота (м): ");
            double searchHeight = scanner.nextDouble();
            System.out.print("Ширина (м): ");
            double searchWidth = scanner.nextDouble();
            System.out.print("Ціна (грн): ");
            double searchPrice = scanner.nextDouble();
            scanner.nextLine(); // Очищення буфера

            Furniture searchFurniture = new Furniture(searchType, searchMaterial, searchHeight, searchWidth, searchPrice);

            // Пошук ідентичного об’єкта
            Furniture foundFurniture = null;
            for (Furniture furniture : furnitureArray) {
                if (furniture.equals(searchFurniture)) {
                    foundFurniture = furniture;
                    break;
                }
            }

            // Виведення результату пошуку
            System.out.println("\nПошук об’єкта: " + searchFurniture);
            if (foundFurniture != null) {
                System.out.println("Знайдено: " + foundFurniture);
            } else {
                System.out.println("Об’єкт не знайдено.");
            }

            // Закриття сканера
            scanner.close();

        } catch (IllegalArgumentException e) {
            System.err.println("Помилка: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Непередбачена помилка: " + e.getMessage());
        }
    }
}