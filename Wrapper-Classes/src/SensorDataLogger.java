import java.util.ArrayList;

public class SensorDataLogger {
    // Method that accepts both primitive and wrapper input
    public static void logTemperature(double tempPrimitive, Double tempWrapper) {
        // Auto-boxing: primitive to wrapper
        Double boxedTemp = tempPrimitive;

        // Auto-unboxing: wrapper to primitive
        double unboxedTemp = tempWrapper != null ? tempWrapper : 0.0;

        System.out.println("📦 Boxed from primitive: " + boxedTemp);
        System.out.println("📤 Unboxed from wrapper: " + unboxedTemp);
    }

    public static void main(String[] args) {
        // Simulated sensor readings
        double sensorReading1 = 36.5;         // primitive
        Double sensorReading2 = 37.2;         // wrapper
        Double sensorReading3 = null;         // null wrapper

        System.out.println("🔍 Logging Sensor Readings:");
        logTemperature(sensorReading1, sensorReading2);
        logTemperature(35.8, sensorReading3); // shows null handling

        // Storing readings in a list (auto-boxing)
        ArrayList<Double> temperatureLog = new ArrayList<>();
        temperatureLog.add(sensorReading1); // auto-boxed
        temperatureLog.add(sensorReading2);
        temperatureLog.add(34.9);           // auto-boxed

        System.out.println("\n📊 Stored Temperatures:");
        for (Double temp : temperatureLog) {
            System.out.println("→ " + temp + " °C");
        }
    }
}