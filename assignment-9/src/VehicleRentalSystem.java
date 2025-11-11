// Interface: Insurable
interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

// Abstract class: BaseVehicle (renamed to avoid duplicate "Vehicle")
abstract class BaseVehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;
    private String insurancePolicyNumber;

    public BaseVehicle(String vehicleNumber, String type, double rentalRate, String insurancePolicyNumber) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    // Encapsulation: Getters and Setters
    public String getVehicleNumber() { return vehicleNumber; }
    public String getType() { return type; }
    public double getRentalRate() { return rentalRate; }
    public void setRentalRate(double rentalRate) { this.rentalRate = rentalRate; }

    // Sensitive field: no public getter for insurancePolicyNumber

    // Abstract method
    public abstract double calculateRentalCost(int days);

    // Common method
    public void displayDetails(int days) {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Type: " + type);
        System.out.println("Rental Rate: ₹" + rentalRate + " per day");
        System.out.println("Rental Cost for " + days + " days: ₹" + calculateRentalCost(days));
        if (this instanceof Insurable) {
            System.out.println("Insurance Cost: ₹" + ((Insurable)this).calculateInsurance());
            System.out.println("Insurance Details: " + ((Insurable)this).getInsuranceDetails());
        }
        System.out.println("----------------------------------");
    }
}

// Subclass: Car
class Car extends BaseVehicle implements Insurable {
    public Car(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Car", rentalRate, insurancePolicyNumber);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.10; // 10% of daily rate
    }

    @Override
    public String getInsuranceDetails() {
        return "Comprehensive car insurance (10% of daily rate)";
    }
}

// Subclass: Bike
class Bike extends BaseVehicle {
    public Bike(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Bike", rentalRate, insurancePolicyNumber);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }
}

// Subclass: Truck
class Truck extends BaseVehicle implements Insurable {
    public Truck(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Truck", rentalRate, insurancePolicyNumber);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days + 500; // extra fixed charge
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.15; // 15% of daily rate
    }

    @Override
    public String getInsuranceDetails() {
        return "Heavy vehicle insurance (15% of daily rate)";
    }
}

// ✅ Public class for main method
public class VehicleRentalSystem {
    public static void main(String[] args) {
        BaseVehicle[] fleet = {
                new Car("UP32CAR1234", 1500, "CAR-INS-001"),
                new Bike("UP32BIKE5678", 500, "BIKE-INS-002"),
                new Truck("UP32TRUCK9999", 3000, "TRUCK-INS-003")
        };

        System.out.println("🚚 Vehicle Rental Summary:");
        for (BaseVehicle vehicle : fleet) {
            vehicle.displayDetails(5); // calculate for 5 days
        }
    }
}
