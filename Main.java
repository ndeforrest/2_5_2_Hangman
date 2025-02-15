
import java.util.Scanner;

public class Main {
    public static Player player1;
    public static Player player2;

    public static void main(String[] args) {
        boolean solved = false;
        Scanner scan = new Scanner(System.in);
        System.out.println("Input player 1 name: ");
        player1 = new Player(scan.nextLine());
        System.out.println("Input player 2 name: ");
        player2 = new Player(scan.nextLine());

        Game myGame = new Game();
        if (Math.random() > 0.5) {
            Player.setTurn(true);
        } else {
            Player.setTurn(false);
        }
        while (solved == false) {
            System.out.println(getPlayer().getName() + ", input guess: ");
            String guess = scan.nextLine();
            if (myGame.getGuess(guess, getPlayer()) == true) {
                solved = true;
            }

        }
    }

    public static Player getPlayer() {
        if (Player.getTurn() == true) {
            return player1;
        }
        return player2;
    }
}