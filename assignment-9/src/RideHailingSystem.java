// Interface: RideGPS
interface RideGPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

// Abstract class: RideVehicle
abstract class RideVehicle implements RideGPS {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;
    private String currentLocation;

    public RideVehicle(String vehicleId, String driverName, double ratePerKm, String currentLocation) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
        this.currentLocation = currentLocation;
    }

    public String getVehicleId() { return vehicleId; }
    public String getDriverName() { return driverName; }
    public double getRatePerKm() { return ratePerKm; }

    public abstract double calculateFare(double distance);

    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver Name: " + driverName);
        System.out.println("Rate per Km: ₹" + ratePerKm);
        System.out.println("Current Location: " + currentLocation);
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }
}

// Subclass: RideCar
class RideCar extends RideVehicle {
    public RideCar(String vehicleId, String driverName, double ratePerKm, String location) {
        super(vehicleId, driverName, ratePerKm, location);
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance + 50;
    }
}

// Subclass: RideBike
class RideBike extends RideVehicle {
    public RideBike(String vehicleId, String driverName, double ratePerKm, String location) {
        super(vehicleId, driverName, ratePerKm, location);
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }
}

// Subclass: RideAuto
class RideAuto extends RideVehicle {
    public RideAuto(String vehicleId, String driverName, double ratePerKm, String location) {
        super(vehicleId, driverName, ratePerKm, location);
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance + 20;
    }
}

// Main class: RideHailingSystem
public class RideHailingSystem {
    public static void main(String[] args) {
        RideVehicle[] rides = {
                new RideCar("CAR001", "Shobhit", 15.0, "Mathura"),
                new RideBike("BIKE002", "Riya", 10.0, "Vrindavan"),
                new RideAuto("AUTO003", "Amit", 12.0, "Chhata")
        };

        double distance = 8.5;

        System.out.println("🚕 Ride Fare Summary:");
        for (RideVehicle ride : rides) {
            ride.getVehicleDetails();
            System.out.println("Fare for " + distance + " km: ₹" + ride.calculateFare(distance));
            System.out.println("-----------------------------");
        }
    }
}