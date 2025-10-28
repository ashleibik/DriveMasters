# DriveMasters — Assignment 2: Abstract Class and Inheritance

This project implements the required class hierarchy and console application for managing a vehicle inventory (Sedan, Hatchback, SUV, Hybrid, Pickup Truck).

## How to run (Eclipse)
1. **Create project**: In Eclipse, File → New → Java Project → name it `DriveMasters`.
2. **Create package**: Right‑click `src` → New → Package → `problemdomain`.
3. **Add files**: Copy the `.java` files from `src/` into the package, and copy `vehicles.txt` to the project root (same level as `src`).  
4. **Run**: Right‑click `DriveMastersApp.java` → Run As → Java Application.

## Files
- `DriveMastersApp.java` — main menu + IO/persist.
- `Vehicle.java` — abstract base class.
- Subclasses:
  - `Sedan.java`
  - `Hatchback.java`
  - `SUV.java`
  - `Hybrid.java`
  - `PickupTruck.java`
- `VehicleRepository.java` — parse & write `vehicles.txt`.
- `Formatting.java` — helpers for mapping codes to human‑readable text.
- `vehicles.txt` — data file (copy to project root).

## Notes
- The app loads `vehicles.txt` on start, and **saves back in the original format** on option `5: Save & Exit`.
- Searches are case‑insensitive. Sub‑type prompts accept the short codes shown in the assignment (e.g., `L/M/S`, `P/T/S`, `AWD/4WD/FWD`, `E/A/PHEV`, `SB/EB/DB`).

