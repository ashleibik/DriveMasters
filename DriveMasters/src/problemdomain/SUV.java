package problemdomain;

public class SUV extends Vehicle {
    public SUV(String carId, String vehicleType, String subtype, int speed, double fuel, int seats,
               int year, String drivetrain, int price, int quantity) {
        super(carId, vehicleType, subtype, speed, fuel, seats, year, drivetrain, price, quantity);
    }

    @Override
    protected String extraDetails() {
        // Duplicate line to mirror sample output where DriveTrain appears again
        return "DriveTrain:\t" + drivetrain + "\n";
    }

    @Override
    public String toDataLine() {
        return String.join(";", carId, vehicleType, subtype, String.valueOf(speed),
                String.valueOf(fuel), String.valueOf(seats), String.valueOf(year),
                drivetrain, String.valueOf(price), String.valueOf(quantity));
    }
}
