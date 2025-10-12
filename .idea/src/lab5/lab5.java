package lab5;

import java.util.List;

/**
 * Головний клас для демонстрації роботи.
 */
public class lab5 {
    public static void main(String[] args) {
        // 1. Створити пасажирський потяг
        Train train = new Train();

        // Додаємо різні типи вагонів
        train.addCar(new BusinessClassRailVehicle(28));
        train.addCar(new EconomyClassRailVehicle(52));
        train.addCar(new EconomyClassRailVehicle(48));
        train.addCar(new BaggageRailVehicle(5000));
        train.addCar(new EconomyClassRailVehicle(54));
        train.addCar(new BusinessClassRailVehicle(32));

        System.out.println("--- Початковий склад потяга ---");
        train.getCars().forEach(System.out::println);
        System.out.println("--------------------------------\n");

        // 2. Порахувати загальну чисельність пасажирів і багажу
        int totalPassengers = train.calculateTotalPassengers();
        int totalBaggage = train.calculateTotalBaggage();
        System.out.println("Загальна кількість пасажирів: " + totalPassengers);
        System.out.println("Загальна вага багажу: " + totalBaggage + " кг\n");

        // 3. Провести сортування вагонів за рівнем комфортності
        train.sortCarsByComfort();
        System.out.println("--- Вагони, відсортовані за комфортом ---");
        train.getCars().forEach(System.out::println);
        System.out.println("------------------------------------------\n");

        // 4. Знайти вагон, що відповідає заданому діапазону кількості пасажирів
        int minPass = 40;
        int maxPass = 50;
        System.out.printf("--- Вагони з кількістю пасажирів від %d до %d ---\n", minPass, maxPass);
        List<RailVehicle> foundCars = train.findCarsByPassengerRange(minPass, maxPass);
        if (foundCars.isEmpty()) {
            System.out.println("Вагонів у заданому діапазоні не знайдено.");
        } else {
            foundCars.forEach(System.out::println);
        }
        System.out.println("-------------------------------------------------");
    }
}