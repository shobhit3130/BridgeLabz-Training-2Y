package lambda;

import java.util.*;
import java.util.function.Predicate;

public class NotificationFilter {
    public static void main(String[] args) {
        List<String> alerts = Arrays.asList(
                "Critical: Heart rate spike",
                "Info: Appointment reminder",
                "Urgent: Oxygen level drop",
                "Info: Medication time"
        );

        // Filter only critical or urgent alerts
        Predicate<String> isImportant = alert -> alert.startsWith("Critical") || alert.startsWith("Urgent");

        System.out.println("Filtered alerts:");
        alerts.stream()
                .filter(isImportant)
                .forEach(System.out::println);
    }
}
