/**
 *
 * @author Nate Eilert
 */

import static org.mockito.Mockito.*;
import junit.framework.Assert;
import org.junit.Test;
import org.mockito.Mock;

public class BlackjackHandTest {
    
    
    //Test some blackjack hand values lower is 4, upper is 30 based on game rules
    //4 is two twos, 30 is 3 cards of 10 value (10 and face cards)
    @Test
    public void testBlackJackHandValues(){
        Card m1 = mock(Card.class);
        when(m1.getValue()).thenReturn(2);
        Card m2 = mock(Card.class);
        when(m2.getValue()).thenReturn(10);
        BlackjackHand hand = new BlackjackHand();
        hand.addCard(m1);
        hand.addCard(m1);
        Assert.assertEquals(hand.getBlackjackValue(), 4);
        hand.clear();
        hand.addCard(m2);
        hand.addCard(m2);
        hand.addCard(m2);
        Assert.assertEquals(hand.getBlackjackValue(), 30);
        hand.removeCard(1);
        hand.addCard(m1);
        Assert.assertEquals(hand.getBlackjackValue(), 22);
    }
    
    //Blackjack is when the hand contains only 2 cards and those cards equal 21
    @Test
    public void testBlackjack(){
        BlackjackHand hand = new BlackjackHand();
        Card mockAce = mock(Card.class);
        when(mockAce.getValue()).thenReturn(1);
        Card mockKing = mock(Card.class);
        when(mockKing.getValue()).thenReturn(10);
        hand.addCard(mockAce);
        hand.addCard(mockKing);
        Assert.assertTrue(hand.isBlackjack(hand));
    }
    
    //It is possible to have a score of 21 but it is not Blackjack
    @Test
    public void testNotBlackjack(){
        BlackjackHand hand = new BlackjackHand();
        Card mockAce = mock(Card.class);
        when(mockAce.getValue()).thenReturn(1);
        Card mockFive = mock(Card.class);
        when(mockFive.getValue()).thenReturn(5);
        hand.addCard(mockAce);
        hand.addCard(mockFive);
        hand.addCard(mockFive);
        Assert.assertFalse(hand.isBlackjack(hand));
        
    }
    
    //Testing 2 hands of with different cards that should total the same amount
    @Test
    public void testPush(){
        BlackjackHand hand1 = mock(BlackjackHand.class);
        when(hand1.getBlackjackValue()).thenReturn(20);
        Card ten = mock(Card.class);
        when(ten.getValue()).thenReturn(10);
        BlackjackHand hand2 = new BlackjackHand();
        hand2.addCard(ten);
        hand2.addCard(ten);
        Assert.assertNotSame(hand1,hand2);
        Assert.assertEquals(hand2.getBlackjackValue(), hand1.getBlackjackValue());
        
    }
    
    //Testing the behavior of a hand with a single ace in it
    //ace will act as a score of 11 if the score is less than 21
    //ace will act as a score of 1 if it being 11 would cause the score to exceed 21
    @Test 
    public void testSingleAce(){
        Card ace = mock(Card.class);
        when(ace.getValue()).thenReturn(1);
        Card eight = mock(Card.class);
        when(eight.getValue()).thenReturn(8);
        BlackjackHand hand = new BlackjackHand();
        hand.addCard(ace);
        hand.addCard(eight);
        Assert.assertEquals(hand.getBlackjackValue(), 19);
        hand.addCard(eight);
        Assert.assertEquals(hand.getBlackjackValue(), 17);
    }
    
    //Testing the behavior of a hand with two aces in it
    //aces will act as a score of 11 if the score is less than 21
    //aces will act as a score of 1 if it being 11 would cause the score to exceed 21
    @Test
    public void testDoubleAce(){
        Card ace = mock(Card.class);
        when(ace.getValue()).thenReturn(1);
        Card six = mock(Card.class);
        when(six.getValue()).thenReturn(6);
        BlackjackHand hand = new BlackjackHand();
        hand.addCard(ace);
        hand.addCard(ace);
        Assert.assertEquals(hand.getBlackjackValue(), 12);
        hand.addCard(six);
        Assert.assertEquals(hand.getBlackjackValue(), 18);
        hand.addCard(six);
        Assert.assertEquals(hand.getBlackjackValue(), 14);
        
    }
    
}
