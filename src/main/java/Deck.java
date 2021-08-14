import java.util.ArrayList;
import java.util.List;

public class Deck implements iDeck {

    ArrayList<Integer> cardHolder;


    @Override
    public ArrayList<Integer> getDeck() {
        return cardHolder;
    }

    public void setCardHolder(ArrayList<Integer> cardHolder) {
        this.cardHolder = cardHolder;
    }

    public Deck() {
        this.resetDeck();
    }

    public void resetDeck() {
        cardHolder = new ArrayList<Integer>();
        for (int i = 0; i < 52; i++) {
            int cardValue = 0;
            if (i >= 0 && i <= 3) {
                cardHolder.add(i, 2);
            }
            if (i >= 4 && i <= 7) {
                cardHolder.add(i, 3);
            }
            if (i >= 8 && i <= 11) {
                cardHolder.add(i, 4);
            }
            if (i >= 12 && i <= 15) {
                cardHolder.add(i, 5);
            }
            if (i >= 16 && i <= 19) {
                cardHolder.add(i, 6);
            }
            if (i >= 20 && i <= 23) {
                cardHolder.add(i, 7);
            }
            if (i >= 24 && i <= 27) {
                cardHolder.add(i, 8);
            }
            if (i >= 28 && i <= 31) {
                cardHolder.add(i, 9);
            }
            if (i >= 32 && i <= 47) {
                cardHolder.add(i, 10);
            }
            if (i >= 48 && i <= 51) {
                cardHolder.add(i, 11);
            }
        }
    }
}