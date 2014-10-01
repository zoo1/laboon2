/**
 *
 * @author Nate Eilert
 */
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
public class DeckTest {
Deck _deck = null; 
//Verify a created deck has 52 cards if none are used.
@Test
	public void testInitialCards() {
		_deck = new Deck();
		assertEquals(_deck.cardsLeft(), 52);
	}
//Verify a created deck has unique cards. Done through checking that each card string isn't equal.
@Test
	public void testUniqueDeck() {
		_deck = new Deck();
		String[] cards = new String[52];
		boolean contain=false;
		for(int i=0;i<52;i++)
		{
			String temp=_deck.dealCard().toString();
			for(int j=i; j>0;j--)
			{
				if(temp.equals(cards[j-1])
					contain=true;
			}
			card[i]=temp;
		}
		assertFalse(contain);
	}
//Verify the deck will correctly track the ammount of cards that are left in the deck.
@Test
	public void testTrackedammount() {
		_deck = new Deck();
		for(int i=0;i<10;i++)
		{
			_deck.dealCard();
		}
		assertEquals(_deck.cardsLeft(),42);
	}
//Verify two decks are not the same after one is shuffled.
@Test
	public void testUniqueDecks() {
		_deck = new Deck();
		_deck2 = new Deck();
		_deck2.shuffle();
		boolean allequal=true;
		for(int i=0;i<52;i++)
		{
			if(!(_deck.dealCard().toString().equals(_deck2.dealCard().toString())
				allequal=false;
		}
		assertFalse(allequal);
	}
//Verify no invalid cards are ever dealt by the deck.
@Test
	public void testNoInvalids() {
		_deck = new Deck();
		boolean containsinvalid=false;
		for(int i=0;i<52;i++)
		{
			if(_deck.dealCard().toString().contains("?"))
				containsinvalid=true;
		}
		assertFalse(containsinvalid);
	}
}
