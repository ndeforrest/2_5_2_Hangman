public class Game {
    private String phrase;
    private String partial;
    private int points;
    private String guessed = "";

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
        System.out.println("Format: " + partial); // print fully blank
        points = (int) (Math.random() * 10);
        System.out.println("Amount of points per guess: " + points);
    }

    public void guessLetter(String guess, Player player) {
        if (guessed.indexOf(guess) >= 0) {
            System.out.println("Already guessed, try again");
            return;
        }
        guessed += guess;
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
            System.out.println("The letter was in the word, you got " + count * this.points + " points.");
            System.out.println("Here's the new phrase: " + partial);
        }
    }

    public boolean guessPhrase(String guess, Player player) {
        if (guess.equals(phrase)) {
            System.out.println("Congrats! You got it! You are rewarded with " + points * 5 + " points.");
            player.addPoints(5 * points);
            return true;
        }
        Player.switchTurn();
        System.out.println("Nope, you didn't get it: switching turns");
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