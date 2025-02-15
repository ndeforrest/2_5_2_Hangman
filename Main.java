
import java.util.Scanner;

public class Main {
    public static Player player1;
    public static Player player2;

    public static void main(String[] args) {
        System.out.println(
                "Welcome to hangman! When prompted, you can either input one letter, or the full phrase. Before the game, a random amount of points is chosen.");
        System.out.println("For every letter in the word you guess, you get the amount of points. ");
        System.out.println("Getting the phrase correct gets you 5x points. Enjoy!");

        boolean solved = false;
        Scanner scan = new Scanner(System.in);
        System.out.println("Input player 1 name: ");
        player1 = new Player(scan.nextLine());
        System.out.println("Input player 2 name: ");
        player2 = new Player(scan.nextLine());
        Game myGame = new Game();

        // Start with random person's turn
        if (Math.random() > 0.5) {
            Player.setTurn(true);
        } else {
            Player.setTurn(false);
        }
        // loop guesses
        while (solved == false) {
            System.out.println(getPlayer().getName() + ", input guess: ");
            String guess = scan.nextLine();
            if (myGame.getGuess(guess, getPlayer()) == true) {
                solved = true; // getGuess() returns true if phrase is completed
            }

        }

        // ending sequence: print scores and winnter
        System.out.println(player1.getName() + ", you got " + player1.getPoints() + " points.");
        System.out.println(player2.getName() + ", you got " + player2.getPoints() + " points.");
        if (player1.getPoints() > player2.getPoints()) {
            System.out.println(player1.getName() + " wins!");
        } else if (player2.getPoints() > player1.getPoints()) {
            System.out.println(player2.getName() + " wins!");
        } else {
            System.out.println("Tie!");
        }
    }

    // true = player1, false = player2
    public static Player getPlayer() {
        if (Player.getTurn() == true) {
            return player1;
        }
        return player2;
    }
}