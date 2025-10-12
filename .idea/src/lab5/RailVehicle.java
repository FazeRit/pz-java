package lab5;

public abstract class RailVehicle implements Comparable<RailVehicle> {
    private final int comfortLevel;
    private final int id;
    private static int counter = 0;

    public RailVehicle(int comfortLevel) {
        this.comfortLevel = comfortLevel;
        this.id = ++counter;
    }

    public int getComfortLevel() {
        return comfortLevel;
    }

    public int getId() {
        return id;
    }

    public abstract int getPassengerCount();
    public abstract int getBaggageWeight();

    @Override
    public int compareTo(RailVehicle other) {
        return Integer.compare(this.comfortLevel, other.comfortLevel);
    }

    @Override
    public String toString() {
        return String.format("Вагон #%d (%s, комфорт: %d, пасажири: %d, багаж: %d кг)",
                id, this.getClass().getSimpleName(), comfortLevel, getPassengerCount(), getBaggageWeight());
    }
}