package problemdomain;

public abstract class Vehicle {
    protected String carId;
    protected String vehicleType;
    protected String subtype;
    protected int speed;
    protected double fuel;
    protected int seats;
    protected int year;
    protected String drivetrain;
    protected int price;
    protected int quantity;

    public Vehicle(String carId, String vehicleType, String subtype, int speed, double fuel, int seats,
                   int year, String drivetrain, int price, int quantity) {
        this.carId = carId;
        this.vehicleType = vehicleType;
        this.subtype = subtype;
        this.speed = speed;
        this.fuel = fuel;
        this.seats = seats;
        this.year = year;
        this.drivetrain = drivetrain;
        this.price = price;
        this.quantity = quantity;
    }

    public String getCarId() { return carId; }
    public String getVehicleType() { return vehicleType; }
    public String getSubtype() { return subtype; }
    public int getQuantity() { return quantity; }
    public void decrementQuantity() { if (quantity > 0) quantity--; }

    protected String commonToString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Car ID:\t\t").append(carId).append("\n");
        sb.append("Vehicle Type:\t").append(vehicleType).append("\n");
        sb.append("Sub Type:\t").append(subtype).append("\n");
        sb.append("Speed:\t\t").append(speed).append("\n");
        sb.append("Fuel:\t\t").append(String.format("%.1f", fuel)).append("\n");
        sb.append("Number of Seats:\t").append(seats).append("\n");
        sb.append("Year:\t\t").append(year).append("\n");
        sb.append("DriveTrain:\t\t").append(drivetrain).append("\n");
        sb.append("Price:\t\t").append(price).append("\n");
        sb.append("Available:\t\t").append(quantity).append("\n");
        return sb.toString();
    }

    protected abstract String extraDetails();

    @Override
    public String toString() {
        return commonToString() + extraDetails();
    }

    // For writing back to file
    public abstract String toDataLine();
}
