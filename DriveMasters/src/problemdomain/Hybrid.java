package problemdomain;

public class Hybrid extends Vehicle {
    private String powerTrain; // E, A, PHEV
    private int electricRange;

    public Hybrid(String carId, String vehicleType, String subtype, int speed, double fuel, int seats,
                  int year, String drivetrain, int price, int quantity, String powerTrain, int electricRange) {
        super(carId, vehicleType, subtype, speed, fuel, seats, year, drivetrain, price, quantity);
        this.powerTrain = powerTrain;
        this.electricRange = electricRange;
    }

    @Override
    protected String extraDetails() {
        return "Power Train:\t" + Formatting.powerTrainFull(powerTrain) + "\n"
             + "Electric Range:\t" + electricRange + "\n";
    }

    @Override
    public String toDataLine() {
        return String.join(";", carId, vehicleType, subtype, String.valueOf(speed),
                String.valueOf(fuel), String.valueOf(seats), String.valueOf(year),
                drivetrain, String.valueOf(price), String.valueOf(quantity), powerTrain, String.valueOf(electricRange));
    }
}
