public class HandComparison implements iHandComparison {


    @Override
    public String compareHand(int playerHand, int dealerHand) {
        if(playerHand>21){
            return "Lose";
        }
        else if (dealerHand >21){
            return "Win";
        }
        else if (playerHand > dealerHand) {
            return "Win";
        }
        else if (playerHand == dealerHand) {
            return "Draw";
        }
        else {
            return "Lose";
        }
    }
}
