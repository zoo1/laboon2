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
    
    //Testing getCard method, adding 2 dummy cards testing them against each other and then against themselves
    @Test
    public void testGetCard(){
        Hand hand = new Hand();
        Card dummy1 = mock(Card.class);
        Card dummy2 = mock(Card.class);
        hand.addCard(dummy1);
        hand.addCard(dummy2);
        Assert.assertNotSame(dummy1, hand.getCard(1));
        Assert.assertNotSame(dummy2, hand.getCard(0));
        Assert.assertEquals(hand.getCard(0), dummy1);
        Assert.assertEquals(hand.getCard(1), dummy2);
        
    }
    
    @Test
    public void testSortBySuit(){
        int spade = 0;
        int heart = 1;
        int diamond = 2;
        int club = 3;
        int[] suits = {spade,heart,diamond,club};
        Hand hand = new Hand();
        Card spade1 = mock(Card.class);
        when(spade1.getSuit()).thenReturn(spade);
        Card spade2 = spade1;
        hand.addCard(spade1);
        Card heart1 = mock(Card.class);
        when(heart1.getSuit()).thenReturn(heart);
        Card heart2 = heart1;
        hand.addCard(heart1);
        Card diamond1 = mock(Card.class);
        when(diamond1.getSuit()).thenReturn(diamond);
        Card diamond2 = diamond1;
        hand.addCard(diamond1);
        Card club1 = mock(Card.class);
        when(club1.getSuit()).thenReturn(club);
        Card club2 = club1;
        hand.addCard(club1);
        hand.addCard(spade2);
        hand.addCard(heart2);
        hand.addCard(diamond2);
        hand.addCard(club2);
        for(int i = 0; i<suits.length;i++){//assert suits are in spade,heart,diamond,club * 2 order
            Assert.assertEquals(suits[i], hand.getCard(i).getSuit());
            Assert.assertEquals(suits[i], hand.getCard(i+4).getSuit());
        }//now sort them
        hand.sortBySuit();
        int j = 0;
        for(int i = 0; i<hand.getCardCount();i++){
            if(i%2!=0){
                j = j-1;
            }
            Assert.assertEquals(hand.getCard(i).getSuit(), suits[j]);
            j++;
        }
    }
    
    @Test
    public void testSortByValue(){
        
    }
    
    
}
