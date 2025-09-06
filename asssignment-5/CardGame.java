import java.util.Scanner;

public class CardGame {

    // 🔹 Suits and Ranks
    static String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
    static String[] ranks = {
        "2", "3", "4", "5", "6", "7", "8", "9", "10",
        "Jack", "Queen", "King", "Ace"
    };

    // 🔹 Initialize the deck
    public static String[] initializeDeck() {
        int numOfCards = suits.length * ranks.length;
        String[] deck = new String[numOfCards];
        int index = 0;

        for (String suit : suits) {
            for (String rank : ranks) {
                deck[index++] = rank + " of " + suit;
            }
        }

        return deck;
    }

    // 🔹 Shuffle the deck
    public static String[] shuffleDeck(String[] deck) {
        int n = deck.length;

        for (int i = 0; i < n; i++) {
            int randomCardNumber = i + (int) (Math.random() * (n - i));
            // Swap cards
            String temp = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = temp;
        }

        return deck;
    }

    // 🔹 Distribute cards to players
    public static String[][] distributeCards(String[] deck, int nCards, int nPlayers) {
        if (nCards > deck.length || nCards % nPlayers != 0) {
            System.out.println("❌ Cannot distribute " + nCards + " cards evenly among " + nPlayers + " players.");
            return null;
        }

        int cardsPerPlayer = nCards / nPlayers;
        String[][] players = new String[nPlayers][cardsPerPlayer];

        int index = 0;
        for (int i = 0; i < nPlayers; i++) {
            for (int j = 0; j < cardsPerPlayer; j++) {
                players[i][j] = deck[index++];
            }
        }

        return players;
    }

    // 🔹 Print players and their cards
    public static void printPlayers(String[][] players) {
        if (players == null) return;

        for (int i = 0; i < players.length; i++) {
            System.out.println("\nPlayer " + (i + 1) + " cards:");
            for (int j = 0; j < players[i].length; j++) {
                System.out.println("  " + players[i][j]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 🔹 Input: number of cards and players
        System.out.print("Enter number of cards to distribute: ");
        int nCards = scanner.nextInt();

        System.out.print("Enter number of players: ");
        int nPlayers = scanner.nextInt();

        // 🔹 Create, shuffle, distribute, and print
        String[] deck = initializeDeck();
        deck = shuffleDeck(deck);
        String[][] players = distributeCards(deck, nCards, nPlayers);
        printPlayers(players);

        scanner.close();
    }
}