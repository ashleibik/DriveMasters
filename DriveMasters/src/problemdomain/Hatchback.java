package problemdomain;

public class Hatchback extends Vehicle {
    private String hatchType; // S, T, P

    public Hatchback(String carId, String vehicleType, String subtype, int speed, double fuel, int seats,
                     int year, String drivetrain, int price, int quantity, String hatchType) {
        super(carId, vehicleType, subtype, speed, fuel, seats, year, drivetrain, price, quantity);
        this.hatchType = hatchType;
    }

    @Override
    protected String extraDetails() {
        return "Hatch Type:\t" + Formatting.hatchTypeFull(hatchType) + "\n";
    }

    @Override
    public String toDataLine() {
        return String.join(";", carId, vehicleType, subtype, String.valueOf(speed),
                String.valueOf(fuel), String.valueOf(seats), String.valueOf(year),
                drivetrain, String.valueOf(price), String.valueOf(quantity), hatchType);
    }
}
