import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class PokerTests {

	@Before
	public void setUp() throws Exception
	{
	}

	@After
	public void tearDown() throws Exception{
		Hand h = new Hand();
		h.add(new Card(Card.A,Card.CLUB));
		h.add(new Card(Card.A,Card.DIAMOND));
		assertTrue(h.isOnePair());
	}
	@Test
	public void shuffleTest() throws Exception{
		System.out.println("SHUFFLE TEST BEGIN");
		Deck d = new Deck();
		d.shuffle();
		//d.print();
		System.out.println("SHUFFLE TEST END");
	}
	@Test
	public void handSortCheckTest() throws Exception{
		System.out.println("HAND SORT TEST BEGIN");
		Deck d = new Deck();
		d.shuffle();
		Hand h = new Hand(d,5);
		//h.sortCheck();
		System.out.println("HAND SORT TEST END");
	}
	@Test
	public void percentageCheckTest5() throws Exception{
		Deck d;
		Hand h;
		int hNum;
		ArrayList<Integer> handTypeNumbers = new ArrayList<Integer>();
		for(int i = 0; i < 10;i++){
			handTypeNumbers.add(new Integer(0));
		}
		for(int i = 0; i < 1000;i++){
			d = new Deck();
			d.shuffle();
			h = new Hand(d,5);
			hNum = h.getHandType();
			Integer I = handTypeNumbers.get(hNum);
			I += 1;
			handTypeNumbers.set(hNum,I);
		}
		System.out.println("NUMBERS OF EACH HAND TYPE");
		for(Integer x : handTypeNumbers){
			System.out.println(x);
		}
		System.out.println("END NUMBER OF EACH HAND TYPE");
	}
	@Test
	public void customHandConstructor() throws Exception{
		Hand h = new Hand();
		h.add(new Card(Card.A,Card.CLUB));
		h.add(new Card(Card.A,Card.DIAMOND));
		assertEquals(2,h.getNumType(Card.A));
		assertEquals(1,h.getNumSuit(Card.CLUB));
		assertEquals(1,h.getNumSuit(Card.CLUB));
	}
	@Test
	public void testHandConstructor() throws Exception
	{
		Deck d = new Deck();
		Hand h = new Hand(d,5);
		assertEquals(h.size(),5);
		assertEquals(d.size(),47);
	}
	@Test
	public void testDeckConstructor() throws Exception{
		Deck d = new Deck();
		for(int i = 0; i < 4;i++){//Each loop is checking a different suit
			for(int j = 13*i; j < 13*(i+1);j++){//making sure that within each suit, all 13 card types are present
				assertEquals(i,d.get(j).getSuit());
				assertEquals((j%13)+2,d.get(j).getCardNum());//j+2 because the integers assigned to cards go from 2-14, instead of 0-12;
			}
		}
	}
	@Test
	public void testDeckGet() throws Exception{
		Deck d = new Deck();
		try{
			d.get(53);
			fail();
		}
		catch(DeckOutOfBoundsException e){
			System.out.println("Alles sind gut");
		}
	}
	//TODO Implement the card dealing test. Make sure an empty deck throws an exception if one tries to draw from it.
	@Test
	public void testCardDealing() throws CardException{
		Deck d = new Deck();
		Card c;
		try{
			for(int i = 0; i < 54;i++){
				c = d.draw();
				System.out.println(c.toString());
				
			}
			fail();
		}
		catch(EmptyDeckDrawException e){
			
		}
		
	}
	@Test
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
