public class Game {
    private String phrase;
    private String partial;
    private int points;

    public Game() {
        phrase = WordProvider.getWord();
        partial = "";
        for (int i = 0; i < phrase.length(); i++) {
            if (phrase.substring(i, i + 1).equals(" ")) {
                partial += " ";
            } else {
                partial += "_";
            }
        }
        System.out.println("Word: " + phrase); // comment out for game
        System.out.println("Format: " + partial); // print fully blank
        points = (int) (Math.random() * 10);
        System.out.println("Amount of points per guess: " + points);
    }

    public void guessLetter(String guess, Player player) {
        int count = 0;
        for (int i = 0; i < phrase.length(); i++) {
            if (phrase.substring(i, i + 1).equals(guess)) {
                count++;
                partial = partial.substring(0, i) + guess + partial.substring(i + 1);
            }
        }
        if (count == 0) {
            System.out.println("The letter was not in the word.");
            System.out.println("Your word is still " + partial);
            Player.switchTurn();
        } else {
            player.addPoints(count * this.points);
            System.out.println("The letter was in the word, you got " + count * this.points + "points.");
            System.out.println("Here's the new phrase: " + partial);
        }
    }

    public boolean guessPhrase(String guess, Player player) {
        if (guess.equals(phrase)) {
            System.out.println("Congrats! You got it! You are rewarded with " + points * 5 + "points.");
            player.addPoints(5 * points);
            return true;
        }
        Player.switchTurn();
        return false;
    }

    public boolean getGuess(String guess, Player player) {
        if (guess.length() == 1) {
            guessLetter(guess, player);
            return false;
        } else {
            return guessPhrase(guess, player);
        }
    }
}

/*
 * All players start with zero points.
 * A phrase is selected at random.
 * The structure of the phrase is displayed to the players.
 * A random point value is selected.
 * At the start of each turn, a player may guess a letter or solve the puzzle.
 * If the player guesses a letter and it is in the phrase, the points are added
 * to the player’s score, and the letters are revealed as a partially solved
 * phrase.
 * If the letter is not in the phrase, the player loses their turn.
 * If the player tries to solve the puzzle by typing in the entire phrase
 * correctly, the game is over. If incorrect, the player loses their turn.
 * Once the puzzle is solved, the player with the highest score wins.
 */