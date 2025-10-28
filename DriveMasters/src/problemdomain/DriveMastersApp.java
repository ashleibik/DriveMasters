package problemdomain;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class DriveMastersApp {

    private static void printMenu() {
        System.out.println("Welcome to DriveMasters\n");
        System.out.println("Please choose any option below");
        System.out.println("---------------------------------");
        System.out.println("1\tPurchase Vehicle");
        System.out.println("2\tDisplay Vehicles by Type");
        System.out.println("3\tDisplay Vehicles by Subtype");
        System.out.println("4\tProduce a Random List of Vehicles");
        System.out.println("5\tSave & Exit\n");
    }

    private static void printMatches(List<Vehicle> matches) {
        if (matches.isEmpty()) {
            System.out.println("No matching vehicles found.\n");
            return;
        }
        System.out.println("Matching Vehicles:\n");
        for (Vehicle v : matches) {
            System.out.println(v);
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        VehicleRepository repo = VehicleRepository.load(Paths.get("vehicles.txt"));
        Random rng = new Random();

        while (true) {
            printMenu();
            System.out.print("\nEnter option: ");
            String raw = sc.nextLine().trim();
            if (raw.isEmpty()) continue;
            int option;
            try { option = Integer.parseInt(raw); } catch (NumberFormatException e) { continue; }

            switch (option) {
                case 1: {
                    System.out.print("Enter CarId: ");
                    String id = sc.nextLine().trim();
                    repo.findById(id).ifPresentOrElse(v -> {
                        if (v.getQuantity() > 0) {
                            v.decrementQuantity();
                            System.out.println("\n\nThe Vehicle \"" + v.getVehicleType() + " " + v.getSubtype() + "\" has been checked out.\n");
                        } else {
                            System.out.println("Sorry, the vehicle is not available.");
                        }
                    }, () -> System.out.println("Error: CarID not found."));
                    break;
                }
                case 2: {
                    System.out.print("Enter vehicle type to search for: (Sedan, SUV, Hatchback, Pickup Truck and Hybrid car) ");
                    String type = sc.nextLine().trim();
                    List<Vehicle> matches = repo.findByType(type);
                    if (!matches.isEmpty()) System.out.println("\nMatching vehicles:\n");
                    for (Vehicle v : matches) {
                        System.out.println(v);
                        System.out.println();
                    }
                    break;
                }
                case 3: {
                    System.out.println("#\tSub Type");
                    System.out.println("1\tSedan");
                    System.out.println("2\tHatchBack");
                    System.out.println("3\tSUV");
                    System.out.println("4\tHybrid");
                    System.out.println("5\tPickup Truck\n");

                    System.out.print("Enter type of vehicle: ");
                    int t = Integer.parseInt(sc.nextLine().trim());
                    String prompt;
                    switch (t) {
                        case 1: prompt = "Enter a format (L for Large/Spacious trunk, S for Small Trunk, or M for Moderate Trunk): "; break;
                        case 2: prompt = "Enter HatchType (S for Standard Liftgate, T for Split Liftgate, P for Power Liftgate): "; break;
                        case 3: prompt = "Enter Drivetrain (AWD for All Wheel Drive, 4WD for Four Wheel Drive): "; break;
                        case 4: prompt = "Enter a PowerTrain (E for Series Hybrid , A for Parallel Hybrid, PHEV for Plug-in Hybrid): "; break;
                        case 5: prompt = "Enter CargoBeds (SB for Short Beds , EB for Extended Beds, DB for Dump Beds): "; break;
                        default: prompt = "Invalid."; break;
                    }
                    System.out.print("\n" + prompt);
                    String code = sc.nextLine().trim();
                    List<Vehicle> matches = repo.filterBySubtypePrompt(t, code);
                    printMatches(matches);
                    break;
                }
                case 4: {
                    System.out.print("Enter number of vehicles to display: ");
                    int n = Integer.parseInt(sc.nextLine().trim());
                    List<Vehicle> all = new ArrayList<>(repo.getAll());
                    Collections.shuffle(all, rng);
                    List<Vehicle> sample = all.subList(0, Math.min(n, all.size()));
                    System.out.println("\n\nRandom Vehicles:\n");
                    for (int i = 0; i < sample.size(); i++) {
                        System.out.println(sample.get(i));
                        if (i < sample.size() - 1) {
                            System.out.println("----------------------------------\n");
                        }
                    }
                    System.out.println();
                    break;
                }
                case 5: {
                    System.out.println("Saving Vehicles... Done!\n\nGoodbye!");
                    repo.save(Paths.get("vehicles.txt"));
                    return;
                }
                default:
                    // ignore
            }
        }
    }
}
