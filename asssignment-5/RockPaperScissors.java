import java.util.Scanner;

public class RockPaperScissors {

    // 🔹 Generate computer's choice
    public static String getComputerChoice() {
        double rand = Math.random();
        if (rand < 0.33) return "rock";
        else if (rand < 0.66) return "paper";
        else return "scissors";
    }

    // 🔹 Determine winner
    public static String getWinner(String user, String comp) {
        if (user.equals(comp)) return "Draw";

        switch (user) {
            case "rock":
                return comp.equals("scissors") ? "User" : "Computer";
            case "paper":
                return comp.equals("rock") ? "User" : "Computer";
            case "scissors":
                return comp.equals("paper") ? "User" : "Computer";
            default:
                return "Invalid";
        }
    }

    // 🔹 Calculate win stats
    public static String[][] calculateStats(String[][] results) {
        int userWins = 0, compWins = 0, draws = 0;
        int total = results.length;

        for (String[] row : results) {
            if (row[3].equals("User")) userWins++;
            else if (row[3].equals("Computer")) compWins++;
            else draws++;
        }

        double userPercent = (userWins * 100.0) / total;
        double compPercent = (compWins * 100.0) / total;

        String[][] stats = {
            {"User Wins", String.valueOf(userWins), String.format("%.2f%%", userPercent)},
            {"Computer Wins", String.valueOf(compWins), String.format("%.2f%%", compPercent)},
            {"Draws", String.valueOf(draws), "-"}
        };

        return stats;
    }

    // 🔹 Display game results and stats
    public static void displayResults(String[][] results, String[][] stats) {
        System.out.println("\nGame\tUser\tComputer\tWinner");
        System.out.println("---------------------------------------------");
        for (int i = 0; i < results.length; i++) {
            System.out.println((i + 1) + "\t" + results[i][0] + "\t" + results[i][1] + "\t\t" + results[i][3]);
        }

        System.out.println("\nSummary:");
        System.out.println("Category\tCount\tPercentage");
        System.out.println("--------------------------------");
        for (String[] row : stats) {
            System.out.println(row[0] + "\t" + row[1] + "\t" + row[2]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 🔹 Ask for number of games
        System.out.print("Enter number of games to play: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // consume newline

        String[][] results = new String[n][4]; // user, computer, winner

        for (int i = 0; i < n; i++) {
            System.out.print("Game " + (i + 1) + " - Enter your choice (rock/paper/scissors): ");
            String userChoice = scanner.nextLine().toLowerCase();

            String compChoice = getComputerChoice();
            String winner = getWinner(userChoice, compChoice);

            results[i][0] = userChoice;
            results[i][1] = compChoice;
            results[i][2] = winner.equals("Invalid") ? "Invalid Input" : winner;
            results[i][3] = winner;
        }

        String[][] stats = calculateStats(results);
        displayResults(results, stats);

        scanner.close();
    }
}