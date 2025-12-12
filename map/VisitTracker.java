package map;

import java.util.*;

public class VisitTracker {
    public static void main(String[] args) {
        // Step 1: Simulate page visits
        String[] visitedPages = {
                "home", "about", "products", "home", "products", "contact", "home",
                "products", "home", "about", "home", "contact", "products", "home"
        };

        Map<String, Integer> visitCount = new HashMap<>();
        for (String page : visitedPages) {
            visitCount.put(page, visitCount.getOrDefault(page, 0) + 1);
        }

        // Step 2: Sort pages by descending visit count
        List<Map.Entry<String, Integer>> sortedVisits = new ArrayList<>(visitCount.entrySet());
        sortedVisits.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        System.out.println("Page visit summary (most visited first):");
        for (Map.Entry<String, Integer> entry : sortedVisits) {
            System.out.println(entry.getKey() + " : " + entry.getValue() + " visits");
        }

        // Step 3: Print most visited page(s)
        int maxVisits = sortedVisits.get(0).getValue();
        System.out.println("\nMost visited page(s):");
        for (Map.Entry<String, Integer> entry : sortedVisits) {
            if (entry.getValue() == maxVisits) {
                System.out.println(entry.getKey() + " : " + entry.getValue() + " visits");
            }
        }
    }
}
