import java.util.ArrayList;

public class Dealer implements iDealer{
    public int dealACard(ArrayList<Integer> deck) {
        return deck.remove(0);
    }
}
