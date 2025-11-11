// Renamed Superclass: TransportUnit
class TransportUnit {
    String model;
    int maxSpeed;

    TransportUnit(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    void showSpecs() {
        System.out.println("Model: " + model);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
    }
}

// Interface: Refuelable
interface Refuelable {
    void refuel();
}

// Subclass: ElectricVehicle
class ElectricVehicle extends TransportUnit {
    int batteryCapacity; // in kWh

    ElectricVehicle(String model, int maxSpeed, int batteryCapacity) {
        super(model, maxSpeed);
        this.batteryCapacity = batteryCapacity;
    }

    void charge() {
        System.out.println(model + " is charging. Battery capacity: " + batteryCapacity + " kWh");
    }
}

// Subclass: PetrolVehicle
class PetrolVehicle extends TransportUnit implements Refuelable {
    double fuelTankSize; // in liters

    PetrolVehicle(String model, int maxSpeed, double fuelTankSize) {
        super(model, maxSpeed);
        this.fuelTankSize = fuelTankSize;
    }

    @Override
    public void refuel() {
        System.out.println(model + " is refueling. Tank size: " + fuelTankSize + " liters");
    }
}

// ✅ Public class for main method
public class VehicleManager {
    public static void main(String[] args) {
        ElectricVehicle ev = new ElectricVehicle("Tesla Model Y", 210, 82);
        PetrolVehicle pv = new PetrolVehicle("Suzuki Swift", 160, 37);

        System.out.println("Electric Vehicle:");
        ev.showSpecs();
        ev.charge();

        System.out.println("\nPetrol Vehicle:");
        pv.showSpecs();
        pv.refuel();
    }
}