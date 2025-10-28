package problemdomain;

public class Sedan extends Vehicle {
    private String trunkSize; // L, M, S

    public Sedan(String carId, String vehicleType, String subtype, int speed, double fuel, int seats,
                 int year, String drivetrain, int price, int quantity, String trunkSize) {
        super(carId, vehicleType, subtype, speed, fuel, seats, year, drivetrain, price, quantity);
        this.trunkSize = trunkSize;
    }

    @Override
    protected String extraDetails() {
        return "Trunk Size:\t" + Formatting.trunkSizeFull(trunkSize) + "\n";
    }

    @Override
    public String toDataLine() {
        return String.join(";", carId, vehicleType, subtype, String.valueOf(speed),
                String.valueOf(fuel), String.valueOf(seats), String.valueOf(year),
                drivetrain, String.valueOf(price), String.valueOf(quantity), trunkSize);
    }
}
