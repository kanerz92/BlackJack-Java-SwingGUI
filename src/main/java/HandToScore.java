public class HandToScore implements IHandToScore {
    @Override
    public int scoreHand(int[] hand) {
        int aces = 0;
        int score = 0;
        for (int i : hand) {
            if (i == 11) {
                aces++;
            }
        }
        for (int rankValue : hand) {
            score += rankValue;
        }
        while (score > 21 && aces >0){
            score -= 10;
            aces--;
        }
        return score;
    }
}
