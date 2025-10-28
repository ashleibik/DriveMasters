package problemdomain;

public class PickupTruck extends Vehicle {
    private String cargoBeds; // SB, EB, DB
    private int cargoCapacity;

    public PickupTruck(String carId, String vehicleType, String subtype, int speed, double fuel, int seats,
                       int year, String drivetrain, int price, int quantity, String cargoBeds, int cargoCapacity) {
        super(carId, vehicleType, subtype, speed, fuel, seats, year, drivetrain, price, quantity);
        this.cargoBeds = cargoBeds;
        this.cargoCapacity = cargoCapacity;
    }

    @Override
    protected String extraDetails() {
        return "Cargo Capacity:\t" + cargoCapacity + "\n"
             + "Cargo Beds:\t" + Formatting.cargoBedsFull(cargoBeds) + "\n";
    }

    @Override
    public String toDataLine() {
        return String.join(";", carId, vehicleType, subtype, String.valueOf(speed),
                String.valueOf(fuel), String.valueOf(seats), String.valueOf(year),
                drivetrain, String.valueOf(price), String.valueOf(quantity), cargoBeds, String.valueOf(cargoCapacity));
    }
}
