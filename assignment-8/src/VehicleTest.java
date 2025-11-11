// Base class
class Vehicle {
    String name;
    int speed;
    String fuelType;

    Vehicle(String name, int speed, String fuelType) {
        this.name = name;
        this.speed = speed;
        this.fuelType = fuelType;
    }

    void displayInfo() {
        System.out.println("Vehicle: " + name + ", Speed: " + speed + " km/h, Fuel: " + fuelType);
    }
}

// Subclass: Car
class Car extends Vehicle {
    int seatCount;

    Car(String name, int speed, String fuelType, int seatCount) {
        super(name, speed, fuelType);
        this.seatCount = seatCount;
    }

    @Override
    void displayInfo() {
        System.out.println("Car: " + name + ", Speed: " + speed + " km/h, Fuel: " + fuelType + ", Seats: " + seatCount);
    }
}

// Subclass: Truck
class Truck extends Vehicle {
    double loadCapacity;

    Truck(String name, int speed, String fuelType, double loadCapacity) {
        super(name, speed, fuelType);
        this.loadCapacity = loadCapacity;
    }

    @Override
    void displayInfo() {
        System.out.println("Truck: " + name + ", Speed: " + speed + " km/h, Fuel: " + fuelType + ", Load: " + loadCapacity + " tons");
    }
}

// Subclass: Motorcycle
class Motorcycle extends Vehicle {
    boolean hasHelmetStorage;

    Motorcycle(String name, int speed, String fuelType, boolean hasHelmetStorage) {
        super(name, speed, fuelType);
        this.hasHelmetStorage = hasHelmetStorage;
    }

    @Override
    void displayInfo() {
        System.out.println("Motorcycle: " + name + ", Speed: " + speed + " km/h, Fuel: " + fuelType +
                ", Helmet Storage: " + (hasHelmetStorage ? "Yes" : "No"));
    }
}

// Main class
public class VehicleTest {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
                new Car("Sedan", 180, "Petrol", 5),
                new Truck("Freightliner", 120, "Diesel", 15.5),
                new Motorcycle("Ducati", 220, "Petrol", true)
        };

        for (Vehicle v : vehicles) {
            v.displayInfo(); // Polymorphic call
        }
    }
}