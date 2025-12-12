package map;

import java.util.*;

public class SalaryDirectory {
    public static void main(String[] args) {
        // Step 1: Add employees with salaries
        Map<String, Double> salaries = new HashMap<>();
        salaries.put("Alice", 55000.0);
        salaries.put("Bob", 62000.0);
        salaries.put("Charlie", 48000.0);
        salaries.put("Diana", 75000.0);
        salaries.put("Ethan", 51000.0);
        salaries.put("Fiona", 68000.0);

        // Step 2: Give raises
        giveRaise(salaries, "Alice", 10);    // +10%
        giveRaise(salaries, "Charlie", 5);   // +5%
        giveRaise(salaries, "George", 7);    // Not found

        // Step 3: Compute average salary
        double total = 0;
        for (double salary : salaries.values()) {
            total += salary;
        }
        double average = total / salaries.size();
        System.out.printf("\nAverage salary: ₹%.2f\n", average);

        // Step 4: Find highest-paid employee(s)
        double maxSalary = Collections.max(salaries.values());
        System.out.println("Highest-paid employee(s):");
        for (Map.Entry<String, Double> entry : salaries.entrySet()) {
            if (entry.getValue() == maxSalary) {
                System.out.printf("%s : ₹%.2f\n", entry.getKey(), entry.getValue());
            }
        }
    }

    // Helper method to apply raise
    public static void giveRaise(Map<String, Double> map, String name, double percent) {
        if (map.containsKey(name)) {
            double current = map.get(name);
            double updated = current + (current * percent / 100);
            map.put(name, updated);
            System.out.printf("%s got a %.1f%% raise. New salary: ₹%.2f\n", name, percent, updated);
        } else {
            System.out.println("Employee not found: " + name);
        }
    }
}