package lab5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Клас, що представляє пасажирський потяг.
 * Містить список вагонів та реалізує бізнес-логіку завдання.
 */
public class Train {
    private final List<RailVehicle> cars = new ArrayList<>();

    /**
     * Додає вагон до потяга.
     * @param car об'єкт будь-якого підкласу RailVehicle.
     */
    public void addCar(RailVehicle car) {
        cars.add(car);
    }

    /**
     * Підраховує загальну кількість пасажирів у потязі.
     */
    public int calculateTotalPassengers() {
        return cars.stream().mapToInt(RailVehicle::getPassengerCount).sum();
    }

    /**
     * Підраховує загальну вагу багажу в потязі.
     */
    public int calculateTotalBaggage() {
        return cars.stream().mapToInt(RailVehicle::getBaggageWeight).sum();
    }

    /**
     * Сортує вагони за рівнем комфортності (від меншого до більшого).
     */
    public void sortCarsByComfort() {
        Collections.sort(cars); // Використовує метод compareTo, реалізований в RailVehicle
    }

    /**
     * Знаходить вагони, що відповідають заданому діапазону кількості пасажирів.
     */
    public List<RailVehicle> findCarsByPassengerRange(int minPassengers, int maxPassengers) {
        return cars.stream()
                .filter(car -> car.getPassengerCount() >= minPassengers && car.getPassengerCount() <= maxPassengers)
                .collect(Collectors.toList());
    }

    public List<RailVehicle> getCars() {
        return cars;
    }
}