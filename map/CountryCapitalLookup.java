package map;

import java.util.*;

public class CountryCapitalLookup {
    public static void main(String[] args) {
        // Step 1: Add country-capital pairs
        Map<String, String> countryCapital = new HashMap<>();
        countryCapital.put("India", "New Delhi");
        countryCapital.put("USA", "Washington D.C.");
        countryCapital.put("France", "Paris");
        countryCapital.put("Germany", "Berlin");
        countryCapital.put("Japan", "Tokyo");
        countryCapital.put("Brazil", "Brasília");
        countryCapital.put("Canada", "Ottawa");
        countryCapital.put("Australia", "Canberra");

        // Step 2: Lookup capital by country input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a country name: ");
        String inputCountry = scanner.nextLine().trim();

        String capital = countryCapital.get(inputCountry);
        if (capital != null) {
            System.out.println("Capital of " + inputCountry + " is " + capital);
        } else {
            System.out.println("Unknown country");
        }

        // Step 3: Print all countries alphabetically
        System.out.println("\nAll countries and their capitals:");
        TreeMap<String, String> sortedMap = new TreeMap<>(countryCapital);
        for (Map.Entry<String, String> entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }
    }
}