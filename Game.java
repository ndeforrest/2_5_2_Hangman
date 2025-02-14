public class Game {
    private String phrase;
    private String partial;
    private int points;

    public Game() {
        phrase = WordProvider.getWord();
        for(int i = 0; i < phrase.length(); i++) {
            if (phrase.substring(i, i+1).equals(" ")) {
                partial += " ";
            }
            else {
                partial+= "_";
            }
        }
        System.out.println(partial);    //print fully blank
        points = (int)(Math.random() * 10);
        System.out.println("Amount of points per guess: " + points);
    }

    public void guessLetter(String guess, Player player) {
        int count = 0;
        for(int i = 0; i < phrase.length()-1; i++) {
            if (phrase.substring(i, i+1).equals(guess)) {
                count++;
                partial = partial.substring(0, i) + guess + partial.substring(i);
            }    
        }
        if (count == 0) {
            player.switchTurn();

        }
        else {
            player.addPoints(count * this.points);
            System.out.println(partial);
        }
    }

    public boolean guessPhrase(String guess, Player player) {
        if (guess.equals(phrase)) {
            System.out.println("Congrats! You got it!");
            //reward 5x points
            player.addPoints(5 * this.points);
            return true;
        }
        player.switchTurn();
        return false;
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