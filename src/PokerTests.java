import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class PokerTests {

	@Before
	public void setUp() throws Exception
	{
	}

	@After
	public void tearDown() throws Exception
	{
		
	}
	@Test
	public void testDeckConstructor(){
		
	}
	public void testCardConstructor() throws CardException{
		Card c = new Card(4,Card.HEART);
		assertEquals(4,c.getCardNum());
		assertEquals(Card.HEART, c.getSuit());
		
		try{
			c.setCardNum(1);
			fail();
		}
		catch(BadCardNumException e){
			
		}
		try{
			c.setSuit(27);
			fail();
		}
		catch(BadSuitException e){
			
		}
		
	}

}
