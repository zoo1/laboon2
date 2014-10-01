/**
 *
 * @author Nate Eilert
 */

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

public class CardTest {

Card _card = null; 

//Pass in a value for a card through the constructor and verify it returns that valid value passed in.
@Test
	public void testValueConstructor() {
		_card = new Card(1,0);
		assertEquals(_card.getValue(), 1);
	}
//Pass in a suit for a card through the constructor and verify it returns the valid suit passed in.
@Test
	public void testSuitConstructor() {
	   _card = new Card(13,3);
		assertEquals(_card.getSuit(), 3);
	}
//Pass in a value for a card through the constructor and verfiy that it returns the correct value as a string(for number cards).
@Test
	public void testValueString() {
	   _card = new Card(5,2);
		assertEquals(_card.getValueAsString(), "5");
	}
//Pass in a value for a card through the constructor and verfiy that it returns the correct value as a string(for royals) tested a boundry value.
@Test
	public void testValueStringChar() {
	   _card = new Card(13,1);
		assertEquals(_card.getValueAsString(), "King");
	}

//Pass in a suit for a card through the constructor and verfiy that it returns the correct suit as a string for a boundry value.
@Test
	public void testSuitString() {
	   _card = new Card(13,3);
		assertEquals(_card.getSuitAsString(), "Clubs");
	}
//Pass in a suit and value and verify the the card is return correctly as a string.
@Test
	public void testString() {
	   _card = new Card(11,3);
		assertEquals(_card.toString(), "Jack of Clubs");
	}
//Create a card with an invalid suit and verify the card holds the suit even though it is invalid. Done on the suites upper boundry.
@Test
	public void testInvalidsuit() {
	   _card = new Card(11,4);
		assertEquals(_card.getSuit(), 4);
	}
//Create a card with an invalid value and verify the card holds the value even though it is invalid. Done on the values upper boundry.
@Test
	public void testInvalidvalue() {
	   _card = new Card(14,0);
		assertEquals(_card.getValue(), 14);
	}
//Create a card with an invalid suit and verify the card returns an invalid string for the suit. Done on the suits lower boundry.
@Test
	public void testInvalidsuitstring() {
	   _card = new Card(11,-1);
		assertEquals(_card.getSuitAsString(), "??");
	}
//Create a card with an invalid value and verify the card returns an invalid string for the value. Done on the values lower boundry.
@Test
	public void testInvalidvaluestring() {
	   _card = new Card(-1,2);
		assertEquals(_card.getValueAsString(), "??");
	}
}
