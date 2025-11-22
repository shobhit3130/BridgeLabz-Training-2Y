package map;

import java.util.*;

public class VotingCount {
    public static void main(String[] args) {
        Map<String, Integer> voteMap = new HashMap<>();

        // Simulate votes for 3 candidates over 10 votes
        String[] votes = {
                "Alice", "Bob", "Alice", "Charlie", "Bob",
                "Alice", "Charlie", "Bob", "Bob", "Charlie"
        };

        // Count votes
        for (String candidate : votes) {
            voteMap.put(candidate, voteMap.getOrDefault(candidate, 0) + 1);
        }

        // Print total votes per candidate
        System.out.println("Vote Count:");
        for (Map.Entry<String, Integer> entry : voteMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }

        // Find candidate with highest votes
        String winner = null;
        int maxVotes = 0;
        for (Map.Entry<String, Integer> entry : voteMap.entrySet()) {
            if (entry.getValue() > maxVotes) {
                maxVotes = entry.getValue();
                winner = entry.getKey();
            }
        }

        System.out.println("\nWinner: " + winner + " with " + maxVotes + " votes");
    }
}
