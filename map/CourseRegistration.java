package map;

import java.util.*;

public class CourseRegistration {
    public static void main(String[] args) {
        // Step 1: Initialize courses with registration counts
        Map<String, Integer> courseRegistrations = new HashMap<>();
        courseRegistrations.put("CS101", 48);
        courseRegistrations.put("MATH201", 3);
        courseRegistrations.put("ENG150", 52);
        courseRegistrations.put("BIO110", 5);
        courseRegistrations.put("HIST330", 0);

        // Step 2: Simulate add/drop operations
        // Add students
        courseRegistrations.put("CS101", courseRegistrations.get("CS101") + 3); // now 51
        courseRegistrations.put("MATH201", courseRegistrations.get("MATH201") + 1); // now 4
        courseRegistrations.put("HIST330", courseRegistrations.get("HIST330") + 2); // now 2

        // Drop students (ensure count doesn't go negative)
        courseRegistrations.put("BIO110", Math.max(0, courseRegistrations.get("BIO110") - 2)); // now 3
        courseRegistrations.put("ENG150", Math.max(0, courseRegistrations.get("ENG150") - 5)); // now 47

        // Step 3: Print near-full and under-subscribed courses
        System.out.println("Courses near full (≥ 50 students):");
        for (Map.Entry<String, Integer> entry : courseRegistrations.entrySet()) {
            if (entry.getValue() >= 50) {
                System.out.println(entry.getKey() + " : " + entry.getValue() + " students");
            }
        }

        System.out.println("\nCourses under-subscribed (< 5 students):");
        for (Map.Entry<String, Integer> entry : courseRegistrations.entrySet()) {
            if (entry.getValue() < 5) {
                System.out.println(entry.getKey() + " : " + entry.getValue() + " students");
            }
        }
    }
}
