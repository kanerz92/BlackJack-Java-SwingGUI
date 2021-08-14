import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class HandToScoreTest {
    HandToScore handToScore = new HandToScore();

    @Test
    void testGivenEmptyHandThenScore0() {
        //Given: I have an empty hand
        int[] hand = new int[] {};
        //When: I score my hand
        int result = handToScore.scoreHand(hand);
        //Then: The hand score is 0
        assertEquals(0,result);
    }

    @Test
    void testGivenHandWithACardOfRank5ThenScore5() {
        //Given: I have an empty hand
        int[] hand = new int[] {5};
        //When: I score my hand
        int result = handToScore.scoreHand(hand);
        //Then: The hand score is 5
        assertEquals(5,result);
    }

    @Test
    void testGivenHandWithMultipleCardsThenScoreIsSumOfRanks() {
        //Given: I have a hand with multiple cards
        int[] hand = new int[] {1,4,8,3};
        //When: I score my hand
        int result = handToScore.scoreHand(hand);
        //Then: The hand score is the sum of the ranks.
        assertEquals(16,result);
    }
    @Test
    void testGivenHandThatContains11andTotalIsOver21That10IsSubtracted() {
        //Given: I have a hand with multiple cards
        int[] hand = new int[] {11,11};
        //When: I score my hand
        int result = handToScore.scoreHand(hand);
        //Then: The hand score is the sum of the ranks.
        assertEquals(12,result);
    }
    @Test
    void testGivenHandThatContains11andTotalIsOver22That10IsSubtracted() {
        //Given: I have a hand with multiple cards
        int[] hand = new int[] {11,10,1,3};
        //When: I score my hand
        int result = handToScore.scoreHand(hand);
        //Then: The hand score is the sum of the ranks.
        assertEquals(15,result);
    }

    @Test
    void testGivenHandContains11ButTotal21ThenNothingSubtracted() {
        //Given: I have a hand with an "ace" that totals 21 then the "ace" counts as an 11
        int[] hand = new int[] {11,4,2,4};
        //When: I score my hand
        int result = handToScore.scoreHand(hand);
        //Then: The hand score is the sum of the ranks.
        assertEquals(21,result);
    }
}