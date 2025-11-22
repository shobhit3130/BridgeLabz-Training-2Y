package map;

import java.util.Map;
import java.util.TreeMap;

public class StudentGradeTracker {
    public static void main(String[] args) {
        // Step 1: Create a TreeMap to store student grades in alphabetical order
        Map<String, Double> gradeMap = new TreeMap<>();

        // Step 2: Add students and their grades
        gradeMap.put("Alice", 85.5);
        gradeMap.put("Bob", 92.0);
        gradeMap.put("Charlie", 78.0);
        gradeMap.put("Diana", 88.5);

        // Step 3: Update grade for a student (e.g., Bob re-takes the test)
        gradeMap.put("Bob", 95.0); // Overwrites previous grade

        // Step 4: Remove a student who dropped out (e.g., Charlie)
        gradeMap.remove("Charlie");

        // Step 5: Print students and grades in alphabetical order
        System.out.println("Student Grades:");
        for (Map.Entry<String, Double> entry : gradeMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}