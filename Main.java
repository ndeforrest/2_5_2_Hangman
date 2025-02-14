
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Input player 1 name: ");
        Player player1 = new Player(scan.nextLine());
        System.out.println("Input player 2 name: ");
        Player player2 = new Player(scan.nextLine());

        Game myGame = new Game();
    }
}

/*
    All players start with zero points.
    A phrase is selected at random.
    The structure of the phrase is displayed to the players.
    A random point value is selected. 
At the start of each turn, a player may guess a letter or solve the puzzle.
If the player guesses a letter and it is in the phrase, the points are added to the player’s score, and the letters are revealed as a partially solved phrase. 
If the letter is not in the phrase, the player loses their turn.
If the player tries to solve the puzzle by typing in the entire phrase correctly, the game is over. If incorrect, the player loses their turn.
Once the puzzle is solved, the player with the highest score wins.
 */