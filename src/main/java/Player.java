public class Player {

    private String name;
    private int chips;

    public Player(String playerName, int playerChips) {
        this.name = playerName;
        this.chips = playerChips;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChips() {
        return chips;
    }

    public void setChips(int chips) {
        this.chips = chips;
    }

    @Override
    public String toString() {
        return getName() + ": " + getChips();
    }
}