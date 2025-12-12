public class GameScoreboard {
    public static void main(String[] args) {
        // Scores stored as Integer objects (some may be null)
        Integer[] scores = { 10, null, 25, 30, null, 15 };

        int notPlayedCount = 0;
        int totalScore = 0;

        for (Integer score : scores) {
            if (score == null) {
                notPlayedCount++;
            } else {
                totalScore += score; // auto-unboxing
            }
        }

        // Display results
        System.out.println("🚫 Players who haven't played: " + notPlayedCount);
        System.out.println("✅ Total Valid Score: " + totalScore);
    }
}
