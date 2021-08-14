import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HandComparisonTest {

    @Test
    public void testCompareHandMethodReturnsWinForPlayerWithGreaterScoreComparedToTheDealersHandValue(){

        //Given: The player and dealer have full hands
        iHandComparison compareHands = new HandComparison();
        //When: The players hand has a value of 20 and the dealers hand has a value of 18
        int playerHandValue = 20;
        int dealerHandValue = 18;
        //Then: The compareHand method returns "Win"
        String result = compareHands.compareHand(playerHandValue,dealerHandValue);
        assertEquals("Win", result);

    }
    @Test
    public void testCompareHandMethodReturnsLoseForPlayerWithLowerScoreComparedToTheDealersHandValue(){

        //Given: The player and dealer have full hands
        iHandComparison compareHands = new HandComparison();
        //When: The players hand has a value of 20 and the dealers hand has a value of 21
        int playerHandValue = 20;
        int dealerHandValue = 21;
        //Then: The compareHand method returns "Lose"
        String result = compareHands.compareHand(playerHandValue,dealerHandValue);
        assertEquals("Lose", result);

    }
    @Test
    public void testCompareHandMethodReturnsDrawForPlayerWithEqualScoreComparedToTheDealersHandValue(){

        //Given: The player and dealer have full hands
        iHandComparison compareHands = new HandComparison();
        //When: The players hand has a value of 20 and the dealers hand has a value of 20
        int playerHandValue = 20;
        int dealerHandValue = 20;
        //Then: The compareHand method returns "Win"
        String result = compareHands.compareHand(playerHandValue,dealerHandValue);
        assertEquals("Draw", result);

    }
}
