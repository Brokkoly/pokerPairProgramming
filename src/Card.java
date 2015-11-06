import java.util.ArrayList;
import java.util.Arrays;


public class Card {
	public static int CLUB = 0;
	public static int DIAMOND = 1;
	public static int HEART = 2;
	public static int SPADE = 3;
	public static int J = 11;
	public static int Q = 12;
	public static int K = 13;
	public static int A = 14;
	//TODO make a map for these string values
	public ArrayList<String> suitStrings = new ArrayList<String>(Arrays.asList("Clubs","Diamonds","Hearts","Spades"));
	public ArrayList<String> typeStrings = new ArrayList<String>(Arrays.asList("0","1","2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"));
	int cardNum;
	int suit;
	/**
	 * Card class's constructor
	 * @param cardNum
	 * @param suit
	 * @throws CardException
	 */
	public Card(int cardNum, int suit) throws CardException
	{
		setCardNum(cardNum);
		setSuit(suit);
	}
	
	public int getCardNum()
	{
		return cardNum;
	}
	public void setCardNum(int cardNum) throws CardException
	{
		if(cardNum > 14 || cardNum<2){
			throw new BadCardNumException();
		}
		else{
			this.cardNum = cardNum;
		}
	}
	public int getSuit()
	{
		return suit;
	}
	public void setSuit(int suit) throws CardException
	{
		if(suit < 0 || suit > 3){
			throw new BadSuitException();
		}
		else{
			this.suit = suit;
		}
	}
	@Override
	public String toString(){
		StringBuilder s = new StringBuilder();
		s.append(typeStrings.get(cardNum));
		s.append(" of ");
		s.append(suitStrings.get(suit));
		return s.toString();
	}
}

