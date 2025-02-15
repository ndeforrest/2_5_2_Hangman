public class Player {
    private String name;
    private int points;
    private boolean turn;

    public Player(String name) {
        this.name = name;
        points = 0;
    }

    public void addPoints(int amt) {
        points += amt;
    }

    public void switchTurn() {
        turn = !turn;
    }

    public boolean getTurn() {
        return turn;
    }

    public String getName() {
        return name;
    }
}