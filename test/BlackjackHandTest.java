/**
 *
 * @author Nate Eilert
 */

import static org.mockito.Mockito.*;
import junit.framework.Assert;
import org.junit.Test;

public class BlackjackHandTest {
    
    //Test some blackjack hand values lower is 4, upper is 30 based on game rules
    //4 is two twos, 30 is 3 cards of 10 value (10 and face cards)
    @Test
    public void testBlackJackHandValues(){
        BlackjackHand hand = mock(BlackjackHand.class);
    }
    
    //Blackjack is when the hand contains only 2 cards and those cards equal 21
    @Test
    public void testBlackjack(){
        BlackjackHand hand = mock(BlackjackHand.class);
    }
    
    //It is possible to have a score of 21 but it is not Blackjack
    @Test
    public void testNotBlackjack(){
        BlackjackHand hand = mock(BlackjackHand.class);
        
    }
    
    //Testing 2 hands of with different cards that should total the same amount
    @Test
    public void testPush(){
        BlackjackHand hand = mock(BlackjackHand.class);
        
    }
    
    //Testing the behavior of a hand with a single ace in it
    //ace will act as a score of 11 if the score is less than 21
    //ace will act as a score of 1 if it being 11 would cause the score to exceed 21
    @Test 
    public void testSingleAce(){
        BlackjackHand hand = mock(BlackjackHand.class);
        
    }
    
    //Testing the behavior of a hand with two aces in it
    //aces will act as a score of 11 if the score is less than 21
    //aces will act as a score of 1 if it being 11 would cause the score to exceed 21
    @Test
    public void testDoubleAce(){
        BlackjackHand hand = mock(BlackjackHand.class);
        
    }
    
}
