# Pharmacy Management System

A simple command-line application for managing a pharmacy’s medicine inventory, built in Java.

## Project Overview

This system allows pharmacy staff to:

* Add new medicines (over-the-counter or prescription)
* Search medicines by name or composition
* Sell and restock medicines
* View all medicines and pharmacy summary information

The application is driven by a text-based menu (`Main.java`) and uses core OOP principles with inheritance for different medicine types.

## Features

1. **Add Medicine**: Prompt for:

   * Type: Over-the-Counter or Prescription
   * Name, Composition, Dose, Price, Quantity
   * Additional field: Minimum age (OTC) or Doctor specialization (Prescription)
2. **Search**:

   * By name (supports partial matches)
   * By active ingredient/composition
3. **Sell Medicine**: Decrease stock; validates availability and dosage.
4. **Restock Medicine**: Increase stock for existing items.
5. **Display All Medicines**: List details of every medicine in inventory.
6. **Pharmacy Summary**: Show total count of medicines, OTC vs. prescription quantities.
7. **Exit**: Cleanly terminate the program.

## Architecture & Class Details

### `Medicine`

* **Fields**: `name`, `composition`, `dose` (mg), `price`, `quantity`
* **Methods**: Getters/setters, `toString()`, `equals(name, dose)`

### `OverTheCounter` (extends `Medicine`)

* **Additional Field**: `minAge`
* **Override**: `toString()` includes minimum age.

### `Prescription` (extends `Medicine`)

* **Additional Field**: `doctorSpecialization`
* **Override**: `toString()` includes doctor specialization.

### `Pharmacy`

* **Fields**:

  * `name`
  * `Medicine[] inventory` (fixed max size)
  * Counters: total medicines, OTC quantity, prescription quantity
* **Core Methods**:

  * `addMedicine(Medicine m)`
  * `searchByName(String)` returns indices of matches
  * `searchByComposition(String)` returns indices of matches
  * `sellMedicine(String name, int dose, int qty)`
  * `restock(String name, int dose, int qty)`
  * Utility: `raisePrices(double percent)`, `toString()` summary

### `Main`

* Presents interactive menu
* Routes user input to `Pharmacy` methods
* Handles input validation and displays results

## Build & Run Instructions

1. **Compile** (requires JDK 8+):

   ```bash
   javac Main.java Pharmacy.java Medicine.java OverTheCounter.java Prescription.java
   ```
2. **Run**:

   ```bash
   java Main
   ```
3. **Follow the on-screen menu** to perform operations.

## Project Structure

```
├── Main.java              # Entry point and menu logic
├── Pharmacy.java          # Inventory management
├── Medicine.java          # Base class for medicines
├── OverTheCounter.java    # OTC-specific subclass
├── Prescription.java      # Prescription-specific subclass
```

## Author

* Tony Dawra

