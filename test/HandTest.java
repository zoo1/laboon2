/**
 *
 * @author Nate Eilert
 */

import java.util.ArrayList;
import static org.mockito.Mockito.*;
import junit.framework.Assert;
import org.junit.Test;

public class HandTest {
    
    //Testing to see if the constructor is working.  Hand should not be null.
    @Test
    public void testConstructor(){
        Hand hand = new Hand();
        Assert.assertNotNull(hand);
    }
    
    //Testing to see if the count function works
    @Test
    public void testGetCardCount(){
        Hand hand = new Hand();
        Assert.assertEquals(hand.getCardCount(),0);
        Assert.assertTrue(hand.getCardCount()>-1);
    }
    
    //Test adding a mock card to a deck - hand should contain 1 card afterwards
    //Not sure how to test this without calling on the count method as well
    @Test
    public void testAddCard(){
        Hand hand = new Hand();
        Card dummy = mock(Card.class);
        hand.addCard(dummy);
        hand.addCard(null);
        Assert.assertEquals(hand.getCardCount(),1);
    }
    
    //Testing card removal, will add 10 mock cards to the hand and test that removing them 1 by 1 works
    @Test
    public void testRemoveCard(){
        Hand hand = new Hand();
        Card dummy = mock(Card.class);
        for(int i=0;i<=10;i++){
            hand.addCard(dummy);
        }
        for(int j=0;j<10;j++){
            hand.removeCard(dummy);
            Assert.assertEquals(hand.getCardCount(), (10-j));
        }
    }
    
    //Test to see when 10 cards are added if the clear function removes them all
    @Test
    public void testClear(){
        Hand hand = new Hand();
        Card dummy = mock(Card.class);
        for(int i=0;i<10;i++){
            hand.addCard(dummy);
        }
        Assert.assertEquals(hand.getCardCount(),10);
        hand.clear();
        Assert.assertEquals(hand.getCardCount(), 0);
    }
    
    @Test
    public void testGetCard(){
        
    }
    
    @Test
    public void testSortBySuit(){
        
    }
    
    @Test
    public void testSortByValue(){
        
    }
    
    
}
