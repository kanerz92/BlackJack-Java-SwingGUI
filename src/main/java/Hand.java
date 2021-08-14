public class Hand implements iHand{
    int[] handCards;
    int numCards;
    public Hand(){
        handCards = new int[5];
        numCards= 0;
    }



    @Override
    public void addCard(int card){
        handCards[numCards]= card;
        numCards++;

    }

    @Override
    public void resetHand() {
        handCards = new int[5];
        numCards = 0;
    }

    public int[] getHand(){
        return handCards;
    }

    @Override
    public String toString() {
        String handString = "";
        for (int hand: handCards) {
            if (hand != 0) {
                handString += Integer.toString(hand) + ", ";
            }
        }
        handString = handString.substring(0, handString.length());
        return handString;
    }
}