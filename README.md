# DriveMasters 🚗  
**Assignment 2 – Abstract Class and Inheritance**  
**Course:** [Your Course Code, e.g., CPRG 216 – Object-Oriented Programming]  
**Student:** Ahmed Shleibik  
**Institution:** Southern Alberta Institute of Technology (SAIT)  
**Date:** October 2025  

---

## 🧩 Project Overview
DriveMasters is a Java console application designed to help a local car dealership manage its vehicle inventory more efficiently.  
The system supports viewing, searching, and purchasing different types of vehicles while demonstrating **inheritance** and **abstraction** principles in object-oriented programming.

---

## 🏗️ Class Design
The project follows a hierarchical structure:

- **Vehicle (Abstract Class)** – Base class with shared attributes such as CarID, Speed, Year, Price, etc.  
- **Sedan** – Extends `Vehicle`, adds trunk size (`L`, `M`, `S`).  
- **Hatchback** – Extends `Vehicle`, adds hatch type (`S`, `T`, `P`).  
- **SUV** – Extends `Vehicle`, adds drivetrain info.  
- **Hybrid** – Extends `Vehicle`, adds powertrain type and electric range.  
- **PickupTruck** – Extends `Vehicle`, adds cargo beds (`SB`, `EB`, `DB`) and cargo capacity.

All subclasses override the `toString()` method to display details vertically in a human-readable format.

---

## ⚙️ Features
✅ Purchase a vehicle by entering its **CarID**  
✅ Display vehicles by **Type** (Sedan, SUV, etc.)  
✅ Display vehicles by **Subtype** (Trunk Size, Hatch Type, etc.)  
✅ Generate a **random list** of vehicles  
✅ Automatically **save updated data** back to `vehicles.txt` on exit  

---

## 🧠 Object-Oriented Concepts Used
- **Abstraction:** Implemented through the abstract class `Vehicle`.  
- **Inheritance:** All subclasses inherit from `Vehicle`.  
- **Polymorphism:** The program calls overridden `toString()` methods dynamically.  
- **Encapsulation:** All attributes are protected with getter/setter methods where needed.

---

## 🧰 How to Run (Eclipse)
1. Open Eclipse → **File → New → Java Project** → name it `DriveMasters`.
2. Create package: `problemdomain`
3. Copy all `.java` files from the `src/problemdomain` folder into the package.
4. Place `vehicles.txt` in the project root (same level as `src`).
5. Right-click `DriveMastersApp.java` → **Run As → Java Application**.

---

## 🧾 Files Included
