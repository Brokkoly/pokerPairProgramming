import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class Deck{
	private ArrayList<Card> cardArray;
	public Deck(){
		cardArray = new ArrayList<Card>();
		for(int i = 0; i < 4;i++){
			for(int j = 2;j<15;j++){
				try {
					cardArray.add(new Card(j,i));
				} catch (CardException e) {
					System.out.println("You don' fucked up");//TODO remove this before shipping code
					e.printStackTrace();
					
				}
			}
		}
	}
	public Card get(int x) throws DeckOutOfBoundsException
	{
		if(x > cardArray.size()||x<0){
			throw new DeckOutOfBoundsException();
		}
		return cardArray.get(x);
	}
	public Card draw() throws EmptyDeckDrawException
	{
		if(cardArray.size() == 0){
			throw new EmptyDeckDrawException();
		}
		else
		{
			Card c = cardArray.get(cardArray.size()-1);
			cardArray.remove(cardArray.size()-1);
			return c;
		}
	}
	public void shuffle(){
		
		Collections.shuffle(cardArray, new Random(System.currentTimeMillis()));//EZPZ
	}
	public int size(){
		return cardArray.size();
	}
	public void print()
	{
		for(Card x:cardArray){
			System.out.println(x.toString());
		}
	}
}
