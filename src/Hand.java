import java.util.ArrayList;


public class Hand {
	//TODO Royal Flush 9
	//TODO Straight Flush 8
	//TODO 4 of a Kind 7
	//TODO Full House 6
	//TODO Flush 5
	//TODO Straight 4
	//TODO 3 of a Kind 3
	//TODO 2 Pair 2
	//TODO 1 Pair 1
	//TODO High Card 0
	private ArrayList<Card> cards;
	public Hand(Deck d, int numCards) throws CardException, EmptyDeckDrawException{
		cards = new ArrayList<Card>();
		for(int i = 0; i < numCards;i++)
		{
			cards.add(d.draw());
		}
		
	}
	public Hand() throws CardException{
		cards = new ArrayList<Card>();
	}
	public int size(){
		return cards.size();
	}
	public void add(Card c){
		cards.add(c);
	}
	public int getNumType(int cardType){
		int num = 0;
		for(int i = 0; i < size();i++){
			if(cards.get(i).getCardNum()==cardType){
				num++;
			}
		}
		return num;
	}
	public int getNumSuit(int cardSuit){
		int num = 0;
		for(int i = 0; i < size();i++){
			if(cards.get(i).getSuit()==cardSuit){
				num++;
			}
		}
		return num;
	}
	public boolean isOnePair()
	{
		for(int i = Card.A;i>1;i++){
			if(getNumType(i) == 2){
				return true;
			}
		}
		// TODO Auto-generated method stub
		return false;
	}
}
