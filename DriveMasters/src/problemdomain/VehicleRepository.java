package problemdomain;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

public class VehicleRepository {
    private final List<Vehicle> vehicles = new ArrayList<>();

    public List<Vehicle> getAll() { return vehicles; }

    public static VehicleRepository load(Path file) throws IOException {
        VehicleRepository repo = new VehicleRepository();
        List<String> lines = Files.readAllLines(file);
        for (String raw : lines) {
            if (raw == null || raw.trim().isEmpty()) continue;
            String line = raw.trim();
            String[] parts = line.split("\\s*;\\s*");

            String carId = parts[0];
            char typeDigit = carId.charAt(0);
            switch (typeDigit) {
                case '1': { // Sedan
                    // 0..10
                    repo.vehicles.add(new Sedan(
                            parts[0], parts[1], parts[2],
                            Integer.parseInt(parts[3]), Double.parseDouble(parts[4]), Integer.parseInt(parts[5]),
                            Integer.parseInt(parts[6]), parts[7], Integer.parseInt(parts[8]), Integer.parseInt(parts[9]),
                            parts[10]
                    ));
                    break;
                }
                case '2': { // Hatchback
                    repo.vehicles.add(new Hatchback(
                            parts[0], parts[1], parts[2],
                            Integer.parseInt(parts[3]), Double.parseDouble(parts[4]), Integer.parseInt(parts[5]),
                            Integer.parseInt(parts[6]), parts[7], Integer.parseInt(parts[8]), Integer.parseInt(parts[9]),
                            parts[10]
                    ));
                    break;
                }
                case '3': { // SUV
                    repo.vehicles.add(new SUV(
                            parts[0], parts[1], parts[2],
                            Integer.parseInt(parts[3]), Double.parseDouble(parts[4]), Integer.parseInt(parts[5]),
                            Integer.parseInt(parts[6]), parts[7], Integer.parseInt(parts[8]), Integer.parseInt(parts[9])
                    ));
                    break;
                }
                case '4':
                case '5': { // Hybrid
                    repo.vehicles.add(new Hybrid(
                            parts[0], parts[1], parts[2],
                            Integer.parseInt(parts[3]), Double.parseDouble(parts[4]), Integer.parseInt(parts[5]),
                            Integer.parseInt(parts[6]), parts[7], Integer.parseInt(parts[8]), Integer.parseInt(parts[9]),
                            parts[10], Integer.parseInt(parts[11])
                    ));
                    break;
                }
                case '6': { // Pickup
                    repo.vehicles.add(new PickupTruck(
                            parts[0], parts[1], parts[2],
                            Integer.parseInt(parts[3]), Double.parseDouble(parts[4]), Integer.parseInt(parts[5]),
                            Integer.parseInt(parts[6]), parts[7], Integer.parseInt(parts[8]), Integer.parseInt(parts[9]),
                            parts[10], Integer.parseInt(parts[11])
                    ));
                    break;
                }
                default:
                    System.err.println("Unknown vehicle type for line: " + line);
            }
        }
        return repo;
    }

    public void save(Path file) throws IOException {
        List<String> lines = vehicles.stream().map(Vehicle::toDataLine).collect(Collectors.toList());
        Files.write(file, lines);
    }

    public Optional<Vehicle> findById(String carId) {
        return vehicles.stream().filter(v -> v.getCarId().equalsIgnoreCase(carId)).findFirst();
    }

    public List<Vehicle> findByType(String type) {
        String t = type.trim().toLowerCase();
        return vehicles.stream()
                .filter(v -> v.getVehicleType().toLowerCase().equals(t))
                .collect(Collectors.toList());
    }

    public List<Vehicle> filterBySubtypePrompt(int choice, String codeOrName) {
        String key = codeOrName.trim().toUpperCase();
        List<Vehicle> matches = new ArrayList<>();
        switch (choice) {
            case 1: // Sedan trunk size L/M/S
                for (Vehicle v : vehicles) {
                    if (v instanceof Sedan) {
                        String line = v.toString();
                        if (line.contains(Formatting.trunkSizeFull(key))) matches.add(v);
                    }
                }
                break;
            case 2: // Hatchback hatch type S/T/P
                for (Vehicle v : vehicles) {
                    if (v instanceof Hatchback) {
                        String line = v.toString();
                        if (line.contains(Formatting.hatchTypeFull(key))) matches.add(v);
                    }
                }
                break;
            case 3: // SUV drivetrain
                for (Vehicle v : vehicles) {
                    if (v instanceof SUV && v.drivetrain.equalsIgnoreCase(key)) matches.add(v);
                }
                break;
            case 4: // Hybrid power train
                for (Vehicle v : vehicles) {
                    if (v instanceof Hybrid) {
                        String full = Formatting.powerTrainFull(key);
                        String line = v.toString();
                        if (line.contains("Power Train:\t" + full)) matches.add(v);
                    }
                }
                break;
            case 5: // Pickup cargo beds
                for (Vehicle v : vehicles) {
                    if (v instanceof PickupTruck) {
                        String full = Formatting.cargoBedsFull(key);
                        String line = v.toString();
                        if (line.contains("Cargo Beds:\t" + full)) matches.add(v);
                    }
                }
                break;
            default:
                break;
        }
        return matches;
    }
}
