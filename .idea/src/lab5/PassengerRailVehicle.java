package lab5;

public abstract class PassengerRailVehicle extends RailVehicle {
    protected int passengerCount;
    private static final int BAGGAGE_PER_PASSENGER = 15;

    public PassengerRailVehicle(int comfortLevel, int passengerCount) {
        super(comfortLevel);
        this.passengerCount = passengerCount;
    }

    @Override
    public int getPassengerCount() {
        return passengerCount;
    }

    @Override
    public int getBaggageWeight() {
        return passengerCount * BAGGAGE_PER_PASSENGER;
    }
}