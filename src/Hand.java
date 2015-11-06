import java.util.ArrayList;


public class Hand {
	//TODO Royal Flush
	//TODO Straight Flush
	//TODO 4 of a Kind
	//TODO Full House
	//TODO Flush
	//TODO Straight
	//TODO 3 of a Kind
	//TODO 2 Pair
	//TODO 1 Pair
	//TODO High Card
	private ArrayList<Card> cards;
	public Hand(Deck d, int numCards) throws CardException, EmptyDeckDrawException{
		for(int i = 0; i < numCards;i++)
		{
			cards.add(d.draw());
		}
		
	}
}
