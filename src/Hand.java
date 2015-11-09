import java.util.ArrayList;
import java.util.Collections;


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
	public boolean containsCard(Card c){
		
		
		
		
		
		return false;
	}
	public boolean isOnePair()
	{
		for(int i = Card.A;i>1;i--){
			if(getNumType(i) == 2){
				return true;
			}
		}
		// TODO Auto-generated method stub
		return false;
	}
	public int getHandType() throws Exception{
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
		if(isRoyalFlush()){
			return 9;
		}
		else if(isStraightFlush()){
			return 8;
		}
		else if(isFourOfAKind()){
			return 7;
		}
		else if(isFullHouse()){
			return 6;
		}
		else if(isFlush()){
			return 5;
		}
		else if(isStraight()){
			return 4;
		}
		else if(isThreeOfAKind()){
			return 3;
		}
		else if(isTwoPair()){
			return 2;
		}
		else if(isOnePair()){
			return 1;
		}
		else{
			return 0;
		}
		
	}
	private boolean isTwoPair()
	{
		int otherCardNum = 0;
		for(int i = Card.A;i>1;i--){//finding a first pair
			if(getNumType(i) == 2){
				otherCardNum = i;
				break;
			}
		}
		if(otherCardNum == 0){
			return false;//if there is no first pair, there can be no second pair
		}
		for(int i = Card.A;i>1;i--){
			if(i == otherCardNum){
				continue;
			}
			if(getNumType(i) == 2){
				return true;
			}
		}
		
		return false;
	}
	private boolean isThreeOfAKind()
	{
		for(int i = Card.A;i>1;i--){
			if(getNumType(i) == 3){
				return true;
			}
		}
		return false;
	}
	private boolean isStraight()
	{
		Collections.sort(cards);
		int prevCard = cards.get(0).getCardNum();
		int count = 1;
		for(int i = 1; i < cards.size();i++){
			if(cards.get(i).getCardNum()==prevCard+1){
				count++;
				prevCard = cards.get(i).getCardNum();
				if(count == 5){
					return true;
				}
			}
			else if(cards.get(i).getCardNum()==prevCard){
				continue;
			}
			else{
				prevCard = cards.get(i).getCardNum();
				count = 1;
			}
		}
		return false;
	}
	public void sortCheck(){
		Collections.sort(cards);
		for(Card x:cards){
			System.out.println(x.toString());
		}
	}
	private boolean isFlush()
	{
		for(int i = Card.A;i>1;i--){
			if(getNumSuit(i) >= 5){
				return true;
			}
		}
		return false;
	}
	private boolean isFullHouse()
	{
		int otherCardNum = 0;
		for(int i = Card.A;i>1;i--){//finding a first pair
			if(getNumType(i) == 3){
				otherCardNum = i;
				break;
			}
		}
		if(otherCardNum == 0){
			return false;//if there is no first pair, there can be no second pair
		}
		for(int i = Card.A;i>1;i--){
			if(i == otherCardNum){
				continue;
			}
			if(getNumType(i) == 2){
				return true;
			}
		}
		
		return false;
	}
	private boolean isFourOfAKind()
	{
		for(int i = Card.A;i>1;i--){
			if(getNumType(i) == 4){
				return true;
			}
		}
		return false;
	}
	private boolean isStraightFlush()
	{
		boolean hasFlush = false;
		int flushSuit = -1;
		for(int i = Card.A;i>1;i--){
			if(getNumSuit(i) >= 5){
				hasFlush = true;
				flushSuit = i;
				break;
			}
		}
		if(!hasFlush){
			return false;
		}
		Collections.sort(cards);
		int prevCard = cards.get(0).getCardNum();
		int count = 1;
		for(int i = 1; i < cards.size();i++){
			if((cards.get(i).getCardNum()==prevCard+1)&&(cards.get(i).getSuit()==flushSuit)){
				count++;
				prevCard = cards.get(i).getCardNum();
				if(count == 5){
					return true;
				}
			}
			else if(cards.get(i).getSuit()==flushSuit){
				prevCard = cards.get(i).getCardNum();
				count = 1;
			}
			
		}
		return false;
	}
	private boolean isRoyalFlush() throws CardException
	{
		boolean hasFlush = false;
		int flushSuit = -1;
		for(int i = Card.A;i>1;i--){
			if(getNumSuit(i) >= 5){
				hasFlush = true;
				flushSuit = i;
				break;
			}
		}
		if(!hasFlush){
			return false;
		}
		else{
			for(int i = Card.A;i>9;i--){
				if(!containsCard(new Card(i,flushSuit))){
					return false;
				}
			}
		}
		return true;
	}
}
