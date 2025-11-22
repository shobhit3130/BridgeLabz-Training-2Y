package map;

import java.util.*;

public class BankingSystem {
    public static void main(String[] args) {
        // Step 1: Initialize accounts
        Map<String, Double> accounts = new HashMap<>();
        accounts.put("ACC1001", 25000.0);
        accounts.put("ACC1002", 48000.0);
        accounts.put("ACC1003", 12000.0);
        accounts.put("ACC1004", 52000.0);
        accounts.put("ACC1005", 3000.0);

        // Step 2: Deposit and withdrawal operations
        deposit(accounts, "ACC1001", 5000);       // now 30000
        withdraw(accounts, "ACC1002", 10000);     // now 38000
        withdraw(accounts, "ACC1005", 4000);      // exceeds balance

        // Step 3: Print all customers sorted by descending balance
        List<Map.Entry<String, Double>> sortedAccounts = new ArrayList<>(accounts.entrySet());
        sortedAccounts.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        System.out.println("\nAll customers sorted by balance:");
        for (Map.Entry<String, Double> entry : sortedAccounts) {
            System.out.printf("%s : ₹%.2f\n", entry.getKey(), entry.getValue());
        }

        // Step 4: Top 3 customers
        System.out.println("\nTop 3 customers by balance:");
        for (int i = 0; i < Math.min(3, sortedAccounts.size()); i++) {
            Map.Entry<String, Double> entry = sortedAccounts.get(i);
            System.out.printf("%s : ₹%.2f\n", entry.getKey(), entry.getValue());
        }
    }

    // Deposit method
    public static void deposit(Map<String, Double> map, String acc, double amount) {
        if (map.containsKey(acc)) {
            map.put(acc, map.get(acc) + amount);
            System.out.printf("Deposited ₹%.2f to %s\n", amount, acc);
        } else {
            System.out.println("Account not found: " + acc);
        }
    }

    // Withdrawal method
    public static void withdraw(Map<String, Double> map, String acc, double amount) {
        if (map.containsKey(acc)) {
            double current = map.get(acc);
            if (amount <= current) {
                map.put(acc, current - amount);
                System.out.printf("Withdrew ₹%.2f from %s\n", amount, acc);
            } else {
                System.out.printf("Insufficient balance in %s. Withdrawal of ₹%.2f failed.\n", acc, amount);
            }
        } else {
            System.out.println("Account not found: " + acc);
        }
    }
}