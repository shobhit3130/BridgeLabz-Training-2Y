package map;

import java.util.*;

public class StudentScoreReport {
    public static void main(String[] args) {
        // Step 1: Add subjects and student marks
        Map<String, Map<String, Integer>> report = new HashMap<>();

        report.put("Math", Map.of("Alice", 95, "Bob", 88, "Charlie", 76));
        report.put("Science", Map.of("Alice", 89, "Bob", 92, "Charlie", 85));
        report.put("English", Map.of("Alice", 78, "Bob", 84, "Charlie", 91));
        report.put("History", Map.of("Alice", 65, "Bob", 72, "Charlie", 94));

        // Step 2: Find top scorer per subject
        System.out.println("Top scorer per subject:");
        for (String subject : report.keySet()) {
            String topStudent = "";
            int topScore = -1;
            for (Map.Entry<String, Integer> entry : report.get(subject).entrySet()) {
                if (entry.getValue() > topScore) {
                    topScore = entry.getValue();
                    topStudent = entry.getKey();
                }
            }
            System.out.printf("%s → %s (%d)\n", subject, topStudent, topScore);
        }

        // Step 3: Average score per subject
        System.out.println("\nAverage score per subject:");
        for (String subject : report.keySet()) {
            int total = 0;
            int count = 0;
            for (int score : report.get(subject).values()) {
                total += score;
                count++;
            }
            double average = (double) total / count;
            System.out.printf("%s → %.2f\n", subject, average);
        }

        // Step 4: Subjects with at least one score > 90
        System.out.println("\nSubjects with at least one student scoring above 90:");
        for (String subject : report.keySet()) {
            boolean hasHighScore = report.get(subject).values().stream().anyMatch(score -> score > 90);
            if (hasHighScore) {
                System.out.println(subject);
            }
        }
    }
}