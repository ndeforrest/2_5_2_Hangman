public class Game {
    private String phrase;
    private String partial;
    private int points;
    private String guessed = "";

    public Game() {
        phrase = WordProvider.getWord();
        partial = "";

        // replace phrase with underscores
        for (int i = 0; i < phrase.length(); i++) {
            if (phrase.substring(i, i + 1).equals(" ")) {
                partial += " ";
            } else {
                partial += "_";
            }
        }
        System.out.println("Format: " + partial); // print fully blank
        points = (int) (Math.random() * 10 + 1); // points from 1-10
        System.out.println("Amount of points per guess: " + points);
    }

    // returns true if phrase completed, otherwise returns false
    public boolean guessLetter(String guess, Player player) {
        // check if letter has been guessed
        if (guessed.indexOf(guess) >= 0) {
            System.out.println("Already guessed, switching turns");
            Player.switchTurn();
            return false;
        }
        guessed += guess;
        // find all iterations of letter in word
        int count = 0; // tally up amount of times letter is in word for the score
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
            if (partial.equals(phrase)) {
                return true; // phrase is completed
            }
        }
        return false;
    }

    // returns true if guessed correctly, false if not
    public boolean guessPhrase(String guess, Player player) {
        if (guess.equals(phrase)) { // guessed right
            System.out.println("Congrats! You got it! You are rewarded with " + points * 5 + " points.");
            player.addPoints(5 * points);
            return true;
        }
        // guess wrong
        Player.switchTurn();
        System.out.println("Nope, you didn't get it: switching turns");
        return false;
    }

    // returns true if game is over(guessed correctly or word is completed)
    public boolean getGuess(String guess, Player player) {
        if (guess.length() == 1) {
            return guessLetter(guess, player);
        } else {
            return guessPhrase(guess, player);
        }
    }
}