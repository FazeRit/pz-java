package lab5;

public class BaggageRailVehicle extends RailVehicle {
    private final int baggageWeight;

    public BaggageRailVehicle(int baggageWeight) {
        super(1);
        this.baggageWeight = baggageWeight;
    }

    @Override
    public int getPassengerCount() {
        return 0;
    }

    @Override
    public int getBaggageWeight() {
        return this.baggageWeight;
    }
}