public class Player {
    private String name;
    private int points;
    private static boolean turn;

    public Player(String name) {
        this.name = name;
        points = 0;
    }

    public static void setTurn(boolean set) {
        turn = set;
    }

    public static void switchTurn() {
        turn = !turn;
    }

    public static boolean getTurn() {
        return turn;
    }

    public void addPoints(int amt) {
        points += amt;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }
}